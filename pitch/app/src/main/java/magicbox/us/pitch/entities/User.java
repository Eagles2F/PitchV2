package magicbox.us.pitch.entities;

import org.json.JSONException;
import org.json.JSONObject;

import magicbox.us.pitch.services.remote.LinkedInAPI;

/**
 * Created by yangwu on 11/13/15.
 */
public class User {

    private String mName;
    private String mPassword;
    private String mEmail;
    private String mHeadline;
    private String mPictureUrl;
    private boolean mPitchable;

    User() {}

    User(String name, String pwd, String email, String headline, String url, boolean pitchale) {
        mName = name;
        mPassword = pwd;
        mEmail = email;
        mHeadline = headline;
        mPictureUrl = url;
        mPitchable = pitchale;
    }

    public String getmName() {
        return mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void email(String _email) {
        this.mEmail = _email;
    }

    public String getmHeadline() {
        return mHeadline;
    }

    public void headline(String _headline) {
        this.mHeadline = _headline;
    }

    public String getmPictureUrl() {
        return mPictureUrl;
    }

    public void pictureUrl(String _pictureUrl) {
        this.mPictureUrl = _pictureUrl;
    }

    public boolean ismPitchable() {
        return mPitchable;
    }

    public void pitchable(boolean _pitchable) {
        this.mPitchable = _pitchable;
    }

    public void password(String _password) {
        this.mPassword = _password;
    }

    public String getmPassword() {
        return mPassword;
    }


//    public static User parse(JSONObject jsonObject) {
//        // TODO: parse user by 3rd party
//        try {
//            return new User(jsonObject.getString(LinkedInAPI.JSON_ID),
//                    jsonObject.getString(LinkedInAPI.JSON_NAME),
//                    jsonObject.getString(LinkedInAPI.JSON_EMAIL),
//                    jsonObject.getString(LinkedInAPI.JSON_HEADLINE),
//                    jsonObject.getString(LinkedInAPI.JSON_PICTUREURL));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
