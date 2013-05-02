package boston_poops;

import java.util.*; //need for Scanner
import java.io.*; //need for file operations
import java.lang.*;

public class location_test {

	/**
	 * @param args
	 */
	//This method counts the number of lines in a file, and returns an int 
	//corresponding to that number
	//To use it, use the form: int somenum = getLines(filename);
	public static int getLines(String filename) throws FileNotFoundException {
		Scanner input = new Scanner(new File(filename));
		int count = 0;
		
		while (input.hasNextLine()) {
			input.nextLine();
			count++;
		}
		input.close();
		return count;
	}
	
	//This method finds the index of a Bathroom based on the marker id
	//It's used in the form: int foundID = findID(int markerID,Bathroom[] places);
	public int findID(int markerID, Bathroom[] places) {
		for (int i=0; i<places.length; i++) {
			if (places[i].getMapID() == markerID) {
				return i;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//make an array of locations - this requires us to know how many locations we have
		Calendar current_daytime = Calendar.getInstance();
		int current_day = current_daytime.get(Calendar.DAY_OF_WEEK);
		String current_hour = Integer.toString(current_daytime.get(Calendar.HOUR_OF_DAY));
		String current_minute = Integer.toString(current_daytime.get(Calendar.MINUTE));
		
		if (current_day == 1) {
			current_day = 6;
		} else {
			current_day -= 2;
		}
				
		//THIS IS IMPORTANT - this is where the program takes in all the input
		//The filename corresponds with the build path
		String filename = "locations_list.csv";
		int num_lines = getLines(filename);
		//initialize the array that the Locations will all be stored in		
		Bathroom[] places = new Bathroom[num_lines];
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
			
			places[iterator] = new Bathroom(buildingName,address,latitude,longitude,0);
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
		
	}

}
