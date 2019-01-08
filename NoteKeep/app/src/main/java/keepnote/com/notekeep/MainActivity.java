package keepnote.com.notekeep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import keepnote.com.notekeep.view.ListActivity;

public class MainActivity extends AppCompatActivity {

    //TODO Short Cut key note
   /* Ctrl + 1 -> Switch between Project File view and Activity/xml file view
      Ctrl + Shift + N -> To open a file
      Ctrl + N -> To open a class

   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this,ListActivity.class);
        startActivity(i);
        finish();
    }
}
