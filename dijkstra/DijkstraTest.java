 
public class DijkstraTest extends Vertex {


public DijkstraTest() {

}




public static void main(String[] args) {

	//Initialize directed Graph
	int vertices = 8;
	Graph graph = new Graph(vertices);
    graph.addEdge(new Vertex("A",0), new Vertex("B",1), 3);
    graph.addEdge(new Vertex("A",0), new Vertex("C",2), 6);
    graph.addEdge(new Vertex("A",0), new Vertex("E",4), 30);
    graph.addEdge(new Vertex("B",1), new Vertex("C",2), 1);
    graph.addEdge(new Vertex("C",2), new Vertex("D",3), 3);
    graph.addEdge(new Vertex("C",2), new Vertex("E",4), 1);
    graph.addEdge(new Vertex("D",3), new Vertex("E",4), 4);
    graph.addEdge(new Vertex("E",4), new Vertex("F",5), 4);
    graph.addEdge(new Vertex("E",4), new Vertex("G",6), 1);
    graph.addEdge(new Vertex("E",4), new Vertex("H",7), 2);


	graph.getDijkstraShortestPath(graph.getSourceIndex(0));
	
	
	
	
}
}
