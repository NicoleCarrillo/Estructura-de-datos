import java.util.Scanner;

public class AsteriscosRombo2 {
	
	public static void main(String[]args) {
		Scanner entrada=new Scanner(System.in);
		System.out.print("INTRODUCE EL NUMERO DE LINEAS MAYOR A 3");
		int lineas=entrada.nextInt();
		rombo(lineas);
	}

	private static void rombo(int lineas) {
		int max=1;
		arriba(0,lineas);
		System.out.println("");
		
		//para saber el num de espacios de abajo
		for(int x=0;x<=lineas-2;x++) {
			max=4*x;
		}
		abajo(0,lineas,max);
	}
	
	private static void arriba(int contador, int lineas) {
		if(lineas>1) {

			System.out.println("");// CAMBIO DE LINEA 
		
			for(int x=0;x<lineas;x++) //IMPRIMIENDO ASTERISCOS
				System.out.print("* ");
			
			for(int  i=0;i<=contador;i++) 
				System.out.print(" ");
			
			for(int x=0;x<lineas;x++) //IMPRIMIENDO ASTERISCOS
				System.out.print("* ");
			
			arriba(contador+4,lineas-1);

		}
	}

	private static void abajo( int lineas2, int controlador,int max) {
		if (controlador>1) {
			
			for(int x=lineas2+1;x>=0;x--) //IMPRIMIENDO ASTERISCOS
				System.out.print("* ");
						
			for(int x=max;x>=0;x--) //IMPRIMIENDO ESPACIOS
				System.out.print(" ");
			
			for(int x=lineas2+1;x>=0;x--) //IMPRIMIENDO ASTERISCOS
				System.out.print("* ");
			
			System.out.println("");
			
			abajo(lineas2+1,controlador-1,max-4);
			
		}	
		
	}
		


}
