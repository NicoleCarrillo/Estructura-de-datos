import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.util.ArrayList;

public class GrafoFacebook {

	List<VerticePersona> myGraph;  //HACIENDO UNA ARREGLO DE LISTAS DE VERTICES
	int total_vertices=0;
	String nl = System.getProperty("line.separator");

	public GrafoFacebook() {
		myGraph = new ArrayList<VerticePersona>();
	}

	public void addPerfilMaestro(VerticePersona v) {
		myGraph.add(v);
		v.identificador=total_vertices;
		this.total_vertices++;
	}

	public VerticePersona addPerfil(String nombre, String contra) {
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 30));

		if(buscar(nombre,contra)) {
			JOptionPane.showMessageDialog(null, "NO HAY NINGUN PERFIL CON ESE NOMBRE Y CONTRASENA","ERROR",JOptionPane.ERROR_MESSAGE);
			return null;
		}else {
			VerticePersona v = new VerticePersona(nombre,contra);
			myGraph.add(v);
			v.identificador=total_vertices;
			this.total_vertices++;
			JOptionPane.showMessageDialog(null, "PERFIL CREADO","FACEBOOK",JOptionPane.INFORMATION_MESSAGE);
			return v;
		}
	}

	//EDITAR UN PERFIL
	public void editarPerfil(String nombre, String contra,String cambio) {
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 30));


		VerticePersona v=getVertice(nombre);
		int opcion=0;
		if(v!=null) {
			opcion=Integer.parseInt(JOptionPane.showInputDialog("QUE DESEAS MODIFICAR?"+nl+"1) CONTRASENA"+nl+"2) NOMBRE"));
			switch (opcion) {
			case 1:
				v.contra=cambio;
				JOptionPane.showMessageDialog(null, "CAMBIOS REALIZADOS","FACEBOOK",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				v.nombre=cambio;
				JOptionPane.showMessageDialog(null, "CAMBIOS REALIZADOS","FACEBOOK",JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "OPCION NO VALIDA","ERROR",JOptionPane.ERROR_MESSAGE);
				break;
			}
		}else {
			JOptionPane.showMessageDialog(null, "NO HAY NINGUN PERFIL CON ESE NOMBRE Y CONTRASENA","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

	//METODO PARA CHECAR EL TAMANIO DEL ARREGLO, EN CASO QUE ESTE LLENO SE MANDA A LLAMAR AL METODO QUE LO AMPLIA
	public void checarTamArreglo(String nombre) {
		VerticePersona v=getVertice(nombre);
		int tamanio=v.arreglo.length;
		if(tamanio==v.num_solicitudes) {
			ampliarArreglo(nombre);
		}
	}

	//METODO PARA AMPLIAR ARREGLO
	public void ampliarArreglo(String nombre) {
		VerticePersona v=getVertice(nombre);
		String arreglo_tem[]=new String[v.arreglo.length];
		for(int x=0;x<arreglo_tem.length;x++) {
			arreglo_tem[x]=v.arreglo[x];
		}
		v.arreglo=new String[(arreglo_tem.length)*2];
		for(int x=0;x<arreglo_tem.length;x++) {
			v.arreglo[x]=arreglo_tem[x];
		}
		arreglo_tem=null;
	}

	//METODO PARA HACER UNA SOLICITUD DE AMISTAD
	//ANADE AL FINAL 
	public void request(String miNombre, String nombreAmigo) {
		VerticePersona v2=getVertice(nombreAmigo);
		int x;
		checarTamArreglo(nombreAmigo);
		boolean caso=noAgregarMismaPersona(v2,miNombre);
		if(caso==false) {
		for(x=0;x<v2.arreglo.length;x++) {
			if(v2.arreglo[x]==null) {
				break;
			}
		}
		v2.arreglo[x]=miNombre;
		v2.num_solicitudes++;
		}else {
			JOptionPane.showMessageDialog(null, "YA MANDASTE SOLICITUD A ESTA PERSONA","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean noAgregarMismaPersona(VerticePersona v2,String miNombre) {
		for(int x=0;x<v2.arreglo.length;x++) {
			if(v2.arreglo[x]!=null&&v2.arreglo[x].equals(miNombre)) {
				return false;
			}
		}
		return true;
	}

	//METODO PARA ACEPTAR LA SOLICITUD DE AMISTAD 
	//ESTE METODO SACA HACE POP DEL ARREGLO Y SI LO ACEPTA ENTONCES LLAMA AL METODO ADD AMIGO 
	//SI NO LO ACEPTA NO SE AGREGA EL AMIGO 
	public void aceptarSolicitud(String nombre) {
		VerticePersona v1=getVertice(nombre); //VERTICE DEL PERFIL
		String persona=v1.arreglo[v1.num_solicitudes-1]; 
		VerticePersona v2=getVertice(persona); //VERTICE DE QUIEN VOY A ACEPTAR LA SOLICITUD
		int seleccion=Integer.parseInt(JOptionPane.showInputDialog(null,"HOLA " +v1.nombre+ " ESTA PERSONA TE ESTA MANDANDO UNA SOLICITUD DE AMISTAD: "+v2.nombre+ " ACEPTAS? "+nl+"1) SI"+"nl"+"2) NO","FACEBOOK",JOptionPane.QUESTION_MESSAGE));
		if(seleccion==1) {
			addAmigos(v1,v2);
		}else {
			JOptionPane.showMessageDialog(null, "SOLICITUD DE AMISTAD RECHAZADA","FACEBOOK",JOptionPane.WARNING_MESSAGE);
		}
		v1.arreglo[v1.num_solicitudes-1]=null; 
		v1.num_solicitudes--;
	}

	public void addAmigos(VerticePersona v1, VerticePersona v2) {

		VerticePersona origen=v1;
		VerticePersona v=v2;
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 30));

		int posicion=0;
		if(myGraph.contains(origen)) {

			ListIterator<VerticePersona> it = myGraph.listIterator();
			VerticePersona tmp =null;
				while(it.hasNext()) {
					tmp = (VerticePersona) it.next();

					if(tmp.nombre.equals(origen.nombre)) {

						tmp.amigos.add(v);
						origen.num_amigos++;

						while(!(tmp.nombre.equals(v.nombre))) {
							tmp=myGraph.get(posicion);
							posicion++;
						}

						tmp.amigos.add(origen);
						v.num_amigos++;
						JOptionPane.showMessageDialog(null, "AMIGO AGREGADO","FACEBOOK",JOptionPane.INFORMATION_MESSAGE);
						break;
					}
				}
		}
	}


	//BUSCAR SI EXISTE UN DETERMINADO PERFIL 
	//METODO PARA VALIDACION
	public boolean buscar(String nombre,String contra) {  
		boolean caso=false;
		caso = depthFirstTraversal_buscar(nombre,contra,caso);
		return caso;
	}

	//BUSCAR SI EXISTE UN DETERMINADO PERFIL PARTE DE BUSCAR
	public boolean depthFirstTraversal_buscar(String nombre,String contra,boolean caso) { 
		boolean estado=caso;
		boolean [] visitado=new boolean[this.total_vertices];
		for(int x=0; x<this.total_vertices;x++) {
			visitado[x]=false;
		}

		for(int x=0;x<this.total_vertices;x++) {
			if(!visitado[x]) {
				estado=dft_buscar(myGraph.get(x),visitado,nombre,contra);
			}
		}
		return estado;
	}

	//BUSCAR SI EXISTE UN DETERMINADO PERFIL PARTE DE BUSCAR
	public boolean dft_buscar(VerticePersona v,boolean[]visitado,String nombre, String contra) { 
		visitado[v.identificador]=true;
		ListIterator<VerticePersona> it = myGraph.listIterator();
		while(it.hasNext()) {
			VerticePersona vertice = it.next();
			if(vertice.nombre.equals(nombre)&&vertice.contra.equals(contra)) {
				return true;
			}
			else if(!visitado[vertice.identificador]) {
				dft_buscar(vertice,visitado,nombre,contra);
			}
		}
		return false;
	}

	//METODO EXTENDIDO DE BUSCAR
	public VerticePersona getVertice (String nombre) { 
		VerticePersona elemento=null;
		elemento = depthFirstTraversal_buscar2(nombre,elemento);
		return elemento;
	}

	public VerticePersona depthFirstTraversal_buscar2(String nombre,VerticePersona elemento) { 
		VerticePersona vertice=elemento;
		boolean [] visitado=new boolean[this.total_vertices];
		for(int x=0; x<this.total_vertices;x++) {
			visitado[x]=false;
		}

		for(int x=0;x<this.total_vertices;x++) {
			if(!visitado[x]) {
				vertice=dft_buscar2(myGraph.get(x),visitado,nombre);
			}
		}
		return vertice;
	}
	public VerticePersona dft_buscar2(VerticePersona v,boolean[]visitado,String nombre) { 
		visitado[v.identificador]=true;
		ListIterator<VerticePersona> it = myGraph.listIterator();
		while(it.hasNext()) {
			VerticePersona vertice = it.next();
			if(vertice.nombre.equals(nombre)) {
				return vertice;
			}
			else if(!visitado[vertice.identificador]) {
				dft_buscar2(vertice,visitado,nombre);
			}
		}
		return null;
	}

	//IMPRIME TOTAL DE PERSONAS EN EL GRAFO
	public String imprimirTotalAmigos() { //IMPRIMIR VERTICES USANDO DepthFirstTraversal
		ListIterator<VerticePersona> it = myGraph.listIterator();
		VerticePersona tmp =null;
		String concatenar="";
		while(it.hasNext()) {
			tmp = (VerticePersona) it.next();
			concatenar=concatenar+tmp.nombre+nl;
		}
		return concatenar;
	}

	//IMPRIME VERTICES MAS LA LISTA DE AMIGOS DE UN VERTICE
	public String imprimirAmigosVertice(String nombre) { //IMPRIMIR VERTICES USANDO DepthFirstTraversal
		VerticePersona v=getVertice(nombre);
		int x=0;
		String concatenar="";
		if(myGraph.contains(v)) {

			while(x<v.num_amigos) {
				concatenar=concatenar+nl+v.amigos.get(x).nombre;
				x++;
			}
			System.out.println("TOTAL DE AMIGOS:"+v.num_amigos);
			return concatenar;
		}else {
			System.out.println("NO EXISTE ESTE PERFIL");
			return null;
		}
	}

	//METODO DE BUSCAR PRINCIPAL
	public void dft(VerticePersona v,boolean[]visitado) { 
		visitado[v.identificador]=true;
		System.out.println("VERTICE "+v.identificador+ " PERSONA VISITADA "+ v.nombre);

		ListIterator<VerticePersona> it = myGraph.listIterator();
		while(it.hasNext()) {
			VerticePersona vertice = it.next();
			if(!visitado[vertice.identificador]) {
				dft(vertice,visitado);
			}
		}
	}

	//METODO PARA VER EL TOTAL DEL PERSONAS EN ESTE CASO VERTICES
	public void depthFirstTraversal() { // GRAFO COMPLETO, METODO QUE MANDA A LLAMAR A DFT
		boolean [] visitado=new boolean[this.total_vertices];
		for(int x=0; x<this.total_vertices;x++) {
			visitado[x]=false;
		}

		for(int x=0;x<this.total_vertices;x++) {
			if(!visitado[x]) {
				dft(myGraph.get(x),visitado);
			}
		}
	}

	//METODO NO SE OCUPA 
	public void dftAtVertex(VerticePersona v) { //EMPEZANDO EN UN VERTICE  METODO QUE MANDA A LLAMAR A DFT
		boolean [] visitado= new boolean[this.total_vertices];
		for(int x=0; x<this.total_vertices;x++) {
			visitado[x]=false;
		}
		dft(v,visitado);
	}
}
