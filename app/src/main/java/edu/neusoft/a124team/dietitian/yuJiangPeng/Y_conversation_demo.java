package edu.neusoft.a124team.dietitian.yuJiangPeng;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import edu.neusoft.a124team.dietitian.R;

public class Y_conversation_demo extends android.support.v7.app.AppCompatActivity {
private Toolbar mtoolBar;
    private ImageView converImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.NoActionBar);
        setContentView(R.layout.activity_y_conversation_demo);
        //mtoolBar=(Toolbar)this. findViewById(R.id.y_conver_toolbar);
        converImg=(ImageView)this. findViewById(R.id.y_img_conver_back);
        converImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
