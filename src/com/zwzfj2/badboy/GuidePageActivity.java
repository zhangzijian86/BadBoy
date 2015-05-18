package com.zwzfj2.badboy;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class GuidePageActivity extends Activity {

	private ViewPager viewPager; 
	private ArrayList<View> pageViews;	 
	private ViewGroup main;  
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	     requestWindowFeature(Window.FEATURE_NO_TITLE);
	     
	     //获取SharedPreferences对象，路径在/data/data/cn.itcast.preferences/shared_pref/paramater.xml
	     SharedPreferences sp=getSharedPreferences("paramater", Context.MODE_PRIVATE);
	     //获取编辑器
	     Editor editor=sp.edit();
	     //通过editor进行设置
	     editor.putString("firstOpen", "1");
	     //提交修改，将数据写到文件
	     editor.commit();
	     
	     LayoutInflater li = getLayoutInflater();
	     pageViews = new ArrayList<View>();  
	     pageViews.add(li.inflate(R.layout.guidepage0, null));
	     pageViews.add(li.inflate(R.layout.guidepage1, null));
	     pageViews.add(li.inflate(R.layout.guidepage2, null)); 
	     pageViews.add(li.inflate(R.layout.guidepage3, null)); 
	     main =  (ViewGroup)li.inflate(R.layout.activity_splash_page, null);  
	     viewPager = (ViewPager)main.findViewById(R.id.guidePages);  
	     setContentView(main);  
	     viewPager.setAdapter(new GuidePageAdapter());  
	 }
	 
	    /** 指引页面Adapter */
	    class GuidePageAdapter extends PagerAdapter {
	        @Override  
	        public int getCount() {  
	            return pageViews.size();  
	        }  
	        @Override  
	        public boolean isViewFromObject(View arg0, Object arg1) {  
	            return arg0 == arg1;  
	        }  
	        @Override  
	        public int getItemPosition(Object object) {  
	            // TODO Auto-generated method stub  
	            return super.getItemPosition(object);  
	        }  
	        @Override  
	        public void destroyItem(View arg0, int arg1, Object arg2) {  
	            // TODO Auto-generated method stub  
	            ((ViewPager) arg0).removeView(pageViews.get(arg1));  
	        }  
	        @Override  
	        public Object instantiateItem(View arg0, int arg1) {
	            // TODO Auto-generated method stub  
	            ((ViewPager) arg0).addView(pageViews.get(arg1));  
	            return pageViews.get(arg1);  
	        }
	        @Override  
	        public void restoreState(Parcelable arg0, ClassLoader arg1) {  
	            // TODO Auto-generated method stub  
	  
	        }  
	  
	        @Override  
	        public Parcelable saveState() {  
	            // TODO Auto-generated method stub  
	            return null;  
	        }  
	  
	        @Override  
	        public void startUpdate(View arg0) {  
	            // TODO Auto-generated method stub  
	  
	        }  
	  
	        @Override  
	        public void finishUpdate(View arg0) {  
	            // TODO Auto-generated method stub  
	  
	        }
	    } 
}
