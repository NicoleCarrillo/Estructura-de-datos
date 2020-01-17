
public class BubbleSort {
	public static void main(String[] args) {
		int arreglo[]= {2,1,6,4,0};
		BubbleSort(arreglo,0);
		BubbleSort2(arreglo,0);
	}

	
	//BUBBLE SORT SIN RECURSIVIDAD 
	private static void BubbleSort2(int[] arreglo, int i) {
		for(int y=0;y<arreglo.length;y++) {
			for(int x=0;x<arreglo.length-1;x++) {
				if(arreglo[x]>arreglo[x+1]) {
					int temp=arreglo[x];
					arreglo[x]=arreglo[x+1];
					arreglo[x+1]=temp;
				}
			}
		}
		for(int x=0;x<arreglo.length;x++) {
			System.out.print(arreglo[x]);
		}
		
	}


	//BUBBLE SORT CON RECURSIVIDAD 
	private static void BubbleSort(int[] arreglo, int n) {
		if(n+1==arreglo.length) {
			System.out.println("arreglo ordenado");
		}
		else {
			for(int x=0;x<arreglo.length-1;x++) {
				if(arreglo[x]>arreglo[x+1]) {
					int temp=arreglo[x];
					arreglo[x]=arreglo[x+1];
					arreglo[x+1]=temp;
				}
			}
			BubbleSort(arreglo,n+1);
		}
	}
	
	
	//BUBBLE SORT SIN RECURSIVIDAD
	
	
	
}
