
public class ListaDobleEnlazada <E> {
	
		private int size;
		private NodoLE<E> inicio;
		private NodoLE<E> fin;
		
		public ListaDobleEnlazada(){
			this.inicio=null;
			this.fin=null;
			this.size=0;
		}
		
		public E inicio(){
			return this.inicio.getDato();
		}
		
		public E fin() {
			return this.fin.getDato();
		}
		public ListaDobleEnlazada(E[] arreglo) {
			for(int x=arreglo.length-1;x>=0;x--) {
				insertarInicio(arreglo[x]);
			}
		}
		
		public int size() { //ACCEDER AL TAMANO DE LA LISTA
			return this.size;
		}
		
		public boolean estaVacia() {
			return this.size==0;
			
		}
		public void flush() { //BORRAR TODA LA LISTA
			this.inicio=this.fin=null;
			this.size=0;
			System.gc();
		}
		
		
		public void insertarInicio (E dato) {
			NodoLE<E> nuevoInicio= new NodoLE<>(dato,this.inicio,null);//ya tiene la referencia del next 
			this.inicio=nuevoInicio;
			if(size==0) {
				this.fin=nuevoInicio;
			}
			else if(size>0) {
				this.inicio.getNext().setPrev(inicio);// AL NUEVO INICIO DIGAMOS EN 8 7 AHORA 8 ES EL NUEVO INICIO
			}											// AL 8 LE DIGO DAME EL SIGUIENTE QUE ES 7 Y DEL 7 LE ASIGNO SU PREVIO COMO 8
			size++;										//DE ESTA FORMA YA ESTAN DOBLEMENTE CONECTADOS EL 8 AL 7 Y DEL 7 AL 8 
		}
		
		
	
		
		public void insertarFin(E dato) {
			if(size==0) {
				insertarInicio(dato);
			}
			else {
			NodoLE<E>nuevoFin= new NodoLE<>(dato,null,this.fin);
			this.fin=nuevoFin;
			this.fin.getPrev().setNext(fin);
			size++;
			}
		}
		
		public void insertarEn(E dato, int posicion) {
			if(size==0) {
				insertarInicio(dato);
			}
			else if (size-1==posicion) {
				insertarFin(dato);
			}
			else {
				NodoLE<E>nuevo=new NodoLE<>(dato);
				NodoLE<E>current=this.inicio;
				for(int x=0;x<posicion-1;x++) {
					current=current.getNext();
				}
				NodoLE<E>despues=current.getNext();
				despues.setPrev(nuevo);
				nuevo.setNext(despues);
				nuevo.setPrev(current);
				current.setNext(nuevo);
				size++;
			}
		}
		
		public void insertarEnOrden(E dato) {
			if(estaVacia()) {
				insertarInicio(dato);
			}
			if(((Comparable<E>)inicio.getDato()).compareTo(dato)>0) {
				insertarInicio(dato);
			}
			else {
				if(((Comparable<E>)fin.getDato()).compareTo(dato)<0) {
					insertarFin(dato);
				}
				else {
					NodoLE <E> nuevo=new NodoLE(dato);
					NodoLE <E> current=this.inicio;
					while(current.getNext()!=null&&((Comparable <E>)current.getNext().getDato()).compareTo(nuevo.getDato())<0) {
						current=current.getNext();
					}
					nuevo.setNext(current.getNext());
					current.getNext().setPrev(nuevo);
					current.setNext(nuevo);
					nuevo.setPrev(current);
					size++;
				}
			}
		}
		
		public String toString() {
			NodoLE<E>current=this.inicio;
			String resultado="";
			for(int x=0;x<size;x++) {
				resultado+=current.getDato()+",";
				current=current.getNext();
			}
			return resultado;
		}
		
