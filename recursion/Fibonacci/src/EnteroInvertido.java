//PROGRAMA DONDE INTRODUCES UN NUMERO Y TE REGRESA EL INVERTIDO 123  321 
public class EnteroInvertido {
	
	public static void main(String[]args) {
		metodo(2100);
		}

	private static void metodo(int num) {
		if(num<10) {
			System.out.print(num);
		}
		else {
			System.out.print(num%10);
			metodo(num/10);
		}
		
		
	}

}
