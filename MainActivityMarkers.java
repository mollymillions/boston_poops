package boston_poops;

import java.util.Calendar;
import java.util.Timer;

import android.os.Bundle;
import android.support.v4.app.*;
import android.view.Menu;
import boston_poops.Bathroom;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;			//Add
import com.google.android.gms.maps.model.Marker;			//Add
import com.google.android.gms.maps.model.MarkerOptions;		//Add

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Fragment {
	
	GoogleMap mMap;
	SupportMapFragment mMapFragment;
	GoogleMapOptions mMapOptions;
	//Show marker will store the output from the toggle switch
	boolean showMarker;
				
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
			//This is where we grab the date & time from the android api
			//You can get all these with a Calendar object!
			Calendar current_daytime = Calendar.getInstance();
			int current_day = current_daytime.get(Calendar.DAY_OF_WEEK);
			String current_hour = Integer.toString(current_daytime.get(Calendar.HOUR_OF_DAY));
			String current_minute = Integer.toString(current_daytime.get(Calendar.MINUTE));

			
			if (current_day == 1) {
				current_day = 6;
			} else {
				current_day -= 2;
			}
			
			//Hardcoding the locations in, because we couldn't figure out how to
			//include a text file in an android app
			int num_locations = 50;
			Bathroom[] places = new Bathroom[num_locations];
			int iterator = 0;

			Bathroom b1 = new Bathroom("Massachusetts State House", "24 Beacon Street", 42.35773,-71.06356,0);
			String[] o_hours1 = {"9","9","9","9","9","0","0"};
			String[] c_hours1 = {"17","17","17","17","17","0","0"};
			b1.setHours(o_hours1,c_hours1);
			places[iterator] = b1;
			iterator++;
			
			Bathroom b2 = new Bathroom("Barnes and Noble @ BU", "660 Beacon Street", 42.34915,-71.09621,0);
			String[] o_hours2 = {"9","9","9","9","9","10","12"};
			String[] c_hours2 = {"21","21","21","21","17","17","17"};
			b2.setHours(o_hours2,c_hours2);
			places[iterator] = b2;
			iterator++;
			
			Bathroom b3 = new Bathroom("Charles Hotel", "1 Bennett Street", 42.37226,-71.12267,0);
			String[] o_hours3 = {"0","0","0","0","0","0","0"};
			String[] c_hours3 = {"2359","2359","2359","2359","2359","2359","2359"};
			b3.setHours(o_hours3,c_hours3);
			places[iterator] = b3;
			iterator++;
			
			Bathroom b4 = new Bathroom("Boston Public Library: Main Branch", "700 Boylston Street", 42.34948,-71.07774,0);
			String[] o_hours4 = {"9","9","9","9","9","9","1"};
			String[] c_hours4 = {"21","21","21","21","17","17","17"};
			b4.setHours(o_hours4,c_hours4);
			places[iterator] = b4;
			iterator++;
			
			Bathroom b5 = new Bathroom("Prudential Center", "800 Boylston Street", 42.34873,-71.08298,0);
			String[] o_hours5 = {"10","10","10","10","10","10","11"};
			String[] c_hours5 = {"21","21","21","21","21","21","18"};
			b5.setHours(o_hours5,c_hours5);
			places[iterator] = b5;
			iterator++;
			
			Bathroom b6 = new Bathroom("Cambridgeside Galleria", "100 Cambridgeside Place", 42.36815,-71.07615,0);
			String[] o_hours6 = {"10","10","10","10","10","10","12"};
			String[] c_hours6 = {"21","21","21","21","21","21","19"};
			b6.setHours(o_hours6,c_hours6);
			places[iterator] = b6;
			iterator++;
			
			Bathroom b7 = new Bathroom("Boston University College of Arts and Sciences", "725 Commonwealth Avenue", 42.35004,-71.10478,0);
			String[] o_hours7 = {"0","0","0","0","0","0","0"};
			String[] c_hours7 = {"2359","2359","2359","2359","2359","2359","2359"};
			b7.setHours(o_hours7,c_hours7);
			places[iterator] = b7;
			iterator++;
			
			Bathroom b8 = new Bathroom("StuVi 2", "33 Harry Agganis Way", 42.35324,-71.11812,0);
			String[] o_hours8 = {"0","0","0","0","0","0","0"};
			String[] c_hours8 = {"2359","2359","2359","2359","2359","2359","2359"};
			b8.setHours(o_hours8,c_hours8);
			places[iterator] = b8;
			iterator++;
			
			Bathroom b9 = new Bathroom("Shaws Supermarket (Fenway)", "33 Kilarnock Street", 42.3436,-71.09985,0);
			String[] o_hours9 = {"0","0","0","0","0","0","0"};
			String[] c_hours9 = {"2359","2359","2359","2359","2359","2359","2359"};
			b9.setHours(o_hours9,c_hours9);
			places[iterator] = b9;
			iterator++;
			
			Bathroom b10 = new Bathroom("Mount Auburn Hospital", "330 Mount Auburn Street", 42.37441,-71.13378,0);
			String[] o_hours10 = {"0","0","0","0","0","0","0"};
			String[] c_hours10 = {"2359","2359","2359","2359","2359","2359","2359"};
			b10.setHours(o_hours10,c_hours10);
			places[iterator] = b10;
			iterator++;
			
			Bathroom b11 = new Bathroom("Quincy Market", "4 South Market Street", 42.35995,-71.05524,0);
			String[] o_hours11 = {"10","10","10","10","10","10","11"};
			String[] c_hours11 = {"21","21","21","21","21","21","18"};
			b11.setHours(o_hours11,c_hours11);
			places[iterator] = b11;
			iterator++;
			
			Bathroom b12 = new Bathroom("Stop & Shop", "60 Everett Street", 42.356403,-71.13936,0);
			String[] o_hours12 = {"7","7","7","7","7","7","7"};
			String[] c_hours12 = {"23","23","23","23","23","23","23"};
			b12.setHours(o_hours12,c_hours12);
			places[iterator] = b12;
			iterator++;
			
			Bathroom b13 = new Bathroom("Boston Common Visitor Center", "148 Tremont Street", 42.355077,-71.063362,0);
			String[] o_hours13 = {"9","9","9","9","9","9","9"};
			String[] c_hours13 = {"17","17","17","17","17","17","17"};
			b13.setHours(o_hours13,c_hours13);
			places[iterator] = b13;
			iterator++;
			
			Bathroom b14 = new Bathroom("Boston Public Library: Honan-Allston Branch", "300 North Harvard Street", 42.360114,-71.128094,0);
			String[] o_hours14 = {"12","10","12","10","9","9","0"};
			String[] c_hours14 = {"20","18","20","18","17","17","0"};
			b14.setHours(o_hours14,c_hours14);
			places[iterator] = b14;
			iterator++;

			Bathroom b15 = new Bathroom("Alewife Station", "Alewife Brook Parkway", 42.395034,-71.142483,0);
			String[] o_hours15 = {"530","530","530","530","530","530","530"};
			String[] c_hours15 = {"0","0","0","0","0","0","0"};
			b15.setHours(o_hours15,c_hours15);
			places[iterator] = b15;
			iterator++;
			
			Bathroom b16 = new Bathroom("Harvard COOP", "1400 Massachusetts Avenue", 42.373714,-71.119662,0);
			String[] o_hours16 = {"9","9","9","9","9","9","10"};
			String[] c_hours16 = {"22","22","22","22","22","22","21"};
			b16.setHours(o_hours16,c_hours16);
			places[iterator] = b16;
			iterator++;

			Bathroom b17 = new Bathroom("Au Bon Pain", "1100 Massachusetts Avenue", 42.327292,-71.063755,0);
			String[] o_hours17 = {"6","6","6","6","6","7","7"};
			String[] c_hours17 = {"20","20","20","20","20","20","19"};
			b17.setHours(o_hours17,c_hours17);
			places[iterator] = b17;
			iterator++;

			Bathroom b18 = new Bathroom("Boston Marriott Cambridge", "2 Cambridge Center", 42.362544,-71.084761,0);
			String[] o_hours18 = {"0","0","0","0","0","0","0"};
			String[] c_hours18 = {"2359","2359","2359","2359","2359","2359","2359"};
			b18.setHours(o_hours18,c_hours18);
			places[iterator] = b18;
			iterator++;

			Bathroom b19 = new Bathroom("Mapparium", "200 Massachusetts Avenue", 42.345164,-71.086727,0);
			String[] o_hours19 = {"0","10","10","10","10","10","10"};
			String[] c_hours19 = {"0","16","16","16","16","16","16"};
			b19.setHours(o_hours19,c_hours19);
			places[iterator] = b19;
			iterator++;
			
			Bathroom b20 = new Bathroom("Lenox Hotel", "61 Exeter Street", 42.349218,-71.079376,0);
			String[] o_hours20 = {"0","0","0","0","0","0","0"};
			String[] c_hours20 = {"2359","2359","2359","2359","2359","2359","2359"};
			b20.setHours(o_hours20,c_hours20);
			places[iterator] = b20;
			iterator++;

			Bathroom b21 = new Bathroom("Jurys Hotel", "350 Stuart Street", 42.349158,-71.072440,0);
			String[] o_hours21 = {"0","0","0","0","0","0","0"};
			String[] c_hours21 = {"2359","2359","2359","2359","2359","2359","2359"};
			b21.setHours(o_hours21,c_hours21);
			places[iterator] = b21;
			iterator++;			
			
			Bathroom b22 = new Bathroom("Liberty Hotel", "215 Charles Street", 42.361942,-71.070815,0);
			String[] o_hours22 = {"0","0","0","0","0","0","0"};
			String[] c_hours22 = {"2359","2359","2359","2359","2359","2359","2359"};
			b22.setHours(o_hours22,c_hours22);
			places[iterator] = b22;
			iterator++;
			
			Bathroom b23 = new Bathroom("Public Toilet", "1 City Hall Square", 42.360353,-71.058320,0);
			String[] o_hours23 = {"0","0","0","0","0","0","0"};
			String[] c_hours23 = {"2359","2359","2359","2359","2359","2359","2359"};
			b23.setHours(o_hours23,c_hours23);
			places[iterator] = b23;
			iterator++;
			
			Bathroom b24 = new Bathroom("Public Toilet", "1 1st Avenue/Charlestown Navy Yard", 42.375159,-71.054528,0);
			String[] o_hours24 = {"0","0","0","0","0","0","0"};
			String[] c_hours24 = {"2359","2359","2359","2359","2359","2359","2359"};
			b24.setHours(o_hours24,c_hours24);
			places[iterator] = b24;
			iterator++;
			
			Bathroom b25 = new Bathroom("South Station","700 Atlantic Avenue", 42.352140,-71.055043,0);
			String[] o_hours25 = {"5","5","5","5","5","5","5"};
			String[] c_hours25 = {"230","230","230","230","230","230","230"};
			b25.setHours(o_hours25,c_hours25);
			places[iterator] = b25;
			iterator++;
			
			Bathroom b26 = new Bathroom("Boston Public Library: Brighton Branch", "40 Academy Hill Road", 42.347808,-71.153348,0);
			String[] o_hours26 = {"12","10","10","12","9","9","0"};
			String[] c_hours26 = {"20","18","18","20","17","17","0"};
			b26.setHours(o_hours26,c_hours26);
			places[iterator] = b26;
			iterator++;

			Bathroom b27 = new Bathroom("Boston Public Library: Charlestown Branch", "179 Main Street", 42.375715,-71.064407,0);
			String[] o_hours27 = {"12","10","10","12","9","9","0"};
			String[] c_hours27 = {"20","18","18","20","17","14","0"};
			b27.setHours(o_hours27,c_hours27);
			places[iterator] = b27;
			iterator++;
			
			Bathroom b28 = new Bathroom("Boston Public Library: East Boston Branch", "276 Meridian Street", 42.376495,-71.039141,0);
			String[] o_hours28 = {"12","10","10","10","9","9","0"};
			String[] c_hours28 = {"20","18","18","18","17","14","0"};
			b28.setHours(o_hours28,c_hours28);
			places[iterator] = b28;
			iterator++;
			
			Bathroom b29 = new Bathroom("Boston Public Library: Faneuil Branch", "419 Faneuil Street", 42.351352,-71.167885,0);
			String[] o_hours29 = {"10","12","10","10","9","9","0"};
			String[] c_hours29 = {"18","20","18","18","17","14","0"};
			b29.setHours(o_hours29,c_hours29);
			places[iterator] = b29;
			iterator++;
			
			Bathroom b30 = new Bathroom("Boston Public Library: North End Branch", "25 Parmenter Street", 42.364026,-71.055002,0);
			String[] o_hours30 = {"10","10","12","10","9","10","0"};
			String[] c_hours30 = {"18","18","20","18","17","15","0"};
			b30.setHours(o_hours30,c_hours30);
			places[iterator] = b30;
			iterator++;
		
			Bathroom b31 = new Bathroom("Roche Bros Supermarket", "1800 Centre Street", 42.287432,-71.152481,0);
			String[] o_hours31 = {"7","7","7","7","7","7","8"};
			String[] c_hours31 = {"23","23","23","23","23","23","21"};
			b31.setHours(o_hours31,c_hours31);
			places[iterator] = b31;
			iterator++;			
			
			Bathroom b32 = new Bathroom("Shaws Supermarket (Packards Corner)", "1065 Commonwealth Avenue", 42.352677,-71.123333,0);
			String[] o_hours32 = {"0","0","0","0","0","0","0"};
			String[] c_hours32 = {"2359","2359","2359","2359","2359","2359","2359"};
			b32.setHours(o_hours32,c_hours32);
			places[iterator] = b32;
			iterator++;
			
			Bathroom b33 = new Bathroom("Shaws Supermarket (MIT)", "20 Sidney Street", 42.362349,-71.100211,0);
			String[] o_hours33 = {"7","7","7","7","7","7","7"};
			String[] c_hours33 = {"2359","2359","2359","2359","2359","2359","2359"};
			b33.setHours(o_hours33,c_hours33);
			places[iterator] = b33;
			iterator++;
			
			Bathroom b34 = new Bathroom("Boston Public Library: Connolly Branch", "433 Centre Street", 42.294923,-71.057203,0);
			String[] o_hours34 = {"12","10","10","10","9","9","0"};
			String[] c_hours34 = {"20","18","18","18","17","14","0"};
			b34.setHours(o_hours34,c_hours34);
			places[iterator] = b34;
			iterator++;
		
			Bathroom b35 = new Bathroom("Boston Public Library: Jamaica Plain Branch", "12 Sedgwick Street", 42.308591,-71.114920,0);
			String[] o_hours35 = {"10","10","10","12","9","9","0"};
			String[] c_hours35 = {"18","18","18","20","17","14","0"};
			b35.setHours(o_hours35,c_hours35);
			places[iterator] = b35;
			iterator++;
			
			Bathroom b36 = new Bathroom("Northeastern University Snell Library", "360 Huntington Avenue", 42.339761,-71.088202,0);
			String[] o_hours36 = {"745","745","745","745","745","9","10"};
			String[] c_hours36 = {"2359","2359","2359","2359","21","22","2359"};
			b36.setHours(o_hours36,c_hours36);
			places[iterator] = b36;
			iterator++;
			
			Bathroom b37 = new Bathroom("Starbucks", "468 Broadway", 42.373979,-71.113073,0);
			String[] o_hours37 = {"530","530","530","530","530","7","7"};
			String[] c_hours37 = {"830","830","830","830","830","830","830"};
			b37.setHours(o_hours37,c_hours37);
			places[iterator] = b37;
			iterator++;
			
			Bathroom b38 = new Bathroom("Starbucks", "1380 Massachusetts Avenue", 42.373373,-71.119168,0);
			String[] o_hours38 = {"5","5","5","5","5","530","530"};
			String[] c_hours38 = {"1","1","1","1","1","1","1"};
			b30.setHours(o_hours38,c_hours38);
			places[iterator] = b38;
			iterator++;
			
			Bathroom b39 = new Bathroom("Starbucks", "655 Massachusetts Avenue", 42.356621,-71.103785,0);
			String[] o_hours39 = {"530","530","530","530","530","6","6"};
			String[] c_hours39 = {"21","21","21","21","22","21","21"};
			b39.setHours(o_hours39,c_hours39);
			places[iterator] = b39;
			iterator++;
			
			Bathroom b40 = new Bathroom("Starbucks", "750 Memorial Drive", 42.357984,-71.115139,0);
			String[] o_hours40 = {"530","530","530","530","530","6","6"};
			String[] c_hours40 = {"21","21","21","21","21","21","21"};
			b40.setHours(o_hours40,c_hours40);
			places[iterator] = b40;
			iterator++;
			
			Bathroom b41 = new Bathroom("Starbucks", "84 State Street", 42.359147,-71.055627,0);
			String[] o_hours41 = {"530","530","530","530","530","6","6"};
			String[] c_hours41 = {"21","21","21","21","21","21","21"};
			b41.setHours(o_hours41,c_hours41);
			places[iterator] = b41;
			iterator++;			
			
			Bathroom b42 = new Bathroom("Starbucks", "240 Washington Street", 42.357938,-71.057886,0);
			String[] o_hours42 = {"530","530","530","530","530","6","6"};
			String[] c_hours42 = {"21","21","21","21","21","21","21"};
			b42.setHours(o_hours42,c_hours42);
			places[iterator] = b42;
			iterator++;
			
			Bathroom b43 = new Bathroom("Starbucks", "165 Newbury Street", 42.350745,-71.078834,0);
			String[] o_hours43 = {"530","530","530","530","530","6","630"};
			String[] c_hours43 = {"21","21","21","21","21","22","21"};
			b43.setHours(o_hours43,c_hours43);
			places[iterator] = b43;
			iterator++;
			
			Bathroom b44 = new Bathroom("Starbucks", "273 Huntington Avenue", 42.342279,-71.085577,0);
			String[] o_hours44 = {"530","530","530","530","530","6","6"};
			String[] c_hours44 = {"22","22","22","22","22","22","22"};
			b44.setHours(o_hours44,c_hours44);
			places[iterator] = b44;
			iterator++;
			
			Bathroom b45 = new Bathroom("Starbucks", "147 Massachusetts Avenue", 42.346646,-71.087574,0);
			String[] o_hours45 = {"530","530","530","530","530","6","6"};
			String[] c_hours45 = {"2230","2230","2230","2230","2230","2230","2230"};
			b45.setHours(o_hours45,c_hours45);
			places[iterator] = b45;
			iterator++;
			
			Bathroom b46 = new Bathroom("Boston University George Sherman Union", "775 Commonwealth Avenue", 42.350686,-71.108994,0);
			String[] o_hours46 = {"7","7","7","7","7","7","9"};
			String[] c_hours46 = {"2359","2359","2359","2359","2","2","2359"};
			b46.setHours(o_hours46,c_hours46);
			places[iterator] = b46;
			iterator++;
			
			//Check to see which places close within 30 minutes, and which ones are open
			//I used the current date/time to check the status. If this was an android,
			//we would call another method
			//So we'd use the results of that in these variables

			//Once the locations have been placed in the array, it gets easier:
			//we just have to iterate through the and make markers that way!
			//Make a new array for each of the LatLng and Marker objects
			LatLng[] positions = new LatLng[places.length];
			Marker[] marks = new Marker[places.length];
			updateMarkers(marks, places, current_day, current_hour, current_minute);
			
			
		Timer time_check = new Timer("time_check");
		time_check.schedule(updateMarkers(marks, places, current_day, current_hour, current_minute), current_minute, 900000);
		

			
		//Current Location
		mMap.setMyLocationEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

public void updateMarkers(Marker[] marks, Bathroom[] places, current_day, current_hour, current_minute) {
	//Check to see which places close within 30 minutes, and which ones are open
	//I used the current date/time to check the status. If this was an android,
	//e would call another method
	//So we'd use the results of that in these variables
	
	for (int i=0; i<marks.length; i++) {
		if (places[i].closeSoon(current_day, current_hour, current_minute)) {
			marks[i]remove();
	marks[i] = mMap.addMarker(new MarkerOptions().position(positions[i])
				.title(placeName)
				.snippet(places[i].getAddress())
				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
	//Set the marker ID into the Bathroom class
	String temp = marks[i].getId();
	places[i].setMapID(temp);
		} else if (places[i].isOpen(current_day, current_hour, current_minute)) {
			marks[i].remove();
			marks[i] = mMap.addMarker(new MarkerOptions().position(position[i])
			.title(placeName)
			.snippet(places[i].getAddress())
			.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
	String temp = marks[i].getId();
	places[i].setMapID(temp);
} else {
	marks[i].remove();
	marks[i] = mMap.addMarker(new MarkerOptions().position(positions[i])
			.title(placeName)
			.snippet(places[i].getAddress())
			.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
	//This is where it checks the toggle output to see if it should show or not
	if (showMarker == false) {
		marks[i].setVisible(false);
	}
	int temp = marks[i].getId();
	places[i].setMapID(temp);
	}
}
}