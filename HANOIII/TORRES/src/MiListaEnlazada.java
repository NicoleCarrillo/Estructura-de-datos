import java.util.NoSuchElementException;
//Escrito por Diego y Jose Sanchez Micalco, A01635164 & A01635093, 27/02/2019 para la clase de Estructura de Datos
public class MiListaEnlazada<E> {

	private Nodo<E> inicio;

	private Nodo<E> fin;

	private int size;

	public MiListaEnlazada() {
		this.inicio = this.fin = null;
		this.size = 0;
	}

	public String toString() {
		String list = "";
		if(size==0) {
			list="";
		}
		else {
		Nodo<E> current = this.inicio;
		for (int i = 0; i < size; i++) {
			list += ", " + current.getDato();
			current = current.getNext();

		}
		}

		return list;
	}

	public MiListaEnlazada(E[] datos) {

		for (int i = datos.length - 1; i >= 0; i--) {
			this.insertarInicio(datos[i]);
		}

	}

	public Nodo getNodo(int pos) {

		if (pos >= 0 && pos < this.size) {
			Nodo<E> current = inicio;
			for (int i = 0; i < pos; i++) {

				current = current.getNext();

			}
			return current;
		} else {
			return null;
		}
	}

	public E borrarInicio() {
//	try {
//		Nodo<E> n = new Nodo<>(null);
//	this.inicio = inicio.getNext()!= null? inicio.getNext() : n ;
//	this.size--;
//	
//	if(size==0) {
//		this.fin = null;
//	
//	}
//	
//
//		
//	}catch(NoSuchElementException e) {
//		throw new IndexOutOfBoundsException("No se puede borrar el inicio de una lista vacia");
//	}
//}

		try {

			E dato = inicio.getDato();
			this.inicio = inicio.getNext();

			this.size--;
			if (size == 0) {
				this.fin = null;

			}
			return dato;
		} catch (NoSuchElementException e) {
			throw new IndexOutOfBoundsException("No se puede borrar el inicio de una lista vacia");
		}
	}

	public void borrarFin() {
		if (size > 1) {
			E dato = fin.getDato();
			Nodo<E> current = inicio;
			for (int i = 0; i < this.size - 2; i++) {
				current = current.getNext();
			}

			current.setNext(null);
			this.size--;

		} else {
			try {

			} catch (NoSuchElementException e) {
				throw new IndexOutOfBoundsException("No se puede borrar al final de una lista vacia");
			}
		}
	}

	public void flush() {
		this.inicio = this.fin = null;
		this.size = 0;
		System.gc();
	}

	public E getEn(int pos) {

		if (pos >= 0 && pos < this.size) {
			Nodo<E> current = inicio;
			for (int i = 0; i < pos; i++) {

				current = current.getNext();

			}

			return current.getDato();
		} else {
			throw new IndexOutOfBoundsException("No se puede regresar el elemento de la posicion " + pos);
		}
	}

	public void setEn(E dato, int pos) {
		if (pos >= 0 && pos < this.size) {
			Nodo<E> current = inicio;
			for (int i = 0; i < pos; i++) {

				current = current.getNext();

			}

			current.setDato(dato);
		} else {
			throw new IndexOutOfBoundsException("No se puede regresar el elemento de la posicion " + pos);
		}
	}

///////////////////////////////////////////////////////////////////
//_______________________

	public E borrarEn(int pos) {
		this.size--;
		E dato = null;
		Nodo<E> current = this.inicio;

		for (int i = 0; i <= pos; i++) {

			if (i == pos - 1) {

				current.setNext(current.getNext().getNext());

			}

			if (i == pos) {

				dato = current.getDato();

			}
			current = current.getNext();
		}

		return dato;
	}

/////////////////////////////////////////////////////////////////
//**********************
	public void insertarEn(E dato, int pos) {
		if (pos < 0 || pos > size) {
			throw new IndexOutOfBoundsException();
		}
		try {
			this.size++;

			Nodo<E> nodo = inicio;
			Nodo<E> nvo = new Nodo<>(dato);
			Nodo<E> nodoAtras = null;
			if (pos == 0) {
				nvo.setNext(inicio);
				inicio = nvo;
			} else {
				for (int i = 0; i <= pos; i++) {
					if (i == pos - 1) {
						nodoAtras = nodo;
					}

					if (i == pos) {

						nvo.setNext(nodoAtras.getNext());
						nodoAtras.setNext(nvo);

					}

					nodo = nodo.getNext();
				}

			}
		} catch (NullPointerException er) {

			System.out.print("");

		}

	}

//*********************
///////////////////////////////////////////////////////////

	public E inicio() {
		try {
			return this.inicio.getDato();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("La lista esta vacia");
		}
	}

	public E fin() {
		try {
			return this.fin.getDato();
		} catch (NullPointerException e) {
			throw new NoSuchElementException("La lista esta vacia");

		}
	}

	public boolean estaVacia() {
		return this.size == 0;

	}

	public int size() {
		return this.size;
	}

	public void insertarInicio(E dato) {

		Nodo<E> nodo = new Nodo<>(dato, this.inicio);
		this.inicio = nodo;

		if (size == 0) {
			this.fin = nodo;
		}
		size++;

	}

	public void insertarFin(E dato) {
		if (this.size == 0) {
			this.insertarInicio(dato);
		}
		Nodo<E> nodo = new Nodo<>(dato);
		this.fin.setNext(nodo);
		this.fin = nodo;
		size++;
	}

	public Nodo getFin() {
		return this.fin;
	}

	public Nodo getInicio() {
		return this.inicio;
	}

}

class Nodo<E> {
	private E dato;
	private Nodo<E> next;

	public Nodo(E dato) {
		this(dato, null);
	}

	public Nodo(E dato, Nodo<E> next) {
		super();
		this.dato = dato;
		this.next = next;
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
}