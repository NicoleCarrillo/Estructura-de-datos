public class BusquedaBinaria2 {

	public static int binarySearch(String data, String[] datos) {
		int min=0;
		int max= datos.length-1;
		int avg;

		do{
			avg=(min+max)/2;
			if(datos[avg].equals(data)) {
				return avg;
			}
			else if(data.compareTo(datos[avg])<0) {
				max=avg-1;
			} else {
				min=avg+1;
			}
		}while(min<=max);	
		return -1;
	}

	public static void main(String []args) {
		String[] nombres= {"Aristoteles","Cesar","Diego","Hector","Jose", "Luis" };
		System.out.println(binarySearch("Aristoteles",nombres));
	}
}