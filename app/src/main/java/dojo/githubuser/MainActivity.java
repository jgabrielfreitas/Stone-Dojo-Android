package dojo.githubuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import dojo.githubuser.utils.Feedback;
import dojo.githubusercore.retrofit.GitHubAPI;
import dojo.githubusercore.retrofit.RetrofitCallback;
import dojo.githubusercore.retrofit.RetrofitConsumer;
import dojo.githubusercore.user.UserRepoListResponse;
import dojo.githubusercore.user.UserResponse;
import retrofit.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button searchUserButton;
    EditText userEditText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instanceViews();
    }

    private void instanceViews() {

        searchUserButton = (Button)   findViewById(R.id.searchUserButton);
        userEditText     = (EditText) findViewById(R.id.userEditText);

        searchUserButton.setOnClickListener(this);
    }

    public void onClick(View v) {

        String usernameToSearch = userEditText.getText().toString();

        RetrofitConsumer<UserResponse> retrofitConsumer = new RetrofitConsumer<UserResponse>(this, BuildConfig.URL_API);
        GitHubAPI gitHubAPI = retrofitConsumer.getRetrofit().create(GitHubAPI.class);
        retrofitConsumer.executable(gitHubAPI.getUserInfo(usernameToSearch));
        retrofitConsumer.setErrorClass(UserResponse.class);
        retrofitConsumer.setWorkInBackground(false);
        retrofitConsumer.setDialogMessage("Carregando informações");
        retrofitConsumer.setRetrofitCallback(new RetrofitCallback<UserResponse>() {
            public void onSuccess(UserResponse response) {
                Log.e("Success", response.toString());
            }

            public void clientError(UserResponse object, Response<UserResponse> response) {
                Feedback.attentionFeedback(MainActivity.this, object.getMessage());
            }

            public void internalServerError() {
                Feedback.attentionFeedback(MainActivity.this, "GitHub error");
            }

            public void onError(Throwable t) {
                Feedback.attentionFeedback(MainActivity.this, "Ooops, check log for this error");
            }
        });
        retrofitConsumer.run();
    }
}
