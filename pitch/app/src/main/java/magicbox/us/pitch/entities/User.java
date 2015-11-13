package magicbox.us.pitch.entities;

import org.json.JSONException;
import org.json.JSONObject;

import magicbox.us.pitch.third_party.LinkedInAPI;

/**
 * Created by yangwu on 11/13/15.
 */
public class User {
    private String mId;
    private String mName;
    private String mEmail;
    private String mHeadline;
    private String mPictureUrl;
    private boolean mPitchable;

    private User() {

    }

    public User(String id, String name, String email, String headline, String url) {
        mId = id;
        mName = name;
        mEmail = email;
        mHeadline = headline;
        mPictureUrl = url;
        mPitchable = true;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }


    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmHeadline() {
        return mHeadline;
    }

    public void setmHeadline(String mHeadline) {
        this.mHeadline = mHeadline;
    }

    public String getmPictureUrl() {
        return mPictureUrl;
    }

    public void setmPictureUrl(String mPictureUrl) {
        this.mPictureUrl = mPictureUrl;
    }

    public boolean ismPitchable() {
        return mPitchable;
    }

    public void setmPitchable(boolean mPitchable) {
        this.mPitchable = mPitchable;
    }

    public static User parse(JSONObject jsonObject) {
        // TODO: parse user by 3rd party
        try {
            return new User(jsonObject.getString(LinkedInAPI.JSON_ID),
                    jsonObject.getString(LinkedInAPI.JSON_NAME),
                    jsonObject.getString(LinkedInAPI.JSON_EMAIL),
                    jsonObject.getString(LinkedInAPI.JSON_HEADLINE),
                    jsonObject.getString(LinkedInAPI.JSON_PICTUREURL));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
