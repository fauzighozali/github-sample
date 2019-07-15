package app.ariadust.githubsample.feature.repositori;

import android.text.TextUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import app.ariadust.githubsample.R;
import app.ariadust.githubsample.github.Github;
import app.ariadust.githubsample.github.model.GitHubRepo;
import app.ariadust.githubsample.github.network.GithubApi;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;

public class RepositoryCreateActivity extends AppCompatActivity {

    private EditText repoName, repoDescription;
    private Button buttonCreateRepo;

    Github github;
    GithubApi githubApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_create);

        repoName = (EditText) findViewById(R.id.editTextRepoName);
        repoDescription = (EditText) findViewById(R.id.editTextRepoDescription);
        buttonCreateRepo = (Button) findViewById(R.id.buttonCreateRepo);

        github = new Github(this);
        githubApi = github.getApi();

        buttonCreateRepo.setOnClickListener(view -> {
            String name = repoName.getText().toString().trim();
            String description = repoDescription.getText().toString().trim();

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(description)) {
                sendPost(name, description);
            }
        });
    }

    private void sendPost(String name, String description) {
        githubApi.reposSave(name, description, "https://github.com", false)
                .enqueue(new Callback<GitHubRepo>() {
                    @Override
                    public void onResponse(Call<GitHubRepo> call, Response<GitHubRepo> response) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<GitHubRepo> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
