package edu.neusoft.a124team.dietitian.haoDengKe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;

import edu.neusoft.a124team.dietitian.R;
import edu.neusoft.a124team.dietitian.haoDengKe.utils.NetUtils;

public class H_fruit extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    ListView listView;
    ArrayList<HashMap<String,Object>> data=new ArrayList<HashMap<String,Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!NetUtils.check(H_fruit.this)) {
            Toast.makeText(H_fruit.this, getString(R.string.network_check), Toast.LENGTH_LONG).show();
            return;
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        setContentView(R.layout.activity_h_fruit);

        viewFlipper=(ViewFlipper)findViewById(R.id.viewflipper);
        viewFlipper.setAutoStart(true); // 设置自动播放功能（点击事件，前自动播放）
        viewFlipper.setFlipInterval(3000);
        if (viewFlipper.isAutoStart() && !viewFlipper.isFlipping()) {
            viewFlipper.startFlipping();
        }
        listView=(ListView)findViewById(R.id.listView);
        HashMap<String,Object> map=new HashMap<>();
        map.put("img", R.drawable.h_imagebutton_fruit_select1);
        map.put("Title","冰甜酒酿水果羹");
        map.put("Content", "9步/<15分钟");
        map.put("details", "甜味/煮");
        HashMap<String, Object> map2=new HashMap<String, Object>();
        data.add(map);
        map2.put("img", R.drawable.h_imagebutton_fruit_select2);
        map2.put("Title","酸奶水果雪糕");
        map2.put("Content", "4步/<30分钟");
        map2.put("details","甜味/冻");
        data.add(map2);
        HashMap<String, Object> map3=new HashMap<String, Object>();
        map3.put("img", R.drawable.h_imagebutton_fruit_select3);
        map3.put("Title","果球虾仁沙拉");
        map3.put("Content", "5步/<13分钟");
        map3.put("details","奶香味/拌");
        data.add(map3);
        HashMap<String, Object> map4=new HashMap<String, Object>();
        map4.put("img", R.drawable.h_imagebutton_fruit_select4);
        map4.put("Title","脆皮水果沙拉");
        map4.put("Content", "13步/<10分钟");
        map4.put("details","甜味/炸");
        data.add(map4);
        SimpleAdapter adapter=new SimpleAdapter(
                this,
                data,
                R.layout.activity_h_breakfast_item1,
                new String[]{"img","Title","Content", "details"},
                new int[]{R.id.imageView2, R.id.text1, R.id.text2, R.id.text3}
        );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent();
                        intent.setClass(H_fruit.this,H_candy.class);
                        startActivity(intent);
                        break;
                    case 1:
                        expressItemClickOne(1);
                        break;

                    case 2:
                        expressItemClickTwo(2);
                        break;
                    case 3:
                        expressItemClickThree(3);
                        break;

                }

            }
        });

    }
    public void expressItemClickOne(int position){
        Intent intent = new Intent(this, H_breakfast_item2.class);
        int img= R.drawable.h_imagebutton_fruit_select2;
        intent.putExtra("Content", "所在区域：大连市甘井子区8号");
        intent.putExtra("Title", "酸奶水果雪糕");
        intent.putExtra("img",img);
        startActivity(intent);
    }
    public void expressItemClickTwo(int position) {
        Intent intent = new Intent(this, H_breakfast_item2.class);
        int img = R.drawable.h_imagebutton_fruit_select3;
        intent.putExtra("Content", "所在区域：大连市甘井子区8号");
        intent.putExtra("Title", "果球虾仁沙拉");
        intent.putExtra("img", img);
        startActivity(intent);
    }
    public void expressItemClickThree(int position){
        Intent intent = new Intent(this, H_breakfast_item2.class);
        int img= R.drawable.h_imagebutton_fruit_select4;
        intent.putExtra("Content", "所在区域：大连市甘井子区8号");
        intent.putExtra("Title", "脆皮水果沙拉");
        intent.putExtra("img",img);
        startActivity( intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.mn_contract_add:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
