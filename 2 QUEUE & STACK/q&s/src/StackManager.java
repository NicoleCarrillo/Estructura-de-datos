
public class StackManager {
	String []stack;
	private int top;
	
	public StackManager(String[] input) {
		stack = new String[input.length];
		stack=input;
		top=0;
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
	
	public boolean isEmptyStack() {
		return (top==0);
	}
	
	public void printStack() {
		for (int i = 0; i < stack.length; i++) {
			System.out.print(stack[i]+" ");
		}
	}

	
	public static void main(String[] args) throws Exception {
		String[]test= {"","","","",""};
		StackManager stacker=new StackManager(test);
		stacker.push("H");
		stacker.push("A");
		stacker.push("I");
		stacker.push("O");
		stacker.printStack();
		stacker.pop();
		stacker.pop();
		System.out.println(" ");
		stacker.printStack();
		//System.out.println(stacker.peek());
		//System.out.println(stacker.pop()+stacker.pop());
	}
}
