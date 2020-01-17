
public class Lista <E>{
	protected Nodo<E> inicio;
	protected Nodo<E> fin;
	protected int size;
	
	public Lista() { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		this.inicio=null;
		this.fin=null;
		size=0;
	}
	
	public boolean estaVacia() {
		return this.size==00; //!!!!!!!!!!!!!!!!!!!!!!!!!
	}
	
	public void flush() {
		this.inicio=null;
		this.fin=null;
		this.size=0;
		System.gc();
	}
	
	public String toString() {
		Nodo<E> current=this.inicio;
		String res="";
		for(int x=0;x<size;x++) {
			res+=current.dato;
			current=current.next;
		}
		return res;
	}
	
	public void insertarInicio(E dato) {
		Nodo<E> nuevo=new Nodo<>(dato, this.inicio);
		inicio=nuevo;
		if(size==0)
			this.fin=nuevo;
		size++;
		
	}
	
	public void insertarFin(E dato) {
		if(estaVacia())
			insertarInicio(dato);
		else {
			Nodo<E>nuevo=new Nodo<>(dato);
			this.fin.next=nuevo;
			this.fin=nuevo;
			size++;
		}
	}
	
	public void insertarEn(E dato, int pos) throws IndexOutOfBoundsException {
		if(pos==0) 
			throw new IndexOutOfBoundsException("VE AL METODO INSERTAR INICIO");
		if(pos==size) {
			throw new IndexOutOfBoundsException("VE AL METODO INSERTAR FIN");
		}
		Nodo<E> current=this.inicio;
		Nodo<E> nuevo=new Nodo <>(dato);
		for(int x=0;x<pos-1;x++) {
			current=current.next;
		}
		Nodo<E> despues=current.next;
		
		nuevo.next=despues;
		current.next=nuevo;
		size++;
	}
	
	
	


public static void main(String []args) {
	Lista <Integer> lista1= new Lista();
	lista1.insertarInicio(1);
	lista1.insertarInicio(2);
	System.out.print(lista1);
	
	lista1.insertarFin(4);
	System.out.println("");
	System.out.print(lista1);
	
	lista1.insertarEn(3,1);
	System.out.println("");
	System.out.print(lista1);
}

class Nodo<E>{
	protected Nodo<E> next;
	protected E dato;//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	public Nodo (E dato) {
		this(dato,null);
	}
	
	public Nodo (E dato, Nodo <E> next) {
		this.dato=dato;
		this.next=next;
	}	
}

}
