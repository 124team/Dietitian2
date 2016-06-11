package edu.neusoft.a124team.dietitian;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import edu.neusoft.a124team.dietitian.wangHan.W_ExpertsAnswer;
import edu.neusoft.a124team.dietitian.wangHan.W_UserCommunicate;
import edu.neusoft.a124team.dietitian.wangHan.W_moreHotTxt;
import edu.neusoft.a124team.dietitian.wangHan.W_mylove;
import edu.neusoft.a124team.dietitian.wangHan.W_workDisplay;
import edu.neusoft.a124team.dietitian.wangHan.fragmentAdapter.W_dataControl;
import edu.neusoft.a124team.dietitian.wangHan.fragmentAdapter.W_fragment_baseAdapter;


public class fragment3 extends Fragment {
    private LinearLayout UserCommunication,ExpertsAnswer,WorkDisplay,MyLove,More;
    private ArrayList<HashMap<String,String>> data;
    private ListView listView;
    private Button searchButton;
    private TextView weather;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout3, container, false);

        /**
         * 注册界面监听器
         */

        MainActivity mainActivity = (MainActivity) getActivity();


        weather = (TextView)view.findViewById(R.id.w_txt_weather);
        weather.setText(mainActivity.getWeatherInfo());

        searchButton = (Button)view.findViewById(R.id.w_fragment_searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"没有找到相关内容",Toast.LENGTH_LONG).show();
            }
        });

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
                "健康饮食金字塔 教你食得营养！",
                "众所周知古埃及金字塔是世界上的奇迹，是智慧和科学的结晶，是最稳定最牢固的建筑形式。同样营养“金字塔”也是膳食的最佳结构，根据塔的原理平衡营养需求，是调整膳食结构，达到合理营养、增进健康的有效方法。",
                R.drawable.h_breakfast_item1+"",
                R.drawable.h_breakfast_item2+"",
                R.drawable.h_breakfast_item3+""));
        data.add(W_dataControl.getFrgmentTxt(
                "鸡蛋该咋吃？啥时该限制？",
                "鸡蛋是一种几乎天天吃的食品，价格又便宜，烹调又方便，营养素含量又高，味道口感也非常不错。这么好的天然食物，还有什么可挑剔的么？但是有关鸡蛋的问题真的很多很多。一个还是两个？蛋清还是蛋黄？什么情况要限制？什么情况要多吃？对鸡蛋过敏怎么办？好大一箩筐问题，让我们一起慢慢说。",
                R.drawable.w_img_egg_3 +"",
                R.drawable.w_img_egg+"",
                R.drawable.w_img_egg_2+""));
        data.add(W_dataControl.getFrgmentTxt(
                "寿命长短取决于它",
                "在《素问·上古天真论》中就有论述人的正常寿命与肾之精气的盛衰有关。中医认为“肾衰”是导致衰老的重要原因。人至中年以后，肾之精气开始衰 退，头发脱落，牙齿枯槁，阳气衰弱于上部，出现面容憔悴、两鬓发白，接着筋骨活动不灵便，丧失生育功能等一系列衰老的症状开始展现。",
                R.drawable.w_img_people_1+"",
                R.drawable.w_img_people_2+"",
                R.drawable.w_img_people_3+""));

        W_fragment_baseAdapter adapter = new W_fragment_baseAdapter(getActivity(),data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new MyListener());

        return view;
    }

    public class MyListener implements AdapterView.OnItemClickListener{

        Intent intent;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case (0) :
                    Toast.makeText(getContext(),"点击了第一个",Toast.LENGTH_LONG).show();
                    intent = new Intent(getActivity(),W_moreHotTxt.class);
                    startActivity(intent);
                    break;
                case (1):
                    intent = new Intent(getActivity(),W_moreHotTxt.class);
                    startActivity(intent);
                    break;
                case (2):
                    intent = new Intent(getActivity(),W_moreHotTxt.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
