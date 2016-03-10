package dojo.githubuser;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Constructor;
import java.util.List;

import dojo.githubusercore.user.UserRepoListResponse;

/**
 * Created by JGabrielFreitas on 09/03/16.
 */
public class RepoListAdapter extends BaseAdapter {

    Context context;
    List<UserRepoListResponse> repoList;

    public RepoListAdapter(Context context, List<UserRepoListResponse> repoList) {
        this.context = context;
        this.repoList = repoList;
    }

    @Override
    public int getCount() {
        return repoList.size();
    }

    @Override
    public Object getItem(int position) {
        return repoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.repo_item_row, parent, false);


        UserRepoListResponse currentRepo = repoList.get(position);

        TextView repoNameTextview     = (TextView) view.findViewById(R.id.tx_repo_name);
        TextView repoLanguageTextview = (TextView) view.findViewById(R.id.tx_repotec);

        repoNameTextview.setText(currentRepo.getName());
        repoLanguageTextview.setText(currentRepo.getLanguage());

        return view;
    }
}
