# Queue

## Introduction

- A Queue is a linear structure which follows a particular order in which the operations are performed. The order is First In First Out (FIFO). 
- **Basic Operations:**
    - Enqueue()	
    - Dequeue()      
    - front() & rear()        
    - isFull() &  isEmpty()

- Array implementation Of Queue:
    - For implementing queue, we need to keep track of two indices, front and rear.
    - We enqueue an item at the rear and dequeue an item from front. 
    - If we simply increment front and rear indices, then there may be problems, front may reach end of the array. 
    - The solution to this problem is to increase front and rear in circular manner .


## Design and Implementation

**1. Creation** - creating queue class and initialising the constructor.
```
class Queue { 
    int front, rear, size; 
    int  capacity; 
    int array[]; 
       
    public Queue(int capacity) { 
         this.capacity = capacity; 
         front = this.size = 0;  
         rear = capacity - 1; 
         array = new int[this.capacity];    
    }
}
```

**2. Insertion**
```
void enqueue( int item) { 
        if (isFull(this)) 
            return; 
        this.rear = (this.rear + 	1)%this.capacity; 
        this.array[this.rear] = item; 
        this.size = this.size + 1; 
        System.out.println(item); 
}
```

**3. Deletion**
```
int dequeue(){ 
        if (isEmpty(this)) 
            return Integer.MIN_VALUE; 
           
        int item = this.array[this.front]; 
        this.front = (this.front + 	1)%this.capacity; 
        this.size = this.size - 1; 
        return item; 
}  
```

**4. Defining isFull() and isEmpty() methods**
```
boolean isFull(Queue queue) {  
      return (queue.size == queue.capacity); 
 }

boolean isEmpty(Queue queue) {  
      return (queue.size == 0);
}
```

**5. Access Front and Rear Element**
```
int front(){ 
        if (isEmpty(this)) 
            return Integer.MIN_VALUE; 
        return this.array[this.front]; 
}

int rear(){ 
        if (isEmpty(this)) 
            return Integer.MIN_VALUE; 
        return this.array[this.rear]; 
}
```

# Priority Queue

- Priority Queue is a special type of queue that is an application of heap data structure.
- To know more about Prioirty Queues, go to : [Priority Queues](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/edit/master/queues/priority_queues.md)
