//NICOLE CARRILLO
//16/08/19
//PROGRAMA 1) ARREGLO DE CARACTERES QUE IMPRIME TU NOMBRE
//PROGRAMA 2) METODO QUE SUMA LOS ELEMENTOS DE UN ARREGLO

public class ArrayHandler {
	static char[] myName= {'N','I','C','O','L','E'};
	static int[] numeros= {1,2,3,4,5};
	
	public static void main(String[] args) {
		
		//    1
		for(int x=0;x<myName.length;x++) {
			System.out.print(myName[x]);
		}
		
		//    2
		int valor=0;
		System.out.println();
		System.out.println(valor=metodo(numeros,numeros.length-1));
	}
	
	public static int metodo(int numeros[],int posicion) {
		if(posicion==0) {
			return numeros[0];
		}
		
		return numeros[posicion]+metodo(numeros,posicion-1);
		
	}
}
