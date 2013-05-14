package numbers.fraction;

public class Fraction implements Comparable<Fraction>{
	public static class WrongDivisorException extends Exception {
		private static final long serialVersionUID = -2229954298656483598L;
	}
	private int p;
	private int q;
	public Fraction (int a, int b) throws WrongDivisorException {
		if (b > 0)
			this.q = b;
		else
			throw new WrongDivisorException();			
		this.p = a;		
		this.reduce();
	}
	public Fraction (int a) throws WrongDivisorException {		//simple number
		this(a, 1);
	}
	public Fraction() {											// zero
		this.p = 0;
		this.q = 1;
	}
	public int getP() {										
		return this.p;
	}
	public int getQ() {
		return this.q;
	}
	public void setP(int a) {
		this.p = a;
		this.reduce();
	}
	public void setQ(int b) throws WrongDivisorException {   
		if (b > 0) {
			this.q = b;
			this.reduce();
		} else
			throw new WrongDivisorException();
	}
	private int gcd(int a, int b) { 			//finding gcd
		if (b == 0){
			//System.out.println(-2%3 + "    " + a);
			return a;
		}
		else{
			a = a % b;
			if (a < 0) a = -a ;
			return this.gcd(b, a);
		}
	}
	
	private void reduce() {  					//do irreducible fraction
		int t = gcd(this.p, this.q);
		this.p /= t;
		this.q /= t;
	}
	public Fraction negative() {				//make negative fraction
		try {
			return new Fraction(-this.getP(), this.getQ());
		} catch (WrongDivisorException e) {		
			e.printStackTrace();
			return null;
		}
	}
	public Fraction invert() throws WrongDivisorException {	//invert fraction
		return new Fraction(this.getQ(), this.getP());
	}
	public void add(Fraction a) {						//adding
		int t = this.gcd(this.q, a.q);
		this.p = this.p * (a.q / t) + a.p * (this.q / t);
		this.q = this.q / t * a.q;
		//System.out.println(this.q);
		this.reduce();
	}
	public void substract(Fraction a) {					//substraction
			this.add(a.negative());
	}
	public void mult(Fraction a) {						//multiplication							
		this.p *= a.p;
		this.q *= a.q;
		this.reduce();
	}
	public void divide(Fraction a) throws WrongDivisorException {	//division
		this.mult(a.invert());
	}
	public String toString() {			//make string
		String t = this.p + "/" + this.q;
		return t;
	}
	public Fraction clone() {			//cloning for comparing
		try {
			Fraction t = new Fraction (this.getP(), this.getQ());
			return t;
		} catch (WrongDivisorException e) {
			return null;
		}
	}
	public int compareTo(Fraction a) {	
		//System.out.println(this+" vs "+a);//comparing fractions
		Fraction t = this.clone();
		t.substract(a);
		if (t.getP() > 0){
			//System.out.println(t);
			return 1;
		}else if (t.getP() == 0){
			//System.out.println("0");
			return 0;
		}else{
			//System.out.println(t);
			return -1;
		}
	}
}
