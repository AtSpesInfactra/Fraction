package numbers.fraction;

import java.util.Arrays;
import java.util.Scanner;			//import class for import/output

import numbers.fraction.Fraction.WrongDivisorException; 	//import class with division exception

public class FractionTestArray {

	public static void main(String[] args) {
		System.out.println("Working with fractions");
		Scanner in = new Scanner(System.in);
		System.out.print("Number of fractions:");
		int size = in.nextInt();
		Fraction[] a = new Fraction[size];	//make array of fractions length size
		int p = 0;
		int q = 0;
		for (int i = 0; i < size; i++) {
			p = in.nextInt();
			q = in.nextInt();
			try {
				a[i] = new Fraction(p, q);
			} catch (WrongDivisorException e) {
				System.err.println("Zero divisor!");
				e.printStackTrace();
			}
		}
		//a[1].add(a[0]);
		//System.out.println("S "+a[1]);
		//for (int i = 0; i < size; i++) {
			//System.out.println(a[i]);
		//}
		Arrays.sort(a);
		for (int j = 0; j < size; j++) {
			System.out.println(a[j]);
		}
	}
}
