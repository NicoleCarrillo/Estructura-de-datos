//NICOLE CARRILLO CAPRISTAN A01551581
//JOSE MARIA SANCHEZ HERNANDEZ A01551625
public class EvenWord {
	
	boolean isEvenWord(String word) {
		String temporal="";
		int contador=0;
		
				
		if(word.length()%2!=0) {
			return false;
		}

		if(word.length()==0) {
			return true;
		}else {
			if(word.length()>0) {
				String letra=word.substring(0, 1);
				temporal=word.replaceAll(letra,"");
				if(temporal.length()%2==0) {
					return isEvenWord(temporal);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		EvenWord obj=new EvenWord();
		System.out.print(obj.isEvenWord("bbaacc"));
		System.out.println("");
		System.out.print(obj.isEvenWord("banana"));
		System.out.println("");
		System.out.print(obj.isEvenWord("tlaquepaque"));
		System.out.println("");
		System.out.print(obj.isEvenWord("a"));
	}
}
