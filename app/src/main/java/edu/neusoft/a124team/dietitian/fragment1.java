package edu.neusoft.a124team.dietitian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class fragment1 extends Fragment {
    private LinearLayout linearLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout1, container, false);

        linearLayout=(LinearLayout)view.findViewById(R.id.s_home_cyclelayout);

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