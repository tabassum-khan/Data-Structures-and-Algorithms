# Priority Queues
>💡 On Notion → [Priority Queues](https://www.notion.so/Priority-Queues-1a5ae7fa96fa48baac8fb26112d2aa10)

# **Introduction**

- **Priority Queue** is an **[abstract data type](https://www.geeksforgeeks.org/abstract-data-types/)** that is similar to a **[queue](https://www.geeksforgeeks.org/queue-data-structure/)**, and every element has some priority value associated with it. The priority of the elements in a priority queue determines the order in which elements are served.
- Properties of Priority Queue:
    - Every item has a priority associated with it.
    - An element with high priority is dequeued before an element with low priority.
    - If two elements have the same priority, they are served according to their order in the queue.

### **💡 Difference between Priority Queue and Normal Queue**

> In a queue, the **first-in-first-out rule** is implemented whereas, in a priority queue, the values are removed **on the basis of priority**. 
> 
> The element with the highest priority is removed first.
> 

### 💡 How is Priority assigned to the elements in a Priority Queue?

> In a priority queue, generally, the value of an element is considered for assigning the priority.
> 
> For example, the element with the highest value is assigned the highest priority and the element with the lowest value is assigned the lowest priority. The reverse case can also be used i.e., the element with the lowest value can be assigned the highest priority. Also, the priority can be assigned according to our needs.
> 

### 💡How to Implement Priority Queue?

> Priority queue can be implemented using the following data structures:
> 
> - Arrays
> - Linked list
> - Heap data structure
> - Binary search tree

# **Design and Implementation**

> For the purpose of this syllabus, we will implement priority queue with array and heaps only.

## ****Implement Priority Queue Using Array:****

A simple structure of a priority queue item will look like this:

```java
class Item {
      public int value;
      public int priority;
    
      public Item(int value, int priority) {
            this.value = value;
            this.priority = priority;
      }
}
```

And a simple priority Queue implementation will have the following variables and methods:

```java
public class PriorityQueue {
    class Item {
        public int value;
        public int priority;

        public Item(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    private Item[] pq;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.pq = new Item(this.capacity);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void swap(int i, int j {
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    
    public void enqueue(int value, int priority) {...}
    public Item dequeue() {...}
    public Item peek() {...}
}
```

### 1. **enqueue(int value, int priority) → O(n)**
> **This function is used to insert new data into the queue.**
> 
> - Create a new Item.
> - We will insert the Item at the end of the array.
> - Compare the priorty of the newly inserted element with the priorities of the previous elements and swap if it is greater than the previous items. We will need to compare with n previous elements. Hence, it will take O(n) time.
> 
> ```java
> public void enqueue(int value, int priority) {
>     if (isFull())
>         return;
> 
>     //create a new item
>     Item item = new Item(value, priority);
> 
>     //insert the item at the end of the array
>     pq[size++] = item;
> 
>     //Compare the item with the other items in the array
>     int index = size - 1;
>     while (index >= 1 && pq[index - 1].priority < item.priority)
>         swap(index - 1, index--);
> }
> ```
>

### 2. **dequeue() → O(n)**
> **This function removes the element with the highest/lowest priority from the queue.**
> 
> - The element with the highest/lowest priority will be the first element in the priority queue depending if it is a max/min priorty queue and it will be deleted when dequeue() will be called.
> - Return the element at the first position.
> - Shift the elements by 1 in the priority queue and decrease the size.
> 
> ```java
> public Item dequeue() {
>     if (isEmpty())
>         return null;
> 
>     Item max = pq[0];
>     //shift the elements by 1 position to the left
>     for (int i = 0; i < size - 1; i++)
>         pq[i] = pq[i + 1];
>     size--;
>     return max;
> }
> ```
>

### 3. **peek() → O(1)**
> **This function is used to get the highest priority element in the queue without removing it from the queue.**
> 
> - The element with the highest/lowest priority will be the first element in the priority queue depending if it is a max/min priorty queue.
> - Return the element at the first position.
> 
> ```java
> public Item peek() {
>         return isEmpty() ? null : pq[0];
> ```
>

## ****Implement Priority Queue Using Heap:****

---

A simple structure of a priority queue item will look like this:

```java
class Item {
    public int value;
    public int priority;

    public Item(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
```

To implement the queue with heap, we can use either max heap or min heap. For the scope of this syllabus, we will be implementing priority queue with max heap. The indexing in heap will start from 1.
```java
public class PriorityQueue {
    class Item {
        public int value;
        public int priority;

        public Item(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    private Item[] pq;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.pq = new Item[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void swap(int i, int j {
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    
    public void heapify(int[] pq, int index, int size) {...}
    public void enqueue(int value, int priority) {...}
    public Item dequeue() {...}
    public Item peek() {...}
}
```
### 1. **enqueue(int value, int priority) → O(Logn)**
> **This function is used to insert new data into the queue.**
> 
> - Create a new Item and insert it at the end.
> - In max priority queue, it should follow the property of max heap, i.e. every parent element must have priorities greater than the priorities of its children.
> - So when we insert a new element, it might not follow the property of max heap. Hence, we should compare it with its parent to check if it has greater priority. If it does, then swap the child and the parent.
> 
> ```java
> public void enqueue(int value, int priority) {
>     if (isFull())
>         return;
> 
>     //create a new item
>     Item item = new Item(value, priority);
> 
>     //insert the item at the end of the queue
>     pq[++size] = item;
> 
>     //Compare the item with its parent and swap if it has greater priority
>     int index = size;
>     while (index > 1 && pq[index].priority > pq[index / 2].priority) {
>         swap(index, index / 2);
>         index /= 2;
>     }
> }
> ```
>

### 2. **dequeue() → O(Logn)**
> **This function removes the element with the highest/lowest priority from the queue.**
> 
> - The element with the highest/lowest priority will be the first element in the priority queue depending if it is a max/min priorty queue and it will be deleted when dequeue() will be called.
> - Return the element at the first position.
> - Copy the last element to the first position and heapify the tree from index 1 to  the new reduced size.
> 
> ```java
> public Item dequeue() {
>     if (isEmpty())
>         return null;
>     Item max = pq[1];
> 
>     //shift the elements by 1 position to the left
>     pq[1] = pq[size--];
> 
>     //heapify the tree
>     heapify(pq, 1, size);
> 
>     return max;
> }
> ```
>

### 3. **peek() → O(1)**
> **This function is used to get the highest priority element in the queue without removing it from the queue.**
> 
> - The element with the highest/lowest priority will be the first element in the priority queue depending if it is a max/min priorty queue.
> - Return the element at the first position.
> 
> ```java
> public Item peek() {
>         return isEmpty() ? null : pq[1];
> ```
>

### 4. **heapify() → O(Logn)**

> Heapify will maintain the property of heap depending on its implementation. Since, here it is a max heap, heapify() will ensure that every parent element has a priority greater than its children.
> 
> To revise heapify, refer to **MAX HEAP IMPLEMENTATION** → [**minHeapify()/ maxHeapify()**](https://www.notion.so/4-minHeapify-maxHeapify-O-Logn-05f9c7294a21491f9af55b92be83a775)
> 
> 
> ```java
> void heapify(Item arr[] , int index, int size){
>     int left  = 2*index; // left child
>     int right = 2*index+1; // right child
>     int largest;
> 
>     if(left <= size && arr[left].priority > arr[index].priority )
>          largest = left;
>     else
>         largest = index;
> 
>     if(right <= size && arr[right].priority > arr[largest].priority)
>         largest = right;
> 
>     if(largest != index){
>         swap (index, largest);
>         heapify (arr, largest, size);
>     } 
> }
> 
> ```
>
