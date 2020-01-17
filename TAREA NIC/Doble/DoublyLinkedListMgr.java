//NICOLE CARRILLO
//CLASE PRINCIPAL
public class DoublyLinkedListMgr {

	Node head;

	//ADDING A NODE TO THE END OF THE LIST
	//THIS IS MAKING THE LIST BEHAVE AS A QUEUE

	public void addNodeAtEnd(Node n) {
		//CHECK IF HEAD IS NULL
		if(head==null) {
			head=n;
			head.prev=null;
			head.next=null;
		}
		//COMES HERE IF THERE IS AT LEAST ONE NODE IN THE LIST
		else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			//CONNECT THE NODE N TO THE END OF THE LIST
			temp.next=n;
			n.prev=temp;
			n.next=null;
		}
	}

	public void deleteNodeAtFront() {
		//THIS WILL CONTINUE TO BEHAVE AS A QUEUE
		if(head!=null) {
			head=head.next;
			head.prev=null;
		}
	}

	public Node getFront() {
		if(head!=null) {
			return head;
		}else {
			return null;
		}
	}

	public void insertNode(Node nuevo,int index) {
		Node current=head;
		int contador=0;

		if(index==0) {
			nuevo.next=head;
			head.prev=nuevo;
			nuevo.prev=null;
			head=nuevo;
		}
		else {
			while(contador!=index) {
				contador++;
				current=current.next;
			}
			nuevo.next=current;
			nuevo.prev=current.prev;
			nuevo.prev.next=nuevo;
			current.prev=nuevo;
		}
	}

	public void removeNode(int index) {
		Node current=head;
		Node borrar=head; //NODO PARA PODER DESCONECTARLO AL 100 Y NO TENER MEMORY LEAK 
		int contador=0;

		if(index==0) {
			deleteNodeAtFront();
		}else {
			while(contador!=index-1) {
				contador++;
				current=current.next;
				borrar=borrar.next;
			}
			borrar=borrar.next;
			if(current.next.next==null) {
				current.next=current.next.next;
			}
			else {
				current.next=current.next.next;
				current.next.next.prev=current;
			}
			borrar.next=null;
			borrar.prev=null;
		}
	}
	
	public String findNode(int ID) {
		Node current=head;
		while(current.ID!=ID) {
			current=current.next;
			if(current==null) {
				return "NO EXISTE ESTE VALOR:"+ID;
			}
		}

		return current.name;
	}

	public void printList() {
		Node temp=head;
		int x=0;
		while(temp!=null) {
			System.out.println(x+" "+temp.name);
			temp=temp.next;
			x++;
		}
	}


	public static void main(String[] args) {
		int MAX_NODES =5;
		DoublyLinkedListMgr mgr= new DoublyLinkedListMgr();
		Node temp=null;

		for(int x=0;x<MAX_NODES;x++) {
			temp=new Node("NODE"+x,x);
			mgr.addNodeAtEnd(temp);
		}

		mgr.printList();
		System.out.println("----------------------------------------------------------");

		Node nuevo1=new Node("NUEVO",10000);
		mgr.insertNode(nuevo1,0);
		mgr.printList();
		System.out.println("----------------------------------------------------------");
		Node nuevo2=new Node("NUEVO2",2000);
		mgr.insertNode(nuevo2,5);
		mgr.printList();
		System.out.println("----------------------------------------------------------");
		Node nuevo3=new Node("NUEVO3",3000);
		mgr.insertNode(nuevo3,6);
		mgr.printList();
		System.out.println("----------------------------------------------------------");

		Node nuevo4=new Node("NUEVO4",3000);
		mgr.addNodeAtEnd(nuevo4);
		mgr.printList();
		System.out.println("----------------------------------------------------------");

		mgr.removeNode(5);
		mgr.printList();
		System.out.println("----------------------------------------------------------");
		mgr.removeNode(0);
		mgr.printList();
		System.out.println("----------------------------------------------------------");
		mgr.removeNode(6);
		mgr.printList();
		System.out.println("----------------------------------------------------------");
		
		System.out.println(mgr.findNode(0));
		System.out.println(mgr.findNode(4));
		System.out.println(mgr.findNode(3000));
		System.out.println(mgr.findNode(7000));

	}

}


