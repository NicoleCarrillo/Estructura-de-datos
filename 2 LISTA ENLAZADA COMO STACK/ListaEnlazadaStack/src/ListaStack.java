
public class ListaStack {
	public nodoStack stackTop; //GIVES THE REFERENCE TO THE NODE THAT IS THE TOP ELEMENT 
	//ES COMO UN TAMANO Y APUNTA AL ULTIMO AGREGADO 

	public ListaStack() {
		stackTop=null;
	}

	public boolean isEmptyStack() {
		return (stackTop==null);
	}

	public boolean isFullStack() { //LISTA ENLADA ES DINAMICA POR LO TANTO NUNCA ESTARA LLENA
		return false;
	}

	public void push(String nombre) { //EN LUGAR DE ADD NODE
		nodoStack nuevo=new nodoStack(nombre,stackTop);
		stackTop=nuevo;
	}

	public String peek() {
		if(stackTop==null) {
			System.out.println("NO HAY NINGUN ELEMENTO EN LA LISTA");
		}
		return stackTop.info;
	}

	public String pop() { //EN LUGAR DE DELETE
		if(stackTop==null) {
			System.out.println("NO HAY NINGUN ELEMENTO EN LA LISTA");
		}
		String info=stackTop.info;
		stackTop=stackTop.next;
		return info;
	}
	
	public void PrintList() {
		nodoStack current=stackTop;
		while(current!=null) {
			System.out.println(current.info+" ");
			current=current.next;
		}
	}


	public static void main(String[] args) {
		
		ListaStack LS=new ListaStack();
		LS.push("NICOLE");
		LS.push("CHEMA");
		LS.push("DIEGO");
		LS.pop();
		//System.out.println(LS.peek());
		//System.out.println(LS.pop());
		//System.out.println(LS.peek());
		LS.PrintList();
	}

}


class nodoStack{ //SIMPLEMEMTE LA CLASE NODO COMO DE CUALQUIER LISTA ENLAZADA 
	String info;
	nodoStack next;

	public nodoStack() {
		this.info=null;
		this.next=null;
	}

	public nodoStack(String nombre,nodoStack next) {
		this.info=nombre;
		this.next=next;
	}

	public String toString() {
		return this.info.toString();
	}
}
