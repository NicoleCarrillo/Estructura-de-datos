import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedLE<E> extends ListaEnlazada{
	private List<E> a;
	
	public SortedLE() {
		super();
	}
	
	public SortedLE(E[] arreglo) { //Constructor a partir de un arreglo
		a = new ArrayList<E>();
		a=Arrays.asList(arreglo);
	}
	
	private static <E extends Comparable<E>> void quicksort(E[] datos,int min, int max ) {
		if(min<max) {
			int p=particionar(datos,min,max);
			quicksort(datos, min, p-1);
			quicksort(datos, p+1, max);
		}
	}
	
	
	//CHECAR LA LOGICA DE ESTA PARTE
	
	
/*	private static <E extends Comparable<E>> int particionar(E[] datos,int min,int max) {
		//Particionar la tabla y regresar en cuál posición quedó P
		E p=datos[min];
		int i=min+1;
		for(int j=min;j<=max;j++) {
			if(datos[j].compareTo(p)<0) {
				swap(datos,i,j);
				i++;
			}
		}
		swap(datos,i+1,max);
		return i-1;
	}*/
	
	/*private static <E> void swap(E[] datos,int i,int j) {
	E tmp;
	tmp=datos[i];
	datos[i]=datos[j];
	datos[j]=tmp;		
}*/
	
	private static <E extends Comparable<E>> int particionar(E[] datos,int min,int max) {
		//Particionar la tabla y regresar en cuál posición quedó P
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

		
		return j-1; }
	
	
	
	
	public static<E> void insert(int dato){
		NodoLE nvo=new NodoLE(dato);
		NodoLE temp=inicio;
		NodoLE temp2;
		if(inicio.getDato()<(dato)) {
			temp=temp.getNext();
			
		}
		temp2=temp.getNext();
		temp.setNext(nvo);
		nvo.setNext(temp2);
		size++;
	}
	

	
	public static void main(String[]args) {
		
		Integer[] arreglo= {10,20,2,0,100};

		quicksort(arreglo,0,arreglo.length-1);
		for(int x=0;x<arreglo.length;x++) {
			System.out.print(arreglo[x]+", ");
		}
		
		SortedLE<Integer> sorted =new SortedLE<Integer>(arreglo);
		
		System.out.print(sorted);
		
		
		
	}


	
}


