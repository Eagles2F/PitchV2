package magicbox.us.pitch.network.api;

import magicbox.us.pitch.network.model.UserRegisterBody;
import magicbox.us.pitch.network.model.UserRegisterResponse;
import magicbox.us.pitch.util.Key;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by evan on 10/20/15.
 */
public interface UserRegisterService {
    @POST("/pitch/register")
    Call<UserRegisterResponse> register(@Body UserRegisterBody body);

    @GET("/pitch/register")
    Call<UserRegisterResponse> login(@Query(Key.EMAIL) String name,
                                          @Query(Key.PASSWORD) String password);
}
