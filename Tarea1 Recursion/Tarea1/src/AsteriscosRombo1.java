import java.util.Scanner;

//PROGRAMA QUE IMPRIME ASTERISCOS EN FORMA DE ROMBO`
public class AsteriscosRombo1 {
	
	
	private static void rombo(int asteriscos) {
		arriba(0,asteriscos);
		System.out.println("");
		abajo(0, asteriscos);
		
	}
	

	private static void arriba(int contador,int asteriscos) {

		if(asteriscos>0) {

			System.out.println("");// CAMBIO DE LINEA 

			for(int x=0;x<asteriscos-1;x++) //IMPRIMIENDO ESPACIOS EN BLANCO
				System.out.print(" ");
			
			for(int x=0;x<contador+1;x++) 
				System.out.print("* ");
			
			arriba(contador+1,asteriscos-1);

		}
	}
	
	
	private static void abajo( int contador,int asteriscos) {
		
		if (asteriscos>0) {
			
			for(int x=contador+1;x>0;x--) 
				System.out.print(" ");
						
			for(int x=asteriscos-1;x>0;x--) 
				System.out.print("* ");
	
			System.out.println("");
			abajo(contador+1,asteriscos-1);
			
		}	
	}

	public static void main(String []args) {
		Scanner entrada= new Scanner (System.in);
		System.out.println("INTRODUCE EN NUMERO MAX DE ASTERISCOS");
		int asteriscos=entrada.nextInt();
		rombo(asteriscos);
	}
}
