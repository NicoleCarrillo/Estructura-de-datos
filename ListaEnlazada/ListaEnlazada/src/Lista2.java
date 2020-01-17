

//PROGRAMA LISTA ENLAZADA SIN GENERICOS Y TIPO PUBLICO 

public class Lista2 {
	
	public NodoLE inicio,fin;
	public int size;
	
	public Lista2() { //ESTO ES SUPER IMPORTANTE SI NO MARCA ERROR
		this.inicio=this.fin=null;
		this.size=0;
	}
	
	public Lista2(int[]datos) { //TRANSFORMA UN ARREGLO EN UNA LISTA ENLAZADA 
		for(int x=datos.length-1;x>=0;x--) {
			insertarInicio(datos[x]);
		}
	}
	
	public void insertarEn(int dato, int pos) throws IndexOutOfBoundsException{
		if(pos==0)
			throw new IndexOutOfBoundsException("NO PUEDE SER 0 LA POSICION, utiliza la otra funcion");
		if(pos>=size)
			throw new IndexOutOfBoundsException("NO PUEDE SER LA POSICION FINAL, utiliza la otra funcion");
		
		NodoLE nvo=new NodoLE (dato);
		NodoLE auxiliar= inicio;
		
		for(int x=0;x<pos-1;x++) {
			auxiliar=auxiliar.next; //obtengo el nodo anterior
		}
		NodoLE despues=auxiliar.next;//obtengo el nodo que va despues de donde lo quiero meter
		
		nvo.next=despues;
		auxiliar.next=nvo;

		size++;
		
	}
	
	
	
	//INSERTAR BACKWARDS
	public void insertarInicio(int dato) { //AQUI ESTAMOS AGREGANDO UN DATO A LA PARTE DE INICIO
		NodoLE nvo=new NodoLE(dato,this.inicio); //AQUI CREAMOS EL NODO CON EL DATO Y LA DIRECCION DE INICIO
		this.inicio=nvo;//A INICIO LE TIENES QUE AGREGAR LA DIRECCION DEL NUEVO 
		if(this.size==0)
			this.fin=nvo;
		this.size++;
			
	}
	
	
	

	
	public String toString() {
		NodoLE current=this.inicio;
		String resultado="";
		for(int x=0;x<size;x++) {
			resultado+=current.dato+",";
			current=current.next;
;		}
		return resultado;
	}
	
//////////////////////////////////////////////////////////////////////////////////	
	
	public static void main(String[]args) {
		MiListaEnlazada<Integer> lista1=new MiListaEnlazada();
		for(int x=0;x<3;x++) {
			lista1.insertarInicio(x);
		}
		lista1.insertarEn(100, 1);
		System.out.print(lista1);
	}
	
	
	
	public class NodoLE {

		public int dato; //IMPORTANTES ESTAS VARIABLES PORQUE UN NODO CONTIENE DIRECCION Y EL DATO
		public NodoLE next;

		public NodoLE(int dato) { //INICIALIZAR UN NODO CON SOLO EL DATO, LA DIRECCION NULL PORQUE SE LA INDICAS DESPUES
			this(dato,null); //INSERTAR EN O INSERTAR FIN
		}

		public NodoLE(int dato, NodoLE next) { //LE VAS A PASAR EL DATO Y ADEMAS LE PASAS LA DIRECCION DE LA CUAL SERA ENLAZADA 
			super(); //INSERTAR INICIO
			this.dato = dato;
			this.next = next;
		}

		public String toString() {//METODO DE IMPLEMENTACION DIRECTA QUE TE PERMITE IMPRIMIR LA LISTA DE MANERA CORRECTA DESDE EL PRINCIPIO
			return this.dato+";"+this.next;
		}

	}
}
