import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Graph {

	List<Vertex> graph = new ArrayList<Vertex>();
	
	public void addVertix(Vertex v) {
		if(!graph.contains(v)) {
			graph.add(v);
		}
	}
	
	public void addConnection(int origin, Vertex v) {
		if(!graph.contains(v)) {
			graph.add(v);
		}
		
		ListIterator it= graph.listIterator();
		Vertex temp=null;
		Vertex tempConnection=null;
		
		while(it.hasNext()) {
			temp=(Vertex) it.next();
			if(temp.ID==origin) {
				tempConnection = temp;
				while(tempConnection.next != null) {
					tempConnection=tempConnection.next;
				}
				tempConnection.next = v;
				break;
			}
		}
	}
}
