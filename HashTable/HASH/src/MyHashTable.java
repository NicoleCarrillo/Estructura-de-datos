import java.util.NoSuchElementException;

public class MyHashTable <K,V> {
	
	private MiListaEnlazada<MyNodoHash<K,V>>[] tabla;  //DE QUE VA A SER MI ARREGLO? DE LISTAS ENLAZADAS, DE QUE VA A SER MI LISTA ENLAZADA? DE NODOS
	private int size;
	private static final double LOAD_FACTOR=0.75;
	
	public MyHashTable() {
		this.tabla=(MiListaEnlazada<MyNodoHash<K,V>>[]) new MiListaEnlazada[3];
		this.size=0;
		for(int x=0;x<this.tabla.length;x++) {
			this.tabla[x]=new MiListaEnlazada<>(); //INICIALIZAMOS LAS LISTAS ENLAZADAS
							//EN CADA POSIICION TIENES UNA LISTA ENLAZADA VACIA 
		}
	}
	
	
	public void put(K llave,V valor) {
		int index=llave.hashCode()%this.tabla.length;//EN QUE POSIICON DEL ARREGLO DEBO GUARDAR EL ELEMENTO
		this.tabla[index].insertarFin(new MyNodoHash<>(llave,valor));
		this.size++;
		if((double)this.size/this.tabla.length>MyHashTable.LOAD_FACTOR) {
			reHashing();
		}
	}
	
	public void reHashing() {
		//GENERA UNA NUEVA TABLA DE TAMANO DOBLE MAS 1 Y GUARDA LOS ELEMENTOS DE LA TABLA ANTERIOR A LA NUEVA TABLA (GRANDE)
		//MUY IMPORTANTE REACOMODAR LOS ELEMENTOS
		
		MiListaEnlazada <MyNodoHash<K,V>>[]tablaTEMP=this.tabla; //CREANDO MI ARREGLO DE LISTAS Y LE ESTOY PASANDO LOS DATOS DE LA PRINCIPAL
		this.tabla=(MiListaEnlazada<MyNodoHash<K,V>>[]) new MiListaEnlazada[this.size*2+1]; //AQUI LE DIGO QUE SEA DE TAMANO DOBLE 
		for(int x=0;x<this.tabla.length;x++) {
			this.tabla[x]=new MiListaEnlazada<>(); //INICIALIZAMOS LAS LISTAS ENLAZADAS
							//EN CADA POSIICION TIENES UNA LISTA ENLAZADA VACIA 
		}
		for(int x=0;x<tablaTEMP.length;x++) {
			MiListaEnlazada <MyNodoHash<K,V>> lista=tablaTEMP[x];
			if(!lista.estaVacia()) {
				for(int y=0;y<lista.size();y++) {
				MyNodoHash<K,V> nodoTEMP=lista.getEn(y);
				int index=nodoTEMP.llave.hashCode()%this.tabla.length;//EN QUE POSIICON DEL ARREGLO DEBO GUARDAR EL ELEMENTO
				this.tabla[index].insertarFin(new MyNodoHash<>(nodoTEMP.llave,nodoTEMP.valor));
				}
			}
		}
	}
	
	
	public void get (K llave) throws NoSuchElementException {
		//CALCULAR EL INDICE DONDE DEBERIA ESTAR ESTA LLAVE
		// BUSCAR EN LA LISTA SI ESTA UN NODO CON LA LLAVE BUSCADA, SI ESTA REGRESA EL VALOR, SI NO NOSUCHELEMENTEXCEPTION
		int index=llave.hashCode()%this.tabla.length;

		MiListaEnlazada <MyNodoHash <K,V>> lista= this.tabla[index]; //NUEVA LISTA QUE CONTIENE LOS VALORES DE LA LISTA DEL INDICE DEL ARREGLO 
		for(int x=0;x<lista.size();x++) {
			MyNodoHash<K,V> nodoTEMP=lista.getEn(x); //NODO DE LA LISTA DEL ARREGLO EN ESPECIFICO
			if(nodoTEMP.llave==llave) {
				System.out.println( nodoTEMP.valor);
			}
			else {
				throw new NoSuchElementException("NO EXISTE UN VALOR CON ESTE NUMERO");
			}
		}
	}

	public V delete(K llave, V valor) throws NoSuchElementException{
		//CALCULAR EL INDICE DONDE DEBERIA ESTAR ESTA LLAVE
		// BUSCAR EN LA LISTA SI ESTA UN NODO CON LA LLAVE BUSCADA, SI ESTA BORRAR EL VALOR, SI NO NOSUCHELEMENTEXCEPTION
		
		
		int index=llave.hashCode()%this.tabla.length;
		int x;
		V dato=null; //VARIABLE PARA REGRESAR EL VALOR
		if(containsKey (llave)) {
		MiListaEnlazada <MyNodoHash <K,V>> lista= this.tabla[index];
		for(x=0;x<lista.size();x++) {
			MyNodoHash<K,V> nodoTEMP=lista.getEn(x);
			dato=nodoTEMP.valor;
			if(nodoTEMP.llave==llave) {
				this.tabla[x].flush();
				//nodoTEMP.valor=null;
				//this.tabla[index].borrarEn(x);
				//x=lista.size();
			}

		}	
		return dato;
		}
		
		//int index=llave.hashCode()%this.tabla.length;
		//MyNodoHash<K,V> nodoTEMP= this.tabla[index].popNodo();
		
		
		
		throw new NoSuchElementException("NO EXISTE UN VALOR CON ESTE NUMERO");

	}
	
	public boolean containsKey(K llave) {

		//REGRESA TRUE SI LA TABLA TIENE LAMLLAVE QUE SE PASO COMO PARAMETRO
		for(int x=0;x<tabla.length;x++) {
			MiListaEnlazada <MyNodoHash <K,V>> lista= this.tabla[x];
			if(!lista.estaVacia()) {
				MyNodoHash<K,V> nodoTEMP=lista.getEn(x);
				if(nodoTEMP.llave==llave) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public void clear () {
		//VACIA LA TABLA
		/*for(int x=0;x<this.tabla.length;x++) {
			MiListaEnlazada <MyNodoHash <K,V>> lista= this.tabla[x];
			lista.flush();
		}*/
		for(int x=0;x<this.tabla.length;x++) {
			tabla[x]=null;
		}
	}
	
	
	
	public static void main(String[] args) {
		MyHashTable<Integer, String> datos=new MyHashTable<Integer,String>();
		datos.put(1,"1000");
		datos.put(1,"2000");
		datos.get(1);
		//System.out.println(datos.containsKey(1));
		//System.out.println(datos.delete(1,"1000"));
		//System.out.println(datos.containsKey(1));
		//datos.put(3,"3000");
		//datos.put(4,"4000");
		//datos.put(5,"5000");
		//datos.put(6,"6000");
		//datos.put(7,"7000");
		//datos.put(8,"8000");
		//datos.put(9,"9000");
		//datos.put(10,"10000");
		//datos.put(11,"11000");
		//datos.clear();
		//System.out.println(datos.containsKey(1));
		
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	class MyNodoHash<K,V>{
		K llave;
		V valor;
		
		public MyNodoHash(K llave, V valor) {
			super();
			this.llave = llave;
			this.valor = valor;
		}

		public V getValor() {
			return valor;
		}

		public void setValor(V valor) {
			this.valor = valor;
		}

		public K getLlave() {
			return llave;
		}
		
		
	}
}
