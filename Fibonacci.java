package dsa;

public class Fibonacci {
//0,1,1,2,3,5,8,13,21........ = fibonacchi series
	
	public static int fib(int n) {
		if(n==0 ) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		int prev = fib(n-1);
		int prev2 = fib(n-2);
		int curr = prev + prev2;
		return curr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(fib(20));
	}

}
