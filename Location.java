package boston_poops;

import java.lang.*;

public class Location {
	
	private String buildingName;
	private String address;
	private int latitude;
	private int longitude;
	private int[] open;
	private int[] close;
	private int rating;

	//Constructor
	//Default constructor
	public Location() {
		this.buildingName = "";
		this.address = "";
		this.latitude = 0;
		this.longitude = 0;
		this.rating = 0;
		
		this.open = new int[7];
		this.close = new int[7];
	}
	
	//Constructor with input
	public Location(String name, String address, int latitude, int longitude, int rating) {
		this.buildingName = name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.rating = rating;
		
		this.open = new int[7];
		this.close = new int[7];
	}
	
	//function that sets when the place is open - takes two arrays as inputs
	public void setHours(int[] o_hours, int[] c_hours) {
		for (int i=0; i<6; i++) {
			this.open[i] = o_hours[i];
			this.close[i] = c_hours[i];
		}
	}
	
	//function that returns the building's name
	public String getBuildingName() {
		return this.buildingName;
	}
	
	//function that returns the address
	public String getAddress() {
		return this.address;
	}
	
	//function that returns the latitude
	public int getLatitude() {
		return this.latitude;
	}
	
	public int getLongitude() {
		return this.longitude;
	}
	
	public boolean isOpen(int day, int hour, int minute) {
		int currentTime = Integer.valueOf(hour+""+minute);
		if ((currentTime-open[day])<0) {
			System.out.println(currentTime-open[day]);
			return false;
		}
		if ((currentTime-close[day])<0) {
			return false;
		}
		return true;
	}
	
	public boolean closeSoon(int day, int hour, int minute) {
		int currentTime = Integer.valueOf(hour+""+minute);
		if ((0 < (close[day]-currentTime)) && ((close[day]-currentTime) < 30)) {
			return true;
		}
		return false;
	}
	
	public int getRating() {
		return this.rating;
	}
	
	public void setRating(int set_rating) {
		if (0<=set_rating && set_rating<=5) {
			this.rating = set_rating;
		}
	}
	
}
