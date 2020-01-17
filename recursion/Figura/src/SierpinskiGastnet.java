import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

public class SierpinskiGastnet extends JFrame{ //BASICAMENT EESTOY DIBUJNADO LINEAS QUE JUNTAS FORMAN TRIANGULOS 
	
	//DECLARANDO LOS PUNTOS Y EL NIVEL DE PROFUNDIDAD
	private Point a,b,c;
	private int nivel;
	
	public SierpinskiGastnet () {
		super("fractal");
		setSize(640,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		a=new Point(320,50);//ASIGNANDO LOS VALORES INICIALES DE LOS PUNTOS
		b=new Point(20,380);
		c=new Point(620,380);
		nivel=8;
	}
	
	public Point puntoMedio(Point a, Point b) {
		int xM=(a.x+b.x)/2;
		int yM=(a.y+b.y)/2;
		
		return new Point(xM,yM);//NECESITO CREAR UN NUEVO PUNTO QUE VA A SER LA MITAD
		
	}
	
	public void paint(Graphics g) { //METODO PARA QUE PUEDA REALIZAR CUALQUIER DIBUJO
		super.paint(g);
		pintaTriangulos(nivel,a,b,c,g); //LE TENGO QUE MANDAR EL G SI NO NO PINTA NADA 
	} //PINTA TRINAGULO ES EL METODO RECURSIVO 
	
	public void pintaLinea(Graphics g,Point a, Point b) { //DIBUJANDO LAS LINEAS QUE VAN A FORMAR EVENTUALMENTE LOS TRIANGULOS 
		g.drawLine(a.x, a.y, b.x, b.y);
	}
	
	public void pintaTriangulos(int nivel, Point a, Point b, Point c, Graphics g) {
		
		if(nivel==0) { //SOLO DIBUJO UN TRIANGULO
			pintaLinea(g,a,b); //PINTA LA LINEA DEL PUNTO A LA PUNTO B
			pintaLinea(g,b,c); //PINTA LA LINEA DEL PUNTO B LA PUNTO C
			pintaLinea(g,c,a); //PINTA LA LINEA DEL PUNTO C LA PUNTO A
		}
		else {
			Point pmAB= puntoMedio(a,b), //SINO ENTONCES CALCULO EL PUNTO MEDIO DE CADA LINEA
				  pmBC= puntoMedio(b,c),
				  pmCA= puntoMedio(c,a);
			
			pintaTriangulos(nivel-1,a,pmAB,pmCA,g); //SOLO DIVIDE EL AREA EN MUCHOS BEBES
			pintaTriangulos(nivel-1,pmAB,b,pmBC,g);
			pintaTriangulos(nivel-1,pmCA,pmBC,c,g);
						  
			
		}
		
	}
	
	public static void main(String[]args) {
		SierpinskiGastnet fractal=new SierpinskiGastnet();
	}
}
	
	