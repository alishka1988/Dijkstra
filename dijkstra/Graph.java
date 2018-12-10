import java.util.LinkedList;
import java.util.HashMap;
 
public class Graph {
	
	
	int vertices;
    LinkedList<Edge>[] adjacency_list;
    
    //initialize Graph object and adjacency lists for all vertices
    Graph(int vertices) {
        this.vertices = vertices;
        adjacency_list = new LinkedList[vertices];
        for (int i = 0; i <vertices ; i++) {
        	//creates empty linked list for each vertex, to be populated with its neighboring vertices 
            adjacency_list[i] = new LinkedList<Edge>();
        }
    }
    
    public void addEdge(Vertex source, Vertex destination, int distance) {
        Edge edge = new Edge(source, destination, distance);
        adjacency_list[source.getIndex()].add(edge);

       edge = new Edge(destination, source, distance); //for undirected graph
        adjacency_list[destination.getIndex()].add(edge);

            }
    
    public Vertex getSourceIndex(int index) {
    	
    	return adjacency_list[index].getFirst().getSource();
    }
   public void getDijkstraShortestPath(Vertex source) {
	   
	   //get index of source vertex (doesn't have to be 0 )
	  int  source_vertex_index=source.getIndex();
	  //set distance from source to itself to 0 in adjacency list, so the Edge can be passed to MinNaryHeap class
      adjacency_list[source_vertex_index].addFirst(new Edge(source, source, 0));

      boolean[] visited = new boolean[vertices];
      
       //array storing distances between each vertex and source
       int [] distance = new int[vertices];

       //set all distances to infinity
       for (int i = 0; i <vertices ; i++) 
           distance[i] = Integer.MAX_VALUE;
       
       //set source distance to source to 0
           distance[source_vertex_index]=0;

	   //create empty Min Heap
         MinNaryHeap min_heap=new MinNaryHeap(2);
        //insert first edge into the heap
        min_heap.insertIntoHeap(adjacency_list[source_vertex_index].getFirst());
        
        
      //while priority queue is not empty
        while(!min_heap.isEmpty()){
            //extract the vertex with the min distance to source

        	Edge edge_min_distance_to_source= min_heap.extractMin();

           Vertex extractedVertex = edge_min_distance_to_source.getDestination();
            
            //mark vertex as visited
            if(visited[extractedVertex.getIndex()]==false) {
            	visited[extractedVertex.getIndex()]=true;

                //iterate through all the adjacent vertices and update the keys
                LinkedList<Edge> list = adjacency_list[extractedVertex.getIndex()];
                
                for (int idx = 1; idx < list.size(); idx++) {
                    Edge edge = list.get(idx);
                    
                    Vertex destinationVertex = edge.getDestination();
                    //only if destination vertex hasn't been visited
                    if (visited[destinationVertex.getIndex()] == false) {
                        ///check if distance needs an update or not
                        //check if current distance from source to vertex is greater than current shortest path
                        //if yes, update current distance to shortest distance
                        int newDistanceToSource =  distance[extractedVertex.getIndex()] + edge.getDistance() ;
                        
                        int currentDistanceToSource = distance[destinationVertex.getIndex()];

                        if(currentDistanceToSource>newDistanceToSource){
                        	
                         edge.setDistance(newDistanceToSource);
                         

                            min_heap.insertIntoHeap(edge);
                            distance[destinationVertex.getIndex()] = newDistanceToSource;
                        }
                    }
                }
            }
        }
           
        
       
       for (int j = 0; j <vertices ; j++) {
           System.out.println("Source " + source.getName() + " to Vertex "    + adjacency_list[j].getFirst().getSource().getName() +
                   ", distance: " + distance[j]);
	   
	   
  }   
   
   }

}
   
