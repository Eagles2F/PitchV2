package magicbox.us.pitch.network.model;

/**
 * Created by evan on 12/8/15.
 */
public class PitchCreateBody {
    private String email;
    private String description;
    private String tag;
    private String title;
    private String date;

    public PitchCreateBody() {}

    public PitchCreateBody(String email, String description, String tag, String title, String date) {
        this.email = email;
        this.description = description;
        this.tag = tag;
        this.title = title;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
