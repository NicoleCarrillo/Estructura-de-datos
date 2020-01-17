
public class LinkedListQueue {
	Nodo front;
	Nodo rear;
	
	public LinkedListQueue() {
		front=null;
		rear=null;
	}
	
	public Nodo front() {
		return front;
	}
	
	public Nodo rear() {
		return rear;
	}
	
	public void addQueue(String letra) {
		Nodo nuevo=new Nodo(letra,null);
		if(front==null) {
			front=nuevo;
			rear=nuevo;
		}else {
			nuevo.next=rear;
			rear=nuevo;
		}
	}
	
	public void deleteQueue() {
		Nodo current=rear;
		while(current.next!=front) {
			current=current.next;
		}
		current.next=null;
		front=current;
	}
	
	public void print() {
		Nodo current= rear;
		while(current!=null) {
			System.out.print(current+" ");
			current=current.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListQueue QL = new LinkedListQueue();
		QL.addQueue("a");
		QL.addQueue("b");
		QL.addQueue("c");
		QL.print();
		System.out.println("  ");
		QL.deleteQueue();
		QL.deleteQueue();
		QL.print();
	}
}


