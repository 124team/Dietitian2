package edu.neusoft.a124team.dietitian.wangRui.baseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import edu.neusoft.a124team.dietitian.R;

/**
 * Created by wang5 on 2016/6/10.
 */
public class S_seetingBaseAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater s_layoutInflater;
    private List<HashMap<String,String>> data;
    public S_seetingBaseAdapter(Context context,List<HashMap<String, String>> data) {
        this.context=context;
        this.data = data;
        this.s_layoutInflater=LayoutInflater.from(context);
    }
    public final class ViewHolder1{
        ImageView img,img1;
        TextView txtTitle;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder1 viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder1();
            convertView= LayoutInflater.from(context).inflate(R.layout.s_setting_listitem,null);
            viewHolder.img=(ImageView)convertView.findViewById(R.id.s_setting_icon);
            viewHolder.txtTitle=(TextView)convertView.findViewById(R.id.s_setting_title);
            viewHolder.img1=(ImageView)convertView.findViewById(R.id.s_setting_aspect);

            convertView.setTag(viewHolder);


        }

        else{
            viewHolder=(ViewHolder1)convertView.getTag();
        }

        viewHolder.img.setImageResource(Integer.parseInt(data.get(position).get("Img")));
        viewHolder.txtTitle.setText(data.get(position).get("Title"));
        viewHolder.img1.setImageResource(Integer.parseInt(data.get(position).get("Img1")));





        return convertView;
    }
}




