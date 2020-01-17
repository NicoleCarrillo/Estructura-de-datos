//NICOLE CARRILLO
//JOSE MARIA SANCHEZ 

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FacebookN {
	
	static GrafoFacebook g = new GrafoFacebook();

	public static boolean logIn() {
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 30));
		
		String nombre=JOptionPane.showInputDialog("INTRODUCE TU NOMBRE DE USUARIO");
		String contra=JOptionPane.showInputDialog("INTRODUCE TU CONTRASENA");
		if(g.buscar(nombre,contra)) {
			return true;
		}else {	
			return false;
		}
	}

	public static void menu() { //MENU QUE DIRIGE TODO
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 30));
		String nl = System.getProperty("line.separator");
		
		int opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "SELECCIONA UNA DE LAS SIGUIENTES OPCIONES"+nl+
				"INTRODUCE 1 PARA AGREGAR PERFIL"+nl+
				"INTRODUCE 2 PARA AGREGAR AMIGO"+nl+
				"INTRODUCE 3 PARA EDITAR PERFIL"+nl+
				"INTRODUCE 4 PARA BUSCAR PERFIL"+nl+
				"INTRODUCE 5 PARA IMPRIMIR SUS AMIGOS"+nl+
				"INTRODUCE 6 PARA VER TODO EL GRAFO"+nl+
				"INTRODUCE 0 PARA SALIR","FACEBOOK",JOptionPane.INFORMATION_MESSAGE));
		
		switch (opcion) {
		case 1:
			g.addPerfil("eduardo","123");
			g.addPerfil("jose","123");
			menu();
			break;
		case 2:
			g.addAmigos("nicole","chema");
			g.addAmigos("nicole", "eduardo");
			g.addAmigos("chema", "eduardo");
			g.addAmigos("eduardo", "jose");
			menu();
			break;
		case 3:
			g.editarPerfil("eduardo", "123", "234");
			menu();
			break;
		case 4:
			System.out.println(g.buscar("joe", "123"));
			menu();
			break;
		case 5:
			g.imprimirAmigosVertice("nicole");
			menu();
			break;
		case 6:
			g.imprimirTotalAmigos();
			menu();
			break;
		case 0:
			JOptionPane.showMessageDialog(null, "SALIDA EXITOSA","FACEBOOK",JOptionPane.INFORMATION_MESSAGE);
			break;

		default:
			JOptionPane.showMessageDialog(null, "OPCION NO VALIDA","ERROR",JOptionPane.ERROR_MESSAGE);
			break;
		}

	}


	public static void main(String[] args) {

		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 30));
		String nl = System.getProperty("line.separator");	
		
		//CUENTAS MAESTRAS - ADMINISTRATIVAS
		//ESTAS CUENTAS TIENEN ACCESO A TODOS LOS VERTICES
		g.addPerfilMaestro(new VerticePersona("nicole","manchas"));
		g.addPerfilMaestro(new VerticePersona("chema","159"));
		
		//PRIMER PASO ES HACER LOG IN PARA PODER ACCEDER EL MENU Y LA RESTO DEL PROGRAMA
		boolean entrada=logIn();
		if(entrada) {
			menu();
		}else {
			int opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "NO HAY NINGUN PERFIL CON ESE NOMBRE O CONTRASENA"+nl+
												"INTRODUCE 1 PARA VOLVER INTENTARLO"+nl+
												"INTRODUCE 0 PARA SALIR","FACEBOOK",JOptionPane.INFORMATION_MESSAGE));
			if(opcion==1) {
				logIn();
			}else {
				JOptionPane.showMessageDialog(null, "SALIDA EXITOSA","FACEBOOK",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
}
