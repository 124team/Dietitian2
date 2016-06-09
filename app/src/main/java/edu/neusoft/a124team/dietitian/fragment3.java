package edu.neusoft.a124team.dietitian;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import edu.neusoft.a124team.dietitian.wangHan.W_ExpertsAnswer;
import edu.neusoft.a124team.dietitian.wangHan.W_UserCommunicate;
import edu.neusoft.a124team.dietitian.wangHan.W_moreHotTxt;
import edu.neusoft.a124team.dietitian.wangHan.W_mylove;
import edu.neusoft.a124team.dietitian.wangHan.W_workDisplay;


public class fragment3 extends Fragment {
    LinearLayout UserCommunication,ExpertsAnswer,WorkDisplay,MyLove,More;

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

        return view;
    }
}
