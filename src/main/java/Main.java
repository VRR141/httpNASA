import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.*;

public class Main {

    private static final String url = "https://api.nasa.gov/planetary/apod?api_key=si92kf3uQ2ErKZc0fIYJ5HXAuI8i7sgfWEeB4lPx";

    public static void main(String[] args){
        ObjectMapper objectMapper = new ObjectMapper();
        ParseNASA getFromNasa = new ParseNASA(url);
        try (CloseableHttpResponse response = getFromNasa.getResponse()) {
            Answer answer = objectMapper.
                    readValue(response.getEntity().getContent(), new TypeReference<>() {
                    });
            String name = getUrlFromString(answer.getUrl());
            ParseNASA getJpg = new ParseNASA(answer.getUrl());
            try (var answerResponse = getJpg.getResponse()) {
                byte[] bytes = answerResponse.getEntity().getContent().readAllBytes();
                if (answer.getMedia_type().equals("image")) {
                    File file = new File(name);
                    if (!file.exists()) {
                        file.createNewFile();
                        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
                            outputStream.write(bytes);
                        }
                        System.out.println(name + " downloaded");
                    } else {
                        throw new RuntimeException(name + " already downloaded");
                    }
                } else {
                    throw new RuntimeException("bad media type");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getUrlFromString(String s){
        String[] strings = s.split("/");
        String name = strings[strings.length - 1];
        if (name.contains(".jpg")) {
            return name;
        }
        return "image.jpg";
    }
}
