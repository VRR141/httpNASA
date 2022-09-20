import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    private final String COPYRIGHT;
    private final String DATE;
    private final String EXPLANATION;
    private final String HDURL;
    private final String MEDIA_TYPE;
    private final String SERVICE_VERSION;
    private final String TITLE;
    private final String URL;

    public Answer(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ){
        this.COPYRIGHT = copyright;
        this.DATE = date;
        this.EXPLANATION = explanation;
        this.HDURL = hdurl;
        this.MEDIA_TYPE = media_type;
        this.SERVICE_VERSION = service_version;
        this.TITLE = title;
        this.URL = url;
    }

    public String getURL(){
        return URL;
    }

    public String getMEDIA_TYPE(){
        return MEDIA_TYPE;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "\n copyright: " + COPYRIGHT +
                "\n date: " + DATE +
                "\n explanation: " + EXPLANATION +
                "\n hdurl: " + HDURL +
                "\n media_type: " + MEDIA_TYPE +
                "\n service_version: " + SERVICE_VERSION +
                "\n title: " + TITLE +
                "\n url: " + URL +
                "\n}";
    }
}
