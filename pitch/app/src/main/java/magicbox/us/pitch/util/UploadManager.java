package magicbox.us.pitch.util;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by evan on 12/7/15.
 */
public abstract class UploadManager {

    public static void dispatchFileChooserIntent(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        activity.startActivityForResult(
                Intent.createChooser(intent, "Select a File to Upload"),
                Code.REQUEST_FILE);
    }
}

