package dojo.githubusercore;

/**
 * Created by JGabrielFreitas on 06/03/16.
 */
public class BaseApiResponse {

    private String message;
    private String documentation_url;

    public String getMessage() {
        return message;
    }

    public String getDocumentation_url() {
        return documentation_url;
    }

    public String toString() {
        return "BaseApiResponse{" +
                "message='" + message + '\'' +
                ", documentation_url='" + documentation_url + '\'' +
                '}';
    }
}
