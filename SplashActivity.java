package com.bostonpoops;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

public class SplashActivity extends FragmentActivity	{
	
	private FrameLayout frame;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.splash);
		
		frame = (FrameLayout) findViewById(R.id.splash_frame_layout);
		frame.setClickable(true);
		
		frame.setOnClickListener(new OnClickListener()	{
			@Override
			public void onClick(View v) {
				Intent launcher = new Intent(getApplicationContext(),Main.class);
				launcher.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(launcher);				
			}
		});
}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}