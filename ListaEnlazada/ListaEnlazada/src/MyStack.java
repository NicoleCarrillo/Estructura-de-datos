import java.util.NoSuchElementException;

public class MyStack <E>{ //PILA
	
	private MiListaEnlazada <E> lista;
	
	public MyStack() {
		this.lista=new MiListaEnlazada<>();
	}
	
	public void push(E dato) {
		this.lista.insertarInicio(dato);
		
	}
	
	public E pop() {
		try {
			return this.lista.borrarInicio();
		}catch (IndexOutOfBoundsException ex) {
			throw new NoSuchElementException("No se puede hacer un dequeue en una cola vacia");
	}
	}
	
	public E top() {
		try {
			return this.lista.inicio();
		}catch (IndexOutOfBoundsException ex) {
			throw new NoSuchElementException("No se puede hacer un dequeue en una cola vacia");
	}
	}
	
	public int size() {
		return this.size();
	}
	
	public boolean isEmpty() {
		return this.lista.estaVacia();
	}
	
	public void flush() {
		this.lista.flush();
	}
	
	public static void main(String[] args) {
		MyStack <Integer> pila =new MyStack<>();
		for(int x=0;x<5;x++) {
			pila.push(x);
		}
		
		pila.push(1);
		while(!pila.isEmpty()) {
			System.out.print(pila.pop());
		}
		
	}
}

