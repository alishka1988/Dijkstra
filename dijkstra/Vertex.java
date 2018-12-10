
public class Vertex {

	
	      String name;
	      int index;
	     private boolean visited=false;
	      
	    public Vertex() {
	    	
	    }
	    public Vertex( String name, int index) {
	        this.name = name;
	        this.index=index;
	    }
	   
	    public String getName() {
	        return name;
	    }
	    public int getIndex() {
	    	
	    	return index;
	    }
	    public boolean isVisited() {
	    	
	    	return visited;
	    }
	    public void setVisited() {
	    	
	    	visited=true;
	    }
		
	
}
