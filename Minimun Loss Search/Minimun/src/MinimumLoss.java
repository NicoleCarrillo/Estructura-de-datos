
public class MinimumLoss {
	public static void main(String[] args) {
		int arreglo[]= {20,15,8,2,12};
		metodo(arreglo,arreglo.length);

	}

	private static void metodo(int[] arreglo, int i) {
		int minimo=1000;
		for(int x=0;x<i;x++) {
			for (int y=x+1;y<i;y++) {
				if(arreglo[x]>arreglo[y]) {
					if(arreglo[x]-arreglo[y]<minimo) {
						minimo=arreglo[x]-arreglo[y];
					}
				}
			}

		}
		System.out.print(minimo);
	}
}
