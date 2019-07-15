package app.ariadust.githubsample.github.network;

import app.ariadust.githubsample.github.model.GitHubRepo;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by Bobby on 2019-06-20.
 */

public interface GithubApi {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForuser(@Path("user") String user);

    @POST("/user/repos")
    @FormUrlEncoded
    Call<GitHubRepo> reposSave(
            @Field("name") String name,
            @Field("description") String description,
            @Field("homepage") String homepage,
            @Field("private") boolean set_private);

//    @POST("/user/repos")
//    @FormUrlEncoded
//    Call<GitHubRepo> reposSave(@Body GitHubRepo gitHubRepo);

}
