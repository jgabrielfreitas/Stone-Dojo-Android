package dojo.githubusercore.retrofit;


import java.util.List;

import dojo.githubusercore.user.UserRepoListResponse;
import dojo.githubusercore.user.UserResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by JGabrielFreitas on 06/03/16.
 */
public interface GitHubAPI {

    @GET("users/{user}")
    Call<UserResponse> getUserInfo(@Path("user") String user);
}
