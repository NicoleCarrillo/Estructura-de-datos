//AUTOR: NICOLE CARRILLO CAPRISTAN 
//NOMBRE DE LA CLASE: MERGESORT
//FECHA: 6/02/2019

public class MergeSort {

	public static <E extends Comparable <E>> void mergesort(E[]datos) {
		mergesort(datos,0,datos.length-1);
	}

	private static <E extends Comparable<E>> void mergesort(E[] datos, int min, int max) {
		if(min<max) {
			int central=(min+max)/2;
			mergesort(datos,min,central);
			mergesort(datos,central+1,max);
			merge(datos,min,max);
		}
		//LA CONDICION DE PARO ES NO HACER NADA 
	}

	private static <E extends Comparable<E>> void merge(E[] datos,int min, int max) {
		// generico no puede ser de clase y no puedes mandar a llamar a un constructor generico 	E[] temporal=new E[max-min];
		E[] temporal=(E[]) new Comparable[max-min+1];
		int central=(min+max)/2;
		int parte1=min;
		int parte2=central+1;
		boolean compare1=true;
		boolean compare2=true;

		for(int x=0;x<max-min+1;x++) {

			if(compare1==false) {
				temporal[x]=datos[parte2];
				parte2++;
			}
			else if(compare2==false) {
				temporal[x]=datos[parte1];
				parte1++;
			}
			else {
				if(datos[parte1].compareTo(datos[parte2])<0) {
					if(parte1<central) {
						temporal[x]=datos[parte1];
						parte1++;
					}else {
						temporal[x]=datos[parte1];
						compare1=false;
					}
				}
				else{
					if(parte2<max) {
						temporal[x]=datos[parte2];
						parte2++;
					}else {
						temporal[x]=datos[parte2];
						compare2=false;
					}
				}
			}
		}
		System.arraycopy(temporal, 0, datos, min, max-min+1);
	}


	public static void main(String[]args) {
		Integer[]datos= {4,2,6,1,0,9,6,7,3};
		mergesort(datos);
		for(int x=0;x<datos.length;x++) {
			System.out.print(datos[x]);
		}
	}

}