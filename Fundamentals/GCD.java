//*******************
//Italo Panta
//COSC 2336-01
//Instructor: Dr.Doerschuk
//Programming Assignment 1
//Due: 1/31/2018
//Submitted: 1/27/2018
//This program shows how to code for the GCD of any two numbers
//*******************

import java.util.Scanner;

public class GreatestCommonDivisor {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the first number: ");
		int m = Integer.parseInt(input.next());
		System.out.print("Enter the second number: ");
		int n = Integer.parseInt(input.next());

		System.out.println("The GCD of " + m + " and " + n + " is " + gcd(m, n));
	}

	private static int gcd(int m, int n) {
		if (m % n == 0)
			return n;
		else
			return gcd(n, m % n);
	}
}
