package magicbox.us.pitch.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import magicbox.us.pitch.R;
import magicbox.us.pitch.network.api.PitchService;
import magicbox.us.pitch.network.model.PitchCreateBody;
import magicbox.us.pitch.network.model.PitchCreateResponse;
import magicbox.us.pitch.util.APIEntrypoint;
import magicbox.us.pitch.util.Code;
import magicbox.us.pitch.util.Session;
import magicbox.us.pitch.util.UploadManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ScheduleActivity extends AppCompatActivity {
    private View mRootView;

    private TextView mTitle;
    private TextView mDes;
    private TextView mTag;
    private DatePicker mPicker;

    private String mVideoPath;
    public static Intent createIntent(Context context) {
        return new Intent(context, ScheduleActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        mRootView = findViewById(R.id.root);

        mPicker = (DatePicker) findViewById(R.id.datePicker);

        mTitle = (TextView) findViewById(R.id.title);

        mDes = (TextView) findViewById(R.id.description);

        mTag = (TextView) findViewById(R.id.tag);

        findViewById(R.id.upload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadManager.dispatchFileChooserIntent(ScheduleActivity.this);
            }
        });

        findViewById(R.id.create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (TextUtils.isEmpty(mVideoPath)) {
//                    Snackbar.make(mRootView, "Please upload an video!",
//                            Snackbar.LENGTH_SHORT).show();
//                    return;
//                }

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIEntrypoint.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                PitchService service = retrofit.create(PitchService.class);

//                File file = new File(mVideoPath);

//                RequestBody requestBody =
//                        RequestBody.create(MediaType.parse("multipart/form-data"), file);

                String year = Integer.toString(mPicker.getYear());
                String month = Integer.toString(mPicker.getMonth());
                String day = Integer.toString(mPicker.getDayOfMonth());

                String date = String.format("%s-%s-%s", year, month, day);
                Log.i("evan", date);
                PitchCreateBody body = new PitchCreateBody(Session.getInstance().getmCurrentUser().getmEmail(),
                        mDes.getText().toString(), mTag.getText().toString(), mTitle.getText().toString(), date);
                Call<PitchCreateResponse> call = service.create(body);
//                Call<PitchCreateResponse> call = service.create(mDes.getText().toString(),
//                        mTitle.getText().toString(), mTag.getText().toString(),
//                        Session.getInstance().getmCurrentUser().getmEmail(), date);
                call.enqueue(new Callback<PitchCreateResponse>() {
                    @Override
                    public void onResponse(Response<PitchCreateResponse> response, Retrofit retrofit) {
                        if (response.isSuccess()) {
                            Snackbar.make(mRootView, "Pitch Event Uploaded Successfully!",
                                    Snackbar.LENGTH_SHORT).show();
                            startActivity(pitchListActivity.createIntent(ScheduleActivity.this));
                        } else {
                            Snackbar.make(mRootView, "Pitch Event Uploading Failed!",
                                    Snackbar.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Snackbar.make(mRootView, "Pitch Event Uploading Failed!",
                                Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case Code.REQUEST_FILE: {
                    final Uri uri = data.getData();
                    mVideoPath = uri.getPath();
                    Log.i("evan", mVideoPath);
                    break;
                }
                default: {
                    super.onActivityResult(requestCode, resultCode, data);
                    break;
                }
            }
        }
    }
}
