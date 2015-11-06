package magicbox.us.pitch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseActivity extends AppCompatActivity {
    public static Intent createIntent(Context context) {
        return new Intent(context, ChooseActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        View seek = findViewById(R.id.pitcher);
        seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ScheduleActivity.createIntent(ChooseActivity.this));
            }
        });

        View offer = findViewById(R.id.pitchee);
        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(pitchListActivity.createIntent(ChooseActivity.this));
            }
        });
    }
}
