package magicbox.us.pitch;

import android.app.Application;

/**
 * The entry of App
 */
public class PitchApp extends Application {
    public static PitchApp sApplication = null;
    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static PitchApp getInstance() {
        return sApplication;
    }
}
