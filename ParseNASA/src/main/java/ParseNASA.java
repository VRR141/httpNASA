import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;

public class ParseNASA {
    private final String url;

    public ParseNASA(String url){
        this.url = url;
    }

    private CloseableHttpClient createClient(){
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.DEFAULT).build();
        return httpClient;
    }

    private HttpGet createRequest(){
        HttpGet request = new HttpGet(url);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
        return request;
    }

    public CloseableHttpResponse getResponse() throws IOException {
        return createClient().execute(createRequest());
    }
}