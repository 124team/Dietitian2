package edu.neusoft.a124team.dietitian.haoDengKe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.neusoft.a124team.dietitian.R;
import edu.neusoft.a124team.dietitian.haoDengKe.utils.NetUtils;

public class H_harm extends AppCompatActivity {
    private Handler pic_hdl;
    private ImageView hImageViewHarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!NetUtils.check(H_harm.this)) {
            Toast.makeText(H_harm.this, getString(R.string.network_check), Toast.LENGTH_LONG).show();
            return;
        }
        setContentView(R.layout.activity_h_harm);
        hImageViewHarm=(ImageView)findViewById(R.id.h_iamgebutton_searchitem1);
        pic_hdl = new PicHandler();
        Thread t = new LoadPicThread();
        t.start();

    }

    class LoadPicThread extends Thread {

        @Override
        public void run() {
            Bitmap img = getUrlImage("http://139.129.57.32:8080/My12306/Food/h_iamgebutton_searchitem1.jpg");
            Message msg = pic_hdl.obtainMessage();
            msg.what = 0;
            msg.obj = img;
            pic_hdl.sendMessage(msg);
        }
    }
    class PicHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            //String s = (String)msg.obj;
            //ptv.setText(s);
            Bitmap myimg = (Bitmap) msg.obj;
           hImageViewHarm.setImageBitmap(myimg);
        }
    }
    public Bitmap getUrlImage(String url) {
        Bitmap img = null;
        try {
            URL picurl = new URL(url);
            // 获得连接
            HttpURLConnection conn = (HttpURLConnection)picurl.openConnection();
            conn.setConnectTimeout(6000);//设置超时
            conn.setDoInput(true);
            conn.setUseCaches(false);//不缓存
            conn.connect();
            InputStream is = conn.getInputStream();//获得图片的数据流
            img = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }
}
