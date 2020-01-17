//TE AN 12348
//SE SEPARA EN 1+2+3+4
//TE DA 10 
//SE SEPARA 1+0
//SUMA MAX==1
public class SUMA_MAX {
	public static void main(String[] args) {
		metodo("123",3);
	}

	private static void metodo(String string, int i) {
		String palabra=string;
		for(int x=0;x<i-1;x++) {
			palabra=palabra+string;
		}
		recursivo(palabra);
	}

	private static void recursivo(String palabra) {
		int acumulador=0;

		if(palabra.length()==1) {
			System.out.print(palabra);
		}
		else {

			for(int x=0;x<palabra.length();x++) {
				acumulador=acumulador+ Integer.parseInt((palabra.substring(x,x+1)));		
			}
			recursivo(Integer.toString(acumulador));
		}
	}

}
