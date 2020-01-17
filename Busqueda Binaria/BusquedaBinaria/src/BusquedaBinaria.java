public class BusquedaBinaria {

	public static int binarySearch(int data, int[] datos) {
		int min=0;
		int max= datos.length-1;
		int avg;

		do{
			avg=(min+max)/2;
			if(datos[avg]==data) {
				return avg;
			}
			else if(datos[avg]>data) {
				max=avg-1;
			} else {
				min=avg+1;
			}
		}while(min<=max);	
		return -1;
	}
	
	public static int binarySearchRecursivo(int []datos, int start, int end, int x) {
		int middle=(start+end)/2;
		
		if(datos[middle]==x) {
			return middle;
		}
		else {
			if(datos[middle]>x) { //GOING LEFT
				return binarySearchRecursivo(datos, start, middle, x);
			}
			else if(datos[middle]<x) { //GOING RIGHT
				return binarySearchRecursivo(datos, middle+1, end, x);
			}
		}
		return -1;
	}

	public static void main(String []args) {
		int[] data= {1,2,3,4,5,6,7,8,9,10};
		System.out.println(binarySearch(3,data));
		//System.out.print(binarySearchRecursivo(data,0,data.length-1,6));
	}
}
