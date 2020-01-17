//PROGRAMA QUE CALCULA EL RESULTADO DE LA SECUENCIA 1+(2X3)+(4X5X6)...
public class Secuencia {
	public static void main(String[]args) {
		System.out.println(secuenciaRec(3));
	}

	private static long secuenciaRec(int n) {
		int contador=n; //VARIABLE QUE ME SIRVE PARA AGRUPAR EN SI ES N SOLO QUE CON OTRO NOMBRE 
		int max=0;		//VALOR MAX DE LA SECUENCIA DEPENDIENDO DE LOS NUMEROS 
		int valor=1;	//VARAIBLE PARA GUARDAR EL RESULTADO DE LAS MULTIPLICACIONES 
		
		for(int y=1;y<=n;y++) { //AQUI CALCULO EL NUMERO MAX DE LA SECUENCIA 
			for(int x=1;x<=y;x++) {
				max++;
			}
		}
		
		return secuenciaRec(valor,contador,max);
	}

	private static long secuenciaRec(int valor,int contador,int max) {
		
		if(contador==1) //O SEA SI YA SOLO QUEDA 1 GRUPO (1)
			return 1;
		
		valor=max*(max-1); //ESTE CASO APLICA PARA LOS PRIMEROS (2X3)   (5X6) 
		max=max-2;			//COMO YA SE HIZO LA MULTIPLICACION ENTONCES MAX YA VALE 4, 6-2=4
		
		if(max!=1) { //SI NO ES 1 ENCONCES QUE HAGA MAS MULTIPLICACIONES DE LO CONTRARIO YA SERIA EL CASO BASE 
		for(int x=0;x<contador-2;x++) { //CONTADOR -2 PORQUE YA MULTIPLIQUE 2 NUM ENTONCES 
			valor=valor*max;
			max=max-1;
		}
		}
		
		return valor+secuenciaRec(valor,contador-1,max);
	}
}
