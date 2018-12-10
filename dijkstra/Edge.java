
public class Edge {
	
	    private  Vertex source;
	    private  Vertex destination;
	    private  int distance;

	    public Edge() {
	    	
	    	
	    }
	    public Edge( Vertex source, Vertex destination, int distance) {
	        this.source = source;
	        this.destination = destination;
	        this.distance = distance;
	    }

	   
	    public Vertex getDestination() {
	        return destination;
	    }

	    public Vertex getSource() {
	        return source;
	    }
	    public int getDistance() {
	        return distance;
	    }
	    public void setDistance(int dist) {
	    	
	    	distance=dist;
	    }
 }    


