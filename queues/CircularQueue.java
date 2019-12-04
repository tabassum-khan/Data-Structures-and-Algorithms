package queues;

public class CircularQueue {
	
	int front, rear, size; 
	int capacity; 
	int array[]; 
	
	CircularQueue(int capacity){
		this.capacity = capacity; 
		front = this.size = 0; 
		rear = capacity - 1; 
		array = new int[this.capacity]; 
	}
	
	// Queue is full when size becomes equal to the capacity 
	boolean isFull(CircularQueue queue){ return (queue.size == queue.capacity); }
	
	// Queue is empty when size is 0 
	boolean isEmpty(CircularQueue queue) { return (queue.size == 0); } 
	
	void enQueue( int item) { 
		if (isFull(this)) {
			System.out.println("System Overflow");
			return; 
		}
		if (this.rear == capacity)
			this.rear =0;
		else 
			this.rear = (this.rear + 1)%this.capacity; 

		this.array[this.rear] = item; 
		this.size = this.size + 1; 
		System.out.println(item+ " enqueued to queue"); 
	}
	
	int deQueue() 
	{ 
		if (isEmpty(this)) {
			System.out.println("System Underflow");
			return Integer.MIN_VALUE;
		}
		int item = this.array[this.front];
		this.array[this.front] = -1;
		
		if (this.front==capacity)
			this.front = 0;
		else
			this.front = (this.front + 1)%this.capacity; 
		
		this.size = this.size - 1; 
		return item; 
	} 
	
	void displayQueue() {
		if (isEmpty(this)) {
			System.out.println("Queue is Empty");
			return;
		}
		System.out.println("\nElements are: ");
		 if (rear >= front) 
		    { 
		        for (int i = front; i <= rear; i++) 
		            System.out.print(array[i] + " ");
		    } 
		    else
		    { 
		        for (int i = front; i < size; i++) 
		            System.out.print(array[i] + " ");
		        for (int i = 0; i <= rear; i++) 
		            System.out.print(array[i] + " "); 
		    } 
		 System.out.println("\n");
	}
	
	public static void main(String[] args) {
		
		CircularQueue q = new CircularQueue(5);
		 // Inserting elements in Circular Queue 
	    q.enQueue(14); 
	    q.enQueue(22); 
	    q.enQueue(13); 
	    q.enQueue(-6); 
	    System.out.println(q.isFull(q));
	    // Display elements present in Circular Queue 
	    q.displayQueue(); 
	  
	    // Deleting elements from Circular Queue 
        System.out.println(q.deQueue() + " is dequeued");
        System.out.println(q.deQueue() + " is dequeued");
	  
	    q.displayQueue(); 
	  
	    q.enQueue(9); 
	    q.enQueue(20); 
	    q.enQueue(5); 

	    q.displayQueue(); 
	  
	    q.enQueue(20); 
	    System.out.println(q.isFull(q));
	    System.out.println(q.deQueue() + " is dequeued");
	}

}
