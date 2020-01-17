
public class Javier {
		
		public static boolean isPalindromo(String palabra) { //METODO PARA REVISAR QUE SEA PALINDORMO UNA PALABRA O NO
			int max=palabra.length()-1;
			int min=0;
			boolean caso=true;
			
			if(max<=0) { //CONTROL PARA QUE MAXIMO NO SEA -1
				return caso;
			}

			char letra1=palabra.charAt(min);
			char letra2=palabra.charAt(max);

			if(letra1!=letra2) {
				caso=false;		
			}

			if(caso==true) {
				if(max>=1) {
				 return isPalindromo(palabra.substring(min+1,max)); //LLAMADA RECURSIVA 
				}
			}
			
			return caso; //EN CASO QUE MAX NO LLEGUE A -1 PERO YA COUMPLIO TODAS LAS CONDICIONES QUE YA REGRESE EL CASO
		}


		public static void main(String[]args) {
			boolean caso=true;
			int contador=0;
			String palabra="ja";
			
			caso=isPalindromo(palabra); //RECIBE EL RESULTADO DEL METODO RECURSIVO
			
			if(caso==true) {//SI SI ES PALINDORMO VERIFICA QUE NO SEAN LETRAS IGUALES
				for(int x=0;x<palabra.length()-1;x++) {
					char letra1=palabra.charAt(x);
					char letra2=palabra.charAt(x+1);
					if(letra1==letra2) {
						contador=contador+1;
					}
				}
				if(contador==palabra.length()-1) { //SI SON LETRAS IGUALES REGRESA 0
					System.out.println("0");
				}else
				System.out.println(palabra.length()-1); //SI SON LETRAS DIFERENTES PERO ES PALINDROMO SOLO QUITALE UNA LETRA 
			}else
				System.out.println(palabra.length()); //SI NO ES PALINDROMO REGRESA EL TAMANO DE LA PALABRA NORMAL
		}
}
