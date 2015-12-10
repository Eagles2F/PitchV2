package magicbox.us.pitch.util;

import java.util.ArrayList;
import java.util.List;

import magicbox.us.pitch.entities.Pitch;
import magicbox.us.pitch.entities.User;

/**
 * Created by evan on 12/7/15.
 */
public class Session {
    public static volatile Session sSession = null;

    private User mCurrentUser;
    private List<Pitch> mCurrentPitchList = new ArrayList<>();

    private Session() {
    }

    public static synchronized Session getInstance() {
        if (sSession == null) {
            sSession = new Session();
        }
        return sSession;
    }


    public User getmCurrentUser() {
        return mCurrentUser;
    }

    public void setmCurrentUser(User mCurrentUser) {
        this.mCurrentUser = mCurrentUser;
    }

    public List<Pitch> getmCurrentPitchList() {
        return mCurrentPitchList;
    }

    public void setmCurrentPitchList(List<Pitch> mCurrentPitchList) {
        this.mCurrentPitchList = mCurrentPitchList;
    }
}
