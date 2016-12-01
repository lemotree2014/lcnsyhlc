package com.lcns.lemotree.lcnsyhlc.move;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lcns.lemotree.lcnsyhlc.R;

public class CardMainActivity extends Activity implements View.OnClickListener {
    /***
     * 卡转账
     */
    public TextView mKzzTv;
    /***
     * 卡查询
     */
    public TextView mKcxTv;
    /***
     * 卡取现
     */
    public TextView mKqxTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_main);

    }

    public void initBodyer(){
        mKcxTv = (TextView)findViewById(R.id.tv_kcx);
        mKzzTv = (TextView)findViewById(R.id.tv_kzz);
        mKqxTv = (TextView)findViewById(R.id.tv_kqx);

        mKcxTv.setOnClickListener(this);
        mKzzTv.setOnClickListener(this);
        mKqxTv.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_kcx:
                break;
            case R.id.tv_kqx:
                break;
            case R.id.tv_kzz:
                break;
            default:
                break;
        }

    }
}
