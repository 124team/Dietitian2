package edu.neusoft.a124team.dietitian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import edu.neusoft.a124team.dietitian.wangRui.S_dataControl;
import edu.neusoft.a124team.dietitian.wangRui.S_newsBasAdapter;


public class fragment1 extends Fragment {
    private LinearLayout linearLayout;
    private ArrayList<HashMap<String, String>> data;
    private ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout1, container, false);

        linearLayout=(LinearLayout)view.findViewById(R.id.s_home_cyclelayout);
        lv = (ListView) view.findViewById(R.id.s_home_thyList);

        data = new ArrayList<>();
        HashMap<String, String> map1 = S_dataControl.getDataSource(
                R.drawable.s_home_newsimg1+ "","三明治", "很好吃"
                );
        data.add(map1);
       S_newsBasAdapter adapter = new S_newsBasAdapter(getActivity(), data);
        lv.setAdapter(adapter);

        int [] img1=new int[]{R.drawable.s_home_imgcycle1,
                R.drawable.s_home_imgcycle2, R.drawable.s_home_imgcycle3};
        for(int i=0;i<img1.length;i++) {
            View view1=inflater.inflate(R.layout.s_home_cycle, null);
            ImageView img=(ImageView)view1.findViewById(R.id.s_Img_Cycle);
            img.setImageResource(img1[i]);
            linearLayout.addView(view1);
        }
        return view;
    }
}