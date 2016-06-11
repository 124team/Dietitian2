package edu.neusoft.a124team.dietitian.haoDengKe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ViewFlipper;

import edu.neusoft.a124team.dietitian.R;

public class H_fruit extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_fruit);
        viewFlipper=(ViewFlipper)findViewById(R.id.viewflipper);
        viewFlipper.setAutoStart(true); // 设置自动播放功能（点击事件，前自动播放）
        viewFlipper.setFlipInterval(5000);
        if (viewFlipper.isAutoStart() && !viewFlipper.isFlipping()) {
            viewFlipper.startFlipping();
        }
    }
}
