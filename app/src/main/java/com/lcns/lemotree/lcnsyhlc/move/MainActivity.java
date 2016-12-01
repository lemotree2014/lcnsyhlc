package com.lcns.lemotree.lcnsyhlc.move;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lcns.lemotree.lcnsyhlc.R;
import com.lcns.lemotree.lcnsyhlc.widget.AlwaysMarqueeTextView;
import com.lcns.lemotree.lcnsyhlc.widget.AutoScrollViewPager;
import com.lcns.lemotree.lcnsyhlc.widget.ImagePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {


    private AlwaysMarqueeTextView mTongZhi;


    private ListView my_listview;
    private View headerView;
    private AutoScrollViewPager viewpa;
    private ArrayList<String> arrayList;
    private MyAdapter adapter;
    private List<HashMap<String, Integer>> imageIdList;
    private LinearLayout viewGroup;
    private ImageView[] imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /***
     * 轮播图相关内容
     */
    public void imageLunBo(){
        arrayList = new ArrayList<String>();

        imageIdList = new ArrayList<HashMap<String, Integer>>();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("img", R.drawable.view_add_1);
        hashMap.put("text", 1);
        HashMap<String, Integer> hashMap2 = new HashMap<String, Integer>();
        hashMap2.put("img",R.drawable.view_add_2);
        hashMap2.put("text",2);
//		HashMap<String, Integer> hashMap3 = new HashMap<String, Integer>();
//		hashMap3.put("img",R.drawable.view_add_3);
//		hashMap3.put("text",3);
//		HashMap<String, Integer> hashMap4 = new HashMap<String, Integer>();
//		hashMap4.put("img",R.drawable.view_add_4);
//		hashMap4.put("text",4);

        imageIdList.add(hashMap);
        imageIdList.add(hashMap2);
//        imageIdList.add(hashMap3);
//        imageIdList.add(hashMap4);

        my_listview = (ListView) findViewById(R.id.my_listview);
        adapter = new MyAdapter();
        headerView = getLayoutInflater().inflate(R.layout.my_viewpager, null);
        viewpa = (AutoScrollViewPager) headerView.findViewById(R.id.viewpager);

        imageViews = new ImageView[imageIdList.size()];
        viewGroup = (LinearLayout)headerView.findViewById(R.id.viewGroup);
        /***
         * 负责又下方的点
         */
        for (int i = 0; i < imageIdList.size(); i++) {
            imageViews[i] = new ImageView(this);
            imageViews[i].setLayoutParams(new LayoutParams(16,16));
            if (i == 0) {
                imageViews[i].setBackgroundResource(R.drawable.white);
            } else {
                imageViews[i].setBackgroundResource(R.drawable.black);
            }
            viewGroup.addView(imageViews[i]);
        }

        my_listview.addHeaderView(headerView, null, false);

        if(imageIdList.size()==1){
            viewpa.setAdapter(new ImagePagerAdapter(MainActivity.this, imageIdList).setInfiniteLoop(false));
        }else {
            viewpa.setAdapter(new ImagePagerAdapter(MainActivity.this, imageIdList).setInfiniteLoop(true));
            viewpa.setInterval(3000);
            viewpa.startAutoScroll();
            viewpa.setCurrentItem(imageIdList.size()*10000);
        }


        viewpa.setOnPageChangeListener(new MyOnPageChangeListener());
        my_listview.setAdapter(adapter);
    }

    public class MyOnPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageSelected(int position) {
            //算出imageViews里的角标
            position=position%imageIdList.size();

            for (int i = 0; i < imageViews.length; i++) {
                imageViews[position].setBackgroundResource(R.drawable.white);
                if (position != i) {
                    imageViews[i].setBackgroundResource(R.drawable.black);
                }
            }

        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    }

    /**
     * 我的适配器
     */
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item, null);
            }

            TextView textView1 = (TextView) convertView.findViewById(R.id.textView1);

            String string = arrayList.get(position);
            textView1.setText(string);

            return convertView;
        }

    }
}
