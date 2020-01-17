
public class InvertirNumRango {
	
	public static void main(String[]args) {
		int arreglo[]= {1,2,3,4,5,6,7,8,9};
		metodo(arreglo,2,5,0,0);
	}

	private static void metodo(int[] arreglo,int RangoInicio, int RangoFin, int posicion,int controlador) {
		if(controlador<arreglo.length) {
						
			if(posicion<RangoInicio||posicion>RangoFin) {
				System.out.print(arreglo[controlador]);
				metodo(arreglo, RangoInicio, RangoFin, posicion+1,controlador+1);
			}
			
			else {
				System.out.print(arreglo[RangoFin]);
				metodo(arreglo, RangoInicio, RangoFin-1, posicion,controlador+1);
			}
		}
	}

}
