package dojo.githubuser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import dojo.githubusercore.retrofit.GitHubAPI;
import dojo.githubusercore.retrofit.RetrofitCallback;
import dojo.githubusercore.retrofit.RetrofitConsumer;
import dojo.githubusercore.user.UserRepoListResponse;
import retrofit.Response;

public class RepoListActivity extends AppCompatActivity implements RetrofitCallback<List<UserRepoListResponse>>, AdapterView.OnItemClickListener{

    ListView repoListView;
    RepoListAdapter repoListAdapter;
    String repoListURL;
    List<UserRepoListResponse> repoList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);

        repoListURL = getIntent().getStringExtra("usernameToSearch");
        Log.e("repoListURL", repoListURL);
        instanceViews();
    }

    private void instanceViews() {

        repoListView = (ListView) findViewById(R.id.repoListView);

        repoListView.setOnItemClickListener(this);
    }

    protected void onResume() {
        super.onResume();

        RetrofitConsumer<List<UserRepoListResponse>> retrofitConsumer = new RetrofitConsumer<List<UserRepoListResponse>>(this, BuildConfig.URL_API);
        GitHubAPI gitHubAPI = retrofitConsumer.getRetrofit().create(GitHubAPI.class);

        // @GET("users/{user}")
        retrofitConsumer.executable(gitHubAPI.getUserRepos(repoListURL));
        retrofitConsumer.setWorkInBackground(false);
        retrofitConsumer.setDialogMessage("Aguarde...");
        retrofitConsumer.setErrorClass(UserRepoListResponse.class);
        retrofitConsumer.setRetrofitCallback(this);

        retrofitConsumer.run();
    }

    public void onSuccess(List<UserRepoListResponse> response) {
        repoListAdapter = new RepoListAdapter(getApplicationContext(), response);
        repoList = response;

        repoListView.setAdapter(repoListAdapter);

        for (UserRepoListResponse userRepoListResponse : response) {

            Log.e("Name", userRepoListResponse.getName());

        }
    }

    public void clientError(List<UserRepoListResponse> object, Response<List<UserRepoListResponse>> response) {

    }

    public void internalServerError() {

    }

    public void onError(Throwable t) {

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String currentUrl = repoList.get(position).getHtml_url();


        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentUrl));
        startActivity(browserIntent);
    }
}
