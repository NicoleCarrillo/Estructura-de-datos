//PROMGRAMA QUE ENCUENTRA EL VALOR MAS PEQUENO Y LO COLOCA EN EL INICIO 
public class SelectionSortMin {
	public static void main(String[] args) {
		int arreglo[]= {10,8,5,4,1,11};

		//LE PASAMOS X PARA QUE SEA DONDE EMPIECE A BUSCAR EL VALOR
		//DESPUES DE LA PRIMERA VUELTA YA NO EMPIEZA DESDE LA POSICION 0
		//AHORA EMPIEZA EN LA 1 
		
		for(int x=0;x<arreglo.length-1;x++) {
			int posMinimo=valorMin(arreglo,x,arreglo.length-1);
			swap(arreglo,posMinimo,x);  
		}
		
		for(int x=0;x<arreglo.length;x++) {
			System.out.print(arreglo[x]+",");
		}
	}

	private static int valorMin(int arreglo[], int primero, int ultimo) {
		int posMinimo=primero;
		for(int x=primero+1;x<=ultimo;x++) {
			if(arreglo[x]<arreglo[posMinimo]) {
				posMinimo=x;
			}
		}
		return posMinimo;
	}
	
	private static void swap(int arreglo[], int posMinimo, int primero) {
		int temporal=arreglo[primero];
		arreglo[primero]=arreglo[posMinimo];
		arreglo[posMinimo]=temporal;
	}
}
