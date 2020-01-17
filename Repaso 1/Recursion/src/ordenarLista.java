
public class ordenarLista<E extends Comparable<E>> extends Lista<E>{

	public void insert (E dato) {
		if(size==0)
			insertarInicio(dato);
		if(size==1){
			insertarFin(dato);
		}
		E dato1;
		E dato2;
		
		Nodo<E> current=this.inicio;
		dato1=current.dato;
		
		for(int x=0;x<size;x++) {
			current=current.next;
		}
			
			Nodo<E> nuevo=new Nodo <>(dato);
			for(int x=0;x<size;x++) {
				current=current.next;
				dato2=current.dato;
				if(dato1.compareTo(dato2)>0){
					current=this.inicio;
					nuevo=this.fin;
				}
				
			}
		}
	
	
	
	public static void main(String []args) {
		ordenarLista <Integer> lista2= new ordenarLista<>();
		lista2.insert(4);
		lista2.insert(3);
		lista2.insert(1);
		System.out.print(lista2);
}
}
