//encuentra el elemento mas grande 
public class numMaxArreglo {
	public static void main(String[] args) {
		int arr[] = {12, 10, 30, 50, 100}; 
		System.out.println(metodo(arr,5));
		System.out.println(metodo2(arr,5));
	}

	private static int metodo2(int[] arr, int i) {
		if(i==1) {
			return arr[0];
		}else {
			int min=metodo2(arr,i-1);
			if(min<arr[i-1]) {
				return min;
			}		
			else {
				return arr[i-1];
			}
		}
	}

	private static int metodo(int[] a, int n) {
		int x; 
		if(n == 1) 
			return a[0]; 
		else
			x = metodo(a, n-1); 
		if(x > a[n-1]) 
			return x; 
		else
			return a[n-1];
	}
}
