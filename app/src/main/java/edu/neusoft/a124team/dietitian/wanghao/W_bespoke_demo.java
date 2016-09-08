package edu.neusoft.a124team.dietitian.wanghao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.neusoft.a124team.dietitian.R;

public class W_bespoke_demo extends android.support.v7.app.AppCompatActivity implements View.OnClickListener {
  private Toolbar mtoolbar;
    private Button y_btn;
    private ImageView bespokeImg;
    private ImageView img1,img2,img3,img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.NoActionBar);
        setContentView(R.layout.activity_y_bespoke_demo);
        img1=(ImageView)this. findViewById(R.id.y_img1);
        img2=(ImageView)this. findViewById(R.id.y_img2);
        img3=(ImageView)this. findViewById(R.id.y_img3);
        img4=(ImageView)this. findViewById(R.id.y_img4);
        img1.setOnClickListener(this) ;
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        //mtoolbar=(Toolbar)this.findViewById(R.id.y_bespoke_toolbar);
        bespokeImg=(ImageView)this. findViewById(R.id.y_img_demo_back);
        bespokeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
       y_btn= (Button)this. findViewById(R.id.y_bespoke_btn);
        y_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(W_bespoke_demo.this,H_popups_activity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.y_img1:
                img1.setImageResource(R.drawable.y_img_true2);
                img2.setImageResource(R.drawable.y_img_true1);
                img3.setImageResource(R.drawable.y_img_true1);
                img4.setImageResource(R.drawable.y_img_true1);
               break;
            case R.id.y_img2:
                img1.setImageResource(R.drawable.y_img_true1);
                img2.setImageResource(R.drawable.y_img_true2);
                img3.setImageResource(R.drawable.y_img_true1);
                img4.setImageResource(R.drawable.y_img_true1);
                break;
            case R.id.y_img3:
                img2.setImageResource(R.drawable.y_img_true1);
                img1.setImageResource(R.drawable.y_img_true1);
                img3.setImageResource(R.drawable.y_img_true2);
                img4.setImageResource(R.drawable.y_img_true1);
                break;
            case R.id.y_img4:
                img2.setImageResource(R.drawable.y_img_true1);
                img1.setImageResource(R.drawable.y_img_true1);
                img3.setImageResource(R.drawable.y_img_true1);
                img4.setImageResource(R.drawable.y_img_true2);
                break;
        }
    }
}
