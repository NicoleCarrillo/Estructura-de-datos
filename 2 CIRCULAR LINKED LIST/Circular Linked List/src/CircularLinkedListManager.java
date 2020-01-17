
public class CircularLinkedListManager {
	CircularNode head;
	CircularNode last;
	
	public CircularLinkedListManager() {
		head=null;
		last=null;
	}
	
	
	public void insertEnd(CircularNode n) {
		if(head==null) {
			head=n;
			last=n;
		}else {
		n.next=head;
		last.next=n;
		last=n;
		}
	}
	
	public void deleteNodeAtBeginning() {
		CircularNode temp=head;
		if(last !=null & head!= null) {
			head=head.next;
			last.next=temp.next;
			temp.next=null;
			temp=null;
			
		}
	}
	
	public void printList() {
		CircularNode temp;
		temp =head;
		while(temp!=last) {
			System.out.println(temp.name);
			temp=temp.next;
		}
		if(temp==last) {
			System.out.println(temp.name);
		}
	}
	
	public static void main(String[] args) {
		CircularNode node=new CircularNode("NICOLE");
		CircularNode node1=new CircularNode("CHEMA1");
		CircularNode node2=new CircularNode("CHEMA2");
		CircularNode node3=new CircularNode("CHEMA3");
		CircularNode node4=new CircularNode("CHEMA4");
		CircularNode node5=new CircularNode("CHEMA5");
		CircularLinkedListManager llMgr = new CircularLinkedListManager();
		llMgr.insertEnd(node);
		llMgr.insertEnd(node1);
		llMgr.insertEnd(node2);
		llMgr.insertEnd(node3);
		llMgr.insertEnd(node4);
		llMgr.insertEnd(node5);
		llMgr.printList();
		System.out.println("---------------------------------");
		llMgr.deleteNodeAtBeginning();
		llMgr.printList();
		
	}
			
}

class CircularNode{
	String name="";
	CircularNode next;
	
	public CircularNode(String name) {
		this.name = name;
	}
}
