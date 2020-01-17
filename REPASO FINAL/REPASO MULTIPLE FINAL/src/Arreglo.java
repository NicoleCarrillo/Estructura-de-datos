//you are given an n x n 2D matrix representing an image.
//Rotate the image by 90 degrees (clockwise).

public class Arreglo {
	public static void main(String[] args) {
		int [][] arreglo= {{1,2,3},{4,5,6},{7,8,9}};
		print(arreglo);
		rotacion(arreglo);
		System.out.println("////////////////////////////");
		print(arreglo);
	}

	private static void rotacion(int[][] arreglo) {
		int a=arreglo[0][0];
		int b=arreglo[0][1];
		int temporal=0;
		int x=0;
		int y=1;
		int contador=0;
		while(contador<arreglo.length-1) {
			
			if(y<arreglo.length) { //v0
				while(y<arreglo.length-1) {
				arreglo[x][y]=a;
				a=b;
				temporal=b;
				b=arreglo[x][y+1];
				arreglo[x][y+1]=temporal;
				y++;
				}
			}
			
			if(y==arreglo.length-1) { //v1
				while(x<arreglo.length-1) {
				arreglo[x][y]=a;
				a=b;
				temporal=b;
				b=arreglo[x+1][y];
				arreglo[x+1][y]=temporal;
				x=x+1;
				}
			}
			
			if(x==arreglo.length-1) { //v2
				while(y>0) {
					arreglo[x][y]=a;
					a=b;
					temporal=b;
					b=arreglo[x][y-1];
					arreglo[x][y-1]=temporal;
					y=y-1;
				}
			}
			
			if(y==0) { //v3
				while(x>0) {
					arreglo[x][y]=a;
					a=b;
					temporal=b;
					b=arreglo[x-1][y];
					arreglo[x-1][y]=temporal;
					x=x-1;
				}
			}
			y++;
			contador++;
		}

	}

	private static void print(int[][] arreglo) {
		for(int x=0;x<arreglo.length;x++) {
			for(int y=0;y<arreglo.length;y++) {
				System.out.print(arreglo[x][y]+" , ");
			}
			System.out.println("");
		}
		
	}
}
