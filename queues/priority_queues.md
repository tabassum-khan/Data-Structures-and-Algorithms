# Priority Queues

##### Pre-requisites: [Heaps]()

## Introduction

- Priority Queue is similar to queue where we insert an element from the back and remove an element from front, but with a one difference that the logical order of elements in the priority queue depends on the priority of the elements.

- The element with highest priority will be moved to the front of the queue and one with lowest priority will move to the back of the queue.

- Thus it is possible that when you enqueue an element at the back in the queue, it can move to front because of its highest priority.

- Priority Queue is an extension of queue with following properties.

    1. Every item has a priority associated with it.
    2. An element with high priority is dequeued before an element with low priority.
    3. If two elements have the same priority, they are served according to their order in the queue.
    
> Example: 
>
> Let’s say we have an array of 5 elements : {4, 8, 1, 7, 3} and we have to insert all the elements in the max-priority queue.
>
> First as the priority queue is empty, so 4 will be inserted initially.
> 
> Now when 8 will be inserted it will moved to front as 8 is greater than 4.
> 
> While inserting 1, as it is the current minimum element in the priority queue, it will remain in the back of priority queue.
> 
> Now 7 will be inserted between 8 and 4 as 7 is smaller than 8.
> 
> Now 3 will be inserted before 1 as it is the 2nd minimum element in the priority queue. 
> 
> All the steps are represented in the diagram below:

![Priority Queue Image](/assets/priority_queue.jpg)


## Design and Implementation

- We can use heaps to implement the priority queue. It will take O(log N) time to insert and delete each element in the priority queue.

- Based on heap structure, priority queue also has two types max- priority queue and min - priority queue.

- A typical priority queue supports following operations.
    - **insert(item, priority):** Inserts an item with given priority.
    - **extractMaximum():** Returns the highest priority item.
    - **deleteMaximum():** Removes the highest priority item.
    
### Insert

```
void increase_value (int Arr[ ], int i, int val)
{
    if(val < Arr[ i ])
         return;

//insert at the end of the heap
    Arr[ i ] = val;

    while( i > 1 and Arr[ i/2 ] < Arr[ i ])
    {
        swap|(Arr[ i/2 ], Arr[ i ]);
        i = i/2;
    }
}


void insert_value (int Arr[ ], int val)
{
//Increase heap_size; 
    length = length + 1;

//assuming all the numbers greater than 0 are to be inserted in queue.
    Arr[ length ] = -1;  

    increase_val (Arr, length, val);
}
```

### Extract Maximum

```
int extract_maximum (int Arr[ ])
{
//if priority queue is empty
    if(length == 0)
           return -1;
    
//Extract the first element.
    int max = Arr[1];
    
    return max;
}
```

### Delete Maximum

```
int delete_maximum (int Arr[ ])
{
//if priority queue is empty
    if(length == 0)
           return -1;
    
//Extract the first element and replace the first element with the last element.
    int max = Arr[1];
    Arr[1] = Arr[length];

//Decrease the heap size
    length = length -1;

//Perform max_heap ify with the last element placed at  index 1;
    max_heapify(Arr, 1, length);

    return max;
}
```




