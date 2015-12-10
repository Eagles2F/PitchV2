package magicbox.us.pitch.network.api;

import com.squareup.okhttp.RequestBody;

import magicbox.us.pitch.network.model.LikeBody;
import magicbox.us.pitch.network.model.LikeResponse;
import magicbox.us.pitch.network.model.PitchCreateBody;
import magicbox.us.pitch.network.model.PitchCreateResponse;
import magicbox.us.pitch.network.model.PitchListResponse;
import magicbox.us.pitch.util.Key;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Query;

/**
 * Created by evan on 12/7/15.
 */
public interface PitchService {
    @POST("/pitch/pitch")
    Call<PitchCreateResponse> create(
//            @Part(Key.VIDEO + "\"; filename=\"pitch_video\"")RequestBody file,
//            @Part(Key.DESCRIPTION) String description,
//            @Part(Key.TITLE) String title,
//            @Part(Key.TAG) String tag,
//            @Part(Key.EMAIL) String email,
//            @Part(Key.DATE) String date
            @Body PitchCreateBody body
    );

    @GET("/pitch/list")
    Call<PitchListResponse> listUserRepo(@Query(Key.EMAIL) String email);

    @GET("/pitch/list")
    Call<PitchListResponse> listAll();

    @POST("/pitch/like")
    Call<LikeResponse> likePitch(@Body LikeBody body);
}
