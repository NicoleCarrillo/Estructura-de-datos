
public class BubbleSort {
	
	
	public static void bubbleSort(int[]numeros) {
		for(int j=1;j<=numeros.length-1;j++) {
			for(int i=0;i<numeros.length-j;i++) {
				if(numeros[i]>numeros[i+1]) {
					swap(numeros,i,i+1);
				}
			}
		}
	}
	
	private static void swap(int[] datos, int i, int j) {
		int tmp;
		tmp=datos[i];
		datos[i]=datos[j];
		datos[j]=tmp;
	}
	
	public static void imprimeArreglo(int[]arreglo) {
		for(int i=0;i<arreglo.length;i++) {
			System.out.print(arreglo[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String []args) {
		int []arreglo={90,60,50,70,80,400,100};
		//Bubblesort.bubbleSort(new int {90,60,50,70,80,4,100}); OTRA FORMA DE DECLARARLO
		System.out.println("ANTES");
		imprimeArreglo(arreglo);
		BubbleSort.bubbleSort(arreglo);
		System.out.println("DESPUES");
		imprimeArreglo(arreglo);
	}
}
