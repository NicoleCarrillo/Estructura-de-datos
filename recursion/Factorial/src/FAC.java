
public class FAC {
	
	public static void main(String[]args) {
		System.out.println(fact(4));
	}

	private static int fact(int i) {
		
		if(i==1) {
			return i;
		}
		
		return i*fact(i-1) ;
		
	}

}
