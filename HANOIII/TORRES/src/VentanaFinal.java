import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaFinal extends JFrame{
	
	private HanoiFinal panel;
	
	public VentanaFinal(int numDiscos) {
		super("T O R R E S  D E  H A N O I");
		this.panel=new HanoiFinal(numDiscos);
		this.add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(2000, 1000);
	}
	
	public static void main(String[] args) {
		
		int numDiscos=Integer.parseInt(JOptionPane.showInputDialog("DAME EL NUMERO DE DISCOS"));
		VentanaFinal ventana=new VentanaFinal(numDiscos);
}
}
