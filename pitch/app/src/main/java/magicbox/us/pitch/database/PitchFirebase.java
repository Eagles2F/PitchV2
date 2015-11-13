package magicbox.us.pitch.database;

import com.firebase.client.Firebase;

/**
 * Created by yangwu on 11/13/15.
 */
public class PitchFirebase {
    public static final Firebase rootFirebase = new Firebase("https://pitchyou.firebaseio.com/");
    public static final Firebase usersFirebase = new Firebase("https://pitchyou.firebaseio.com/users");
    public static final Firebase chatFirebase = new Firebase("https://pitchyou.firebaseio.com/chat");
}
