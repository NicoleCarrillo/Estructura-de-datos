//PROGRAMA QUE REALIZA UNA MULTIPLICACION POR MEDIO DE SUMAS 
public class MultiPorSuma {
	public static void main(String[]args) {
		System.out.println(metodo(2,16));
	}

	private static int metodo(int x, int y) {
		if(x==y)
			return x+x;
		
		return x+metodo(x,y-1);
	}
}
