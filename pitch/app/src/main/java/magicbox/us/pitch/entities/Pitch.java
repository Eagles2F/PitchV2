package magicbox.us.pitch.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pitch {
    private String mId; // foreign key for User
    private String date;
    private String title;
    private String description;

    private Date calDate;

    SimpleDateFormat iso8601Format =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Pitch() {}

    public Pitch(String mId, String date, String title, String description) {
        this.mId = mId;
        this.date = date;
        this.title = title;
        this.description = description;

        try {
            this.calDate = iso8601Format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCalDate() {
        return calDate;
    }

    public void setCalDate(Date calDate) {
        this.calDate = calDate;
    }
}
