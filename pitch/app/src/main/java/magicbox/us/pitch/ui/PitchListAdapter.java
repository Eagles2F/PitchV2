package magicbox.us.pitch.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import magicbox.us.pitch.R;
import magicbox.us.pitch.entities.Pitch;
import magicbox.us.pitch.util.Utils;

/**
 * Created by evan on 12/8/15.
 */
public class PitchListAdapter extends BaseAdapter {
    private List<Pitch> pitchList = new ArrayList<>();
    private final LayoutInflater mInflater;

    public PitchListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pitchList.size();
    }

    @Override
    public Object getItem(int position) {
        return pitchList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Pitch pitch = (Pitch) getItem(position);
        PitchViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_pitch, parent, false);
            viewHolder = new PitchViewHolder();
            viewHolder.mTitle = (TextView) convertView.findViewById(R.id.title);
            viewHolder.mEmail = (TextView) convertView.findViewById(R.id.email);
            viewHolder.mLike = (TextView) convertView.findViewById(R.id.like);
            viewHolder.mIcon = (ImageView) convertView.findViewById(R.id.thumbnail);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (PitchViewHolder) convertView.getTag();
        }

        viewHolder.mTitle.setText(pitch.getTitle());
        viewHolder.mEmail.setText(pitch.getEmail());
        final String like = "" + pitch.getLike();
        viewHolder.mLike.setText(like);
        viewHolder.mIcon.setImageResource(Utils.getDrawableId());
        return convertView;
    }

    public void setData(List<Pitch> data) {
        pitchList = data;
        notifyDataSetChanged();
    }

    public static class PitchViewHolder {
        TextView mTitle;
        TextView mEmail;
        TextView mLike;
        ImageView mIcon;
    }
}
