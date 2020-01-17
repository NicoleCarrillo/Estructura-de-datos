//PROGRAMA DONDE INTRODUCES UN NUMERO ENTERO Y SE TRADUCE EN PALABRAS, 123 UNO DOS TRES
public class Examen {
	public static void main(String []args) {
		metodo(1005);
	}

	private static void metodo(int x) {
		if(x<10&&x>=0) {
			numeros(x);
		}
		else{
			metodo(x/10);
			numeros(x%10);
		}
		
	}
	
	private static void numeros(int x) {
		switch (x) {
		case 0:  System.out.print("CERO "); break;
		case 1:  System.out.print("UNO "); break;
		case 2:  System.out.print("DOS "); break;
		case 3:  System.out.print("TRES "); break;
		case 4:  System.out.print("CUATRO "); break;
		case 5:  System.out.print("CINCO "); break;
		case 6:  System.out.print("SEIS "); break;
		case 7:  System.out.print("SIETE "); break;
		case 8:  System.out.print("OCHO "); break;
		case 9:  System.out.print("NUEVE "); break;

		}	
	}

}
