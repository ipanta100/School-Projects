//*******************
//Italo Panta
//COSC 2336-01
//Instructor: Dr.Doershuk
//Due: 2/28/2018
//Submitted: 2/27/2018
//This program shows how to use HasMaps and search for strings in them
//*******************

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateCapitals {
	public static void main(String[] args) {	

		Scanner input = new Scanner(System.in);
		String state;
		
		// Store the 50 states and their capitals in a map
		Map<String, String> StatesAndCapitals = getStates();

	
		// Loop that lets the user input their state
		while (true) {
	   		System.out.print("Enter a state, or 'done' when finished: ");
	   		state = input.nextLine();
	   		if(state.equalsIgnoreCase("done")) {
                System.exit(0);
            	}
	   		else {
	   			if ((StatesAndCapitals.get(state) != null)){
	   				System.out.println("The capital is " + StatesAndCapitals.get(state));
	   			}
	   			else {
	   			System.out.println("No such state");
	   		}
	   	}
	}
}
	public static Map<String, String> getStates() {
		//Create HashMap to store Capitals and States
		Map<String, String> map = new HashMap<>();
		String[][] states = {
			{"Alabama", "Montgomery"}, {"Alaska", "Juneau"},
			{"Arizona", "Phoenix"}, {"Arkansas", "Little Rock"}, 
			{"California", "Sacramento"}, {"Colorado", "Denver"},
			{"Connecticut", "Hartford"}, {"Delaware", "Dover"},
			{"Florida", "Tallahassee"}, {"Georgia", "Atlanta"},
			{"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
			{"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
			{"Iowa Des", "Moines"}, {"Kansas", "Topeka"},
			{"Kentucky","Frankfort"}, {"Louisiana", "Baton Rouge"},
			{"Maine", "Augusta"}, {"Maryland", "Annapolis"},
			{"Massachusetts", "Boston"}, {"Michigan", "Lansing"},
			{"Minnesota", "Saint Paul"}, {"Mississippi", "Jackson"},
			{"Missouri", "Jefferson City"}, {"Montana", "Helena"},
			{"Nebraska", "Lincoln"}, {"Nevada	", "Carson City"},
			{"New Hampshire", "Concord"}, {"New Jersey", "Trenton"},
			{"New Mexico", "Santa Fe"}, {"New York", "Albany"},
			{"North Carolina", "Raleigh"}, {"North Dakota", "Bismarck"},
			{"Ohio", "Columbus"}, {"Oklahoma", "Oklahoma City"},
			{"Oregon", "Salem"}, {"Pennsylvania", "Harrisburg"},
			{"Rhode Island", "Providence"}, {"South Carolina", "Columbia"},
			{"South Dakota", "Pierre"}, {"Tennessee", "Nashville"},
			{"Texas", "Austin"}, {"Utah", "Salt Lake City"},
			{"Vermont", "Montpelier"}, {"Virginia", "Richmond"},
			{"Washington", "Olympia"}, {"West Virginia", "Charleston"},
			{"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"}};

		for (int i = 0; i < states.length; i++) {
			map.put(states[i][0], states[i][1]);
		}
		return map;
	}
}
