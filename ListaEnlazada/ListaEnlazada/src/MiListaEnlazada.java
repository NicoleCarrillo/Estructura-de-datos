import java.util.NoSuchElementException;

//AUTOR NICOLE CARRILLO 
//FECHA 11/02/19
public class MiListaEnlazada<E> {
	
	private NodoLE<E> inicio,fin;
	private int size;
	
	public MiListaEnlazada() { //ESTO ES SUPER IMPORTANTE SI NO MARCA ERROR
		this.inicio=this.fin=null;
		this.size=0;
	}
	
	public MiListaEnlazada(E[]datos) { //TRANSFORMA UN ARREGLO EN UNA LISTA ENLAZADA 
		for(int x=datos.length-1;x>=0;x--) {
			insertarInicio(datos[x]);
		}
	}
	
	public void insertarEn(E dato, int pos) throws IndexOutOfBoundsException{
		if(pos==0)
			throw new IndexOutOfBoundsException("NO PUEDE SER 0 LA POSICION, utiliza la otra funcion");
		if(pos>=size())
			throw new IndexOutOfBoundsException("NO PUEDE SER LA POSICION FINAL, utiliza la otra funcion");
		
		NodoLE<E> nvo=new NodoLE<>(dato);
		NodoLE<E> auxiliar= inicio;
		
		for(int x=0;x<pos-1;x++) {
			auxiliar=auxiliar.getNext(); //obtengo el nodo anterior
		}
		NodoLE<E>despues=auxiliar.getNext();//obtengo el nodo que va despues de donde lo quiero meter
		
		nvo.setNext(despues);
		auxiliar.setNext(nvo);
		size++;
		
	}
	
	public void  insertarOrden(E dato) {
	
		if(estaVacia()) {// SI ESTA VACIA LA LISTA 
			insertarInicio(dato);
		}	

		if( ((Comparable<E>) inicio.getDato()).compareTo(dato)<0) {
			insertarInicio(dato);
		}
		else {
			if(((Comparable<E>) fin.getDato()).compareTo(dato)>0) {
				insertarFin(dato);
			}
			else {
				NodoLE<E> nuevo=new NodoLE<>(dato);
				NodoLE<E> current= inicio;
				while (current.getNext() != null && ((Comparable<E>) current.getNext().getDato()).compareTo(nuevo.getDato())>0) {
				current = current.getNext();
			}

			nuevo.setNext(current.getNext()); 
			current.setNext(nuevo);
			size++;
			}
		}
	}
	
	public int size() { //ACCEDER AL TAMANO DE LA LISTA
		return this.size;
	}
	
	public E inicio() {// REGRESA EL VALOR UBICADO EN INICIO
		try {
		return this.inicio.getDato();
		}catch (NullPointerException e) {
			throw new NoSuchElementException("NO SE PUEDE REGRESAR UN ELEMENTO DE UNA LISTA VACIA");
		}
	}
	
	public E fin() { //REGRESA EL VALOR UBICADO EN FIN
		try {
		return this.fin.getDato();
		}catch (NullPointerException e) {
			throw new NoSuchElementException("NO SE PUEDE REGRESAR UN ELEMENTO DE UNA LISTA VACIA");
		}
	}
	
	public boolean estaVacia() {
		return this.size==0;
		
	}
	
	//INSERTAR BACKWARDS
	public void insertarInicio(E dato) { //AQUI ESTAMOS AGREGANDO UN DATO A LA PARTE DE INICIO
		NodoLE<E> nvo=new NodoLE<>(dato,this.inicio); //AQUI CREAMOS EL NODO CON EL DATO Y LA DIRECCION DE INICIO
		this.inicio=nvo;//A INICIO LE TIENES QUE AGREGAR LA DIRECCION DEL NUEVO 
		if(this.size==0)
			this.fin=nvo;
		this.size++;
			
	}
	
	//INSERTAR FORWARDS
	public void insertarFin(E dato) {//INSERTA UN DATO AL FINAL
		
		if(this.estaVacia()) {
			this.insertarInicio(dato);
		}else {
		NodoLE<E> nvo=new NodoLE<>(dato);
		this.fin.setNext(nvo);
		this.fin=nvo;
		this.size++;
		}
	}
	
