
public class I2 {

	public static <E extends Comparable<E>>void Ordena(E[]datos){
		int y;
		E min=null;
		int max=0;//CONTROL PARA EL NUMERO DE VECES QUE SE VA A SER EL DO 
		int posicion=0;
		
		do {
			E primero=datos[posicion];
			int x=posicion+1;
			while(x<=datos.length-1) {//RECORRO TODAS LAS POSICIONES Y GUARDO EL MAS PEQUE DE TODOS
			if(datos[x].compareTo(primero)<0)
				min=datos[x];
			else
				min=primero;
			x++;
		}
		
		for(y=0;y<=datos.length-1;y++) {//BUSCAR EN QUE POSICION SE ENCUENTRA EL VALOR PEQUE 
			if(datos[y].equals(min)) {
				break;
			}
		}
		
		if(datos[posicion]!=min) { //DATOS EN LA POSICION MIN 0 ES DIFERENTE DE MIN ENTONCES HAGO EL CAMBIO
		E temp;
		temp=datos[y];
		datos[y]=datos[posicion];
		datos[posicion]=temp;
		}
		posicion++;
		

		max++;
		}while(max<datos.length-1);
		}

	public static void main (String []args) {
		Integer datos[]= {4,3,2,5};
		Ordena(datos);
		for(int x=0;x<datos.length;x++) {
			System.out.print(datos[x]);
		}
	}

}

