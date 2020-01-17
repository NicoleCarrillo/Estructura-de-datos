//NICOLE CARRILLO CAPRISTAN A01551581
//JOSE MARIA SANCHEZ HERNANDEZ A01551625
public class MergeSort {

	private static void mergesort(int[] arreglo,int min,int max) {

		if(min<max) {
			int central=((min+max)/2);
			mergesort(arreglo,min,central);
			mergesort(arreglo,central+1,max);
			merge(arreglo,min,central,max);
		}
	}

	private static void merge(int[] arreglo, int min, int central, int max) {
		int n1=central-min+1;
		int n2=max-central;
		int L[]=new int[n1+1];
		int R[]=new int[n2+1];
		for(int i=1;i<=n1;i++) {
			L[i]=arreglo[min+i-1];
		}
		for(int j=1;j<=n2;j++) {
			R[j]=arreglo[central+j];
		}

		int i=1;
		int j=1;

		for(int k=min;k<max;k++) {

			if(L[i]<=R[j]) {
				arreglo[k]=L[i];
				i=i+1;
			}else {
				arreglo[k]=R[j];
				arreglo[k+1]=L[i];
				j++;
			}
		}

	}	

	public static void main(String[] args) {
		int datos[]= {5,2,4};
		int datos2[]= {5,2,4,1};
		long start = System.nanoTime();
		mergesort(datos,0,datos.length-1);
		for(int x=0;x<datos.length;x++) {
			System.out.print(datos[x]);
		}
		System.out.println("");
		long finish = System.nanoTime();
		long timeElapsed = finish - start;
		System.out.println("Tiempo de ejecución en nanosegundos: " + timeElapsed);

		//PROFE COPIAMOS TAL CUAL EL CODIGO DEL LIBRO Y PARA MAS DE 4 VALORES YA MARCA INDEX 
		//OUT OF BOUNDS
		//PARA LA SIGUIENTE TAREA PONDREMOS EL QUE IMPLEMENTAMOS EN CLASE Y ESE SI FUNCIONA
		//PARA TODOS LOS CASOS 
		System.out.println("");
		mergesort(datos2,0,datos.length-1);
		for(int x=0;x<datos2.length;x++) {
			System.out.print(datos[x]);
		}
	}
}
