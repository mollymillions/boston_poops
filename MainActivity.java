package com.bostonpoops;

<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

import android.os.Bundle;
import android.support.v4.app.*;
import android.view.Menu;
import boston_poops.Location;

=======
import android.os.Bundle;
import android.support.v4.app.*;
import android.view.Menu;
>>>>>>> c8aa918ddea71fb4b154884fe5c5ca2a03558abd
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;			//Add
import com.google.android.gms.maps.model.Marker;			//Add
import com.google.android.gms.maps.model.MarkerOptions;		//Add

<<<<<<< HEAD
public class MainActivity extends FragmentActivity throws FileNotFoundException {

	public int getLines(String filename) throws FileNotFoundException {
		Scanner input = new Scanner(new File(filename));
		int count = 0;
		
		while (input.hasNextLine()) {
			input.nextLine();
			count++;
		}
		input.close();
		return count;
	}
	
	
=======
public class MainActivity extends FragmentActivity {

	static final LatLng BTHRM = new LatLng(42.35214, -71.05504);  //Add
>>>>>>> c8aa918ddea71fb4b154884fe5c5ca2a03558abd
	private GoogleMap map;										  //Add
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		GoogleMap mapObject = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.supportMapFrag)).getMap();
		
		//Add
<<<<<<< HEAD
		//map.addMarker(new MarkerOptions().position(new LatLng(42.35214, -71.05504)).title("Marker"));
		
		//OR
		if(map!=null){
			//This is where we grab the date & time from the android api
			//You can get all these with a Calendar object!
			Calendar current_daytime = Calendar.getInstance();
			int current_day = current_daytime.get(Calendar.DAY_OF_WEEK);
			String current_hour = Integer.toString(current_daytime.get(Calendar.HOUR_OF_DAY));
			String current_minute = Integer.toString(current_daytime.get(Calendar.MINUTE));
			
		
			//This is where the locations get read in and processed into an array
			String filename = "locations_list.csv";
			int num_lines = getLines(filename);
			//initialize the array that the Locations will all be stored in		
			Location[] places = new Location[num_lines];
			//while the file has lines to read in, read them in!
			int iterator = 0;
			Scanner input = new Scanner(new File(filename));
			while (iterator<num_lines) {
				input.useDelimiter(",|\r\n|\r|\n");
				String address = input.next();
				String buildingName = input.next();
				String[] open = new String[7];
				String[] close = new String[7];
				for (int day = 0; day < 7; day++) {
					open[day] = Integer.toString(input.nextInt());
					if (open[day].length() < 4) {
						open[day] += "00";
					}
					close[day] = Integer.toString(input.nextInt());
					if (close[day].length() < 4) {
						close[day] += "00";
					}
				}
				double latitude = input.nextDouble();
				double longitude = input.nextDouble();
				
				places[iterator] = new Location(buildingName,address,latitude,longitude,0);
				places[iterator].setHours(open, close);
				iterator++;
			}
			input.close();

			//Check to see which places close within 30 minutes, and which ones are open
			//I used the current date/time to check the status. If this was an android,
			//we would call another method
			//So we'd use the results of that in these variables
			for (int i=0; i < places.length; i++) {
				if (places[i].closeSoon(current_day, current_hour, current_minute)) {
					System.out.println("Close soon");
				} else if (places[i].isOpen(current_day, current_hour, current_minute)) {
					System.out.println("Is Open");
				} else {
					System.out.println("Closed");
				}
			}
			

			
			
			//THIS IS WHERE CHECKING THE CURRENT TIME WOULD GO
			int current_day = 0;
			int current_hour = 20;
			int current_minute = 05;

			//Once the locations have been placed in the array, it gets easier:
			//we just have to iterate through the and make markers that way!
			//Make a new array for each of the LatLng and Marker objects
			LatLng[] positions = new LatLng[places.length];
			Marker[] marks = new Marker[places.length]
			
			for (int i=0; i<places.length; i++) {
			//Get the latitude and longitude of each place
				String placeName = places[i].getBuildingName();
			positions[i] = new LatLng(places[i].getLatitude(),places[i].getLongitude());  //Add
			
			//Check to see which places close within 30 minutes, and which ones are open
			//I used the current date/time to check the status. If this was an android,
			//we would call another method
			//So we'd use the results of that in these variables
				if (places[i].closeSoon(current_day, current_hour, current_minute)) {
					marks[i] = map.addMarker(new MarkerOptions().position(positions[i])
							.title(placeName)
							.snippet(places[i].getAddress())
							.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
				} else if (places[i].isOpen(current_day, current_hour, current_minute)) {
					marks[i] = map.addMarker(new MarkerOptions().position(position[i])
							.title(placeName)
							.snippet(places[i].getAddress())
							.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
				} else {
					marks[i] = map.addMarker(new MarkerOptions().position(positions[i])
							.title(placeName)
							.snippet(places[i].getAddress())
							.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
				}
=======
		map.addMarker(new MarkerOptions().position(new LatLng(42.35214, -71.05504)).title("Marker"));
		
		//OR
		if(map!=null){
			Marker bthrm = map.addMarker(new MarkerOptions().position(BTHRM).title("BTHRM1"));
>>>>>>> c8aa918ddea71fb4b154884fe5c5ca2a03558abd
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
