import javax.swing.JOptionPane;

public class CompareSorts {
	public static void main(String[] args) {
		String valores;
		String letras;
		int opcion;
		opcion=Integer.parseInt(JOptionPane.showInputDialog("SI QUIERES ORDENAR NUMEROS PRESIONA 1, SI QUIERES ORDENAR LETRAS PRESIONA 2"));
		valores=JOptionPane.showInputDialog("INTRODUCE LOS DATOS QUE QUIERAS ORDENAR SEPARADOR POR UNA COMA Y SIN ESPACIO");
		String arreglo[]=valores.split(",");
		if(opcion==1) {
			Integer arreglo_num[]=new Integer[arreglo.length];
			for(int x=0;x<arreglo.length;x++) {
				arreglo_num[x]=Integer.parseInt(arreglo[x]);
			}
			menu(arreglo_num,opcion);
		}
		else {
			menu(arreglo,opcion);
		}

	}

	private static <G extends Comparable <G>> void menu(G[] arreglo,int opcion) {
		String l = System.getProperty("line.separator");
		int metodo=Integer.parseInt(JOptionPane.showInputDialog("Bubble Sort 1"+l+"Insertion Sort 2"+l+"Merge Sort 3"+l+"Quick Sort 4"));
		switch (metodo) {
		case 1:
			long start = System.nanoTime();
			bubbleSort(arreglo);
			imprimeArreglo(arreglo);
			System.out.println("");
			long finish = System.nanoTime();
			long timeElapsed = finish - start;
			System.out.println("Tiempo de ejecución en nanosegundos: " + timeElapsed);
			break;
		case 2:
			long start2 = System.nanoTime();
			insertionSort(arreglo);
			imprimeArreglo(arreglo);
			System.out.println("");
			long finish2 = System.nanoTime();
			long timeElapsed2 = finish2 - start2;
			System.out.println("Tiempo de ejecución en nanosegundos: " + timeElapsed2);
			break;

		case 3:
			long start3 = System.nanoTime();
			mergesort(arreglo);
			System.out.println("");
			imprimeArreglo(arreglo);
			long finish3 = System.nanoTime();
			long timeElapsed3 = finish3 - start3;
			System.out.println("Tiempo de ejecución en nanosegundos: " + timeElapsed3);
			break;

		case 4:
			long start4 = System.nanoTime();
			quicksort(arreglo);
			System.out.println("");
			imprimeArreglo(arreglo);
			long finish4 = System.nanoTime();
			long timeElapsed4 = finish4 - start4;
			System.out.println("Tiempo de ejecución en nanosegundos: " + timeElapsed4);
			break;

		}

	}
	
	public static <G extends Comparable<G>> void quicksort(G[]datos) {
		quicksort(datos,0,datos.length-1);
	}
	
	private static <G extends Comparable<G>> void quicksort(G[]datos, int min, int max) {
		
	//HACE LA PARTICION Y TE REGRESA EN QUE POSICION QUEDO EL PIVOTE 
	//VA DIVIDIENDO EL ARREGLO 
		if(min<max) {
			int p=particionar(datos,min,max);
			quicksort(datos,min,p-1); //SE ORDENA LA PRIMERA MITAD
			quicksort(datos,p+1,max); //SE ORDENA LA SEGUNDO MITAD
		}
	}
	
	private static <G extends Comparable<G>> int particionar(G[] datos, int min, int max) {//PRIMERO DIVIDO EL ARREGLO EN LA MITAD QUE ES MENOR Y LA MITAD QUE ES MAYOR 
		G pivote= datos[min];
		int j=min+1;
		
			for(int i=min;i<=max;i++) {
				if(datos[i].compareTo(pivote)<0) {
					G tmp;
					tmp=datos[j];
					datos[j]=datos[i];
					datos[i]=tmp;
					j++;
				}
			}
			
			G tmp;
			tmp=datos[j-1];
			datos[j-1]=datos[min];
			datos[min]=tmp;

		
		return j-1; //REGRESANDO LA POSICION DEL PIVOTE PARA QUE SEA TOMADO COMO MIN O MAX 
	}
	
	public static <G extends Comparable <G>> void mergesort(G[]datos) {
		mergesort(datos,0,datos.length-1);
	}
	
	private static <G extends Comparable<G>> void mergesort(G[] datos, int min, int max) {
		if(min<max) {
			int central=(min+max)/2;
			mergesort(datos,min,central);
			mergesort(datos,central+1,max);
			merge(datos,min,max);
		}
		//LA CONDICION DE PARO ES NO HACER NADA 
	}
	
	private static <G extends Comparable<G>> void merge(G[] datos,int min, int max) {
		// generico no puede ser de clase y no puedes mandar a llamar a un constructor generico 	E[] temporal=new E[max-min];
		G[] temporal=(G[]) new Comparable[max-min+1];
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
	
	private static <G extends Comparable <G>> void insertionSort(G[] arreglo) {
		
		for(int x=1;x<arreglo.length;x++) {
			if(arreglo[x].compareTo(arreglo[x-1])<0) {
				G temporal=arreglo[x];
				int posicion=x;
				do {
					arreglo[posicion]=arreglo[posicion-1];
					posicion--;

				}while(posicion>0 && temporal.compareTo(arreglo[posicion-1])<0);
				arreglo[posicion]=temporal;
			}
		}	
	}
	

	public static <G extends Comparable <G>> void bubbleSort(G[] arreglo) { //METODO QUE COMPARA 
		for(int j=1;j<arreglo.length-1;j++) {
			for(int i=0;i<arreglo.length-j;i++) { //-J ES PARA QUE NO SE COMPARE OTRA VES TODO QUE YA NO ES NECESARIO 
				if(arreglo[i].compareTo(arreglo[i+1])>0) {
					swap(arreglo,i,i+1);
				}
			}
		}
	}
	
	private static <G> void swap(G [] datos, int i, int j) { //METODO QUE HACE EL INTERCAMBIO
		G tmp;
		tmp=datos[i];
		datos[i]=datos[j];
		datos[j]=tmp; 
	}
	
	public static <G> void imprimeArreglo(G []arreglo) {
		for(int i=0;i<arreglo.length;i++) {
			System.out.print(arreglo[i]+",");
		}
		System.out.println();
	}
}

