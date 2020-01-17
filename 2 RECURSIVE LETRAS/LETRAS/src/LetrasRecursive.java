
public class LetrasRecursive {

	public static void main(String[] args) {
		String palabra1="abcd";
		String palabra2="wxyz";
		String palabra3="awbxcydz";
		metodo(palabra1,palabra2,palabra3);
	}

	private static void metodo(String palabra1, String palabra2, String palabra3) {
		if(palabra1.length()==0&&palabra2.length()==0&&palabra3.length()==0) {
			System.out.print(true);
		}
		else {
			if(palabra1.length()>0&&palabra1.charAt(0)==palabra3.charAt(0)) {
				metodo(palabra1.substring(1, palabra1.length()),palabra2,palabra3.substring(1, palabra3.length()));
			}
			else if (palabra2.length()>0&&palabra2.charAt(0)==palabra3.charAt(0)) {
				metodo(palabra1,palabra2.substring(1, palabra2.length()),palabra3.substring(1, palabra3.length()));
			}
			else {
				System.out.print(false);
			}
		}


	}
}
