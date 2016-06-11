package edu.neusoft.a124team.dietitian;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import edu.neusoft.a124team.dietitian.yuJiangPeng.Y_detail_data;


public class fragment2 extends Fragment {
    private ImageView headImage1,headImage2,headImage3,headImage4,headImage5,headImage6,
            headImage7, headImage8;
    private ScrollView mScrollView;
 //   private Toolbar mtoolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout2, container, false);
       // mtoolbar=(Toolbar)getActivity().findViewById(R.id.y_major_toolbar);

        mScrollView=(ScrollView)view.findViewById(R.id.y_scrollView_consult);
        mScrollView.post(new Runnable() {
            @Override
            public void run() {
                mScrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });
        headImage1= (ImageView)view. findViewById(R.id.y_img_nutr_head1);
        headImage2= (ImageView)view. findViewById(R.id.y_img_nutr_head2);
        headImage3= (ImageView)view. findViewById(R.id.y_img_nutr_head3);
        headImage4= (ImageView)view. findViewById(R.id.y_img_nutr_head4);
        headImage5= (ImageView)view. findViewById(R.id.y_img_nutr_head5);
        headImage6= (ImageView)view. findViewById(R.id.y_img_nutr_head6);
        headImage7= (ImageView)view. findViewById(R.id.y_img_nutr_head7);
        headImage8= (ImageView)view. findViewById(R.id.y_img_nutr_head8);
        headImage1.setOnClickListener(new ImageButton());
        headImage2.setOnClickListener(new ImageButton());
        headImage3.setOnClickListener(new ImageButton());
        headImage4.setOnClickListener(new ImageButton());
        headImage5.setOnClickListener(new ImageButton());
        headImage6.setOnClickListener(new ImageButton());
        headImage7.setOnClickListener(new ImageButton());
        headImage8.setOnClickListener(new ImageButton());

        return view;
    }
    class ImageButton implements View.OnClickListener{

        @Override
        public void onClick(View v) {
           switch (v.getId()){
               case R.id.y_img_nutr_head1://跳转目的地是同一个Activity 所以。。。0.0
               case R.id.y_img_nutr_head2:
               case R.id.y_img_nutr_head3:
               case R.id.y_img_nutr_head4:
               case R.id.y_img_nutr_head5:
               case R.id.y_img_nutr_head6:
               case R.id.y_img_nutr_head7:
               case R.id.y_img_nutr_head8:

                   Intent intent= new Intent(getActivity().getApplicationContext(),
                           Y_detail_data.class);
                   startActivity(intent);
                   break;

           }


        }
    }

}
