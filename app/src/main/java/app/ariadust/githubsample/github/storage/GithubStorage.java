package app.ariadust.githubsample.github.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Bobby on 2019-06-20.
 */

public class GithubStorage {

    private final static String GITHUB_CREDENTIALS = "GithubCredentials";

    private SharedPreferences sharedPreferences;

    public GithubStorage(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("default", Context.MODE_PRIVATE);
    }

    public void setCredentials(@NonNull String email, @NonNull String password) {
        final String credentials = Base64.encodeToString((email + ":" + password).getBytes(), Base64.NO_WRAP);
        sharedPreferences.edit().putString(GITHUB_CREDENTIALS, credentials).apply();
    }

    @Nullable
    public String getCredentials() {
        return sharedPreferences.getString(GITHUB_CREDENTIALS, null);
    }
}
