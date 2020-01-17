//PROGRAMA QUE DADO UN ARREGLO DE NUMEROS REGRESA AQUEL MAS PEQUENO
public class ValorMinimo {

	public static void main(String[]args) {
		int arreglo[]= {3,2,1,4,5,6};
		System.out.println("EL VALOR MINIMO ES: "+minimo(arreglo,0,arreglo.length-1));
	}

	private static int minimo(int arreglo[], int min, int max) {
	

		if(arreglo[min]==max)
			return arreglo[min];
		
		else {
			int valor=minimo(arreglo,min+1, max);
			
			if(valor<arreglo[min]) {
	
				return valor;
			}
			else {
				return arreglo[min];
			}
		
		}
	
	}

}
