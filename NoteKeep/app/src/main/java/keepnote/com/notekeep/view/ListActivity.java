package keepnote.com.notekeep.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.List;

import keepnote.com.notekeep.R;
import keepnote.com.notekeep.adapter.CustomAdapter;
import keepnote.com.notekeep.data.FakeDataSource;
import keepnote.com.notekeep.data.ListItem;
import keepnote.com.notekeep.logic.Controller;
import keepnote.com.notekeep.utils.LogHelper;

public class ListActivity extends AppCompatActivity implements ViewInterface{

    private static final String EXTRA_DATE_TIME = "extra_date_time";
    private static final String EXTRA_MSG = "extra_msg";
    private static final String EXTRA_COL = "extra_col";

    //List<ListItem> listOfData;

    LayoutInflater layoutInflater;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recycler_list_view);
       // layoutInflater = getLayoutInflater();

        //This is a dependency injection here
        controller = new Controller(this, new FakeDataSource());
    }


    @Override
    public void startDetailActivity(String dateTime, String msg, int colorRes) {

        Intent i =new Intent(this,DetailActivity.class);
        i.putExtra(EXTRA_DATE_TIME,dateTime);
        i.putExtra(EXTRA_MSG,msg);
        i.putExtra(EXTRA_COL,colorRes);
        startActivity(i);

    }

    @Override
    public void setUpAdapterView(List<ListItem> listofData) {
        LogHelper.successLog(String.valueOf(listofData.size()));

        customAdapter = new CustomAdapter(this,listofData,controller);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);
    }
}
