package edu.neusoft.a124team.dietitian.wanghao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import edu.neusoft.a124team.dietitian.R;

/**
 * Created by dell on 2016/6/9.
 */
public class H_detail_adapter extends BaseAdapter{
    private List<Map<String, Object>> y_data;
    private LayoutInflater y_layoutInflater;
    private Context y_context;

    public H_detail_adapter(Context y_context, List<Map<String, Object>> y_data){
        this.y_context=y_context;
        this.y_data=y_data;
        this.y_layoutInflater=LayoutInflater.from(y_context);
    }
    public final class Y_Component{
        public ImageView image;
        public TextView username, evaluate, e_content;
    }
    @Override
    public int getCount() {
        return y_data.size();
    }

    @Override
    public Object getItem(int position) {
        return y_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Y_Component component=null;
        if(convertView==null){
            component= new Y_Component();
            //获得组件实例化组件
            convertView=y_layoutInflater.inflate(R.layout.activity_y_detail_list_item, null);
            component.image=(ImageView)convertView.findViewById(R.id.y_detail_image);
            component.username=(TextView)convertView.findViewById(R.id.y_detail_username);
            component.evaluate=(TextView)convertView.findViewById(R.id.y_detail_evaluate);
            component.e_content=(TextView)convertView.findViewById(R.id.y_evaluate_content);
           convertView.setTag(component);
        }else
        component=(Y_Component)convertView.getTag();
        //绑定数据
        component.image.setBackgroundResource((Integer)y_data.get(position).get("image"));
        component.username.setText((String)y_data.get(position).get("username"));
        component.evaluate.setText((String)y_data.get(position).get("evaluate"));
        component.e_content.setText((String)y_data.get(position).get("e_content"));
        return convertView;
    }
}
