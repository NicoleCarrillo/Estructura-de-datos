//NICOLE CARRILLO
public class LinkedListManager {
	Node head;

	public void addNode(Node n) {
		if(head==null) {//THE LIST IS BRAND NEW
			head=n;
			head.next=null;
		}else { //I ALREADY HAVE A LIST WITH AT LEAST ONE NODE
			Node tmp=head;
			while(tmp.next != null) {//SEARCHING FOR THE LAST NODE
				tmp=tmp.next;
			}
			tmp.next= n;//I FOUND IT AND I NEED TO ADD IT TO THE END
			tmp= tmp.next;//MOVE THE TMP TO THE LAST NODE
			tmp.next=null;//NEXT OF LAST ONE SHOULD BE NULL
		}
	}

	public void loop(Node head) { //METODO PARA CREAR UN LOOP Y PROBAR EL METODO HAS LOOP
		Node tmp=head;
	
		while(tmp.next != null) {
			tmp=tmp.next;
		}
		tmp.next=head;
	}

	public void deleteFirst() throws Exception{
		if(head==null) {
			throw new Exception ("LISTA VACIA");
		}
		Node tmp=head;
		head=head.next;
		tmp.next=null;
		tmp=null;
	}

	public void updateNode(int ID, String author, String title) {
		Node temp=head;
		while(temp.ID!=ID) {
			temp=temp.next;
		}
		temp.authorName=author;
		temp.title=title;
	}

	public void insertNode(int index, Node n) throws Exception{
		if(head==null) {
			throw new Exception("LISTA VACIA");
		}
		if(index==1) {
			Node nuevo=n;
			nuevo.next=head;
			head=nuevo;

		}else {
			Node temp=head;
			for(int x=1;x<index-1;x++) {
				temp=temp.next;
			}
			Node nuevo=n;
			nuevo.next=temp.next;
			temp.next=nuevo;
		}
	}

	public void deleteNode(int ID) throws Exception {
		if(head==null) {
			throw new Exception ("LISTA VACIA"); //CHECO SI ESTA VACIA 
		}
		Node delete=head;
		Node temp=head;
		boolean caso=false;
		if(temp.ID==ID) { //CHECO SI ES EL PRIMERO
			deleteFirst();
		}
		else {
		while(temp.next!=null) {
			if(temp.next.ID==ID) {
				if(temp.next.next==null) { //CHECO SI ES EL ULTIMO
					delete=temp.next;
					temp.next=null;
					caso=true;
					delete=null;
					break;
				}else {
					delete=temp.next;
					temp.next=temp.next.next;
					caso=true;
					delete.next=null;
					delete=null;
					break;
				}
			}else {
				temp=temp.next;
			}
		}
		if(caso==false) {
			throw new Exception ("INDICE NO EXISTE");
		}
		}

	}
	
	public void deleter(int ID) {
		Node temp=head;
		while(temp!=null) {
			if(temp.next.ID==ID) {
				temp.next=temp.next.next;
				break;
			}
			temp=temp.next;
		}
	}

	public boolean hasLoop(Node head) {
		Node tmp=head;
		Node pointer=head;
		if(head.next!=null) {
			tmp=head.next;
		}
		if(head.next==head){
			return true;
		}

		else {
			while(tmp.next!=null||tmp.next!=pointer) {
				do {
					if(tmp.next==pointer) {
						return true;
					}else {
						pointer=pointer.next;
					}
				}while(tmp!=pointer);
				pointer=head;
				tmp=tmp.next;
				if(tmp.next==null) {
					return false;
				}
			}
		}
		return true;
	}

	public void printList() {
		Node tmp=head;
		while (tmp!=null) {
			System.out.println(tmp.title);
			tmp=tmp.next;
		}
	}
	

	public static void main(String[] args) throws Exception{
		Node test1=new Node("victor hugo","les miserables", 1);
		Node test2=new Node("jane austend","crime and punishment", 2);
		Node test3=new Node("j.k.rowling","Harry potter", 3);
		Node test4=new Node("rick riordan","Los dioses del olimpo", 4);

		LinkedListManager llMgr = new LinkedListManager();
		llMgr.addNode(test1);
		llMgr.addNode(test2);
		llMgr.addNode(test3);

		//llMgr.printList();
		//llMgr.deleteFirst();
		//System.out.println("-------------------------------------------");
		llMgr.printList();
		System.out.println("-------------------------------------------");


		//System.out.println("-------------------------------------------");

		//PRUEBAS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		//llMgr.insertNode(2, test4);
		//llMgr.insertNode(4, test4);
		//llMgr.insertNode(1, test4);
		//llMgr.printList();
		//System.out.println("-------------------------------------------");

		//llMgr.updateNode(4,"NICOLE","LA AMANTE DE LOS BRILLOS");
		//llMgr.updateNode(1,"NICOLE","LA AMANTE DE LOS BRILLOS");
		//llMgr.printList();
		//System.out.println("-------------------------------------------");

//		llMgr.deleteNode(4);
//		llMgr.deleteNode(1);
//		llMgr.deleteNode(2);
//		llMgr.deleteNode(20);
		llMgr.printList();
		System.out.println("-------------------------------------------");
		
		llMgr.deleter(4);
		
		llMgr.printList();
		System.out.println("-------------------------------------------");
		
		//llMgr.loop(test1);
		//System.out.print(llMgr.hasLoop(test1));
	}
}

class Node{
	String authorName;
	String title;
	int ID;
	Node next;

	public Node(String author,String title, int ID) {
		this.authorName=author;
		this.title=title;
		this.ID=ID;
	}
}
