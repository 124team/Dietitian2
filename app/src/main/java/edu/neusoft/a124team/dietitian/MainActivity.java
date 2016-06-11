package edu.neusoft.a124team.dietitian;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends android.support.v7.app.AppCompatActivity {

    ViewPager mvp;

    private ArrayList<Fragment> fragmentArrayList;

    fragment1 fragment1;
    edu.neusoft.a124team.dietitian.fragment2 fragment2;
    fragment3 fragment3;
    edu.neusoft.a124team.dietitian.fragment4 fragment4;
    edu.neusoft.a124team.dietitian.fragment5 fragment5;

    RadioGroup radio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio=(RadioGroup)findViewById(R.id.radio);
        radio.setOnCheckedChangeListener(new onCheckchagnge());

        mvp=(ViewPager)findViewById(R.id.pager);
        mvp.addOnPageChangeListener(new onPageChangeListener());

        fragmentArrayList = new ArrayList<Fragment>();

        fragment1 = new fragment1();
        fragment2 = new fragment2();
        fragment3 = new fragment3();
        fragment4 = new fragment4();
        fragment5 = new fragment5();

        fragmentArrayList.add(fragment1);
        fragmentArrayList.add(fragment2);
        fragmentArrayList.add(fragment3);
        fragmentArrayList.add(fragment4);
        fragmentArrayList.add(fragment5);

        mvp.setAdapter(new MyFragerPagerAdapter(getSupportFragmentManager()));

    }

    class MyFragerPagerAdapter extends FragmentPagerAdapter {

        public MyFragerPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }
    }
    class onCheckchagnge implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

                int current = 0;
                switch (checkedId) {
                    case R.id.radioButton:
                        current = 0;
                        break;
                    case R.id.radioButton2:
                        current = 1;
                        break;
                    case R.id.radioButton3:
                        current = 2;
                        break;
                    case R.id.radioButton4:
                        current = 3;
                        break;
                    case R.id.radioButton5:
                        current = 4;
                        break;
                }
                if (mvp.getCurrentItem() != current) {
                    mvp.setCurrentItem(current);
                }
        }
    }
    class onPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            int current = mvp.getCurrentItem();
            switch (current) {
                case 0:
                    radio.check(R.id.radioButton);
                    break;
                case 1:
                    radio.check(R.id.radioButton2);
                    break;
                case 2:
                    radio.check(R.id.radioButton3);
                    break;
                case 3:
                    radio.check(R.id.radioButton4);
                    break;
                case 4:
                    radio.check(R.id.radioButton5);
                    break;
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}



