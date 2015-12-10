package magicbox.us.pitch.ui;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import magicbox.us.pitch.R;
import magicbox.us.pitch.entities.Pitch;
import magicbox.us.pitch.network.api.PitchService;
import magicbox.us.pitch.network.model.LikeBody;
import magicbox.us.pitch.network.model.LikeResponse;
import magicbox.us.pitch.util.APIEntrypoint;
import magicbox.us.pitch.util.Session;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A fragment representing a single pitch detail screen.
 * This fragment is either contained in a {@link pitchListActivity}
 * in two-pane mode (on tablets) or a {@link pitchDetailActivity}
 * on handsets.
 */
public class pitchDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Pitch mItem;

    private View mRootView;
    private TextView mDescription;
    private TextView mTags;
    private FloatingActionButton mLikeButton;
    private TextView mLikeCount;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public pitchDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Session.getInstance().getmCurrentPitchList().get(getArguments().getInt(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getTitle());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_pitch_detail, container, false);
        mDescription = (TextView) mRootView.findViewById(R.id.description);
        mTags = (TextView) mRootView.findViewById(R.id.tag);
        mLikeCount = (TextView) mRootView.findViewById(R.id.like_count);
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            mDescription.setText("Description:" + mItem.getDescription());
            mTags.setText("Tags: " + mItem.getTag());
            final String like_count = "" + mItem.getLike();
            mLikeCount.setText(like_count);
        }

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLikeButton = ((pitchDetailActivity) getActivity()).getLikeButton();
        mLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIEntrypoint.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                PitchService service = retrofit.create(PitchService.class);
                Call<LikeResponse> call = service.likePitch(new LikeBody(mItem.getPid()));
                call.enqueue(new Callback<LikeResponse>() {
                    @Override
                    public void onResponse(Response<LikeResponse> response, Retrofit retrofit) {
                        if (response.isSuccess() && response.body().getSuccess()) {
                            Snackbar.make(mRootView, "Liked this Post!", Snackbar.LENGTH_SHORT).show();
                            mItem.setLike(mItem.getLike() + 1);
                            final String like_count = "Like: " + mItem.getLike();
                            mLikeCount.setText(like_count);
                        } else {
                            Snackbar.make(mRootView, "Like Action failed!", Snackbar.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Snackbar.make(mRootView, "Like Action failed!", Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
