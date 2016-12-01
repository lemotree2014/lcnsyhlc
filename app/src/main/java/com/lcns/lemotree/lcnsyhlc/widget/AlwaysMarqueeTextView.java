package com.lcns.lemotree.lcnsyhlc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/***
 * @Description:textview的跑马灯效果，为了焦点的固定
 * @author LiuChao
 * @Date：2016-12-01 14:10:11
 *
 */

public class AlwaysMarqueeTextView extends TextView {
    public AlwaysMarqueeTextView(Context context) {
        super(context);
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
