
public class InsertionSort {

	public static <E extends Comparable<E>>void Ordena(E[]datos){
		
		int n = datos.length;  //TAMANO DEL ARREGLO
        for (int i=1; i<n; ++i)  //RECORRER COMO TAL EL ARREGLO
        { 
            E key = datos[i];  //PUNTO DE COMPARACION
            int j = i-1;  //CONTROL
   
            while (j>=0 && datos[j].compareTo(key)>0) 
            { 
                datos[j+1] = datos[j]; 
                j = j-1; 
            } 
            datos[j+1] = key; 
        } 
		}

	public static void main (String []args) {
		Integer datos[]= {9,5,8,6,1};
		Ordena(datos);
		for(int x=0;x<datos.length;x++) {
			System.out.print(datos[x]);
		}
	}

}
