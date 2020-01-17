import java.util.ArrayList;
import java.util.List;

public class VerticePersona {
	String nombre;
	String contra;
	int num_amigos;
	int identificador;
	List<VerticePersona> amigos;
	String[]arreglo; //ARREGLO QUE FUNCIONA COMO STACK     SE AGREGO
	int num_solicitudes; //SE AGREGO
	
	public VerticePersona(String nombre, String contra) {
		this.nombre=nombre;
		this.contra=contra;
		this.identificador=0;
		this.num_amigos=0;
		this.amigos= new ArrayList<VerticePersona>();
		this.arreglo=new String[30]; //SE AGREGO
		this.num_solicitudes=0; //SE AGREGO
	}
}
