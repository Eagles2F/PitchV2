package magicbox.us.pitch.services.remote;

public class LinkedInAPI {
    public static final String JSON_ID = "id";
    public static final String JSON_NAME = "formattedName";
    public static final String JSON_EMAIL = "emailAddress";
    public static final String JSON_HEADLINE ="headline";
    public static final String JSON_PICTUREURL = "pictureUrl";

    public static final String host = "api.linkedin.com";
    public static final String basicUserInfoUrl = "https://" + host + "/v1/people/~:(id,formatted-name,email-address,headline,picture-url)";
    public static final String shareUrl = "https://" + host + "/v1/people/~/shares";
}
