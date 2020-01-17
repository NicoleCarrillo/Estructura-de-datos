
public class MedianSortedArrays {
	public static void main(String[] args) {
		int [] nums1= {1,2};
		int [] nums2= {3};
		System.out.println(median(nums1,nums2));
	}
	
	public static int[] insertionSort(int[] arreglo) {
		
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
		return arreglo;	
	}

	public static int median(int[] nums1, int[] nums2) {
		int l1 =nums1.length;
		int l2 =nums2.length;
		int p=0;
		int[] arreglo=new int[l1+l2];
		for(int x=0;x<arreglo.length;x++) {
			if(x<l1) {
				arreglo[x]=nums1[x];
			}else {
				arreglo[x]=nums2[p];
				p++;
			}
		}
		arreglo=insertionSort(arreglo);
		
		int tamanio=arreglo.length;
		if(tamanio%2==0) {//es par
			int avg=(tamanio/2)-1;
			int x1=arreglo[avg];
			int x2=arreglo[avg+1];
			return (x1+x2)/2;
		}else { //es impar
			int avg=(tamanio+1)/2;
			return avg;
		}
	
	}
}
