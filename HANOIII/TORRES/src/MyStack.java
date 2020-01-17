import java.awt.Graphics;
import java.util.NoSuchElementException;

public class MyStack <E>{ //PILA
	//aqui hacemos que se dibuje cada torre

	public MiListaEnlazada <E> lista;
	
	private int x;//posicion
	private int xOriginal;
	
	int y;//torres
	int largo;
	
	
	public void paint(Graphics g) { //este metodo dibuja los discos se basa en cuantos nodos hay 
		x=xOriginal;
		y=700;
		largo=150;
		for(int i=0; i<this.size();i++) {
			g.fillRect(this.x, this.y, this.largo, 20);
			largo-=10;
			y-=25;
			x+=5;
		}
		
		x=xOriginal;
		y=700;
		largo=150;
	
	}
	
	public MyStack(int x) {
		this.lista=new MiListaEnlazada<>();
		this.x=x;
		this.xOriginal=x;
		y=700;
		largo=150;
	}
	
	public void push(E dato) {
		this.lista.insertarInicio(dato);
		
	}
	
	public Nodo getTop() {
		return this.lista.getInicio();
		
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
		return this.lista.size();
	}
	
	public boolean isEmpty() {
		return this.lista.estaVacia();
	}
	
	public void flush() {
		this.lista.flush();
	}
}

