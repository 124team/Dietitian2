package edu.neusoft.a124team.dietitian.wangHan.activityAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import edu.neusoft.a124team.dietitian.R;
import edu.neusoft.a124team.dietitian.wangHan.W_camera;

public class W_activity_adapterActivity extends AppCompatActivity {

    LinearLayout camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_activity_adapter);

      camera = (LinearLayout) findViewById(R.id.w_btn_adapter_camera);
      camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);*/
                Intent intent = new Intent(W_activity_adapterActivity.this, W_camera.class);
                startActivity(intent);

            }
        });


    }
}
