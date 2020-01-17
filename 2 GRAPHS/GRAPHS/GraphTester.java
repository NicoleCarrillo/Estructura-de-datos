
public class GraphTester {
public static void main(String[] args) {
	Graph g=new Graph();
	Vertex v1=new Vertex(1,"nic");
	Vertex v2=new Vertex(2,"manchas");
	g.addVertix(v1);
	g.addVertix(v2);
	g.addConnection(v1.ID, v2);
	
	System.out.println(g.graph.get(0).name);
	System.out.println(g.graph.get(0).next.name);
 }
}
