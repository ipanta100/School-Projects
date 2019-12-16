//*******************
//Italo Panta
//COSC 2336-01
//Instructor: Dr.Doershuk
//Due: 2/7/2018
//Submitted: 2/5/2018
//This program shows how to add integers and strings into an array
//*******************

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
	 public static void main(String[] args) {

	        Scanner input = new Scanner(System.in);
	        ArrayList<Integer> list1 = new ArrayList<>();
	        int temp1;
	        do {
	        	 System.out.println("Enter an integer to add to a list of integers, 0 to stop: ");
	            temp1 = input.nextInt();
	            if (temp1 != 0) {
	                list1.add(temp1);
	            }
	        } while (temp1 != 0);

	        System.out.println("The largest integer in the array is " + max(list1));
	 
	        ArrayList<String> list2 = new ArrayList<String>();
	        String temp2;
	   		do {
	   			System.out.println("Enter a string to add to a list of strings, 'done' to stop: ");
	   			temp2 = input.next();
	   			if (!temp2.equals("done")) {
	   				list2.add(temp2);
	   			}
	   		} while (!temp2.equals("done"));
	   		
	   		System.out.println("The largest string in the array is " + max(list2));	
	 }
	  public static <E extends Comparable<E>> E max(ArrayList<E> list) {
	        E max = list.get(0);

	        for (int i = 1; i < list.size(); i++) {
	            if (list.get(i).compareTo(max) > 0) {
	                max = list.get(i);
	            }
	        }
	        return max;
	}
}