		public E borrarEn(int posicion) {//visto de atras hacia delante para hacer uso de la doble lista enlazada
			NodoLE<E>current=this.fin;
			E dato=null;
			for(int x=size-1;x>posicion+1;x--) {
				current=current.getPrev();
				dato=current.getPrev().getDato();
			}
			current.setPrev(current.getPrev().getPrev());
			current.getPrev().getPrev().setNext(current);
			size--;
			return dato;
				
		}
		
		public E borrarInicio() {
			NodoLE<E> current=this.inicio;
			E dato=this.inicio.getDato();
			
			this.inicio=current.getNext();
			this.inicio.setPrev(null);
			size--;
			
			return dato;
		}
		
		public E borrarFin() {
			NodoLE<E>current=this.fin;
			E dato=this.fin.getDato();
			this.fin=current.getPrev();
			this.fin.setNext(null);
			size--;
			return dato;
		}
		
		public void imprimirReves() {
			NodoLE<E> current=this.fin;
			while(current!=null) {
				System.out.print(current.getDato()+",");
				current=current.getPrev();
			}
		}
		 
		public boolean buscar(E dato) {
			NodoLE<E> current=this.inicio;
			boolean caso=false;
			while(current!=null&&caso==false) {
				if(current.getDato()==dato) {
					caso=true;
				}
				else {
					current=current.getNext();
				}
			}
			return caso;
		}
		
		
		
		public static void main(String[] args) {
			Integer arreglo[]=new Integer[4];
			for(int x=0;x<4;x++) {
				arreglo[x]=x;
			}
			ListaDobleEnlazada objeto=new ListaDobleEnlazada(arreglo);
			System.out.print(objeto.toString());
			objeto.insertarEn(4, 2);
			objeto.borrarEn(2);
			System.out.println("");
			System.out.print(objeto);
			System.out.println("");
			objeto.imprimirReves();
			System.out.println("");
			System.out.println(objeto.buscar(2));
			System.out.println("");
			objeto.borrarInicio();
			System.out.print(objeto);
			System.out.println("");
			objeto.borrarFin();
			System.out.print(objeto);
			System.out.println("");
			objeto.insertarEnOrden(2);
			System.out.print(objeto);
		}

}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		class NodoLE <E>{
		
		private E dato; //IMPORTANTES ESTAS VARIABLES PORQUE UN NODO CONTIENE DIRECCION Y EL DATO
		private NodoLE<E> next;
		private NodoLE<E> prev;

		public NodoLE(E dato) { //INICIALIZAR UN NODO CON SOLO EL DATO, LA DIRECCION NULL PORQUE SE LA INDICAS DESPUES
			this(dato,null,null); //INSERTAR EN O INSERTAR FIN
		}
		
		public NodoLE(E dato, NodoLE<E> next, NodoLE<E> prev) { //LE VAS A PASAR EL DATO Y ADEMAS LE PASAS LA DIRECCION DE LA CUAL SERA ENLAZADA 
			super(); //INSERTAR INICIO
			this.dato = dato;
			this.next = next;
			this.prev= prev;
		}
		
		//COMO ES PRIVADO EL OBJETO DE NODO, NECESITAS GETTER Y SETTER 
		public E getDato() {  //PERMITE OBTENER EL DATO DEL NODO
			return dato;
		}
		public void setDato(E dato) { //PERMITE ASIGNARLE EL DATO AL NODO
			this.dato = dato;
		}
		public NodoLE<E> getNext() { //PERMITE SABER CUAL ES EL SIGUIENTE EN LA LISTA 
			return next;
		}
		public void setNext(NodoLE<E> next) { //ASIGNAR UN NODO COMO EL SIGUIENTE EN LA LISTA
			this.next = next;
		}
		public NodoLE<E> getPrev() {
			return prev;
		}

		public void setPrev(NodoLE<E> prev) {
			this.prev = prev;
		}
		public String toString() {//METODO DE IMPLEMENTACION DIRECTA QUE TE PERMITE IMPRIMIR LA LISTA DE MANERA CORRECTA DESDE EL PRINCIPIO
			return this.dato+";"+this.next;
		}

}
