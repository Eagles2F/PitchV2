package magicbox.us.pitch;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * The entry of App
 */
public class PitchApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //set up firebase
        Firebase.setAndroidContext(this);
    }
}
