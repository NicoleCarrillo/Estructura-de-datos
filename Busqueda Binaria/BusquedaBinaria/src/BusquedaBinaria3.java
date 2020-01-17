public class BusquedaBinaria3 {

	public static <E extends Comparable <E>>  int binarySearch(E d, E[]data ) {
		int min=0;
		int max= data.length-1;
		int avg;

		do{
			avg=(min+max)/2;
			if(data[avg].equals(d)) {
				return avg;
			}
			else if(d.compareTo(data[avg])<0) {
				max=avg-1;
			} else {
				min=avg+1;
			}
		}while(min<=max);	
		return -1;
	}

	public static void main(String []args) {
		String[] nombres= {"Aristoteles","Cesar","Diego","Hector","Jose", "Luis" };
		Integer [] lista= {1,2,3 };
		System.out.println(binarySearch("Aristoteles",nombres));
		System.out.println(binarySearch(2,lista));
	}
}
