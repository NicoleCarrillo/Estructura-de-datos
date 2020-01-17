
public class SumaMax2 {
public static void main(String[]args) {
	System.out.print(metodo(110));
}
private static int metodo(int num) {
	int x=num/10;
	int y=num%10;
	if(x==0) {
		return y;
	}
	return y+metodo(x);
}
}
