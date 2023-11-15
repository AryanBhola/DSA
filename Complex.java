package dsa;

public class Complex {
//Factorial
	public static int fac(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		//recursive function
		return n * fac(n-1);
	}

	public static void main(String[] args) {
		System.out.print(fac(5));

	}

}
