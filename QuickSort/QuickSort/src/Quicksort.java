//AUTOR:NICOLE CARRILLO
//FECHA:07/02/19
//TEMA: QUICK SORT 
public class Quicksort {
	public static <E extends Comparable<E>> void quicksort(E[]datos) {
		quicksort(datos,0,datos.length-1);
	}
	
	private static <E extends Comparable <E>> void quicksort(E[]datos, int min, int max) {
		
	//HACE LA PARTICION Y TE REGRESA EN QUE POSICION QUEDO EL PIVOTE 
	//VA DIVIDIENDO EL ARREGLO 
		if(min<max) {
			int p=particionar(datos,min,max);
			quicksort(datos,min,p-1); //SE ORDENA LA PRIMERA MITAD
			quicksort(datos,p+1,max); //SE ORDENA LA SEGUNDO MITAD
		}
	}
	
	private static <E extends Comparable<E>> int particionar(E[] datos, int min, int max) {//PRIMERO DIVIDO EL ARREGLO EN LA MITAD QUE ES MENOR Y LA MITAD QUE ES MAYOR 
		E pivote= datos[min];
		int j=min+1;
		
			for(int i=min;i<=max;i++) {
				if(datos[i].compareTo(pivote)<0) {
					E tmp;
					tmp=datos[j];
					datos[j]=datos[i];
					datos[i]=tmp;
					j++;
				}
			}
			
			E tmp;
			tmp=datos[j-1];
			datos[j-1]=datos[min];
			datos[min]=tmp;

		
		return j-1; //REGRESANDO LA POSICION DEL PIVOTE PARA QUE SEA TOMADO COMO MIN O MAX 
	}
	
	public static void main(String []args) {
		Integer []datos= {3,8,20,5,1,4,7,6};
		quicksort(datos);
		for(int x=0;x<datos.length;x++) {
			System.out.print(datos[x]);
		}
	}
}
