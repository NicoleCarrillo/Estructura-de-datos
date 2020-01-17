
public class SumaNumBinarios {
	public static void main(String[] args) {
		int arreglo1[]= {1,1,1,0};
		int arreglo2[]= {1,0,1,0};
		metodo(arreglo1,arreglo2);
	}

	private static void metodo(int[] arreglo1, int[] arreglo2) {
		int tamano=1;
		int acarreo=0;
		if(arreglo1.length>arreglo2.length){
			tamano=arreglo1.length;
		}
		else {
			tamano=arreglo2.length;
		}
		int[] arreglo3=new int[tamano+1];

		arreglo3=suma(arreglo1,arreglo2,arreglo3,tamano-1,acarreo);

		for(int x=0;x<arreglo3.length;x++) {
			System.out.print(arreglo3[x]);
		}
	}

	private static int[] suma(int[] arreglo1, int[] arreglo2, int[] arreglo3,int tamano,int acarreo) {

		if(tamano<0)
			return arreglo3;
		else {

			int valor1=arreglo1[tamano];
			int valor2=arreglo2[tamano];

			switch (valor1) {
			case 0:
				if(acarreo==1) {
					arreglo3[tamano+1]=1;
					acarreo=0;
				}else {
				if(valor2==0) 
					arreglo3[tamano+1]=0;
				else if(valor2==1) 
					arreglo3[tamano+1]=0;
				}
				break;

			case 1:
				if(valor2==0) {
					if(acarreo==1) {
						arreglo3[tamano+1]=0;
						acarreo=1;
					}else {
					arreglo3[tamano+1]=1;
					}
				}
				else if(valor2==1) {
					if(acarreo==1&&tamano==0) {
						arreglo3[tamano+1]=1;
						arreglo3[tamano]=1;
						acarreo=0;
					}else {
					arreglo3[tamano+1]=0;
					acarreo=1;
					}
				}
				break;
			}

			if(acarreo==1) {
				if(tamano==0) {
					arreglo3[0]=1;
				}
			}

			return suma(arreglo1,arreglo2,arreglo3,tamano-1,acarreo);
		}


	}
}
