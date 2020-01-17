
public class Nodo {
	String letra;
	Nodo next;
	
	public Nodo() {
		letra="";
		next=null;
	}
	
	public Nodo(String letra, Nodo next) {
		this.letra=letra;
		this.next=next;
	}
	
	public String toString() {
		return letra.toString();
	}
}
