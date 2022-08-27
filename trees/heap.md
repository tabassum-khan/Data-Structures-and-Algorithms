# Heap
>💡 On Notion → [Heap](https://www.notion.so/Heap-39734a077ce946ff81eec793f2379ff7)
# **Introduction**

- A heap is a specific tree based data structure in which all the nodes of tree are in a specific order. They are hierarchical data structure.
- The maximum number of children of a node in the heap depends on the type of heap. However in the more commonly used heap type, there are at most 2 children of a note and it's known as a Binary heap.
- In binary heap, if the heap is a complete binary tree with N nodes, then it has has smallest possible height which is logN .
- **There can be two types of heap:**
    - **Max Heap:**
        
        > In this type of heap, the value of parent node will always be greater than or equal to the value of child node across the tree and the node with highest value will be the root node of the tree.
        > 
    - **Min Heap:**
        
        > In this type of heap, the value of parent node will always be less than or equal to the value of child node across the tree and the node with lowest value will be the root node of tree.
        > 

### Representation of Heap

![https://github.com/tabassum-khan/Data-Structures-and-Algorithms/raw/master/assets/heap.png](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/raw/master/assets/heap.png)

>💡 Here we are only going to cover Binary Heap

# **Binary Heap**

### Properties

---

- A Binary Heap is a Binary Tree with following properties:
    1. **It’s a complete tree.** All levels are completely filled except possibly the last level and the last level has all keys as left as possible. This property of Binary Heap makes them suitable to be stored in an array.
    2. **A Binary Heap is either Min Heap or Max Heap**. 
        1. In a **Min Binary Heap**, the key at root must be minimum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. 
        2. **Max Binary Heap** is similar to MinHeap except the root must be maximum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. 
- A Binary Heap is typically represented as an array. The root element will be at `arr[0]`. The relationship between the elements of the heap can be represented as:
    
    > Note : The indexing starts from 1 and not 0 to make indexing easier. Lets say that an element is at index 'i', then its
    > 
    > 1. Left child : **2*i**
    > 2. Right child : **2*i + 1**
    > 3. Parent : **i/2**

### **Applications:**

---

1. [Heap Sort](../sorting/heap_sort.md) 
2. [Priority Queues](../queues/priority_queues.md) 

# **Design and Implementation**

If we are going to implement binary heap, we will either implement a max heap or a min heap. We will see both of those implementation.

- The binary Heap will be created with the help of an array and its capacity and size will be declared.
```java
private[] int heap;
private int capacity;
private int size;
```

## Operations on Binary Heap
- **insert() →** Inserting a new key takes **O(Log n)** time. We add a new key at the end of the tree. Then we traverse up to fix if the binary heap property has been violated.
- **getMin() / getMax()** → It returns the root element of Min Heap / Max Heap. The Time Complexity of this operation is **O(1).**
- **extractMin() / extractMax()** → Removes the minimum / maximum element from MinHeap. The Time Complexity of this Operation is **O(Log n)** as this operation needs to maintain the heap property (by calling heapify()) after removing the root.
- A simple binary heap can be implemented as:
    
    ```java
    public class BinaryHeap {
        private int[] heap;
        private int size;
    		private int capacity;
         
        // initialise heap
        public BinaryHeap(int[] heap, int capacity){
            this.size = 0;
            this.heap = new int[ capacity+1];
            this.capacity = capacity;
        }
    
        public boolean isEmpty(){
            return size == 0;
        }
         
        public boolean isFull(){
            return size == capacity;
        }
        
        public void swap(int index1, int index2){
            int temp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = temp;
        }
        
        public buildHeap(int[] arr){..}
        public heapify(int[] arr, int index, int size){...}
        public void insert(int key){..}
        public getMin(){...}
        public int extractMin(){...}
    }
    ```
    

## Heap Implementation

### 1. **Insertion → O(Logn)**

---

- If heap is full, i.e if heap array has exhausted its full capacity, then return.
- Else, insert the element to the last empty slot
- Now, after insertion, we should check if min/max heap property is being maintained i.e. every parent element must be less/greater than its children.
- Since the element is added to the bottom of the tree, we move upwards and check if the inserted element is less/greater than its parent. If it is, then we swap the parent and the child. We keep doing this until the property is satisfied or we have reached the root.

**MIN HEAP INSERTION**

```java
public void insert(int element){
    if (isFull())
        return;
    
    heap[++size] = element;
    int current = size;
 
    while (heap[current] < heap[current/2]) {
        swap(current, current/2);
	    current = current/2;
    }
}
```

**MAX HEAP INSERTION**

```java
public void insert(int element){
    if (isFull())
        return;
	
    heap[++size] = element;
    int current = size;
 
    while (heap[current] > heap[current/2]) {
        swap(current, current/2);
        current = current/2;
    }
}
```

### 2. **Get the min/max element: getMin()/getMax() → O(1)**

---

- In Min/Max Heap, the minimum/maximum element will be present at the root. The root is at index ‘1’ of the heap array.

**GET MIN**

```java
public int getMin(){
    return heap[1];
}
```

**GET MAX**

```java
public int getMax(){
    return heap[1];
}
```

### 3. **Extract the min/max element: extractMin()/extractMax() → O(Logn)**

---

- In Min/Max Heap, the minimum/maximum element will be present at the root. The root is at index ‘1’ of the heap array.
- We need to return this element as well as remove it. To delete the element, copy the last element to the root element and decrease the size of the heap.
- Since the last element has been copied to the first element, we must heapify it to maintain the min/max heap property. Now it will only heapify from index 1 till the new reduced size.

**EXTRACT MIN**

```java
public int extractMin(){ 
    // Get the min element
    int minElement = heap[1]

    // Replace root with last element and decrease its size
    heap[1] =  heap[size--]; 
  
    // heapify the root node 
    min_heapify(heap, 1, size); 

    return minElement; 
}
```

**EXTRACT MAX**

```java
public int extractMax(){ 
    // Get the last element and decrease size
    int maxElement = heap[1];

    // Replace root with last element and decrease size 
    heap[1] = heap[size--];
  
    // heapify the root node 
    max_heapify(heap, 1, size); 

    return maxElement; 
}
```

### 4. **minHeapify()/ maxHeapify()→ O(Logn)**

---

- The most important step in the implementation of heap. Heapify is the process of implementing and maintaing the properties of max/min heap. This method will heapify the tree to min heap or max heap as defined. It takes 3 paramters
    - **arr[]** → which array/tree to heapify
    - **int index** → from which index should it begin to heapify
    - **int size** → till what size should it heapify the tree
- Suppose we have any array with some elements. For any node that we select, we check with its left child and right child and find the smallest/largest of the three.
- If the selected node itself is the smallest/largest, then it is at the right position and we do not need to heapify the tree. But if it is not, then swap it with the smaller/larger child. After swapping, we repeat the process until the selected is at its right position
- Now if we do this for every node, we will have a min/max heap.

**MIN HEAPIFY**

```java
void min_heapify (int[] arr, int index, int size){
    int left  = 2*index; // left child
    int right = 2*index+1; // right child
    int smallest;
	
	//compare with left child and find the smaller of them
    if(left <= size && arr[left] < arr[index] )
         smallest = left;
    else
        smallest = index;
		
	//compare the smaller node with the right child and find the smallest
    if(right <= size && arr[right] < arr[smallest] )
        smallest = right;
		
	//if the selected node itself is smallest 
	// then it is at the right position and we do not need to process further.
    if(smallest != index){
        swap (index, smallest]);
        min_heapify (arr, smallest, size);
    } 
}
```

**MAX HEAPIFY**

```java
void max_heapify(int arr[] , int index, int size){
    int left  = 2*index; // left child
    int right = 2*index+1; // right child
    int largest;
		
    if(left <= size && arr[left] > arr[index] )
         largest = left;
    else
        largest = index;

    if(right <= size && arr[right] > arr[largest] )
        largest = right;

    if(largest != index){
        swap (index, largest);
        max_heapify (arr, largest, size);
    } 
}
```

💡 **TIME COMPLEXITY:**

For an element to be placed at its right position, it will check with its parent and sibling and then swap if it is the smallest of the three. At most, any element at level $‘l’$ will make $‘l’$ swaps where $l$ = number of levels.

- Now, maximum of nodes, n,  at any level, l, in a binary tree can be given by: $n = 2^l$.
- Taking Log on both sides, we get, $Logn = Log (2^l)$
- $Logn = lLog(2)$
- $Logn / Log 2 = l$ ⇒ $Log{_2}{n} = l$.
- Hence, the **time complexity to heapify any element at level $‘l’$ is $O(Logn)$**

### 5. **buildHeap() → to build a min/max heap of any given array → O(nLogn)**

---

- We have an array to store N elements indexed from 1 to N. They are currently not following the property of min/max heap. So we can use `min_heapify() / max_heapify()`function to make a min/max heap out of the array.
- Now we know that by using `min_heapify() / max_heapify()`, we can adjust a node of the heap array to its correct position. In order for the whole array to satisfy the min/max heap properties, we have to `min_heapify() / max_heapify()` every node to place it in its correct position.
- If we start from `index=1` , then we start from the first element and adjust it and we do this till the last element including leaf nodes. But, if you observe carefully, you will find that as you adjust the nodes from top to bottom, the leaf nodes are automatically placed at their right positons. Another way to think is that the leaf nodes have no children to compare themselves with. They have already been compared with their parents and have been adjusted accordingly. Hence, we only need to check till the level above leaf nodes.
- A N element array will have leaves indexed from N/2+1, N/2+2 , N/2+3 …. upto N. Hence, we ony have to iterate `min_heapify() / max_heapify()` from `index=1` to `index=N/2`.
    
    
    ![heap leaf nodes](https://user-images.githubusercontent.com/22317530/187022358-71378584-2572-4cdd-a7ee-1a32beec315f.png)
    

**BUILD MIN HEAP**

```java
void build_minheap(int[] arr){
	//set the size of the heap
	this.size = arr.length-1;

	for( int i=1 ; i <= size/2 ; i++)
		min_heapify (arr, i, size);

	this.heap = arr;
}
```

**BUILD MAX HEAP**

```java
void build_maxheap (int[] arr){
	
	this.size = arr.length-1;

	for(int i = size/2 ; i >= 1 ; i-- )
        max_heapify (heap, i, size) ;

	this.heap = arr;
}
```
>💡 **TIME COMPLEXITY:**

To heapify an element, it takes O(Logn) time. Thus, **to heapify ‘n’ elements it will take O(nLogn) time.**
