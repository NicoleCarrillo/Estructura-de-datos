import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class HanoiFinal extends JPanel implements Runnable{ //manejo el thread 
	
	private int discos;
	private MyStack torre1;
	private MyStack torre2;
	private MyStack torre3;
	private Thread hilo;
	private int timer;//mide cuanto tiene que durar antes de que sorbepase el numero de nodos que tienes
	private int limite;
	private boolean complete;
	private Color colores[]={Color.BLUE,Color.CYAN,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.YELLOW};
	
	public HanoiFinal(int numDiscos) { 
		super();
		this.discos=numDiscos;//aqui va el backgroud
		this.setBackground(Color.BLACK);
		torre1=new MyStack(400);
		torre2=new MyStack(800);
		torre3=new MyStack(1200);
		this.hilo= new Thread(this);
		this.timer=0;
		this.complete=false;
		this.limite=2*(2*discos-1-1)+1;// cuantas veces puedes repetir la recursividad para que en cuando se termine no vuelva a volver a llamarse 
		
		this.setPreferredSize(new Dimension(1500,800));
		for(int x=0;x<numDiscos;x++) {
			//inicializar los nodos que van a ser los discos
			torre1.push(1); //insertar hasta arriba de la pila 
		}
		

		
		//System.out.println(torre1.toString());
		//System.out.println(torre3.toString());
		//this.move(numDiscos, torre1,torre2,torre3);
		//System.out.println(torre1.toString());
		//System.out.println(torre3.toString());
		
		this.hilo.start();
	}
	
	public Color getColor(int discos){
		System.out.print(Math.random()*8);
		return colores[(int) Math.random()*8];
	}
	
	public void paintComponent(Graphics g) {//aqui dibujo mis torres 
		super.paintComponent(g);
		g.setColor(Color.RED );
		g.drawRoundRect(460, 540, 20, 200, 10, 10);
		g.drawRoundRect(860, 540, 20, 200, 10, 10);
		g.drawRoundRect(1260, 540, 20, 200, 10, 10);
		
		g.setColor(getColor(this.discos));
		torre1.paint(g);
		torre2.paint(g);
		torre3.paint(g);
		
		
	}
	
	public void move(int numDiscos, MyStack torre1,  MyStack torre2,  MyStack torre3 ) {
		
		try {
			Thread.sleep(500);
			this.repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(numDiscos==1) {//caso base
			Nodo current = torre1.getTop();//aqui ya lo movi pero sigue siento una copia
			torre3.push(current);
			torre1.pop();//aqui  ya lo borra
			this.repaint();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			this.repaint();
			move(numDiscos-1,torre1, torre3,torre2);
			Nodo current = torre1.getTop();//aqui ya lo movi pero sigue siento una copia
			torre3.push(current);
			torre1.pop();//aqui  ya lo borra
			this.repaint();
			move(numDiscos-1,torre2, torre1,torre3);
			this.repaint();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(timer<limite) {
		try {
			timer+=1;
			Thread.sleep(500);
			this.move(discos, torre1,torre2,torre3);
			if(torre3.size()==discos) {
				complete=true;
				break;
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
