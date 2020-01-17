import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame /*implements Runnable*/{
	
	//Atributos
	private Hanoi panel;
	private Thread hilo;

	public Ventana() {
		super("T O R R E S  D E  H A N O I");
		this.panel=new Hanoi();
		this.hilo=new Thread();
		this.hilo.start();
		//Menu menu=new Menu(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//panel.setMenu(menu);
		this.add(panel);
		//this.add(menu,BorderLayout.NORTH);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public static void main(String[] args) {
		Ventana ventana=new Ventana();
		for(int i=0;i<3;i++)
			ventana.panel.setTop(i,-1);
		
		for(int i=ventana.panel.getN();i>0;i--)
		{
			ventana.panel.push(1,i);
		}
		
		try{
			ventana.panel.mover(ventana.panel.getGraphics(),ventana.panel.getN(),1,2,3);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/*
	@Override
	public void run() {
		try {
			this.panel.mover(this.panel.getGraphics(),this.panel.getN(),1,2,3);
			this.panel.repaint();
			Thread.sleep(50);
		}catch(InterruptedException a){
			System.out.println(a);
		}
	}*/

}
