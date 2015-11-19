package magicbox.us.pitch.exception;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

/**
 *
 * Log the exception and pop up an alert
 *
 */
public class PitchException {
    private static final String TAG = "PITCH DEBUG";

    public void log(String msg, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("ERROR");
        builder.setMessage(msg);
        builder.setPositiveButton("OK", null);
        builder.show();

        Log.d(TAG, msg);
    }
}
