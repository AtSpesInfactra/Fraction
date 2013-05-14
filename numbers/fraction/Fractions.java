package numbers.fraction;

import java.util.Arrays;

public class Fractions {
	public static float toFloat(Fraction a) {	//make float from fraction
		return ((float) a.getP() / a.getQ());
	}
	
	public static double toDouble(Fraction a) {	//make double from fraction
		return ((double) a.getP() / a.getQ());
	}
	
	public static void sort(Fraction[] a) {		//sorting array of fractions
		Arrays.sort(a);
	}
}
