
public class InvertirArreglo {
	public static void main(String[]args) {
		int[]arreglo= {1,2,3,4,5,6};
		//metodo(arreglo,arreglo.length-1);
		
		for(int x=0;x<arreglo.length;x++) {
			System.out.print(arreglo[x]);
		}
		
		System.out.println("");
		System.out.println("invertido");
		//metodo2(arreglo);
		invertir3(arreglo,arreglo.length-1,0);
		
		for(int x=0;x<arreglo.length;x++) {
			System.out.print(arreglo[x]);
		}
	}

	//METODO DE PREPARACION PARA CREAR OTRO ARREGLO TEMPORAL E INVERTIR EL ORIGINAL 
	private static void metodo2(int[] arreglo) {
		int size=arreglo.length;
		int temporal[]=new int[size];
		
		for(int x=0;x<size;x++) {
			temporal[x]=arreglo[x];
		}

		invertir2(arreglo,temporal,size-1,0);

	}

	//METODO RECURSIVO QUE INVIERTE EL ORIGINAL 
	private static void invertir2(int[] arreglo, int[] temporal, int size, int posicion) {
		if(size>=0) {
			arreglo[posicion]=temporal[size];
			invertir2(arreglo, temporal, size-1, posicion+1);
		}

	}
	
	private static void invertir3(int[] arreglo, int max, int min) {
		
		
		if((min+1)<=max) {
			int pos1=arreglo[min];
			int pos2=arreglo[max];
			
			arreglo[max]=pos1;
			arreglo[min]=pos2;
			
			invertir3(arreglo,max-1,min+1);
			
		}

	}

	//SOLO IMPRIME AL REVES
	private static void metodo(int[] arreglo, int x) {
		if(x>=0){

			System.out.println(arreglo[x]);
			metodo(arreglo,x-1);

		}
	}
}
