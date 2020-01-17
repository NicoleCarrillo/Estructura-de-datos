import java.util.NoSuchElementException;

public class MyQueue<E> {
	MiListaEnlazada<E> lista;
	
	public MyQueue() {
		this.lista = new MiListaEnlazada<>();
	}
	
	public void enqueue(E dato) {
		this.lista.insertarFin(dato);
	}
	
	public E dequeue() {
		try {
			return this.lista.borrarFin();
		}catch(IndexOutOfBoundsException ex) {
			throw new NoSuchElementException("No se puede hacer un dequeue en una cola vacia");
		}
	}
	
	public E next() {
		try {
			return this.lista.inicio();
		}catch(IndexOutOfBoundsException ex) {
			throw new NoSuchElementException("No se puede obtener el siguiente elemento a salir de una cola vacia");
		}
	}
	
	public int size() {
		return this.lista.size();
	}
	
	public boolean isEmpty() {
		return this.lista.estaVacia();
	}
	
	public void flush() {
		this.lista.flush();
	}
	
	public static void main(String[] args) {
		MyQueue<String> cola = new MyQueue<>();
		cola.enqueue("Hola");
		cola.enqueue("Si");
		cola.enqueue("No");
		cola.enqueue("Adios");
		cola.enqueue("Rojo");
		cola.enqueue("Azul");
		
		while(!cola.isEmpty()) {
			System.out.println(cola.dequeue());
		}
	}
}