package edu.neusoft.a124team.dietitian;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import edu.neusoft.a124team.dietitian.wangRui.S_dataControl;
import edu.neusoft.a124team.dietitian.wangRui.S_loginUi;
import edu.neusoft.a124team.dietitian.wangRui.baseAdapter.S_seetingBaseAdapter;


public class fragment5 extends Fragment {
    private Button button;
    private ArrayList<HashMap<String, String>> data;
    private ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout5, container, false);
        lv = (ListView) view.findViewById(R.id.s_setting_list);
        button=(Button)view.findViewById(R.id.s_circle_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), S_loginUi.class);
                startActivity(intent);
            }
        });


        data = new ArrayList<>();
        HashMap<String, String> map = S_dataControl.getDataSource1(
                R.drawable.s_setting_mymessage + "", "我的私信",R.drawable.s_setting_aspect + ""

        );
        data.add(map);
        HashMap<String, String> map1 = S_dataControl.getDataSource1(
                R.drawable.s_setting_post + "", "我的贴子",R.drawable.s_setting_aspect + ""

        );
        data.add(map1);
        HashMap<String, String> map2 = S_dataControl.getDataSource1(
                R.drawable.s_setting_information + "", "查看定制信息",R.drawable.s_setting_aspect + ""

        );
        data.add(map2);
        HashMap<String, String> map3 = S_dataControl.getDataSource1(
                R.drawable.s_transform_account + "", "切换账号",R.drawable.s_setting_aspect + ""

        );
        data.add(map3);
        HashMap<String, String> map4 = S_dataControl.getDataSource1(
                R.drawable.s_setting_update + "", "检查更新",R.drawable.s_setting_aspect + ""

        );
        data.add(map4);
        S_seetingBaseAdapter adapter = new S_seetingBaseAdapter(getActivity(), data);
        lv.setAdapter(adapter);


        return view;
    }


}
