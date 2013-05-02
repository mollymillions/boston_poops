package boston_poops;

//import java.lang.*;

public class Bathroom {
	
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
	private String[] open;
	private String[] close;
	private int rating;
	private int mapID;

	//Constructor
	//Default constructor
	public Bathroom() {
		this.buildingName = "";
		this.address = "";
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.rating = 0;
		this.mapID = 0;
		this.open = new String[7];
		this.close = new String[7];
	}
	
	//Constructor with input
	public Bathroom(String name, String address, double latitude, double longitude, int rating) {
		this.buildingName = name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.rating = rating;
		this.mapID = 0;
		this.open = new String[7];
		this.close = new String[7];
	}
	
	//function that sets when the place is open - takes two arrays as inputs
	public void setHours(String[] o_hours, String[] c_hours) {
		for (int i=0; i<7; i++) {
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
	public double getLatitude() {
		return this.latitude;
	}
	
	//function that returns the longitude
	public double getLongitude() {
		return this.longitude;
	}
	
	//function that checks the hours to determine if the location is open
	public boolean isOpen(int day, String hour, String minute) {
		int int_close = 0;
		int int_open = 0;
		int_close = Integer.valueOf(close[day]);
		int_open = Integer.valueOf(open[day]);
		
		int currentTime = 0;
		if (minute.length() < 2 && Integer.valueOf(minute)==0) {
			currentTime = Integer.valueOf(hour+minute+"0");
		} else if (minute.length() < 2) {
			currentTime = Integer.valueOf(hour+"0"+minute); 
		} else {
			currentTime = Integer.valueOf(hour+minute);
		}
			
		if ((currentTime-int_open) < 0) {
			return false;
		}
		if ((currentTime-int_close) > 0) {
			return false;
		}
		return true;
	}
	
	//function that checks the hours to see if it closes within a half hour
	public boolean closeSoon(int day, String hour, String minute) {
		int int_close = 0;
		int_close = Integer.valueOf(close[day]);		
		int currentTime = Integer.valueOf(hour+""+minute);
		
		if ((0 < (int_close-currentTime)) && ((int_close-currentTime) < 30)) {
			return true;
		}
		return false;
	}
	
	//returns the rating
	public int getRating() {
		return this.rating;
	}
	
	//sets the rating (this is the only mutator so far)
	public void setRating(int set_rating) {
		if (0<=set_rating && set_rating<=5) {
			this.rating = set_rating;
		}
	}
	
	//returns the map id
	public int getMapID() {
		return this.mapID;
	}
	
	//sets the map ID
	public void setMapID(int id) {
		this.mapID = id;
	}
}