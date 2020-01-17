
public class recur {
	public static void main(String[] args) {
		int n=2;
		int num=factorial(n);
		String palabra="reconocer";
		boolean caso;
		System.out.print(caso=palindromo(palabra));
		System.out.println("");
		System.out.print(power(3,4));
		System.out.println("");
		binary(-10);
	}

	private static int factorial(int n) {
		if(n==0)
			return 1;
		else 
			return n*factorial(n-1);
	}
	
	private static void printStar(int n) {
		if(n==0)
			System.out.print("*");
		else
			System.out.print("*");
			printStar(n-1);
		
	}
	
	private static boolean palindromo(String palabra) {
		int max=palabra.length()-1;
		int min=0;
		boolean caso=true;

		char letra1=palabra.charAt(min);
		char letra2=palabra.charAt(max);

		if(letra1!=letra2) {
			caso=false;		
		}

		if(caso==true) {
			if(max>=1) {
			 return palindromo(palabra.substring(min+1,max));
			}
		}
		
		return caso;
	}
	
	private static int power(int base,int exp) {
		if(base==1) {
			return 1;
		}
		if(exp==0) {
			return 1;
		}
		
		if(exp==1) {
			return base;
		}
		else{
			return base*(power(base,exp-1));
		}
		
	}
	
	private static void binary(int num) {
		int bin=num%2;
		if(num<0) {
			System.out.print("-");
			 num=num*-1;
		}
		if(num<2) {
			System.out.print(bin); 
		}else {
		binary(num/2);
		System.out.print(bin);
		}
	}
}
