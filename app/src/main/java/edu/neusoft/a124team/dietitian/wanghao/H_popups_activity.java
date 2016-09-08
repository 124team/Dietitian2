package edu.neusoft.a124team.dietitian.wanghao;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import edu.neusoft.a124team.dietitian.R;

public class H_popups_activity extends AppCompatActivity implements View.OnClickListener {
   private LinearLayout mlinearyout;
    private RelativeLayout r1,r2,r3;
    private Button concel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.MyDialogStyleBottom);
        setContentView(R.layout.activity_y_popups);
        //设置与手机边框无距离
        getWindow().setLayout(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        mlinearyout=(LinearLayout)this. findViewById(R.id.y_popups_layout);
        r1=(RelativeLayout)this. findViewById(R.id.y_r1);
        r2=(RelativeLayout)this. findViewById(R.id.y_r2);
        r3=(RelativeLayout)this. findViewById(R.id.y_r3);
        concel=(Button) findViewById(R.id.y_popups_button);
        //添加选择窗口范围监听可以优先获取触点，即不再执行onTouchEvent()函数，
        // 点击其他地方时执行onTouchEvent()函数销毁Activity
        mlinearyout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击窗口外部关闭窗口！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        concel.setOnClickListener(this);
    }
    //实现onTouchEvent触屏函数但点击屏幕时销毁本Activity
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.y_r1:
                break;
            case R.id.y_r2:
                break;
            case R.id.y_r3:
                break;
            case R.id.y_popups_button:
                break;
            default:
                break;
        }
        finish();
    }
}
