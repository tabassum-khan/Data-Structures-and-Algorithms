# Heap

## Introduction

- A heap is a specific tree based data structure in which all the nodes of tree are in a specific order. They are hierarchical data structure.
- The maximum number of children of a node in the heap depends on the type of heap. However in the more commonly used heap type, there are at most 2 children of a note and it's known as a Binary heap.- 
- In binary heap, if the heap is a complete binary tree with N nodes, then it has has smallest possible height which is logN .

- #### There can be two types of heap:
    - **Max Heap:**
      > In this type of heap, the value of parent node will always be greater than or equal to the value of child node across the tree and the node with highest value will be the root node of the tree.
    - **Min Heap:**
      > In this type of heap, the value of parent node will always be less than or equal to the value of child node across the tree and the node with lowest value will be the root node of tree.

- A min heap and max heap can be seen in the following figure:

![Heap Image](/assets/heap.png)

### Binary Heap


A Binary Heap is a Binary Tree with following properties:

1) **It’s a complete tree** (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.

2) **A Binary Heap is either Min Heap or Max Heap**. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.

- A Binary is typically represented as an array. The root element will be at Arr[0]. The relationship between the elements of the heap can be represented as:

    > ###### Note : The indexing starts from 1 and not 0 to make indexing easier. 
    > 
    > 1. Left child : **2*i**
    > 
    > 2. Right child : **2*i + 1**
    > 
    > 3. Parent : **i/2**
  
  
- #### Applications:

1.	Heap Sort
2.	Priority  Queue


## Design and Implementation

### Max Heap

- **Time Complexity to heapify: O(log N)**

- **Time Complexity to build heap: O(N)**

```
void max_heapify (int Arr[ ], int i, int N)
{
    int left = 2*i               //left child
    int right = 2*i +1           //right child
    
    if(left<= N and Arr[left] > Arr[i] )
          largest = left;
    else
         largest = i;
 
    if(right <= N and Arr[right] > Arr[largest] )
        largest = right;
    
    if(largest != i )
    {
        swap (Ar[i] , Arr[largest]);
        max_heapify (Arr, largest,N);
    } 
 }
 
 /*** Start to build the heap from the bottom and since leaf nodes do not have any children, we can ignore them. 
      Leaf nodes being N/2, the function runs in linear time 
 ***/

void build_maxheap (int Arr[ ])
{
    for(int i = N/2 ; i >= 1 ; i-- )
    {
        max_heapify (Arr, i, N) ;
    }
}
```

### Min Heap

- **Time Complexity to heapify: O(log N)**

- **Time Complexity to build heap: O(N)**

```
void min_heapify (int Arr[ ] , int i, int N)
{
    int left  = 2*i;
    int right = 2*i+1;
    int smallest;

    if(left <= N and Arr[left] < Arr[ i ] )
         smallest = left;
    else
        smallest = i;

    if(right <= N and Arr[right] < Arr[smallest] )
        smallest = right;

    if(smallest != i)
    {
        swap (Arr[ i ], Arr[ smallest ]);
        min_heapify (Arr, smallest,N);
    } 
}

 
 /*** Start to build the heap from the bottom and since leaf nodes do not have any children, we can ignore them. 
      Leaf nodes being N/2, the function runs in linear time 
 ***/

void build_minheap (int Arr[ ]) 
{
    for( int i = N/2 ; i >= 1 ; i--)
    min_heapify (Arr, i, N);
}
```

### Insertion

```
void insertNode(int arr[], int& n, int Key) 
{ 
    // Increase the size of Heap by 1 
    n = n + 1; 
  
    // Insert the element at end of Heap 
    arr[n - 1] = Key; 
  
    // Heapify the new node following a 
    // Bottom-up approach 
    min_heapify(arr, n, n - 1); 
}
```

### Deletion

```
static int deleteRoot(int arr[], int n) 
{ 
    // Get the last element 
    int lastElement = arr[n - 1]; 
  
    // Replace root with first element 
    arr[0] = lastElement; 
  
    // Decrease size of heap by 1 
    n = n - 1; 
  
    // heapify the root node 
    min_heapify(arr, n, 0); 
  
    // return new size of Heap 
    return n; 
}
```

## Applications
1. [Heap Sort](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/tree/master/trees.heap_sort.md)
2. [Priority Queues](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/queues/priority_queues.md)