	public E borrarInicio() {
		try {
		E res=this.inicio();//regresa el dato que se borro
		this.inicio=this.inicio.getNext();
		this.size--;
		if(this.size==0) {
			this.fin=null;
		}
		return res;
		}catch (NoSuchElementException e) {
			throw new IndexOutOfBoundsException("no se puede borrar el primer elemento de una lista ");
		}
	}
	
	public E borrarFin() {
		if(size>1) {
			E res=this.fin();
			NodoLE<E> current=this.inicio;
			for(int x=0;x<this.size-2;x++) {
				current=current.getNext();
			}
			current.setNext(null);
			this.fin=current;
			this.size--;
			return res;
		}
		else {
			try {
				return this.borrarInicio();
			}catch(IndexOutOfBoundsException ex){
				throw new IndexOutOfBoundsException("NO SE PUEDE BORRAR EL ULTIMO ELEMENTO DE UNA LISTA DE TAMANO 1");
			}

		}
	}
	
	public void metodoBorrarNodo(int posicion) { //METODO PARA PROBAR EL BORRAR NODO
		int x=0;
		NodoLE<E> current=this.inicio;
		while(x<posicion) {
			current=current.getNext();
			x++;
		}
		borrarNodo(current);
	}
	
	public E borrarNodo(NodoLE <E> nodo ) { //METODO QUE BORRA UN NODO CUYO PARAMETRO ES UN NODO
		NodoLE<E> current=this.inicio;
		
		if(current.getDato()==nodo.getDato()) { //CHECA SI EL NODO A BORRAR ES EL PRIMERO
			this.inicio=this.inicio.getNext();
			this.size--;
		}
		else {
			if(this.fin.getDato()==nodo.getDato()) {// CHECA SI EL NODO A BORRAR ES EL ULTIMO
				while(current.getNext()!=null) {
					current=current.getNext();
				}
				current.setNext(null);
				this.size--;
			}
			else {
				while(current!=null) {
					if(current.getNext().getDato()==nodo.getDato()) {
						current.setNext(current.getNext().getNext());
						size--;
						return nodo.getDato();
					}
					else {
						current=current.getNext();
					}
				}
			}
		}
		return nodo.getDato();
	}

	public void flush() { //BORRAR TODA LA LISTA
		this.inicio=this.fin=null;
		this.size=0;
		System.gc();
	}
	
	public E borrarEn(int pos) throws IndexOutOfBoundsException{
		E dato=null;
		if(pos>0&&pos<this.size()) {
			NodoLE<E> current=this.inicio;
			for(int x=0;x<pos-1;x++) {
				current=current.getNext();
			}
			dato=current.getNext().getDato();
			current.setNext(current.getNext().getNext());
			size--;
			
			}else {
				throw new IndexOutOfBoundsException("NO SE PUEDE REGRESAR EL ELEMENTO DE LA POSICION INTROCIDA, EN CASO DE SER 0 EL DE LA ULTIMA POSICION UTILIZA LOS METODOS CORRESPONDIENTES "+pos);
			}
		return dato;
	}

	
	public E getEn(int pos) throws IndexOutOfBoundsException{
		if(pos<0&&pos<this.size()) {
		NodoLE<E> current=this.inicio;
		for(int x=0;x<pos;x++) {
			current=current.getNext();
		}
		return current.getDato();
		}else {
			throw new IndexOutOfBoundsException("NO SE PUEDE REGRESAR EL ELEMENTO DE LA POSICION "+pos);
		}
	}
	
	public void setEn(E dato, int pos) throws IndexOutOfBoundsException{
		
		if(pos>0&&pos<this.size()) {
			NodoLE<E> current=this.inicio;
			for(int x=0;x<pos;x++) {
				current=current.getNext();
			}
						
			current.setDato(dato);
			
			}else {
				throw new IndexOutOfBoundsException("NO SE PUEDE REGRESAR EL ELEMENTO DE LA POSICION "+pos);
			}
	}
	
	public  int getSize() throws NoSuchElementException{
		if(this.estaVacia()) {
			throw new NoSuchElementException("LISTA VACIA");
		}else {
			int tamanio=0;
			NodoLE<E> current=this.inicio;
			do{
				tamanio++;
				current=current.getNext();
			}while(current!=null);

			return tamanio;
		}
	}
	
