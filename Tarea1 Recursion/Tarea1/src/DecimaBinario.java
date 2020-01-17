
public class DecimaBinario {
	
	public static void main(String[] args) {
		binario(20);
	}

	private static void binario(int n) {
		
		if(n<2) {
			System.out.print(n);
			return; //esto realmente no se necesita pero ayuda a entender, pero si lo quitas es lo mismo 
		}
		else {
			binario(n/2);
			System.out.print(n%2);
		}
	}

}
