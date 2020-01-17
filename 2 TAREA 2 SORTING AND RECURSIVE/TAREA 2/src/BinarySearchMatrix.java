//NICOLE CARRILLO CAPRISTAN A01551581
//JOSE MARIA SANCHEZ HERNANDEZ A01551625
public class BinarySearchMatrix {
	
	//FORMA 1 DE QUE LO HICIMOS
	// MANEJANDO LA MATRIZ COMO UN TODO 
	
	private void bidimensionalBinarySearch2(int [][] arr, int x) {
		int filas=arr.length-1;
		int columnas=arr[0].length-1;
		int min=0;
		boolean caso=false;
		do {
			int avg_filas=(min+filas)/2;
			int avg_columnas=(columnas)/2;
			if(x==arr[avg_filas][avg_columnas]) {
				System.out.print("VALOR ENCONTRADO EN-> "+"fila: "+avg_filas+" "+" columna: "+avg_columnas);
				caso=true;
			}else if(x>arr[avg_filas][avg_columnas]){ //CON ESTE PRIMERO CHECO LA FILA
				for(int i=avg_columnas;i<=columnas;i++) {//CON ESTE PRIMERO CHECO LA COLUMNA, SI ESTA EN ESA COLUMNA O NO 
					if(x==arr[avg_filas][i]) {
						System.out.print("VALOR ENCONTRADO EN-> "+"fila: "+avg_filas+" columna: "+i);
						caso=true;
					}
				}
				min=avg_filas+1;
			}
			else if(x<arr[avg_filas][avg_columnas]){
				for(int i=avg_columnas;i>=0;i--) {
					if(x==arr[avg_filas][i]) {
						System.out.print("VALOR ENCONTRADO EN-> "+"fila: "+avg_filas+" columna: "+i);
						caso=true;
					}
				}
				filas=avg_filas-1;
			}
		}while(caso==false);

	}
	
	//MANEJANDO LA MATRIZ COMO UN CONJUNTO DE ARREGLOS INDEPENDIENTE 
	//ESTE ES MAS STABLE
	
	private void bidimensionalBinarySearch(int [][] arr, int x) {
		int posicion=0;
		do {
			int min=0;
			int max=arr[posicion].length-1;
			int avg=(min+max)/2;
			do {
				avg=(min+max)/2;
				if(arr[posicion][avg]==x) {
					System.out.println("VALOR ENCONTRADO EN->"+ "fila: "+posicion+" columna: "+avg);
					return;
				}else if(x<arr[posicion][avg]) {
					max=avg-1;
				}else {
					min=avg+1;
				}
			}while(min<=max);
			posicion++;
		}while(posicion<arr.length);
		System.out.println("VALOR NO ENCONTRADO");
	}
	
	
	public static void main(String[] args) {
		int x=2;
		int y=6;
		int z=10;
		int [][] arr= {{0,1,2},{2,4,5},{6,7,8},{9,10,11}}; 

		//COMO EL METODO FUE SOLICITADO TAL CUAL SE ESCRIBIO
		//FUE NECESARIO CREAR UN OBJETO PARA PODER INVOCARLO
		BinarySearchMatrix obj=new BinarySearchMatrix();

		obj.bidimensionalBinarySearch2(arr, x);
		System.out.println("");
		System.out.println("metodo 2");
		obj.bidimensionalBinarySearch(arr, x);
		
		System.out.println("valor 2 -----------------------------------");
		
		obj.bidimensionalBinarySearch2(arr, y);
		System.out.println("");
		System.out.println("metodo 2");
		obj.bidimensionalBinarySearch(arr, y);
		
System.out.println("valor 3 -----------------------------------");
		
		obj.bidimensionalBinarySearch2(arr, z);
		System.out.println("");
		System.out.println("metodo 2");
		obj.bidimensionalBinarySearch(arr, z);
	}

}
