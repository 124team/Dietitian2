package edu.neusoft.a124team.dietitian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;

import edu.neusoft.a124team.dietitian.wangRui.S_dataControl;
import edu.neusoft.a124team.dietitian.wangRui.baseAdapter.S_adapter_solveBug;
import edu.neusoft.a124team.dietitian.wangRui.baseAdapter.S_newsBasAdapter;


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
                R.drawable.s_home_newsimg1+ "","高价水果卖的可能只是概念,牛奶草莓没有牛奶味","大连网"
        );
        data.add(map2);
        HashMap<String, String> map3 = S_dataControl.getDataSource(
                R.drawable.s_home_newsimg1+ "","高价水果卖的可能只是概念,牛奶草莓没有牛奶味","大连网"
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

}