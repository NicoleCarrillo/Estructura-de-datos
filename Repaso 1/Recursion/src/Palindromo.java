public class Palindromo {
	
	public static boolean isPalindromo(String palabra) {
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
			 return isPalindromo(palabra.substring(min+1,max));
			}
		}
		
		return caso;
	}


	public static void main(String[]args) {
		System.out.println(isPalindromo("reconocr"));
	}
}
