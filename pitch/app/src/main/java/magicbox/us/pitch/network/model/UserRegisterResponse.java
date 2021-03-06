package magicbox.us.pitch.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import magicbox.us.pitch.util.Key;

public class UserRegisterResponse {

    @SerializedName(Key.SUCCESS)
    @Expose
    private boolean success;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}