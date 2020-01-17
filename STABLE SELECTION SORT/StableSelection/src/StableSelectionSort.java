
public class StableSelectionSort {
	public static void main(String[] args) {
		int[]arreglo= {4,5,3,2,4,1};
		int contador=0;
		metodo(arreglo,contador);
		for(int x=0;x<arreglo.length;x++) {
			System.out.print(arreglo[x]+",");
		}
	}

	private static void metodo(int[] arreglo,int contador) {
		if(contador!=arreglo.length) {
			int min=100;
			int posicion=0;
			for(int x=contador;x<arreglo.length;x++) {
				if(arreglo[x]<min) {
					min=arreglo[x];
					posicion=x;
				}
			}
			
			while(posicion>contador) {
				arreglo[posicion]=arreglo[posicion-1];
				posicion--;
			}
			arreglo[contador]=min;
			
			metodo(arreglo,contador+1);
			
		}
		

	}

}
