
public class multiplicacion {
	public static void main(String[] args) {
		System.out.println(metodo(2,3));
		System.out.println(metodo2(2,3));
	}

	private static int metodo2(int a, int b) {
		if (b == 0) 
		       return 0; 
		   if (b % 2 == 0) 
		       return metodo(a+a, b/2); 
		  
		   return metodo(a+a, b/2) + a; 
	}

	private static int metodo(int a, int b) {
		if(b==0)
			return 0;
		else
			return a+metodo(a,b-1);
	}
}
