import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hanoi extends JPanel implements Runnable{

	private int torres[][],						// the three towers' disks as stack
				top[],							//top of the three stacks
				from,
				to,								//moving 'from' tower number 'to' tower number
				disco,							//number of disk moved (1 to n)
				n,
				largo,
				ancho,
				alturaT;
	private Thread hilo;
	private Point punto;
	
	//private Color colors[]={Color.BLUE,Color.CYAN,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.YELLOW};
	private Color color;
	
	public Hanoi(){
		this.setPreferredSize(new Dimension(1000,600));
		this.setLayout(new BorderLayout());
		
		try {
			setN(Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de discos")));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Introduce un numero");
		}
		//torres=new int[3][this.n];
		//top=new int[3];
		this.largo=1000/4;
		this.ancho=600-50;
		this.alturaT=this.ancho-this.n*12;
		this.color=Color.RED;
		this.punto=new Point(0,0);
		this.hilo=new Thread();
		this.hilo.start();
		new Thread(this).start();
	}

	public void push(int to, int diskno){
	//putting disk on tower
		torres[to-1][++top[to-1]]=diskno;
	}

	public int pop(int from){
	//take topmost disk from tower
		return(torres[from-1][top[from-1]--]);
	}

	/*public Color getColor(int disknum){
		return colors[disknum%8];
	}*/

	public void pinta(Graphics g){
		int cont;
		//g.clearRect(0,0,getWidth(),getHeight());
		for(int j=1;j<=3;j++){
			//draw tower
			g.setColor(Color.GRAY);
			g.fillRoundRect(j*this.largo,this.alturaT,5,this.ancho-this.alturaT,1,1);

			//draw all disks on tower
			for(int i=0;i<=top[j-1];i++){
				cont=torres[j-1][i];
				this.punto.setLocation(j*this.largo-15-cont*5,this.ancho-(i+1)*14 );
				System.out.println(cont);
				g.setColor(this.color);
				g.fillRect(this.punto.x,this.punto.y,35+cont*10,10);
 
			}
		}
	}

	public void drawFrame(Graphics g,int x,int y){
		try{
			pinta(g);
			this.punto.setLocation(x, y);
			g.setColor(this.color);
			g.fillRect(this.punto.x-15-disco*5,this.punto.y-14,35+disco*10,10);
			Thread.sleep(60);
		}catch(InterruptedException e){
			System.out.println(e);
		}
	}

	public void desplazamiento(){
	//to show the movement of disk
		Point temp= new Point();
		int delta,sign;
		this.disco=pop(this.from);
		temp.x=from*largo;
		temp.y=ancho-(top[from-1]+1)*14;
		//taking disk upward from the tower
		for(int i=temp.y;i>alturaT-20;i-=8)
			drawFrame(getGraphics(), temp.x, temp.y);

		temp.y=this.alturaT-20;
		delta=this.to*this.largo-temp.x;
		sign=delta/Math.abs(delta);
		//moving disk towards a target tower
		do {
			drawFrame(getGraphics(), temp.x, temp.y);
			temp.x+=sign*12;
		}while(Math.abs(temp.x-to*largo)>=24);
		temp.x=to*largo;
		
		//placing disk on a target tower
		for(int i=temp.y;i<this.ancho-(this.top[this.to-1]+1)*10;i+=8)
			drawFrame(getGraphics(), temp.x, temp.y);
		push(to,disco);
		pinta(getGraphics());
	}

	public void mover(Graphics g, int n, int a, int b, int c) throws InterruptedException{
	//Move top n disk from tower 'a' to tower 'c'
	//tower 'b' used for swapping
		if(n>=1){
			mover(g,n-1,a,c,b);
			pinta(g);
			//Thread.sleep(50);
			from=a;
			to=c;
			//animating the move
			desplazamiento();
			mover(g,n-1,b,a,c);
		}
	}
	
	public void setN(int n) throws InputMismatchException{
		if(n<3) 
			JOptionPane.showMessageDialog(null,"Introduce un numero igual o mayor a 3");
		else {
			this.n = n;
			this.torres=new int[3][n];
			this.top=new int[3];
		}
	}
	
	public int getN() {
		return this.n;
	}
	
	public void setTop(int i, int valor) {
		this.top[i]=valor;
	}

	@Override
	public void run() {
		try {
			desplazamiento();
			this.repaint();
			Thread.sleep(200);
		}catch(InterruptedException a) {
			System.out.println(a);
		}
	}

}
