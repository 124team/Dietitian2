package edu.neusoft.a124team.dietitian.haoDengKe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import edu.neusoft.a124team.dietitian.R;

public class H_breakfast_item2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_breakfast_item2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        ImageView imageview = (ImageView) findViewById(R.id.imageView1);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = getIntent().getExtras();
            int imgs = bundle.getInt("img");
            imageview.setImageResource(imgs);
            String StringE = intent.getStringExtra("Title");
            String StringB = intent.getStringExtra("Content");
            TextView text1 = (TextView) findViewById(R.id.text3);
            text1.setText(StringE);
            TextView text2 = (TextView) findViewById(R.id.text4);
            text2.setText(StringB);

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.mn_contract_add:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}