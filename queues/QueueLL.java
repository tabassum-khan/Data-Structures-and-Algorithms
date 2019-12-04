package queues;
// Java program for linked-list implementation of queue 

// A linked list (LL) node to store a queue entry 
class QNode 
{ 
	int key; 
	QNode next; 
	
	// constructor to create a new linked list node 
	public QNode(int key) { 
		this.key = key; 
		this.next = null; 
	} 
} 

// A class to represent a queue 
//The queue, front stores the front node of LL and rear stores ths 
//last node of LL 
class Queue 
{ 
	QNode front, rear; 
	int size;
	public Queue() { 
		this.front = this.rear = null; 
		this.size =0;
	} 
	
	boolean isEmpty() {
		if (this.rear == null)
			return true;
		return false;
	}
	
	// Method to add an key to the queue. 
	void enqueue(int key) 
	{ 
		
		// Create a new LL node 
		QNode temp = new QNode(key); 
	
		// If queue is empty, then new node is front and rear both 
		if (isEmpty()) 
		{ 
		this.front = this.rear = temp; 
		this.size++;
		return; 
		} 
	
		// Add the new node at the end of queue and change rear 
		this.rear.next = temp; 
		this.rear = temp; 
		this.size += 1;
	} 
	
	// Method to remove an key from queue. 
	QNode dequeue() 
	{ 
		// If queue is empty, return NULL. 
		if (this.front == null) 
		return null; 
	
		// Store previous front and move front one node ahead 
		QNode temp = this.front; 
		this.front = this.front.next; 
	
		// If front becomes NULL, then change rear also as NULL 
		if (this.front == null) 
		this.rear = null; 
		this.size -= 1;	
		return temp; 
	} 
} 

	
// Driver class 
public class QueueLL 
{ 
	public static void main(String[] args) 
	{ 
		Queue q=new Queue(); 
		System.out.println(q.isEmpty() + " " + q.size);
		q.enqueue(10); 
		q.enqueue(20); 
		
		q.dequeue(); 
		q.dequeue(); 
		
		q.enqueue(30); 
		q.enqueue(40); 
		q.enqueue(50); 
		System.out.println(q.isEmpty()+ " " + q.size);
		System.out.println("Dequeued item is "+ q.dequeue().key); 
		System.out.println(q.isEmpty()+ " " + q.size);
	} 
} 
// This code is contributed by Gaurav Miglani 
