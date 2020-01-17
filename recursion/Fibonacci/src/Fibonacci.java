
public class Fibonacci {
	
	public static long fibonacci(int n) {
		if(n==0||n==1) {
			return 1;
	}
		else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
}
	
	
	
	public static long fibonacciOpt(int n) {
		long tabla[]=new long[n+1];
		tabla[0]=tabla[1]=1;
		return fibonacciOpt(n,tabla);
	}
	
	public static long fibonacciOpt(int n,long tabla[]) {
		if(tabla[n]!=0) {
			return tabla[n];
		}
		else {
			tabla[n]=fibonacciOpt(n-1,tabla)+fibonacciOpt(n-2,tabla);
			return tabla[n];
		}
	}
	
	
	
	
	public static void main(String[]args) {
		System.out.println(fibonacciOpt(1));
	}
}