package edu.neusoft.a124team.dietitian;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;

import edu.neusoft.a124team.dietitian.wangRui.S_dataControl;
import edu.neusoft.a124team.dietitian.wangRui.S_healthyOne;
import edu.neusoft.a124team.dietitian.wangRui.S_healthy_two;
import edu.neusoft.a124team.dietitian.wangRui.baseAdapter.S_adapter_solveBug;
import edu.neusoft.a124team.dietitian.wangRui.baseAdapter.S_newsBasAdapter;
import edu.neusoft.a124team.dietitian.wangRui.S_healthy_Zero;


public class fragment1 extends Fragment {

    private ArrayList<HashMap<String, String>> data;
    private ListView lv;
    private ViewFlipper viewFlipper;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout1, container, false);

        final ScrollView svResult = (ScrollView)view.findViewById(R.id.s_home_scroll);
        svResult.post(new Runnable() {
            public void run() {
                svResult.fullScroll(ScrollView.FOCUS_UP);

            }
        });

        lv = (ListView) view.findViewById(R.id.s_home_thyList);
        lv.setOnItemClickListener(new MyLinstener());
        viewFlipper=(ViewFlipper)view.findViewById(R.id.s_home_vie);
        viewFlipper.setAutoStart(true); // 设置自动播放功能（点击事件，前自动播放）
        viewFlipper.setFlipInterval(3000);
        if (viewFlipper.isAutoStart() && !viewFlipper.isFlipping()) {
            viewFlipper.startFlipping();
        }
        data = new ArrayList<>();
        HashMap<String, String> map1 = S_dataControl.getDataSource(
                R.drawable.s_home_newsimg1+ "","高价水果卖的可能只是概念,牛奶草莓没有牛奶味","大连网"
                );
        data.add(map1);
        HashMap<String, String> map2 = S_dataControl.getDataSource(
                R.drawable.s_home_newsimg2+ "","四大食物可使口气清新 可以尝试一下","大连网"
        );
        data.add(map2);
        HashMap<String, String> map3 = S_dataControl.getDataSource(
                R.drawable.s_home_newsimg3+ "","食用零食过量致情绪激动 山楂片利胆消食","大连网"
        );
        data.add(map3);
        HashMap<String, String> map4 = S_dataControl.getDataSource(
                R.drawable.s_home_newsimg1+ "","高价水果卖的可能只是概念,牛奶草莓没有牛奶味","大连网"
        );

        data.add(map4);
        S_newsBasAdapter adapter = new S_newsBasAdapter(getActivity(), data);
        lv.setAdapter(adapter);
        S_adapter_solveBug.setListViewHeightBasedOnChildren(lv);
        return view;

    }
    public  class  MyLinstener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            switch (position) {
                case 0:
                    expressItemClickOne(0);
                    break;
                case 1:
                    expressItemClickTwo(1);
                    break;
                case 2:
                    expressItemClickThree(2);
                    break;
                case 3:
                    expressItemClickFour(3);
                    break;
            }
        }

    }
    public void expressItemClickOne(int position){
        Intent intent = new Intent();

        intent.setClass(getActivity(), S_healthy_Zero.class);

        startActivity(intent);
    }
    public void expressItemClickTwo(int position){
        Intent intent = new Intent();
        intent.setClass(getActivity(), S_healthyOne.class);
        startActivity(intent);
    }
    public void expressItemClickThree(int position){
        Intent intent = new Intent();
        intent.setClass(getActivity(), S_healthy_two.class);
        startActivity(intent);
    }
    public void expressItemClickFour(int position){
        Intent intent = new Intent();
        intent.setClass(getActivity(), S_healthy_two.class);
        startActivity(intent);
    }


}

