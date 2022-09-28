import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    private final String copyright;
    private final String date;
    private final String explanation;
    private final String hdurl;
    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final String url;

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
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = media_type;
        this.serviceVersion = service_version;
        this.title = title;
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public String getMediaType(){
        return mediaType;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "\n copyright: " + copyright +
                "\n date: " + date +
                "\n explanation: " + explanation +
                "\n hdurl: " + hdurl +
                "\n media_type: " + mediaType +
                "\n service_version: " + serviceVersion +
                "\n title: " + title +
                "\n url: " + url +
                "\n}";
    }
}
