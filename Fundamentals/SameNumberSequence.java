//*******************
//Italo Panta
//COSC 2336-01
//Instructor: Dr.Doershuk
//Due: 3/19/2018
//Submitted: 3/15/2018
//This program shows how to program a same number sequence in order to find
//where the index begins and how many of the same number there are
//*******************

import java.util.*;

public class SameNumberSequence {
	private static List<Integer> list = new ArrayList<>();
	private static int input;
	private static int counter = 1;
	public static void main(String[] args) {

	    Scanner scan = new Scanner(System.in);
	    System.out.print("Enter a series of numbers ending with 0: ");

	    while (true) {
	        input = scan.nextInt();
	        if (input == 0) {
	            break;
	        }
	        list.add(input);
	    }

	    int index = 0;
	    int CurrNum;
	    int SeqNum = list.get(0);
	    int Length = 0;
	    int Index = 0;
	   
	    for (int i = 1; i < list.size(); i++) {
	        CurrNum = list.get(i-1);
	        if (list.get(i).equals(CurrNum)) {
	            if (counter == 1) {
	                index = i - 1;
	            }
	            counter++;
	            if (counter > Length) {
	            	Length = counter;
	            	SeqNum = CurrNum;
	                Index = index;
	            }
	        } else {
	            counter = 1;
	        }
	    }
	    System.out.println("The longest same number sequence starts at index "
	            + Index + " with " + Length + " values of " + SeqNum);
	}
}
