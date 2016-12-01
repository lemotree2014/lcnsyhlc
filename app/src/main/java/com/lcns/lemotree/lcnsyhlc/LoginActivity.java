package com.lcns.lemotree.lcnsyhlc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button mLoginBtn;
    private TextView mUserNameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void initBody(){
        mLoginBtn = (Button) findViewById(R.id.loginIdfirst);
    }
}
