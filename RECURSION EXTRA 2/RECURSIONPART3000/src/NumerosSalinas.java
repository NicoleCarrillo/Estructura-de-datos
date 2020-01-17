
public class NumerosSalinas {
public static void main(String[] args) {
	metodo(5);
}

private static void metodo(int num) {
	if(num==0) {
		System.out.print(num);
	}
	else {
		System.out.print(num);
		metodo(num-1);
		System.out.print(num);
	}
}
}