	//VERSION NICOLE 1 
	public boolean checarDato( E dato) { 
		NodoLE<E> current=this.inicio;
		for(int x=0;x<this.size;x++) {
			if(current.getDato()==dato) 
				return true;
			else {
				current=current.getNext();
				if(current==this.fin&&current.getDato()!=dato) 
					return false;
			}
		}
		return true;
	}
	
	//VERSION NICOLE 2
	public boolean checarDato2( E dato) { 
		NodoLE<E> current=this.inicio;
		boolean found=false;
		while(current !=null && !found) { //MIENTRAS CURRENT SEA DIFERENTE DE NULL Y FOUND SEA FALSO...!FOUND ES VERDADERO MIENTRAS FOUND SEA FALSO 
			if(current.getDato().equals(dato))
				found=true;
			else
				current=current.getNext();
		}
		return found;
	}
	
	//VERSION NICOLE 3
	public boolean checarDato3( E dato) { 
		NodoLE<E> current=this.inicio;
		boolean found=false;
		while(current !=null && !found) { //MIENTRAS CURRENT SEA DIFERENTE DE NULL Y FOUND SEA FALSO...!FOUND ES VERDADERO MIENTRAS FOUND SEA FALSO 
			Comparable<E> temporal= (Comparable<E>) current.getDato();
			
			if(temporal.compareTo(dato)==0)
				found=true;
			else
				current=current.getNext();
		}

		return found;
	}
	
	
	public String toString() {
		NodoLE<E> current=this.inicio;
		String resultado="";
		for(int x=0;x<size;x++) {
			resultado+=current.getDato()+",";
			current=current.getNext();
		}
		return resultado;
	}
	
//////////////////////////////////////////////////////////////////////////////////	
	
	public static void main(String[]args) {
		System.out.println("hola");
		MiListaEnlazada<Integer> lista1=new MiListaEnlazada();
		for(int x=0;x<5;x++) {
			lista1.insertarInicio(x);
		}
		lista1.insertarOrden(2);
		System.out.print(lista1);
		System.out.println("");
		lista1.metodoBorrarNodo(5);
		System.out.println("");
		//lista1.insertarEn(100, 1);
		//lista1.insertarInicio(200);
		System.out.print(lista1);
		System.out.println("");
		//System.out.print("size "+lista1.getSize());
		//System.out.println("");
		System.out.print("dato "+lista1.checarDato3(1));
		System.out.println("");
		//lista1.borrarEn(1);
		//System.out.print(lista1);
		lista1.setEn(20,2);
		//lista1.borrarInicio();
		//System.out.println("");
		System.out.print(lista1);
		//System.out.println("");
		//lista1.insertarFin(500);
		//lista1.borrarInicio();
		//System.out.print(lista1);
		
		//Integer datos[]= {1,2,3,4,5,6};//CUANDO SE VAN IINTRODUCIENDO SOLO APUNTA A LA POSICION A RECORRE TODO? 
		//MiListaEnlazada<Integer> lista2=new MiListaEnlazada(datos);
		//lista2.insertarEn(100, 3);
		//System.out.print(lista2);
		MiListaEnlazada<String> lista3=new MiListaEnlazada();
		lista3.insertarInicio("A");
		lista3.insertarInicio("B");
		lista3.insertarInicio("D");
		lista3.insertarInicio("E");
		lista3.insertarOrden("C");
		System.out.print(lista3);
		
	
	}

	/////////////////////////////////////////////////////////////////////////////////////	
	class NodoLE <E>{
		
		private E dato; //IMPORTANTES ESTAS VARIABLES PORQUE UN NODO CONTIENE DIRECCION Y EL DATO
		private NodoLE<E> next;
		
		public NodoLE(E dato) { //INICIALIZAR UN NODO CON SOLO EL DATO, LA DIRECCION NULL PORQUE SE LA INDICAS DESPUES
			this(dato,null); //INSERTAR EN O INSERTAR FIN
		}
		
		
		
		public NodoLE(E dato, NodoLE<E> next) { //LE VAS A PASAR EL DATO Y ADEMAS LE PASAS LA DIRECCION DE LA CUAL SERA ENLAZADA 
			super(); //INSERTAR INICIO
			this.dato = dato;
			this.next = next;
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
		
		public String toString() {//METODO DE IMPLEMENTACION DIRECTA QUE TE PERMITE IMPRIMIR LA LISTA DE MANERA CORRECTA DESDE EL PRINCIPIO
			return this.dato+";"+this.next;
		}
		
	}}


