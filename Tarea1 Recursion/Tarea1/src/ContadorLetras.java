import java.util.Scanner;

//PROGRAMA QUE CUENTA DADO UNA LETRAS, CUANTAS VECES APARECE ESTA EN UNA PALABRA
public class ContadorLetras {
	public static void main(String[]args) {
		Scanner entrada=new Scanner(System.in);
		System.out.println("INTRODUCE LA PALABRA");
		String palabra=entrada.nextLine();
		System.out.println("INTRUDUCE LA LETRA A CONTAR");
		String letra=entrada.nextLine();
		
		System.out.print("LA CANTIDAD DE VECES QUE APARECE LA LETRA "+letra+ " ES: "+ contador(letra.charAt(0),palabra));
	}

	private static int contador(char letra, String palabra) {
		int cont=0;
		if(palabra.length()-1==0) {
			return cont;
		}
		char letra2=palabra.charAt(palabra.length()-1);
		if(letra2==letra) {
			cont++;
		}
		return cont+contador(letra,palabra.substring(0,palabra.length()-1));		
	}
}
