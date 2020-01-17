
public class InsertionSortMenorAMayor {
	public static void main(String[] args) {
		int arreglo[]= {2,4,1,3,5};
		insertionSort(arreglo);
		
		for(int x=0;x<arreglo.length;x++) {
			System.out.print(arreglo[x]+",");
		}

	}

	private static void insertionSort(int[] arreglo) {
	
		for(int x=1;x<arreglo.length;x++) {
			if(arreglo[x]<arreglo[x-1]) {
				int temporal=arreglo[x];
				int posicion=x;
				do {
					arreglo[posicion]=arreglo[posicion-1];
					posicion--;

				}while(posicion>0 && temporal<arreglo[posicion-1]);
				arreglo[posicion]=temporal;
			}
		}	
	}
}
