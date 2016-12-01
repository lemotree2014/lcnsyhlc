package com.lcns.lemotree.lcnsyhlc.move;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lcns.lemotree.lcnsyhlc.R;

public class LoginActivity extends Activity implements android.view.View.OnClickListener{

    private Button mLoginBtn;
    private TextView mUserNameTv;
    private  TextView mUserPwdTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initBody();
    }

    public void initBody(){
        mLoginBtn = (Button) findViewById(R.id.loginIdfirst);
        mUserNameTv = (TextView) findViewById(R.id.edt_login_id);
        mUserPwdTv = (TextView) findViewById(R.id.edt_login_pass);

       mLoginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view1) {
        switch(view1.getId())
        {
            case R.id.loginIdfirst:
                Intent in = new Intent();
				in.setClass(LoginActivity.this,
						MainActivity.class);
				startActivity(in);
				finish();
        }
    }
}
