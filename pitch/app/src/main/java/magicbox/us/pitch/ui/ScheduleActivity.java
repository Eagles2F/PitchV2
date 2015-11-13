package magicbox.us.pitch.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import magicbox.us.pitch.R;

public class ScheduleActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, ScheduleActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(pitchListActivity.createIntent(ScheduleActivity.this));
            }
        });
    }
}
