package app.ariadust.githubsample.github.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import app.ariadust.githubsample.R;
import app.ariadust.githubsample.github.model.GitHubRepo;
import app.ariadust.githubsample.github.model.Owner;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.List;

public class GitHubRepoAdapter extends ArrayAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<GitHubRepo> list;

    public GitHubRepoAdapter(Context context, int resource, List<GitHubRepo> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item, null);
        }
        TextView name = (TextView) view.findViewById(R.id.textViewName);
        TextView description = (TextView) view.findViewById(R.id.textViewDescription);
        TextView last_update = (TextView) view.findViewById(R.id.textViewLastUpdate);
        TextView owner_name = (TextView) view.findViewById(R.id.textViewOwnerName);
        CircleImageView owner_avatar = (CircleImageView) view.findViewById(R.id.imageViewAvatar);
        TextView forks_count = (TextView) view.findViewById(R.id.textViewForks);
        TextView stargazers_count = (TextView) view.findViewById(R.id.textViewStargazers);
        TextView watchers_count = (TextView) view.findViewById(R.id.textViewWatchers);

        GitHubRepo gitHubRepo = list.get(position);
        if (name != null) {
            name.setText(gitHubRepo.getName());
            description.setText(gitHubRepo.getDescription());
            last_update.setText(gitHubRepo.getUpdated_at());
            owner_name.setText(gitHubRepo.getOwner().getLogin());
            Picasso.get().load(gitHubRepo.getOwner().getAvatar_url()).into(owner_avatar);
            forks_count.setText(String.valueOf(gitHubRepo.getForks_count()));
            stargazers_count.setText(String.valueOf(gitHubRepo.getStargazers_count()));
            watchers_count.setText(String.valueOf(gitHubRepo.getWatchers_count()));
        }
        return view;
    }
}
