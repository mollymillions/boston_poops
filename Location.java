package boston_poops;

import java.lang.*;

public class Location {
	
<<<<<<< HEAD
	/*List of functions:
	 * void setHours()
	 * void setRating()
	 * 
	 * String getBuildingName()
	 * String getAddress()
	 * double getLatitude()
	 * double getLongitude()
	 * boolean isOpen()
	 * boolean closeSoon()
	 */
	
	private String buildingName;
	private String address;
	private double latitude;
	private double longitude;
=======
	private String buildingName;
	private String address;
	private int latitude;
	private int longitude;
>>>>>>> a9db1e3e4e7dcc51e6b2fc10e804645ad7d426ce
	private int[] open;
	private int[] close;
	private int rating;

	//Constructor
	//Default constructor
	public Location() {
		this.buildingName = "";
		this.address = "";
<<<<<<< HEAD
		this.latitude = 0.0;
		this.longitude = 0.0;
=======
		this.latitude = 0;
		this.longitude = 0;
>>>>>>> a9db1e3e4e7dcc51e6b2fc10e804645ad7d426ce
		this.rating = 0;
		
		this.open = new int[7];
		this.close = new int[7];
	}
	
	//Constructor with input
<<<<<<< HEAD
	public Location(String name, String address, double latitude, double longitude, int rating) {
=======
	public Location(String name, String address, int latitude, int longitude, int rating) {
>>>>>>> a9db1e3e4e7dcc51e6b2fc10e804645ad7d426ce
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
<<<<<<< HEAD
	public double getLatitude() {
		return this.latitude;
	}
	
	//function that returns the longitude
	public double getLongitude() {
		return this.longitude;
	}
	
	//function that checks the hours to determine if the location is open
	public boolean isOpen(int day, int hour, int minute) {
		int currentTime = Integer.valueOf(hour+""+minute);
		if ((currentTime-open[day])<0) {
			return false;
		}
		if ((currentTime-close[day])>0) {
=======
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
>>>>>>> a9db1e3e4e7dcc51e6b2fc10e804645ad7d426ce
			return false;
		}
		return true;
	}
	
<<<<<<< HEAD
	//function that checks the hours to see if it closes within a half hour
=======
>>>>>>> a9db1e3e4e7dcc51e6b2fc10e804645ad7d426ce
	public boolean closeSoon(int day, int hour, int minute) {
		int currentTime = Integer.valueOf(hour+""+minute);
		if ((0 < (close[day]-currentTime)) && ((close[day]-currentTime) < 30)) {
			return true;
		}
		return false;
	}
	
<<<<<<< HEAD
	//returns the rating
=======
>>>>>>> a9db1e3e4e7dcc51e6b2fc10e804645ad7d426ce
	public int getRating() {
		return this.rating;
	}
	
<<<<<<< HEAD
	//sets the rating (this is the only mutator so far)
=======
>>>>>>> a9db1e3e4e7dcc51e6b2fc10e804645ad7d426ce
	public void setRating(int set_rating) {
		if (0<=set_rating && set_rating<=5) {
			this.rating = set_rating;
		}
	}
	
}
