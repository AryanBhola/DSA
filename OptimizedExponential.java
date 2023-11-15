package dsa;

public class OptimizedExponential {
// O(log n)
	public static int exp(int x, int n) {
		if(n==0) {
			return 1;
		}
		int function = exp(x,n/2);
		int funcSq = function * function;
		if(n%2 != 0) {
			return x * funcSq;
		}
		else {
			return funcSq;
		}
		
	}
	public static void main(String[] args) {
		System.out.print(exp(3,5));

	}

}
