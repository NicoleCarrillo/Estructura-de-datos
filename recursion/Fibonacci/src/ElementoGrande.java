//EN ESTE PROGRAMA BUSCO EL ELEMENTO MAS GRANDE DE UN ARREGLO Y LO REGRESO 
//
//
public class ElementoGrande {
	
	
	public static void main(String[] args) {
		int arreglo[]= {5,8,2,10,9,4};
		System.out.println(grande(arreglo, 0, arreglo.length-1));
	}

	private static int grande(int[] arreglo, int menor, int mayor) {
		int max; //aqui guardo el valor max
		
		if(menor==mayor) { //SOLO HAY UN ELEMENTO EN EL ARREGLO
			return arreglo[menor]; //REGRESO ESE VALOR 
		}
		else {
			max=grande(arreglo,menor+1,mayor); //LLAMADA RECURSIVA 
			if(arreglo[menor]>=max) {
				return arreglo[menor];
			}
			else
				return max;
		}
	}
		
}
