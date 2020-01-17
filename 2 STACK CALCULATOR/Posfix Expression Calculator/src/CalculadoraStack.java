
public class CalculadoraStack {
	String stack[];
	int top;

	public CalculadoraStack() {
		stack=new String[20];
		top=0;
	}


	public boolean evaluarOperador(String elemento) {
		
		if(elemento.equals("+")||elemento.equals("-")||elemento.equals("*")||elemento.equals("/")||elemento.equals("=")) {
			return true;
		}
		else {
			return false;
		}
	}

	public int Operacion(String operador,int elem1, int elem2) {
		switch (operador) {
		case "+":
			return (elem1+elem2);

		case "-":
			return (elem1-elem2);

		case "*":
			return (elem1*elem2);

		case "/":
			return (elem1/elem2);
		}
		return -1;
	}

	public void push(String s)throws Exception {
		if(stack[0]!=null&&top<stack.length) {
			top++;
			stack[top]=s;
		}
		else if(stack[0]==null) {
			stack[top]=s;
		}
		else throw new Exception("STACK OVERFLOW");
	}


	public String peek() {
		return stack[top];
	}

	public String pop() {
		String result=null;
		if(top<stack.length) {
			result=stack[top];
			stack[top]=null;
			top--;
		}
		return result;
	}

	public void printResult() {
		System.out.println(pop());
	}

	public static void main(String[] args) throws Exception{
		String cadena="34 87 + 2 * =";
		CalculadoraStack calcu=new CalculadoraStack();
		String[]arreglo=cadena.split(" ");
		int x=0;
		boolean caso=true;
			
		while(caso==true) {
			while(calcu.evaluarOperador(arreglo[x])==false) {
				calcu.push(arreglo[x]);
				x++;
			}
		
			int elemento1=Integer.parseInt(calcu.pop());
			int elemento2=Integer.parseInt(calcu.pop());
			String operacion=Integer.toString(calcu.Operacion(arreglo[x],elemento1,elemento2));
			calcu.top++;
			calcu.push(operacion);
			x++;
			
			if(arreglo[x].equals("=")) {
				caso=false;
			}
		}
		calcu.printResult();
	}
}
