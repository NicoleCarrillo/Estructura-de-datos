//PROGRAMA QUE DADO UN NUMERO 100 CUETE CUANTAS SOLUCIONES POSIBLES HAY PARA QUE X^2+Y^2....TE DE 100
//POR EJEMPLO 13 Y 2
//SOLO HAY UNA FORMA QUE TE DE ESTO
//2^2+3^2
//POR LO TANTO LA SALIDA ES 1
public class PowerSum {
	
	public static void main(String[] args) {

		System.out.print(powerSum(100,2));
	}
	
	static int powerSum(int num, int potencia) {
		// Complete this function
		return calc(num,potencia,1);
	}



	static int calc(int num, int potencia, int acumulador) {
		int numToN= (int) Math.pow(acumulador,potencia);
		if (numToN > num) {
			return 0;
		} else if (numToN == num) {
			System.out.println(numToN+" "+num+" "+"YEYYY");
			return 1;
		} else {
			return (calc(num,potencia,acumulador+1) + calc(num-numToN,potencia,acumulador+1));
		}

	}
}

