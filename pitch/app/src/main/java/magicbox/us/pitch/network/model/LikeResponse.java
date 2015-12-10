package magicbox.us.pitch.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by evan on 12/9/15.
 */
public class LikeResponse {
    @SerializedName("success")
    @Expose
    private boolean success;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
