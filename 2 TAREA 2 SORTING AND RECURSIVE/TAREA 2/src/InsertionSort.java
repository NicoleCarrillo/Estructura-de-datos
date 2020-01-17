import java.time.Duration;
import java.time.Instant;

public class InsertionSort {
	public static void main(String[] args) {
		int arreglo[]= {1,2,1,0};

		insertionSort(arreglo);

	}

	private static void insertionSort(int[] arreglo) {

		long start = System.nanoTime();

		for(int j=2;j<arreglo.length;j++) {
			int key=arreglo[j];
			int i=j-1;
			while(i>=0&&arreglo[i]>key) {
				arreglo[i+1]=arreglo[i];
				i=i-1;
			}
			arreglo[i+1]=key;
		}
		
		for(int x=0;x<arreglo.length;x++) {
			System.out.print(arreglo[x]);
		}
		
		System.out.println(" ");
		
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		
		
		System.out.println("Tiempo de ejecución en nanosegundos: " + timeElapsed);

	}
}
