
public class misterio {
public static void main(String[] args) {
	System.out.print(mystery(648));
	System.out.print(function(5));
}

private static int function(int n) {
	
	int result;
	if( n==1)
	return 1;
	result=function(n-1);
	return result;
}

private static int mystery(int n) {
	if (n<10) {
		return n;
	}else {
		int a=n/10;
		int b=n%10;
		return mystery(a+b);
	}
	
	
}
}
