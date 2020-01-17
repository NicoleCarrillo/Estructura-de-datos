
public class SumaArreglo {

	public static void main(String[]args) {
		int arreglo[]={1,2,3,4,5,6,7,8,9,10};
		System.out.print(suma(arreglo, arreglo.length-1));
		
	}

	private static int suma(int arreglo[], int posicion) {
		
		if(posicion==0) {
			return arreglo[0];
		}
		
		return arreglo[posicion]+suma(arreglo,posicion-1);
		
	}
}
