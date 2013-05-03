// AboutTabFragment.java

package com.bostonpoops;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AboutTabFragment extends Fragment	{
	
	@Override
	public void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState)	{
		return inflater.inflate(R.layout.about_layout, container, false);
	}
	
	// TODO: add legal code function call for google maps api.
}