
public class On {
	public static void main(String[] args) {
		int[][]matriz=new int[5][5];
		int[][]matriz2=new int[5][5];
		insertarNum(matriz,1,1);
		insertarNum(matriz,2,1);
		insertarNum(matriz,3,1);
		insertarNum(matriz,4,1);
		insertarNum(matriz,5,1);
		imprimeMatriz(matriz);	
		copiarMatriz(matriz,matriz2);
		System.out.println(" ");
		imprimeMatriz(matriz2);
		System.out.println(" ");
		copiarMatriz2(matriz,matriz);
		imprimeMatriz(matriz2);
	}

	private static void copiarMatriz2(int[][] matriz, int[][] matriz2) {
		System.out.println("FILA"+matriz.length);
		for (int fila=0;fila<matriz.length;fila++) {
			int mitad=(matriz.length)/2; //ESTO ES PARA QUE VUELVA A REGRESAR A LA MITAD!!!
			for (int columna=0;columna<=(matriz[fila].length)/2;columna++) {
				matriz2[fila][columna]=matriz[fila][columna];
				matriz2[fila][mitad]=matriz[fila][mitad];
				mitad++;
			}
		}
		
	}

	private static void copiarMatriz(int[][] matriz, int[][] matriz2) {
		for(int x=0;x<matriz.length;x++) {
			for(int y=0;y<matriz[x].length;y++) {
				matriz2[x][y]=matriz[x][y];
			}
		}

	}

	private static void imprimeMatriz(int[][] matriz) {
		for(int x=0;x<matriz.length;x++) {
			for(int y=0;y<matriz[x].length;y++) {
				System.out.print(matriz[x][y]);
			}
			System.out.println(" ");
		}
	}

	private static void insertarNum(int[][] matriz, int num, int x) {
		for(int y=0;y<matriz.length;y++) {
			if(matriz[y][x-1]==0) {
				matriz[y][x-1]=num;
				break;
			}
		}

	}
}
