
public class AsteriscosVersion4 {
	public static void main(String []args) {
		Rombo(2);
	}

	private static void Rombo(int i) {
		int num=i;
		if(i==0) {
			return;
		}
		else {
			System.out.println("");
			while(i>0) {
				System.out.print("*");
				i--;
			}
			Rombo(num-1);
			System.out.println("");
			int cont =0;
			while(cont<num) {
				System.out.print("*");
				cont++;
			}
			
		}
	}
}
