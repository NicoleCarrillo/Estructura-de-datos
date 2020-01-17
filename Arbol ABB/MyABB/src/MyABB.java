import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue; 
//RECORRER UNA ESTRUCTURA ES VISITAR TODOS LOS ELEMENTOS QUE SE ENCUENTRAN EN UNA ESTRUCUTRA DE MANERA PARTICULAR, ES DECIR PASAR SOLO UNA VEZ CADA DATO 
public class MyABB <E extends Comparable <E>>{

	private int size;
	private NodoABB<E> root;

	public MyABB() {
		this.root=null;
		this.size=0;
	}

	public void insert(E dato) {
		NodoABB <E> nuevo=new NodoABB<>(dato);
		NodoABB <E> current=this.root;
		NodoABB <E> padre=null;
		
		if(this.root!=null) {
		while(current!= null) {
			padre=current;
			current=dato.compareTo(current.dato)<0?current.left:current.right;
		}
		//PADRE ES VAYA A PAPA DE CURRENT
		if(dato.compareTo(padre.dato)<0){
			padre.left=nuevo;
		}
		else {
			padre.right=nuevo;
		}
		}
		else {
			this.root=nuevo;
		}
		
		this.size++;
	}
	
	public E borrar(E dato) {
		NodoABB<E> current=this.root,
		 		prev = null;
		 boolean lado;//lado es true entonces está a la izq sino a la derecha
		while(!current.dato.equals(dato)) {
			prev=current;
			current=dato.compareTo(current.dato)<0?current.left:current.right;
		}
		//Aqui current está en el nodo a borrar y prev en el padre del nodo a borrar
		
		//Saber si el nodo está a la izq o derecha de su padre
		lado=prev.left==current;
		//Caso en el que el nodo a borrar es una hoja
		if(current.left==null && current.right==null) {
			if(lado) {
				prev.left=null;
			} else {
				prev.right=null;
			}
		//Caso que solo tiene hijo derecho	
		} else if(current.left==null) {
			if (lado) {
				prev.left=current.right;
			} else {
				prev.right=current.right;
			}
		//Caso que solo tiene un hijo izquierdo	
		} else if(current.right==null) {
			if (lado) {
				prev.left=current.left;
			} else {
				prev.right=current.left;
			}
			//Caso que tiene dos hijos
		} else {
			NodoABB<E> predecesor=null;
			predecesor=predecesor(current);
			current.dato=predecesor.dato;
		}
		
		return current.dato;
	}
	
	public E buscar(E dato) throws NoSuchElementException{
		NodoABB<E> current=this.root;
		while(current!=null) {
			if(current.dato.equals(dato)) {
				return current.dato;
			}
			else if( dato.compareTo(current.dato)<0) {
				current=current.left;
			}
			else {
				current=current.right;
			}
 		}
		throw new NoSuchElementException("EL ELEMENTO "+dato+"NO ESTA EN EL ARBOL");
	}
	
	private NodoABB<E> predecesor(NodoABB<E> current){
		current=current.left;
		while(current.right!=null) {
			current=current.right;
		}
		return current;
	}

	public static void main(String[] args) {
		
		MyABB<Integer> arbol= new MyABB<>();
		arbol.insert(21);
		arbol.insert(13);
		arbol.insert(33);
		arbol.insert(10);
		arbol.insert(28);
		arbol.insert(25);
		arbol.insert(40);
		arbol.insert(29);
		arbol.insert(27);
		arbol.insert(30);
		arbol.borrar(30);
		arbol.preorden();
		arbol.posorden();
		arbol.inorden();
		arbol.ordenTransversal();
		System.out.println("listo");
		System.out.println(arbol.buscar(13));
		
	}
	
	public void preorden() {//RECORRER EL ARREGLO ARBOL DE FORMA DE PREORDEN 
		preorden(this.root);
		System.out.println("");
	}
	
	private void preorden(NodoABB<E> current) { //FUNCION DE PREPARACION DEL PREORDEN
		if(current!=null) {
		System.out.print(current.dato+" ,");
		preorden(current.left);
		preorden(current.right);
	}
	}
	
	public void inorden() {
		inorden(this.root);
		System.out.println();
	}
	
	private void inorden(NodoABB<E> current) {
		if(current!=null) {
			inorden(current.left);
			System.out.print(current.dato+" ,");
			inorden(current.right);
		}
		
	}
	
	public void posorden() {
		posorden(this.root);
		System.out.println();
	}
	
	private void posorden(NodoABB<E> current) {
		if(current!=null) {
			posorden(current.left);
			posorden(current.right);
			System.out.print(current.dato+" ,");
		}
		
	}
	
	public void ordenTransversal() {
		ordenTransversal(this.root);
		System.out.println();
	}
	
	
	//CLASE PROGRAMACION 
	private void ordenTransversal(NodoABB<E> current) {
		Queue<NodoABB<E>> q = new LinkedList<>(); 
		q.add(current);
		NodoABB<E> nodoActual;
	
		while(!q.isEmpty()) {
			nodoActual=q.poll();
			System.out.print(nodoActual+", ");
			if(nodoActual.left!=null) {
				q.add(nodoActual.left);
			}
			if(nodoActual.right!=null) {
				q.add(nodoActual.right);
			}
		}	
	}
	
	

	class NodoABB<E>{
		E dato;
		NodoABB<E> right;
		NodoABB<E> left;

		public NodoABB( E dato, NodoABB<E> right, NodoABB<E>left) {
			super();
			this.dato=dato;
			this.right=right;
			this.left=left;
		}

		public NodoABB(E dato) {
			this(dato,null,null);
		}
		
		public String toString() {
			return this.dato.toString();
		}
	}
}
