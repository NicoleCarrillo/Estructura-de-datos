
public class MaximoComunDivisor {

	public static void main(String[]args) {
		System.out.println(metodo(2,4));
	}

	private static int metodo(int x, int y) {//MAXIMO COMUNN DIVISOR
		if(y==0)
			return x;

		return metodo(y,x%y);

	}

}
