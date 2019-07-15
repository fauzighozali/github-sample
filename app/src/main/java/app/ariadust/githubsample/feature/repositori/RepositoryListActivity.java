package app.ariadust.githubsample.feature.repositori;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import app.ariadust.githubsample.R;
import app.ariadust.githubsample.github.Github;
import app.ariadust.githubsample.github.adapter.GitHubRepoAdapter;
import app.ariadust.githubsample.github.model.GitHubRepo;
import app.ariadust.githubsample.github.network.GithubApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

/**
 * Created by Bobby on 2019-06-20.
 */

public class RepositoryListActivity extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;
    private ListView listView;

    Github github;
    GithubApi githubApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_list);

        github = new Github(this);
        githubApi = github.getApi();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.listView);

//        String sessionId = getIntent().getStringExtra("username");

        Call<List<GitHubRepo>> call = githubApi.reposForuser("fauzighozali");
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> repos = response.body();
                listView.setAdapter(new GitHubRepoAdapter(RepositoryListActivity.this, -1, repos));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(RepositoryListActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_plus) {
            Intent intent = new Intent(RepositoryListActivity.this, RepositoryCreateActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
