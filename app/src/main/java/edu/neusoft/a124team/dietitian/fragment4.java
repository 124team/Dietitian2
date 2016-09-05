package edu.neusoft.a124team.dietitian;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.ViewFlipper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.neusoft.a124team.dietitian.haoDengKe.H_breakfast;
import edu.neusoft.a124team.dietitian.haoDengKe.H_fash;
import edu.neusoft.a124team.dietitian.haoDengKe.H_fruit;
import edu.neusoft.a124team.dietitian.haoDengKe.H_ribs;
import edu.neusoft.a124team.dietitian.haoDengKe.H_search;


public class fragment4 extends Fragment {
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private List<Map<String, Object>> data_list;
    private ImageButton hImageButtonSearch;
    private ImageButton hImageButtonOnclick1;
    private ImageButton hImageButtonOnclick2;
    private ImageButton hImageButtonOnclick5;
    private ImageButton hImageButtonOnclick8;
    private ViewFlipper viewFlipper;
    private Handler pic_hdl;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout4, null);
        final ScrollView svResult = (ScrollView)rootView.findViewById(R.id.h_home_scroll);
        svResult.post(new Runnable() {
            public void run() {
                svResult.fullScroll(ScrollView.FOCUS_UP);
                svResult.setFocusable(false);
                svResult.setFocusableInTouchMode(false);
            }
        });
        viewFlipper=(ViewFlipper)rootView.findViewById(R.id.h_home_vie);
        viewFlipper.setAutoStart(true); // 设置自动播放功能（点击事件，前自动播放）
        viewFlipper.setFlipInterval(3000);
        if (viewFlipper.isAutoStart() && !viewFlipper.isFlipping()) {
            viewFlipper.startFlipping();
        }
        data_list = new ArrayList<Map<String, Object>>();
        pic_hdl = new PicHandler();
        hImageButtonSearch=(ImageButton)rootView.findViewById(R.id.imageSearch);
        hImageButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), H_search.class);
                startActivity(intent);
            }
        });
        hImageButtonOnclick1=(ImageButton)rootView.findViewById(R.id.hImageButtonOnclick1);
        hImageButtonOnclick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), H_ribs.class);
                startActivity(intent);


            }
        });
        hImageButtonOnclick2=(ImageButton)rootView.findViewById(R.id.hImageButtonOnclick2);
        hImageButtonOnclick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), H_fash.class);
                startActivity(intent);


            }
        });
        hImageButtonOnclick5=(ImageButton)rootView.findViewById(R.id.hImageButtonOnclick5);
        hImageButtonOnclick5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), H_breakfast.class);
                startActivity(intent);
            }
        });
        hImageButtonOnclick8=(ImageButton)rootView.findViewById(R.id.hImageButtonOnclick8);
        hImageButtonOnclick8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(getActivity().getApplicationContext(), H_fruit.class);
                startActivity(intent);
            }
        });

        spinner1=(Spinner)rootView.findViewById(R.id.hSpinnerSelect1);
        spinner2=(Spinner)rootView.findViewById(R.id.hSpinnerSelect2);
        spinner3=(Spinner)rootView.findViewById(R.id.hSpinnerSelect3);
        ArrayList<String> SpinnerSource1 = new ArrayList<String>();
        SpinnerSource1.add("早餐");
        SpinnerSource1.add("午餐");
        SpinnerSource1.add("晚餐");
        ArrayList<String> SpinnerSource2 = new ArrayList<String>();
        SpinnerSource2.add("蔬菜");
        SpinnerSource2.add("肉类");
        SpinnerSource2.add("水果");
        ArrayList<String> SpinnerSource3 = new ArrayList<String>();
        SpinnerSource3.add("青少年");
        SpinnerSource3.add("婴儿");
        SpinnerSource3.add("孕妇");
        SpinnerSource3.add("老人");


        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                SpinnerSource1
        );
        ArrayAdapter <String>adapter2=new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                SpinnerSource2
        );
        ArrayAdapter <String>adapter3=new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                SpinnerSource3
        );
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        data_list = new ArrayList<Map<String, Object>>();
        Thread t = new LoadPicThread();
        t.start();
        return rootView;

    }
    class LoadPicThread extends Thread {

        @Override
        public void run() {
            Bitmap img = getUrlImage("http://139.129.57.32:8080/My12306/Food/h_imagebutton_select1.jpg");
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
            hImageButtonOnclick1.setImageBitmap(myimg);
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

