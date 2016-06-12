package chenhong.com.quickindex.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import chenhong.com.quickindex.Bean.Friend;
import chenhong.com.quickindex.R;

/**
 * Created by Administrator on 2016/6/11.
 */
public class MyAdapter extends BaseAdapter {
    private ArrayList<Friend> friends;
    private Context context;
    public MyAdapter(ArrayList<Friend> friends,Context context) {
        this.friends=friends;
        this.context=context;
    }

    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.adapter, null);
        }
        ViewHolder holder=ViewHolder.getHolder(convertView);
        String name=friends.get(position).getName();
        String letter=friends.get(position).getPinyin().charAt(0)+"";
        if(position>0){
            String lastletter=friends.get(position-1).getPinyin().charAt(0)+"";
            if(letter.equals(lastletter)){
                holder.tv_letter.setVisibility(View.GONE);
            }else {
                //布局是复用的要再次设置布局可见
                holder.tv_letter.setVisibility(View.VISIBLE);
                holder.tv_letter.setText(letter);
            }
        }else {
            holder.tv_letter.setVisibility(View.VISIBLE);
            holder.tv_letter.setText(letter);
        }

         holder.tv_name.setText(name);

        return convertView;
    }
    static class ViewHolder{
        TextView tv_letter;
        TextView tv_name;
        // 在构造方法中封装findviewByid
        public ViewHolder(View convertview){
            tv_letter= (TextView) convertview.findViewById(R.id.tv_letter);
            tv_name= (TextView) convertview.findViewById(R.id.tv_name);
        }
        public static ViewHolder getHolder(View convertview){
            ViewHolder holder= (ViewHolder) convertview.getTag();
            if(holder==null){
                holder=new ViewHolder(convertview);
                convertview.setTag(holder);
            }
            return holder;
        }
    }
}
