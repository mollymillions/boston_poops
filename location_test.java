package boston_poops;

import java.lang.*;

public class location_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//make a location
		Location South_Station = new Location("South Station","700 Atlantic Avenue",0,0,0);
		int[] open = {800,800,800,800,800,800,800};
		int[] close ={800,800,800,800,800,800,800};
		South_Station.setHours(open, close);
		
		System.out.println(South_Station.getRating());
		System.out.println(South_Station.isOpen(0, 17, 44));

	}

}
