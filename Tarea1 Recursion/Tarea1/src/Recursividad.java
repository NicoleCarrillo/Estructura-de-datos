//AUTOR: NICOLE CARRILLO CAPRISTAN
//NOMBRE DE LA CLASE: RECURSION 
//FECHA:21/01/19
//SUMATORIA DE NUMEROS Y CONVERSIONES DE BASE 10 A BASE 2

public class Recursividad {	
	
	public static long sumatoria(int n) {
		if(n==0)
		return n;
		
		else return n + (sumatoria(n-1));
	} 
	
	
public static String cadena ="";	
	
	public static String base10a2(int n) {
		int cociente=n/2;	
		if(cociente==0) {
			int bin=n%2;
			cadena=Integer.toString(bin)+" , "+cadena;
			return cadena;
		}		
		else {
			int bin=n%2;
			cadena=Integer.toString(bin)+" , "+cadena;
			return base10a2(cociente);
		}		
	}	
	
	public static void main (String []args) {
		//System.out.println(sumatoria(10));
		System.out.println(base10a2(149));
	}

}
