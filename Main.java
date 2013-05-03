package com.bostonpoops;

import android.os.Bundle;
import android.support.v4.app.*;
import android.view.Menu;

public class Main extends FragmentActivity	{
	
	private FragmentTabHost mTabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		
		// Set up FragmentTabHost.
		setContentView(R.layout.main);
		mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		
		// Create AboutTabFragment.
        mTabHost.addTab(mTabHost.newTabSpec("About")
        		.setIndicator("About",getResources()
        		.getDrawable(R.drawable.abouttabicon)),
                AboutTabFragment.class, null);
        // Create MapTabFragment.
        mTabHost.addTab(mTabHost.newTabSpec("Map")
        		.setIndicator("Map",getResources()
        		.getDrawable(R.drawable.maptabicon)),
                MapTabFragment.class, null);
        // Create SettingsTabFragment.
        mTabHost.addTab(mTabHost.newTabSpec("Settings")
        		.setIndicator("Settings",getResources()
        		.getDrawable(R.drawable.settingstabicon)),
                SettingsTabFragment.class, null);

        // Default to the map tab on start up.
        mTabHost.setCurrentTab(1);
		
    	// TODO: page switcher to swipe back from marker page.
        
        // TODO: create interfaces for data sharing between settings and map fragments.
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// XXX: menu is a stub.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	protected void onPause()	{
		super.onPause();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState)	{
		super.onSaveInstanceState(savedInstanceState);
		
		// TODO: Save stuff for next time you start app!!!
		//savedInstanceState.putString("SavedMapType","")		
	}
	
	@Override
	protected void onStop()	{
		super.onStop();
	}
	
	@Override
	protected void onResume()	{
		super.onResume();
	}
	
	@Override
	protected void onDestroy()	{
		super.onDestroy();
	}
}