
public class Secuencia {
	
	
	public static long Funcion(int num) {
		
		int contador=num;
		long total=1;
		int n=2;
		
		if(num==1)
		return 1;
		
		else {
		
		do {
			total=n*total;
			n++;
			contador--;
		}while(contador>0);
		
		return total+Funcion(num-1);
		}
	}
	
	public static void main(String[]args) {
		System.out.println(Funcion(10));
	}

}
