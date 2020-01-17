//programa que calcula cualquier numero elevado a la algo 
public class Power {
	
	public static void main (String[]args) {
		//System.out.println(metPower(2,8));
		System.out.println(metPower(2,-3));
	}

	private static float metPower(int x, int y) {
		
		if(y==0)
			return 1;
		
		else if(y==1)
			return x;
		
		else if( y<0) 
			return (1/(x*metPower(x,(y*-1)-1)));
		
		else
			return (x*metPower(x,y-1));
	}

}
