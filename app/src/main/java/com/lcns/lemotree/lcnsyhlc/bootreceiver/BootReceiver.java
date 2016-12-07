package com.lcns.lemotree.lcnsyhlc.bootreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.lcns.lemotree.lcnsyhlc.move.MainActivity;

public class BootReceiver extends BroadcastReceiver {

	//当手机重新启动的时候调用
	@Override
	public void onReceive(Context context, Intent intent) {


		//在这个方法里面开启activity
		Intent intent2 = new Intent(context,MainActivity.class);

		intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


		//开启activity
		context.startActivity(intent2);




	}

}
