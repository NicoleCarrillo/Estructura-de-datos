import java.util.Scanner;

public class StringReverso {
	public static void main(String[]args) {
		Scanner entrada=new Scanner(System.in);
		//System.out.println("INTRODUCE TU PALABRA");
		//String palabra=entrada.nextLine();
		System.out.print("PALABRA AL REVES:  " + revertir("hola"));
		
	}

	private static String revertir(String palabra) {
		if((palabra.length()-1)==0) {
			return palabra;
		}
		char letra=palabra.charAt(palabra.length()-1);
		return letra+revertir(palabra.substring(0, palabra.length()-1));
		
	}

}
