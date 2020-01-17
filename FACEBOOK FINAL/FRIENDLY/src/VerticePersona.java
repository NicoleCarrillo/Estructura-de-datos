//NICOLE CARRILLO
//JOSE MARIA SANCHEZ 

import java.util.ArrayList;
import java.util.List;

public class VerticePersona {
	String nombre;
	String contra;
	int num_amigos;
	int identificador;
	List<VerticePersona> amigos;
	String []arreglo;
	int num_solicitudes;
	
	public VerticePersona(String nombre, String contra) {
		this.nombre=nombre;
		this.contra=contra;
		this.identificador=0;
		this.num_amigos=0;
		this.amigos= new ArrayList<VerticePersona>();
		this.arreglo=new String[30];
		this.num_solicitudes=0;
		
	}
	public String toString() {
		return this.nombre;
		
	}
}
