
public class SumaEntero {
	public static void main(String[]args) {
		System.out.println(metodo(110));
	}

	private static int metodo(int x) {
		int numero=x;
		if(x<10) {
			return x;
		}else {
			numero=x%10;
			return numero+metodo(x/10);
		}	
	}
}
