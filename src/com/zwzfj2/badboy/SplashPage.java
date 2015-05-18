package com.zwzfj2.badboy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String firstOpen = readFirstOpenName();		
		if("".equals(firstOpen)){
			startActivity(new Intent(getApplication(), GuidePageActivity.class));
			overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit); 
			SplashPage.this.finish();
		}else{
			setContentView(R.layout.splashpage);
			Handler x = new Handler();
			x.postDelayed(new splashhandler(), 2000);
		}
    }
    
	class splashhandler implements Runnable {

		@Override
		public void run() {
			startActivity(new Intent(getApplication(), LoginPageActivity.class));
			overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
			SplashPage.this.finish();
		}
	}
    
    private String readFirstOpenName(){
		SharedPreferences sp=getSharedPreferences("paramater", Context.MODE_PRIVATE);
		//若没有数据，返回默认值""
		String firstOpen=sp.getString("firstOpen", "");
		return firstOpen;
	}
}
