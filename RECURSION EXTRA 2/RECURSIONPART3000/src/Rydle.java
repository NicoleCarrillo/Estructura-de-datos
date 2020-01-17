
public class Rydle {
	public static void main(String[] args) {
		System.out.print(metodo(4));
		fun1(3);
		System.out.println();
		fun2(4);
		System.out.println();
		fun3(25);
		System.out.println();
		fun4(4);
	}

	private static int metodo(int i) {
		// TODO Auto-generated method stub
		int result;
		if(i==1)
			return 1;
		result=metodo(i-1);
		return result;
	}
	
	static void fun1(int n) 
	{ 
	   int i = 0;   
	   if (n > 1) 
	     fun1(n-1); 
	   for (i = 0; i < n; i++) 
	     System.out.print(" * "); 
	} 
	
	static void fun2(int n) 
	{ 
		if(n > 0) 
		  { 
		     fun2(--n); 
		     System.out.print(n);
		     fun2(--n); 
		  } 
	} 
	
	static void fun3(int n) {
		if(n==0) {
			return;
		}
		fun3(n/2);
		System.out.print(n%2);
		
	}
	static void fun4(int n) {
		if(n<1) {
			return;
		}
		fun4(n-1);
		fun4(n-3);
		System.out.print(n);
		
	}
}



