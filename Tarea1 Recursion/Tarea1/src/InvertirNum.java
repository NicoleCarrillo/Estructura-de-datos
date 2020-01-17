import java.util.Scanner;

public class InvertirNum {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce una cadena de texto: ");
		String cadena = entrada.nextLine();
		String invertida = invertirCadena(cadena);
		System.out.printf("Cadena introducida: %s%n", cadena);
		System.out.printf("Cadena invertida:%s%n ", invertida);
	}
	
	private static String invertirCadena(String cadena){
		if(cadena.length()==1){
			return cadena;
		} else {
			return invertirCadena(cadena.substring(1)) + cadena.charAt(0);
		}
	}
}