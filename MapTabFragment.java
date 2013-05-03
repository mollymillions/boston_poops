// MapTabFragment.java

package com.bostonpoops;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapTabFragment extends Fragment	{
	GoogleMap mMap;
	SupportMapFragment mMapFragment;
	GoogleMapOptions mMapOptions;
				
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState)	{
		return inflater.inflate(R.layout.map_layout, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)	{
		super.onActivityCreated(savedInstanceState);
		FragmentManager fm = getChildFragmentManager();
		mMapFragment = (SupportMapFragment) fm.findFragmentById(
				R.id.map_container);
		if(mMapFragment == null)	{
			mMapFragment = SupportMapFragment.newInstance();
			fm.beginTransaction().replace(R.id.map_container,
					mMapFragment).commit();
		}		
	}
	
	@Override
	public void onDestroyView()	{
		super.onDestroyView();
	}
	
	@Override
	public void onResume()	{
		super.onResume();
		if (mMap == null){
			mMap = mMapFragment.getMap();
		}
		// Implement Audrey's code here...
	}
}