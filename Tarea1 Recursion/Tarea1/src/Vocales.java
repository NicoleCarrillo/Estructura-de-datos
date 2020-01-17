
public class Vocales {
		
	public static void main(String[]args) {
		System.out.println(numV("hola"));
	}

	public static int numV(String palabra) {
		int total=0;
		int indice=palabra.length();
		char vocal;
	
		if(indice==0) {
			return total;
		}
		
		vocal=palabra.charAt(indice-1);
		
		if(vocal==('a')||vocal==('e')||vocal==('i')||vocal==('o')||vocal==('u')){
			total++;
		}
		indice--;
		return total+numV(palabra.substring(0,indice)); //AQUI OCURRE LA MAGIA
				
			}
		}