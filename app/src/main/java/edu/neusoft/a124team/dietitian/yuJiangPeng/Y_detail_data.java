package edu.neusoft.a124team.dietitian.yuJiangPeng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neusoft.a124team.dietitian.R;

public class Y_detail_data extends AppCompatActivity {
    private ListView listView = null;
    int h[] = new int[]{R.drawable.y_img_user1, R.drawable.y_img_user2, R.drawable.y_img_user3,
            R.drawable.y_img_user4, R.drawable.y_img_user5, R.drawable.y_img_user6,
            R.drawable.y_img_user7, R.drawable.y_img_user8, R.drawable.y_img_user9,
            R.drawable.y_img_user10};
    String na[] = new String[]{"LV小茹", "白雪", "华哥", "红", "华仔",
            "雅苏", "小婷", "雅望", "殇离雪", "幸运星"};
    String ev[] = new String[]{"非常满意", "非常满意", "非常满意", "非常满意",
            "非常满意", "满意", "非常满意", "不满意", "非常满意",
            "非常满意"};
    String e_c[] = new String[]{"谢谢！非常有耐心的回答！", "非常满意！", "对你的回答非常满意，感谢为你点赞！",
            "谢谢！服务态度很棒！", "谢谢！非常有耐心的回答！", "非常详细耐心，谢谢！！",
            "回答的有点慢！", "谢谢你给我的建议，很好！", "回答的很慢简直让人无法理解！",
            "答得很详细，非常好！"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y_detail_data);
        listView = (ListView) findViewById(R.id.y_detail_listV);
        List<Map<String, Object>> list = getData();
        listView.setAdapter(new Y_detail_adapter(this,list));


    }
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image",h[i]);
            map.put("username", na[i]);
            map.put("evaluate", ev[i]);
            map.put("e_content", e_c[i]);
          list.add(map);
        }
        return list;
    }

}
