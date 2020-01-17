public class ListaStack2{
Node head;
String []stack=new String[10];
int top=0;

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
	
	public void push(String s) throws Exception{
		if(stack[0]!=null&&top<stack.length) {
			top++;
			stack[top]=s;
		}
		else if(stack[0]==null) {
			stack[top]=s;
		}
		else throw new Exception("STACK OVERFLOW");
	}
	
	public String pop() {
		String result=null;
		if(top<stack.length) {
			result=stack[top];
			top--;
		}
		return result;
	}
	
	public String peek() {
		return stack[top];
		
	}

	public void printBack() throws Exception{
		Node current=head;
		while(current!=null) {
			push(current.Name);
			current=current.next;
		}
		while(top>=0) {
			System.out.println(peek());
			pop();
		}
	}

	public static void main(String[] args) throws Exception{
		Node test1=new Node("FRANK");
		Node test2=new Node("JOSE");
		Node test3=new Node("CHEMA");
		Node test4=new Node("NICOLE");

		ListaStack2 llMgr = new ListaStack2();
		llMgr.addNode(test1);
		llMgr.addNode(test2);
		llMgr.addNode(test3);
		llMgr.addNode(test4);
		llMgr.printBack();
	}
}

class Node{
	String Name;
	Node next;

	public Node(String name) {
		this.Name=name;
	}
}

