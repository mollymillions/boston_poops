package com.bostonpoops;

import android.os.Bundle;
import android.support.v4.app.*;
import android.view.Menu;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;			//Add
import com.google.android.gms.maps.model.Marker;			//Add
import com.google.android.gms.maps.model.MarkerOptions;		//Add

public class MainActivity extends FragmentActivity {

	static final LatLng BTHRM = new LatLng(42.35214, -71.05504);  //Add
	private GoogleMap map;										  //Add
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		GoogleMap mapObject = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.supportMapFrag)).getMap();
		
		//Add
		map.addMarker(new MarkerOptions().position(new LatLng(42.35214, -71.05504)).title("Marker"));
		
		//OR
		if(map!=null){
			Marker bthrm = map.addMarker(new MarkerOptions().position(BTHRM).title("BTHRM1"));
		}
		
		//Current Location
		map.setMyLocationEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
