package app.ariadust.githubsample.github;

import android.content.Context;

import app.ariadust.githubsample.github.network.GithubApi;
import app.ariadust.githubsample.github.storage.GithubStorage;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bobby on 2019-06-20.
 */

public class Github {

    private GithubApi api;
    private GithubStorage storage;

    public Github(Context context) {
        this.api = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(githubClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubApi.class);
        this.storage = new GithubStorage(context);
    }

    private Interceptor authorizationInterceptor() {
        return chain -> {
            final Request originalRequest = chain.request();
            final String credentials = storage.getCredentials();
            final Request newRequest = originalRequest.newBuilder()
                    .header("Accept", "application/vnd.github.v3+json")
                    .header("Authorization", "Basic " + credentials)
                    .build();
            return chain.proceed(newRequest);
        };
    }

    private OkHttpClient githubClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(authorizationInterceptor())
                .build();
    }

    public GithubApi getApi() {
        return api;
    }

    public GithubStorage getStorage() {
        return storage;
    }
}
