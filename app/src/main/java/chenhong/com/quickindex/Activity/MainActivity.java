package chenhong.com.quickindex.Activity;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import chenhong.com.quickindex.Bean.Friend;
import chenhong.com.quickindex.Adapter.MyAdapter;
import chenhong.com.quickindex.View.QuickIndexBar;
import chenhong.com.quickindex.R;

public class MainActivity extends AppCompatActivity {
   private QuickIndexBar quickIndexBar;
    private ListView lv_content;
    private ArrayList<Friend> friends = new ArrayList<Friend>();
    private TextView currentindex;
    private Handler handler=new Handler(){
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initview();
        fillList();
        //对数据进行排序
        Collections.sort(friends);
        lv_content.setAdapter(new MyAdapter(friends, this));
        quickIndexBar.setonTouchListener(new QuickIndexBar.onTouchListener() {
            @Override
            public void onTouchLetter(String letter) {
                Log.e("tag", letter);
                //根据触摸的字母去集合中找到那个item然后放到顶端
                for(int i=0;i<friends.size();i++){
                    String firstletter=friends.get(i).getPinyin().charAt(0)+"";
                    if(letter.equals(firstletter)){
                      lv_content.setSelection(i);
                        break;//只需要找到第一个
                    }
                }
                //显示当前触摸字母
                currentindex.setText(letter);
                currentindex.setVisibility(View.VISIBLE);
                //设置属性动画
//                com.nineoldandroids.view.ViewPropertyAnimator.animate(currentindex).scaleX(1f).setInterpolator(new OvershootInterpolator()).setDuration(350).start();
//                com.nineoldandroids.view.ViewPropertyAnimator.animate(currentindex).scaleY(1f).setInterpolator(new OvershootInterpolator()).setDuration(350).start();

                //延时隐藏 handler在哪声明就在哪个线程中运行
                //每次post之前消除之前的视图
                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      currentindex.setVisibility(View.INVISIBLE);
                    }
                }, 1500);
            }
        });
    }
    private void initview() {
        currentindex = (TextView) findViewById(R.id.currentindex);
        quickIndexBar= (QuickIndexBar) findViewById(R.id.qib);
        lv_content = (ListView) findViewById(R.id.lv_content);
    }
    private void fillList() {
        // 虚拟数据
        friends.add(new Friend("李伟"));
        friends.add(new Friend("张三"));
        friends.add(new Friend("阿三"));
        friends.add(new Friend("阿四"));
        friends.add(new Friend("段誉"));
        friends.add(new Friend("段正淳"));
        friends.add(new Friend("张三丰"));
        friends.add(new Friend("陈坤"));
        friends.add(new Friend("林俊杰1"));
        friends.add(new Friend("陈坤2"));
        friends.add(new Friend("王二a"));
        friends.add(new Friend("林俊杰a"));
        friends.add(new Friend("张四"));
        friends.add(new Friend("林俊杰"));
        friends.add(new Friend("王二"));
        friends.add(new Friend("王二b"));
        friends.add(new Friend("赵四"));
        friends.add(new Friend("杨坤"));
        friends.add(new Friend("赵子龙"));
        friends.add(new Friend("杨坤1"));
        friends.add(new Friend("李伟1"));
        friends.add(new Friend("宋江"));
        friends.add(new Friend("宋江1"));
        friends.add(new Friend("李伟3"));
    }

}
