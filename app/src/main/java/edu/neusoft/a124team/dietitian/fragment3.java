package edu.neusoft.a124team.dietitian;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import edu.neusoft.a124team.dietitian.wangHan.W_ExpertsAnswer;
import edu.neusoft.a124team.dietitian.wangHan.W_UserCommunicate;
import edu.neusoft.a124team.dietitian.wangHan.W_moreHotTxt;
import edu.neusoft.a124team.dietitian.wangHan.W_mylove;
import edu.neusoft.a124team.dietitian.wangHan.W_workDisplay;
import edu.neusoft.a124team.dietitian.wangHan.fragmentAdapter.W_adapter_Utility;
import edu.neusoft.a124team.dietitian.wangHan.fragmentAdapter.W_dataControl;
import edu.neusoft.a124team.dietitian.wangHan.fragmentAdapter.W_fragment_baseAdapter;


public class fragment3 extends Fragment {
    private LinearLayout UserCommunication,ExpertsAnswer,WorkDisplay,MyLove,More;
    private ArrayList<HashMap<String,String>> data;
    private ListView listView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout3, container, false);
        UserCommunication = (LinearLayout)view.findViewById(R.id.w_btn_communityLayout);
        UserCommunication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), W_UserCommunicate.class);
                startActivity(intent);
            }
        });

        ExpertsAnswer = (LinearLayout)view.findViewById(R.id.w_btn_expertsAnswerButton);
        ExpertsAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),W_ExpertsAnswer.class);
                startActivity(intent);
            }
        });

        WorkDisplay = (LinearLayout)view.findViewById(R.id.w_btn_workDisplayLayout);
        WorkDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), W_workDisplay.class);
                startActivity(intent);
            }
        });

        MyLove = (LinearLayout)view.findViewById(R.id.w_btn_myLoveLayout);
        MyLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),W_mylove.class);
                startActivity(intent);
            }
        });

        More = (LinearLayout)view.findViewById(R.id.w_btn_moreButton);
        More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),W_moreHotTxt.class);
                startActivity(intent);
            }
        });


        /**
         * 使用适配器制作小窗模版Adapter
         */

        listView = (ListView)view.findViewById(R.id.w_fragment_listView);
        data=new ArrayList<>();

        data.add(W_dataControl.getFrgmentTxt(
                "健康饮食金字塔 教你如何食得营养！",
                "  众所周知古埃及金字塔是世界上的奇迹，是智慧和科学的结晶，是最稳定最牢固的建筑形式。同样营养“金字塔”也是膳食的最佳结构，根据塔的原理平衡营养需求，是调整膳食结构，达到合理营养、增进健康的有效方法。",
                R.drawable.h_breakfast_item1+"",
                R.drawable.h_breakfast_item2+"",
                R.drawable.h_breakfast_item3+""));
        data.add(W_dataControl.getFrgmentTxt("标题",
                "内容111111111111111111111111122222222222222222222222222222222222222222222222222222222222222",
                R.drawable.h_breakfast_item1+"",
                R.drawable.h_breakfast_item2+"",
                R.drawable.h_breakfast_item3+""));
        data.add(W_dataControl.getFrgmentTxt("标题",
                "内容111111111111111111111111122222222222222222222222222222222222222222222222222222222222222",
                R.drawable.h_breakfast_item1+"",
                R.drawable.h_breakfast_item2+"",
                R.drawable.h_breakfast_item3+""));

        W_fragment_baseAdapter adapter = new W_fragment_baseAdapter(getActivity(),data);
        listView.setAdapter(adapter);
        W_adapter_Utility.setListViewHeightBasedOnChildren(listView);

        return view;
    }
}
