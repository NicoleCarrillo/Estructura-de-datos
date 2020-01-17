//AUTOR: NICOLE CARRILLO CAPRISTAN
//NOMBRE DE LA CLASE: BUSQUEDA BINARIA
//FECHA:27/01/2019
//COMENTARIOS: LO IMPRIMI DOS VECES PARA NOTAR EL USO DE GENERICOS 

public class busquedaBinaria {
	public static  <E extends Comparable <E>> int binarySearchRec(E valor, E[] valores){
		int min=0;
		int max= valores.length-1;
		
		return (int) (binarySearchRec(valor, valores,min,max)); //FUNCION DE PREPARACION

	}
	
	private static <E extends Comparable <E>> int binarySearchRec( E valor, E[]valores, int min, int max) {

		int avg;
		
		avg=(min+max)/2;
		
		if(valores[avg].equals(valor)) {//CASO BASE
			return avg;
		}
		
		else if(valor.compareTo(valores[avg])<0) {//RECURSION
			return (binarySearchRec(valor, valores,min,max=avg-1));
		} else {
			return (binarySearchRec(valor, valores,min=avg+1,max));
		}

		}

public static void main(String []args) {
	String[] valores= {"NICOLE","CHEMA","MANCHAS", "SPONCHY"};
	System.out.println(binarySearchRec("CHEMA",valores));
	Integer[] valores2= {100,200,300,400};
	System.out.println(binarySearchRec(100,valores2));
}
}
