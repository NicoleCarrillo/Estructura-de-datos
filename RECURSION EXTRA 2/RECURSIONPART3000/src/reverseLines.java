public class reverseLines {
	public static void main(String[] args) {
		String frase="MI NOMBRE ES NICOLE";
		String reverse="";
		System.out.print(metodo(frase.trim(), reverse));
	}

	private static String metodo(String frase, String reverse) {

		if(frase.length()==0)
			return "";
		else {
			reverse=frase.substring(frase.length()-1,frase.length());
			frase=frase.substring(0,frase.length()-1);
			return reverse+metodo(frase,reverse);
		}
	}
}
