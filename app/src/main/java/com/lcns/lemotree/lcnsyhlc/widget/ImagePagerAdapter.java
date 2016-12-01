package com.lcns.lemotree.lcnsyhlc.widget;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.View.OnClickListener;

import com.lcns.lemotree.lcnsyhlc.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016-12-01.
 */

public class ImagePagerAdapter extends RecyclingPagerAdapter {

    private Context context;
    private List<HashMap<String, Integer>> imageIdList;

    private int           size;
    private boolean       isInfiniteLoop;

    public ImagePagerAdapter(Context context, List<HashMap<String, Integer>> imageIdList) {
        this.context = context;
        this.imageIdList = imageIdList;
        this.size = imageIdList.size();
        isInfiniteLoop = false;
    }

    @Override
    public int getCount() {
        // Infinite loop
        return isInfiniteLoop ? Integer.MAX_VALUE :  imageIdList.size();
    }

    /**
     * get really position
     *
     * @param position
     * @return
     */
    private int getPosition(int position) {
        return isInfiniteLoop ? position % size : position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup container) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.imgs, null);
//            view = holder.imageView = new ImageView(context);
            holder.imageView = (ImageView) view.findViewById(R.id.my_img);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
//       holder.imageView.setImageResource(imageIdList.get(getPosition(position)));
        final HashMap<String, Integer> hashMap = imageIdList.get(getPosition(position));
        holder.imageView.setBackgroundResource(hashMap.get("img"));


        holder.imageView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.v("tangcy", "cccccccccccccccccccccccccc"+hashMap.get("text"));

            }
        });

        return view;
    }

    private static class ViewHolder {

        ImageView imageView;
    }

    /**
     * @return the isInfiniteLoop
     */
    public boolean isInfiniteLoop() {
        return isInfiniteLoop;
    }

    /**
     * @param isInfiniteLoop the isInfiniteLoop to set
     */
    public ImagePagerAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
        return this;
    }
}


