package edu.neusoft.a124team.dietitian.wangHan;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Hansen on 2016/6/11.
 * 用来实现跑马灯效果，滚动显示天气预报
 */
public class W_diy_textView extends TextView {

    public W_diy_textView(Context context) {
        super(context);
    }

    public W_diy_textView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public W_diy_textView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused(){
        return true;
    }
}
