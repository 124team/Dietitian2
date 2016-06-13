package edu.neusoft.a124team.dietitian.wangHan.activityAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Hansen on 2016/6/11.
 */
public class W_activity_baseAdapter extends BaseAdapter{

    private Context context;
    private List<HashMap<String,String>> data;
    public W_activity_baseAdapter(Context context,List<HashMap<String,String>> data){
        this.context = context;
        this.data = data;

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




        return convertView;
    }
}
