package edu.neusoft.a124team.dietitian;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.neusoft.a124team.dietitian.wangRui.S_loginUi;


public class fragment5 extends Fragment {
private Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout5, container, false);
        button=(Button)view.findViewById(R.id.s_seeting_circleBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), S_loginUi.class);
                startActivity(i);
            }
        });

        return view;
    }

}
