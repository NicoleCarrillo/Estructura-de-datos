
public class Comparacion2Arreglos {
public static void main(String[] args) {
	int a1[]= {1,2,3};
	int a2[]= {1,2,3};
	System.out.print(metodo(a1,a2,a1.length-1));
}

private static boolean metodo(int[] a1, int[] a2, int i) {
	if(i==0) {
	return true;
	}
	else {
		if(a1[i]==a2[i]) {
			i=i-1;
			return metodo(a1,a2,i);
		}
		return false;
	}
}
}
