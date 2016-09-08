package edu.neusoft.a124team.dietitian.haoDengKe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.neusoft.a124team.dietitian.R;
import edu.neusoft.a124team.dietitian.haoDengKe.utils.NetUtils;

public class H_ribs extends AppCompatActivity {
    private Handler pic_hdl;
    private ImageView hImageViewRibs;
    private TextView hTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!NetUtils.check(H_ribs.this)) {
            Toast.makeText(H_ribs.this, getString(R.string.h_network_check), Toast.LENGTH_LONG).show();
            return;
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        setContentView(R.layout.activity_h_ribs);
        hImageViewRibs=(ImageView)findViewById(R.id.h_imageview_ribs);
        hTextView=(TextView)findViewById(R.id.h_tv_Internet);
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());

        StringRequest stringRequest = new StringRequest("http://139.129.57.32:8080/Dietitian/SynTxtDataServlet",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                        hTextView.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
                hTextView.setText(error.getMessage());

            }
        });
        mQueue.add(stringRequest);
        pic_hdl = new PicHandler();
        Thread t = new LoadPicThread();
        t.start();



    }


    class LoadPicThread extends Thread {

        @Override
        public void run() {
            Bitmap img = getUrlImage("http://139.129.57.32:8080/My12306/Food/h_imageview_ribs.jpg");
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
            hImageViewRibs.setImageBitmap(myimg);
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
