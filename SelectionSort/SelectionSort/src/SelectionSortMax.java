//PROMGRAMA QUE ENCUENTRA EL VALOR MAS GRANDE Y LO COLOCA EN EL INICIO
public class SelectionSortMax {
	public static void main(String[] args) {
		int arreglo[]= {10,8,5,4,1,11};
		
		for(int x=arreglo.length-1;x>=0;x--) {
			int posicionMax=valorMax(arreglo,x,0);
			swap(arreglo,posicionMax,x);
		}
		
		for(int x=0;x<arreglo.length;x++) {
			System.out.print(arreglo[x]+",");
		}
	}

	private static int valorMax(int[]arreglo, int indice, int primero) {
		int posicionMax=indice;
		
		for(int x=posicionMax-1;x>=primero;x--) {
			if(arreglo[posicionMax]<arreglo[x]) {
				posicionMax=x;
			}
		}
		return posicionMax;
	}
	
	private static void swap(int[] arreglo, int posicionMax, int indice) {
		int temporal=arreglo[indice];
		arreglo[indice]=arreglo[posicionMax];
		arreglo[posicionMax]=temporal;
		
	}

}
