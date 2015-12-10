package magicbox.us.pitch.entities;

/**
 * Created by yangwu on 11/13/15.
 */
public class User {
    private String mEmail;
    private boolean mPitchable;
    private String mSkills;

    public User() {}

    public User(String email, boolean pitchable, String skills) {
        mEmail = email;
        mPitchable = pitchable;
        mSkills = skills;
    }

    public boolean ismPitchable() {
        return mPitchable;
    }

    public void pitchable(boolean _pitchable) {
        this.mPitchable = _pitchable;
    }

    public String getmSkills() {
        return mSkills;
    }

    public void setmSkills(String mSkills) {
        this.mSkills = mSkills;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
