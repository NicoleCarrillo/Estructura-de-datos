
public class ORDENAR {

	public static void Orden(int []datos){
		
		int min=0;
		int posicion=0;
		for(int j=0;j<datos.length;j++) {
			min=datos[j];
			for(int i=j;i<datos.length;i++) {
				if(datos[i]<min) {
					min=datos[i];
					posicion=i;
			}
		}
			if(min!=datos[j]) {
			int tmp;
			tmp=datos[j];
			datos[j]=min;
			datos[posicion]=tmp;
			}
	}
	}

	public static void main (String []args) {
		int datos[]= {9,5,8,6,1};
		Orden(datos);
		for(int x=0;x<datos.length;x++) {
			System.out.print(datos[x]);
		}
	}

}
