//AUTOR: NICOLE CARRILLO CAPRISTAN
//NOMBRE DE LA CLASE: BUBBLE SORT
//FECHA:28/01/2019
 
public class BubbleSortGenericos {
	
	
	public static <E extends Comparable <E>> void bubbleSort( E []numeros) { //METODO QUE COMPARA 
		for(int j=1;j<numeros.length-1;j++) {
			for(int i=0;i<numeros.length-j;i++) { //-J ES PARA QUE NO SE COMPARE OTRA VES TODO QUE YA NO ES NECESARIO 
				if(numeros[i].compareTo(numeros[i+1])>0) {
					swap(numeros,i,i+1);
				}
			}
		}
	}
	
	private static <E> void swap(E [] datos, int i, int j) { //METODO QUE HACE EL INTERCAMBIO
		E tmp;
		tmp=datos[i];
		datos[i]=datos[j];
		datos[j]=tmp; 
	}
	
	public static <E> void imprimeArreglo(E []arreglo) {
		for(int i=0;i<arreglo.length;i++) {
			System.out.print(arreglo[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String []args) {
		Integer []arreglo={90,60,50,70,80,4,100};
		String []arreglo2={"NICOLE","CHEMA","ARISTOTELES","KARLA","LUIS"};
		//Bubblesort.bubbleSort(new int {90,60,50,70,80,4,100}); OTRA FORMA DE DECLARARLO
		System.out.println("ANTES");
		imprimeArreglo(arreglo);
		BubbleSortGenericos.bubbleSort(arreglo);
		System.out.println("DESPUES");
		imprimeArreglo(arreglo);
		
		System.out.println("");
		System.out.println("");
		
		System.out.println("ANTES");
		imprimeArreglo(arreglo2);
		BubbleSortGenericos.bubbleSort(arreglo2);
		System.out.println("DESPUES");
		imprimeArreglo(arreglo2);
	}
}
