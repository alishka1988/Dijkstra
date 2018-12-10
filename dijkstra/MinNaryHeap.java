/**
 * 
 */

/**
 * @author alinasaiakhova
 *
 */




//import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.ArrayList;


public class MinNaryHeap extends Edge
 {
	

	private  ArrayList <Edge> heap_data; // ArrayList storing heap data
    private int heap_size; // heap size
    private int num_children; //number of children per node
   
   
	//creates empty heap
    public MinNaryHeap( int k){
    	heap_data= new ArrayList <Edge>(); 
    	num_children=k; 
    	heap_size=0;
    	
    }
    
	//creates heap and populates it with user data
    public MinNaryHeap(ArrayList <Edge> array_list, int k){
    	heap_size=0;
    	heap_data= new  ArrayList<Edge>();
    	num_children=k;
    	//insert each element at the bottom of the heap,  then heapifyUp
        for (int i = 0; i < array_list.size(); i++) 
        	insertIntoHeap(array_list.get(i));
    	
    }
    
  public void insertIntoHeap (Edge element) {
	 
    heap_data.add( element); //insert at the bottom for now
  	heap_size++; 
  	heapifyUp(heap_size-1); //then heapifyUp until heap property is met
	  
  }
  
  public void traverseHeap(int index) {
	  
	  
	  for (int i=index; i<heap_data.size();i++)
		  System.out.print(heap_data.get(i).getDestination().getName()+",");
	  System.out.println("");
  }
  
  public void deleteFromHeap (int child_index) {
	  
	  if(heap_size ==0)           
		  throw new NoSuchElementException("Cannot delete from index "+child_index+" because the heap is empty");
	  
	  //set element at index to last element in heap
	  heap_data.set(child_index, heap_data.get(heap_size-1));
	  heap_data.remove(heap_size-1);
	  heap_size--;
	  heapifyDown(child_index);
	  
  }
  public int getSize() {
	  
	  return heap_size;
	  
  }
  public Edge extractMin() {
	  
	  if(heap_size ==0)           
		  throw new NoSuchElementException("Cannot extract min because the heap is empty");
	//extract the top element, then heapifyDown
	  Edge extracted=heap_data.get(0);
	  heap_data.set(0, heap_data.get(heap_size-1));
	  heap_data.remove(heap_size-1);
	  heap_size--;
	  heapifyDown(0);
	  return extracted;
	 
	  
  }
  
  
  public void heapifyDown (int cur_index) {
	 
	  if(cur_index*num_children+1  < heap_size) { //loop until we get to the 2nd to last level
			//get min value child of node at cur_index
			  int minChild_index=getMinChildIndex(cur_index);
			
			if(compare(cur_index, minChild_index) > 0) {//if min child is smaller, swap child and parent
				swapElements(cur_index,minChild_index);
			}else {
				//do nothing
				}
			cur_index=minChild_index; // after exchanging current node with its smallest child, we place it where the smallest child used to be and heapifyDown from there
	       heapifyDown(cur_index);
	  }
	  

  }
  
  
  public int getMinChildIndex(int parent_index) {
	  
	  //current minimum node is the left most node
	  int cur_min_index=parent_index*num_children+1;
//go through the rest of the child nodes to determine the actual minimum node
	  for(int i=num_children*parent_index+2;i<=num_children*parent_index+num_children; i++ ) 
		  if (i < (heap_size-1))
		  if (compare(i,cur_min_index)<0) 
		      cur_min_index=i;
	  
	  return cur_min_index;
	  
	  
  }
  
  public void heapifyUp (int child_index) {
	  
	  //compare child and parent node, swap if necessary; child becomes new parent if swap occurred; 
	  if(child_index >0 && compare(child_index,  getParentIndex(child_index))<0){
	  
		  int parent_index=getParentIndex(child_index);
		  swapElements(child_index,parent_index); 
		  child_index=parent_index;
		  heapifyUp(child_index);
		  
	  }
  }
  
  public void swapElements(int index1, int index2) {
	  
	Edge nodeAtindex1=heap_data.get(index1);
	heap_data.set(index1, heap_data.get(index2));
	heap_data.set(index2, nodeAtindex1);
	  
	  
  }
  
  public int getParentIndex(int child_index) {
	  
	  return (child_index-1)/num_children;
	  
  }
  
	  
  public int compare(int indexOfelement1, int indexOfelement2) 
  { 
	  Edge element1=heap_data.get(indexOfelement1);
	  Edge element2=heap_data.get(indexOfelement2);
	 // System.out.println("distance:"+(element1.getDistance() - element2.getDistance()));
	  return (element1.getDistance() - element2.getDistance());
	  
  } 
	
	
  public boolean isEmpty() {
	  
	  if (heap_size ==0) return true;
	  else return false;
  }

	
	public static void main(String[] args) {
		
		/*
		Scanner scan = new Scanner(System.in);
		
        System.out.println("Min N-ary Heap Test\n");
        System.out.println("Enter max number of children per node:");
        

        //Creates empty heap
        MinNaryHeap min_heap = new MinNaryHeap(scan.nextInt() );
		
		//print options:
        System.out.println("Min N-ary Heap operations :");
        System.out.println("1. Populate heap with comma-delimited list of values");
        System.out.println("2. Delete element at index");
        System.out.println("3. Insert new element");
        System.out.println("4. Print heap");
        System.out.println ("Pick an operation:");
        
        int option=scan.nextInt();
		
        
        switch (option)
        {
        case 1 : 
            try
            {
                System.out.println("Enter comma delimited list of numbers or characters");
                
               String numeric_string=
                
                dh.insert( scan.nextInt() ); 
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage() );
            }
            break;                          
        case 2 : 
            try
		
		ArrayList my_list = new ArrayList ();
		my_list =  new ArrayList  ( Arrays.asList(10.5,20.4,1.1,5.3,4.1,3.7,3.6,10.1,5.0,6.0,3.6));
	       MinKaryHeap heap = new MinKaryHeap(my_list, 2 );

       MinKaryHeap heap = new MinKaryHeap(8, 2 );
       // heap.insertIntoHeap(5.0);
       // heap.insertIntoHeap(2.0);
      //  heap.insertIntoHeap(1.0);


        heap.traverseHeap(0);
	       heap.deleteFromHeap(0);
	       heap.traverseHeap(0);
	       heap.traverseHeap(1);
//System.out.print(heap.heap_size+","+my_list.size());
	}
	*/
	}
}


