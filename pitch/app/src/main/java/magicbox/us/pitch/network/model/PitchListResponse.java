package magicbox.us.pitch.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import magicbox.us.pitch.entities.Pitch;

/**
 * Created by evan on 12/8/15.
 */
public class PitchListResponse {
    @SerializedName("meta")
    @Expose
    private List<Pitch> pitchList;

    public List<Pitch> getPitchList() {
        return pitchList;
    }

    public void setPitchList(List<Pitch> pitchList) {
        this.pitchList = pitchList;
    }

    @SerializedName("success")
    @Expose
    private String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
