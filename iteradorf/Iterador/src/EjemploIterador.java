import java.util.Iterator;

//public class EjemploIterador<E> implements Iterable<E>  CASO GENERICOS 
public class EjemploIterador implements Iterable<Integer>{
	
	private Integer [] valores;
	private int size;
	

	public EjemploIterador(Integer[] valores) {
		this.valores=valores;
		this.size=valores.length;
	}

	public Iterator<Integer> iterator() { //CLASE ANONIMA
		
		return new Iterator<Integer>() {
			private int pos=0;
			private boolean callRemove=false; //CONTROL PARA QUE SOLO SE PUEDA MANDAR A LLAMAR SOLO DESPUES DE UN NEXT 

			public boolean hasNext() {
				return pos<size;
			}

			public Integer next() {
				this.callRemove=true;
				return valores[pos++];
			}
			
			public void remove() {
		
				if(this.callRemove) {
					for(int x=pos;x<size;x++) {
					valores[x-1]=valores[x];
					}
					valores[size-1]=null;
					size--;
					pos--;
				}
				this.callRemove=false;	
			}
			
		};
	}
	
	public static void main(String []args) {
		Integer[]numeros= {1,2,3,4,5,6,7,8,9,10};
		EjemploIterador ei=new EjemploIterador(numeros);
		//FOR EACH
		for(int valor:ei) {
			System.out.println(valor);
		}
		System.out.println("****************");

		//FORMA ANTIGUA
		Iterator<Integer> it=ei.iterator();
		int num;
		while(it.hasNext()) {
			num=it.next();
			if(num==4) {
				it.remove();
			}
			System.out.println(num);
		}
		
		System.out.println("****************");
		
		for(int valor:ei) {
			System.out.println(valor);
		}
		System.out.println("****************");
		
		
	}

}
