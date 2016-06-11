package edu.neusoft.a124team.dietitian.wangRui.personalEdit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by wang5 on 2016/6/11.
 */
public class S_personalAgeEdit extends EditText {
    private String str;
    public S_personalAgeEdit(Context context) {
        super(context);
    }

    public S_personalAgeEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public S_personalAgeEdit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public S_personalAgeEdit(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public void setStr(String str){
        this.str=str;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);

//编写提示文字。
        canvas.drawText("年龄",50,getHeight()/2+23,paint);
        super.onDraw(canvas);
    }
}
