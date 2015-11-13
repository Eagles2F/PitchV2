package magicbox.us.pitch;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by yangwu on 11/13/15.
 */
public class PitchApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //set up firebase
        Firebase.setAndroidContext(this);
    }
}
