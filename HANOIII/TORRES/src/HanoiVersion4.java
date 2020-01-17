import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class HanoiVersion4 extends JPanel{
	
	private static Color DiscoColor;
		
	private int estado;
	
	public int n;
	
	private static final int EMPEZAR=0;
	private static final int REINICIAR=2;
	
	private int[][] tower;
	private int[] towerHeight;
	private int moveDisk;
	private int moveTower;
	
	private JButton empezarButton;  // 2 control buttons for controlling the animation
	private JButton reiniciarButton;
	
	private Panel panel;
	
	private HanoiVersion4() {
	      panel = new Panel();
	      setLayout(new BorderLayout());
	      add(panel, BorderLayout.CENTER);
	        
	      empezarButton = new JButton("Run");
	      empezarButton.addActionListener((ActionListener) this);
	      add(empezarButton,BorderLayout.SOUTH);
	      
	      reiniciarButton = new JButton("Start Over");
	      reiniciarButton.addActionListener((ActionListener) this);
	      add(reiniciarButton,BorderLayout.SOUTH);
	      
	      new Thread().start();
	   }
	
	public void actionPerformed(ActionEvent evt) {
		if(empezarButton==evt.getSource()) {
			System.out.println("hola");
		}
	}
	
	public static void main(String[] args) {
		JFrame ventana=new JFrame("PO FAVO BASTA");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(true);
		ventana.setVisible(true);
		ventana.setSize(1000, 1000);
		ventana.setLocation(600, 600);
	}

}
