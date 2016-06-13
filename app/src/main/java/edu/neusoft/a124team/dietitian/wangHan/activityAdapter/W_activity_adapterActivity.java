package edu.neusoft.a124team.dietitian.wangHan.activityAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import edu.neusoft.a124team.dietitian.R;

public class W_activity_adapterActivity extends AppCompatActivity {

    LinearLayout camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_activity_adapter);

     //   camera = (LinearLayout) findViewById(R.id.w_btn_adapter_camera);
 /*     camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(W_activity_adapterActivity.this, W_CamreaActivity.class);
                startActivity(intent);*//*
            }
        });*/



    }
}
