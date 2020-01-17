//PROGRAMA QUE COMPARA SI DOS PALABRAS SON O NO IGUALES 
import java.util.Scanner;

public class CompararPalabras {
	
	public static void main(String[]args) {
		Scanner entrada=new Scanner(System.in);
		System.out.println("INTRODUCE LA PALABRA 1");
		String palabra1=entrada.nextLine();
		System.out.println("INTRODUCE LA PALABRA 2");
		String palabra2=entrada.nextLine();
		
		System.out.print("LAS PALABRAS SON IGUALES: "+comparar(palabra1,palabra2));
		
	}

	private static String comparar(String palabra1, String palabra2) {

		if((palabra1.length()-1)==0||(palabra2.length()-1)==0) {
			return "si";
		}
		else {
			char letra1=palabra1.charAt(palabra1.length()-1);
			char letra2=palabra2.charAt(palabra2.length()-1);
			if(letra1==letra2) {
				return comparar(palabra1.substring(0,palabra1.length()-1),palabra2.substring(0,palabra2.length()-1));
			}
			else {
			return "no";
			}
		}
	}

}
