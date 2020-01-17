// LISTA QUE  SOLO TIENE UN APUNTADOR QUE ES PRIMERO Y VA AL FINAL DE LA LISTA
// DE MODO QUE PRIMERO PUEDA ACCEDER AL ULTIMO ELEMENTO Y CON INICI.GETNEXT TE DA EL PRIMERO

public class ListaEnlazadaCircular <E>{
	
	private Nodo<E> primero;	
	private int size;
	
	public ListaEnlazadaCircular() {
		this.primero=null;
		this.size=0;
	}
	
	public ListaEnlazadaCircular(E[] arreglo) {
		for(int x=0;x<arreglo.length-1;x++) {
			insertarInicio(arreglo[x]);
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public E inicio() {
		return this.primero.getDato();
	}
	
	public boolean estaVacia() {
		return this.size==0;
	}
	
	public void flush() {
		this.primero=null;
		this.size=0;
		System.gc();
	}
	
	public void insertarInicio(E dato) { //INSERTAR EN ORDEN DESCENDENTE   4 3 2 1 0  EL NUEVO VA PRIMERO
		Nodo nuevo=new Nodo(dato);
		
		if(estaVacia()) {
			 this.primero=nuevo;
			this.primero.setNext(nuevo);	 
		}
		else {			
			Nodo temporal=this.primero.getNext();
			nuevo.setNext(temporal);
			this.primero.setNext(nuevo);	
		}
		this.size++;
	}
	
	public void insertarFin(E dato) {//INSERTAR EN ORDEN ASECENDETE 0 1 2 3 4  EL NUEVO VA HASTA ATRAS 
		Nodo nuevo= new Nodo(dato);
		if(estaVacia()) {
			this.primero=nuevo;
			this.primero.setNext(nuevo);
		}
		else {
			Nodo temporal=this.primero.getNext();
			this.primero.setNext(nuevo);
			nuevo.setNext(temporal);
			this.primero=nuevo;
		}
		size++;
	}
	
	public void insertarEn(E dato, int posicion) { //METODO QUE INSERTA EN POSICION DETERMINADA, TOMANDO EN CUENTA QUE SEA 1 2 3 4 ASI LAS POSICIONES 
		Nodo nuevo=new Nodo(dato);
		Nodo current=this.primero.getNext(); //PARA QUE CORRESPONDA AL PRIMERO VISTO VISUALMENTE 
		
		if(posicion==0) {
			nuevo.setNext(current);
			this.primero.setNext(nuevo);
		}
		if(posicion>size) {
			throw new IndexOutOfBoundsException("NO SE PUEDE INSERTAR EN ESA POSICION");
		}
				
		for(int x=0;x<posicion-1;x++) {
			current=current.getNext();
		}
		
		Nodo despues=current.getNext();
		nuevo.setNext(despues);
		current.setNext(nuevo);
		size++;
	}
	 
	public void borrarInicio() {
		this.primero.setNext(primero.getNext().getNext());
		size--;
	}
	
	public void borrarFin() {
		Nodo current=this.primero.getNext();
		while(current.getNext()!=primero) {
			current=current.getNext();
		}
		this.primero=current;
		this.primero.setNext(primero.getNext().getNext());
	}
	
	public void borrarEn(int posicion) {
		Nodo current=this.primero.getNext();
		for(int x=0;x<posicion-1;x++) {
			current=current.getNext();
		}
		current.setNext(current.getNext().getNext());
	}
	
	
	public boolean buscarElemento(E dato) {
		boolean caso=false;
		Nodo<E> current=this.primero;
		Comparable<E> temporal=(Comparable<E>) current.getDato();
	
		if(temporal.compareTo(dato)==0) {
			caso=true;
			return caso;
		}
		
		current=this.primero.getNext();
		while(current!=this.primero&&!caso) {
			temporal=(Comparable<E>) current.getDato();
			if(temporal.compareTo(dato)==0) {
				caso=true;
			}
			else {
				current=current.getNext();
			}
		}
		return caso;
	}

	
	public String toString() { //IMPRIME LA LISTA TAL COMO ES 
		Nodo current=this.primero;
		String resultado="";
		do {
			resultado+=current.getDato()+",";
			current=current.getNext();
		}while(current!=this.primero);
		return resultado;
	}
	
	public static void main(String[] args) {
		ListaEnlazadaCircular<Integer> lista=new ListaEnlazadaCircular();
		for(int x=0;x<5;x++) {
			lista.insertarInicio(x);
		}
		System.out.print(lista);
		System.out.println("");
		//lista.insertarEn(100, 2);
		System.out.println("");
		System.out.print(lista);
		System.out.println("");
		System.out.println(lista.buscarElemento(2));
		System.out.println("");
		lista.borrarEn(2);
		System.out.print(lista);
	
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	class Nodo<E>{
		private E dato;
		private Nodo<E> next;
		
		public Nodo(E dato){
			this.dato=dato;
			this.next=null;
		}
		
		public Nodo(E dato,Nodo next) {
			super();
			this.dato=dato;
			this.next=next;
		}
		
		public E getDato() {
			return dato;
		}

		public void setDato(E dato) {
			this.dato = dato;
		}

		public Nodo<E> getNext() {
			return next;
		}

		public void setNext(Nodo<E> next) {
			this.next = next;
		}
		
		public String toString() {
			return this.dato + ";"+this.next;
		}
		
	}
}
