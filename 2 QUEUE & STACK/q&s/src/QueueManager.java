//ES COMO UNA COLA

public class QueueManager {
	int [] queue =new int[10];
	private int front;
	private  int rear;

	public QueueManager(int [] input) {
		this.queue=input;
		front=0;
		rear=0;
	}
	//AGREGANDO ALGO A LA PILA
	public void enqueue(int n) throws Exception{
		if(rear<queue.length) {
			queue[rear]=n;	
			rear++; 
		}
		else {
			throw new Exception("OUT OF CAPACITY");
		}
	}
	
	//ELIMINANDO ALGO DE LA PILA
	public int dequeue() {
		if(rear<queue.length&&front<=rear) {
			int result=queue[front];
			if(rear==front) {
				rear=0;
				front=0;
			}
			front++;
			return result ;
		}
		else {
			return -1;
		}
	}
	
	public int peak() {
		return queue[front];
	}
	

	public void printQueue() {
		for (int i = 0; i < queue.length; i++) {
			System.out.print(queue[i]+" ");
		}
	}

	public static void main(String[] args) throws Exception{
		int test[]= {0,0,0,0,0,0};
		QueueManager qTest=new QueueManager(test);
		qTest.enqueue(3);
		qTest.enqueue(5);
		qTest.enqueue(8);
		qTest.enqueue(8);
		qTest.printQueue();
		//System.out.println("");
		//System.out.print("LOS PRIMEROS 3 son"+ qTest.dequeue()+qTest.dequeue()+qTest.dequeue());
		System.out.println("");
		//System.out.print(qTest.peak());
		qTest.dequeue();
		qTest.dequeue();
		qTest.printQueue();

	}
}
