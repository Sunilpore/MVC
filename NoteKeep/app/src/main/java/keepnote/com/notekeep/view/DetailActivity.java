package keepnote.com.notekeep.view;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import keepnote.com.notekeep.R;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_DATE_TIME = "extra_date_time";
    private static final String EXTRA_MSG = "extra_msg";
    private static final String EXTRA_COL = "extra_col";

    TextView mDateTime;
    TextView mMsg;
    View mColoredBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mDateTime = findViewById(R.id.date_time_header);
        mMsg = findViewById(R.id.msg_body);
        mColoredBackground = findViewById(R.id.cont_colored_background);

        Intent iData = getIntent();
        if(iData!=null){
            String dateTime = iData.getStringExtra(EXTRA_DATE_TIME);
            String msg = iData.getStringExtra(EXTRA_MSG);
            int colRes = iData.getIntExtra(EXTRA_COL,0);

            mDateTime.setText(dateTime);
            mMsg.setText(msg);
            mColoredBackground.setBackgroundColor(ContextCompat.getColor(this,colRes));
        }

    }
}
