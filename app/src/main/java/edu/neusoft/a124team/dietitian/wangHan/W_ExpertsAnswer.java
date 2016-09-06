package edu.neusoft.a124team.dietitian.wangHan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import edu.neusoft.a124team.dietitian.R;

/**
 * 专家解疑版块
 */

public class W_ExpertsAnswer extends AppCompatActivity {

    private ArrayList<HashMap<String,String>> data;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_activity_adapter);
        setTitle("专家解疑");


    }

}
