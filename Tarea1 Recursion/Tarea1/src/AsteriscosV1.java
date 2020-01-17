//PROGRAMA QUE IMPRIME ASTERISCOS AL DERECHO Y AL REVES DEL GRANDE AL PEQUENO, ENTRADA ES EL NUM MAX DE ASTERISCOS
import javax.swing.JOptionPane;

public class AsteriscosV1 {

	public static void dibujo(int num) {
		mayor_menor( num);
		menor_mayor(0,num);
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
	
	public static void main(String[]agrs) {
		int num=Integer.parseInt(JOptionPane.showInputDialog("INTRODUCE UN NUMERO ENTERO"));
		dibujo(num);
		
	}

}
