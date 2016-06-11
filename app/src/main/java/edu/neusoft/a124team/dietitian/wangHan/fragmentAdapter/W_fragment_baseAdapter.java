package edu.neusoft.a124team.dietitian.wangHan.fragmentAdapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import edu.neusoft.a124team.dietitian.R;

/**
 * 社区首页的ListView
 */

public class W_fragment_baseAdapter extends BaseAdapter{

    private Context context;
    private List<HashMap<String,String>> data;
    public W_fragment_baseAdapter(Context context,List<HashMap<String,String>> data){
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
        W_viewHolder w_viewHolder;
        if (convertView == null){
            w_viewHolder = new W_viewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.w_fragment_listview_item,null);
            w_viewHolder.title = (TextView)convertView.findViewById(R.id.w_fragment_adapter_title);
            w_viewHolder.txt = (TextView)convertView.findViewById(R.id.w_fragment_adapter_txt);
            w_viewHolder.img1 = (ImageView)convertView.findViewById(R.id.w_fragment_adapter_img1);
            w_viewHolder.img2 = (ImageView)convertView.findViewById(R.id.w_fragment_adapter_img2);
            w_viewHolder.img3 = (ImageView)convertView.findViewById(R.id.w_fragment_adapter_img3);
            w_viewHolder.watching = (LinearLayout)convertView.findViewById(R.id.w_fragment_adapter_watching);
            w_viewHolder.reply = (LinearLayout)convertView.findViewById(R.id.w_fragment_adapter_reply);
            w_viewHolder.share = (LinearLayout)convertView.findViewById(R.id.w_fragment_adapter_share);
            convertView.setTag(w_viewHolder);
        }

        else {
            w_viewHolder = (W_viewHolder)convertView.getTag();
        }


        w_viewHolder.title.setText(data.get(position).get("Title"));
        w_viewHolder.txt.setText(data.get(position).get("Txt"));
        w_viewHolder.img1.setImageResource(Integer.parseInt(data.get(position).get("Img1")));
        w_viewHolder.img2.setImageResource(Integer.parseInt(data.get(position).get("Img2")));
        w_viewHolder.img3.setImageResource(Integer.parseInt(data.get(position).get("Img3")));
        return convertView;
    }

    class W_viewHolder{
        TextView title,txt;
        ImageView img1,img2,img3;
        LinearLayout watching,reply,share;
    }
}
