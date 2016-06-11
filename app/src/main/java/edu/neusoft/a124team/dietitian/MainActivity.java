package edu.neusoft.a124team.dietitian;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neusoft.a124team.dietitian.wangHan.jsonWeather.W_getAndParseJson;
import edu.neusoft.a124team.dietitian.wangHan.jsonWeather.W_weather;

public class MainActivity extends AppCompatActivity {
    /*********************************解析提天气预报BEGIN*********************************/
    private List<W_weather> listWeather;
    public String weatherInfo;

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what) {
                case W_getAndParseJson.PARSESUCCWSS:
                    listWeather=(List<W_weather>) msg.obj;
                    // initData();
                    show();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void show() {
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (W_weather weather : listWeather) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("city", weather.getCity());
            item.put("temp1", weather.getTemp1());
            item.put("temp2", weather.getTemp2());
            item.put("weather", weather.getWeather());
            item.put("ptime",weather.getPtime());
            items.add(item);

            weatherInfo = "城市："+weather.getCity()+"  天气:"+weather.getWeather()+"  最高温度："
                    +weather.getTemp1()+"  最低温度："+weather.getTemp2()+"  发布时间"+weather.getPtime();
        }

    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    /*******************************解析天气预报END*********************************************/

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

        W_getAndParseJson getAndParseJson=new W_getAndParseJson(mHandler);
        getAndParseJson.getJsonFromInternet();

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



