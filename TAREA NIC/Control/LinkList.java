//NICOLE CARRILLO
//CLASE LISTA ENLAZADA
public class LinkList {
	Node fin;
	Node inicio;

	public LinkList() {
		fin=null;
		inicio=null;
	}

	public LinkList(String [] arreglo) {
		for(int x=0;x<arreglo.length;x++) {
			insertarFin(arreglo[x]);
		}
	}

	public void insertarFin(String palabra) {
		Node nuevo=new Node(palabra);
		Node current=inicio;

		if(inicio==null) {
			inicio=nuevo;
			fin=nuevo;
		}else {
			while(current.next!=null) {
				current=current.next;
			}
			current.next=nuevo;
			fin=nuevo;
			fin.prev=current;
		}
	}

	public void printList() {
		Node tmp=inicio;
		while (tmp!=null) {
			System.out.print(tmp.palabra+" ");
			tmp=tmp.next;
		}
	}
}
