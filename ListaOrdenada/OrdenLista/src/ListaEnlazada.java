import java.util.NoSuchElementException;

public class ListaEnlazada {
	
		protected static  NodoLE inicio;

		protected NodoLE fin;
		
		protected static int size;
		
		public ListaEnlazada(){
			this.inicio = this.fin = null;
			this.size = 0;
		}
		
		public ListaEnlazada(int datos) {
			
		}
		
		public int inicio(){
			try{
				return this.inicio.getDato();
			}catch(NullPointerException e) {
				
				throw new NoSuchElementException("No se puede regresar el primer elmento de una lista enlazada");
			}
		}
		
		
		
		public int fin() {
			try {
			return this.fin.getDato();
		}catch(NullPointerException e){
			throw new NoSuchElementException("No hay fin");
			}
		}
		
		
		public boolean estaVacia() {
			return this.size==0;
		}
		
		public int size() {
			return this.size;
		}
		
		public void insertarInicio(int dato) {
			NodoLE nvo = new NodoLE(dato, this.inicio);
				this.inicio = nvo;
				if(this.estaVacia()) {
					this.fin = nvo;
				}
				this.size++;
			}
		
	/*	public <E extends Comparable<E>> void insertarOrden(E ins) {
			NodoLE<E>nuevo = new NodoLE<E>(ins);
			nuevo.setNext(null);
			
			NodoLE<E> current = (NodoLE<E>) inicio;
			while (current.getNext() != null && current.getNext().getDato().compareTo(nuevo.getDato()) < 0) {
				System.out.println(current.getDato());
				current = current.getNext();
			}

			nuevo.setNext(current.getNext()); 
			System.out.println(current.getNext().getNext().getDato());
			current.setNext(nuevo);
			size++;
		}
		
*/
		
		public void insertarOrden(int ins) {
			
			if(inicio.getDato()<ins) {
				insertarInicio(ins);
			}else {
			
			NodoLE nuevo = new NodoLE(ins);
			nuevo.setNext(null);
			
			NodoLE current = (NodoLE) inicio;
			while (current.getNext() != null && current.getDato()>=(nuevo.getDato())) {
				//System.out.println(current.getDato());
				current = current.getNext();
			}

			nuevo.setNext(current.getNext()); 
			//System.out.println(current.getNext().getNext().getDato());
			current.setNext(nuevo);
			size++;
			}
		}
		
		
		public void insertarFin(int dato) {
			if(this.estaVacia()) {
				this.insertarInicio(dato);
			}else {
				NodoLE nvo = new NodoLE(dato);
				this.fin.setNext(nvo);
				this.fin = nvo;
				this.size++;
			}

		}
		
		public void insertarEn(int dato, int pos) {
			if(pos==0)
				throw new IndexOutOfBoundsException("NO PUEDE SER 0 LA POSICION, utiliza la otra funcion");
			if(pos>=size())
				throw new IndexOutOfBoundsException("NO PUEDE SER LA POSICION FINAL, utiliza la otra funcion");
			
			NodoLE nvo=new NodoLE(dato);
			NodoLE auxiliar= inicio;
			
			for(int x=0;x<pos-1;x++) {
				auxiliar=auxiliar.getNext(); //obtengo el nodo anterior
			}
			NodoLE despues=auxiliar.getNext();//obtengo el nodo que va despues de donde lo quiero meter
			
			nvo.setNext(despues);
			auxiliar.setNext(nvo);
			size++;
		}
		
		public int borrarInicio() {
			try {
			int res = this.inicio();
			this.inicio= this.inicio.getNext();
			this.size --;
			if(this.size ==0) {
				this.fin = null;
			}
			return res;
			}catch(NullPointerException e) {
				throw new IndexOutOfBoundsException("No se puede borrar el inicio de una lista vacía");
			}
		}
		
		public int borrarFin() {
			if(size > 1) {
			int dato = this.fin();
			NodoLE current = this.inicio;
			for(int i =0; i<this.size-1;i++) {
				current = current.getNext();		
				}
			//Quiero que current se detenga uno antes de fin
			current.setNext(null);
			fin = current;
			this.size--;
			return dato;
			}else {
				try {
					return borrarInicio();
				}catch(IndexOutOfBoundsException e) {
					throw new IndexOutOfBoundsException("No se puede borrar el fin de una lista vacía");
				}
				
			}
		}
		
		public void flush() {
			inicio = fin = null;
			size=0;
			System.gc();
		}
		
		public int getEn(int pos) {
			if(pos==size-1) {
				return fin();
			}else if(pos>= 0 && pos<size) {
			NodoLE current = this.inicio;
			for(int i = 0; i<pos;i++) {
				current = current.getNext();
			}
			return current.getDato();
			}else {
				throw new IndexOutOfBoundsException("No se puede regresar el elemento en la posicion" + pos);
			}
		}
		
		public void setEn(int dato, int pos) {
			if(pos>= 0 && pos<size) {
			NodoLE current = this.inicio;
			for(int i = 0; i<pos;i++) {
				current = current.getNext();
			}
				current.setDato(dato);
			}else {
				throw new IndexOutOfBoundsException("No se puede regresar el elemento en la posicion" + pos);
			}
		}
		
	
		

		public String toString() {
			String res  =" ";	
			NodoLE current = this.inicio;
			for(int i =0; i < this.size; i++) {
				res+=current.getDato()+",";
				current = current.getNext();
			}
			return res;
		}
		
		
		
		public static void main(String[] args) {
		ListaEnlazada lista=new ListaEnlazada();
		for(int x=1;x<5;x++) {
			lista.insertarInicio(x);
		}
		
		
		
		System.out.print(lista);
		lista.insertarEn(100, 2);
		System.out.println("");
		System.out.print(lista);
		
		lista.insertarOrden(5);
		
		System.out.println("");
		System.out.print(lista);

		}
		
	}
		
		class NodoLE{
			private int dato;
			private NodoLE next;
		
			public NodoLE(int dato, NodoLE next) {
				super();
				this.dato = dato;
				this.next = next;
			}
			
			public NodoLE(int dato) {
				this(dato, null);
			}
			public int getDato() {
				return dato;
			}
			public void setDato(int dato) {
				this.dato = dato;
			}
			public NodoLE getNext() {
				return next;
			}
			public void setNext(NodoLE next) {
				this.next = next;
			}
			
			public String toString() {
				return this.dato+":"+ this.next;
			}
			
			
		}

