//CLASE PRINCIPAL
public class Stack {
	LinkList stackZ; //STACK DONDE SE GUARDA TODA LA ORACION 
	LinkList stackY;//STACK DONDE SE GUARDA LO QUE SAQUEMOS CON CONTROL Z

	public Stack(String[]arreglo) {
		stackZ=new LinkList(arreglo);
		stackY=new LinkList();
	}

	public void controlZ() throws Exception{
		if(stackZ.inicio==null) {
			throw new Exception("YA NO HAY NADA QUE BORRAR");
		}
		else if(stackZ.inicio.next==null) {
			String bloque=stackZ.inicio.palabra;
			stackZ.inicio=null;
			stackY.insertarFin(bloque);
		}else {
			String bloque=stackZ.fin.palabra;
			stackZ.fin=stackZ.fin.prev;
			stackZ.fin.next=null;
			stackY.insertarFin(bloque);
		}
	}

	public void controlY() throws Exception{
		if(stackY.inicio==null) {
			throw new Exception("YA NO HAY NADA QUE RECUPERAR");
		}else {
			String palabra=stackY.fin.palabra;
			Node current=stackY.fin;

			if(stackY.inicio.next==null) {
				stackY.fin=null;
				stackY.inicio=null;
			}else {
				stackY.fin=current.prev;
				stackY.fin.next=null;
				current=null;
			}
			stackZ.insertarFin(palabra);
		}
	}

	public static void main(String[] args) throws Exception{

		String palabra="HOLA COMO ESTAS";
		String arreglo[]=palabra.split(" ");

		Stack controlador=new Stack(arreglo);

		controlador.stackZ.printList();
		System.out.println(" ");
		System.out.println("--------------------------------");

		controlador.controlZ();
		controlador.stackZ.printList();
		System.out.println(" ");
		System.out.println("--------------------------------");

		controlador.controlZ();
		controlador.stackZ.printList();
		System.out.println(" ");
		System.out.println("--------------------------------");

		controlador.controlZ();
		controlador.stackZ.printList();
		System.out.println(" ");
		System.out.println("--------------------------------");

		//		controlador.controlZ();    PRUEBA PARA QUE TRUENE
		//		controlador.stackZ.printList();
		//		System.out.println(" ");
		//		System.out.println("--------------------------------");

		controlador.controlY();
		controlador.stackZ.printList();
		System.out.println(" ");
		System.out.println("--------------------------------");

		controlador.controlY();
		controlador.stackZ.printList();
		System.out.println(" ");
		System.out.println("--------------------------------");

		controlador.controlY();
		controlador.stackZ.printList();
		System.out.println(" ");
		System.out.println("--------------------------------");

		//		controlador.controlY();   PRUEBA PARA QUE TRUENE 
		//		controlador.stackZ.printList();
		//		System.out.println(" ");
		//		System.out.println("--------------------------------");

	}
}
