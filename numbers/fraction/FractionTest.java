package numbers.fraction;

import java.io.IOException;
import java.util.Scanner;		//import class for input/output

import numbers.fraction.Fraction.WrongDivisorException;  //import class for division exception 

public class FractionTest {


	public static void main(String[] args) {
		System.out.println("Hello world!");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter first fraction nunerator");
		int a = in.nextInt();
		System.out.println("Enter first fraction denominator");
		int b = in.nextInt();
		Fraction f1 = null;
		Fraction f2 = null;
		try {
			f1 = new Fraction(a, b);
		} catch (WrongDivisorException e) {
			System.err.println("Zero divison error");
			System.exit(0);
		}
		System.out.println("Enter second fraction nunerator");
		a = in.nextInt();
		System.out.println("Enter second fraction denominator");
		b = in.nextInt();
		try {
			f2 = new Fraction(a, b);
		} catch (WrongDivisorException e) {
			System.err.println("Zero divison error");
			System.exit(0);
		}
		System.out.println("Enter operation");
		//in.close();
		try {
			char c = (char) System.in.read();
			switch (c) {
			case '+':
				f1.add(f2);
				break;
			case '-':
				f1.substract(f2);
				break;
			case '*':
				f1.mult(f2);
				break;
			case '/':
				try {
					f1.divide(f2);
				} catch (WrongDivisorException e) {
					System.err.println("Zero divisor");
					System.exit(0);
				}
				break;
			default:
				System.err.println("Unknown operation");
				System.exit(0);
			}
			System.out.print("Result:");
			System.out.println(f1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
