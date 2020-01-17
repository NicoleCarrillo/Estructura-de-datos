//NICOLE CARRILLO CAPRISTAN A01551581
//JOSE MARIA SANCHEZ HERNANDEZ A01551625
public class Hanoi {
	public static void main(String[] args) {
		System.out.println("CON 3 DISCOS");
		int n=3;
		Hanoi(n,1,2,3);  //1:origen  2:auxiliar 3:destino

		System.out.println("CON 4 DISCOS");
		n=4;
		Hanoi(n,1,2,3);
	}

	public static void Hanoi(int n, int origen,  int auxiliar, int destino){
		if(n==1)
			System.out.println("mover disco  1 de " + "torre:"+origen + " a " + "torre"+destino);
		else{
			Hanoi(n-1, origen, destino, auxiliar);
			System.out.println("mover disco "+n+" de "+ "torre:"+origen + " a " + "torre:"+destino);
			Hanoi(n-1, auxiliar, origen, destino);
		}
	}
}
