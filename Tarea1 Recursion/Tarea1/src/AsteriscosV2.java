//PROGRAMA QUE IMPRIME ASTERISCOS AL DERECHO Y AL REVES DEL PEQUENO AL GRANDE, ENTRADA ES EL NUM MAX DE ASTERISCOS
import javax.swing.JOptionPane;

public class AsteriscosV2 {

	public static void dibujo(int num) {
		menor_mayor(0,num);
		mayor_menor( num);
		}

	public static void mayor_menor(int num){
		if(num>0){
		for(int x=0;x<num;x++) {
			System.out.print("*");
		}
		System.out.println(" ");
		mayor_menor(num-1);
	}
	}
	
	public static void menor_mayor(int cont,int num){
		if(num!=cont){
			for(int x=cont;x>=0;x--) {
				System.out.print("*");
			}
			System.out.println(" ");
			menor_mayor(cont+1,num);
		}
		}
	
	
	//VERSION CHUCHO
	public static void prueba(int num, int tope)
	{
		if(tope==0)
			return;
		
		if(tope>num) {
			for(int x=0;x<(((num*2)-tope)+1);x++)
				System.out.print("*");
		}
		else {
			for(int x=tope;x>0;x--)
				System.out.print("*");
		}
		System.out.println(" ");
		prueba(num,tope-1);
	}
	
	public static void main(String[]agrs) {
		//int num=Integer.parseInt(JOptionPane.showInputDialog("INTRODUCE UN NUMERO ENTERO"));
		//dibujo(num);
		prueba(5,10);
		
	}

}