
# Heap Sort
>💡 On Notion → [Heap Sort](https://www.notion.so/Heap-Sort-23b8ab691f6b4214af65bf268a09256a)

## **Introduction**

- Heap Sort is one of the many applications of Binay Heap. It is a **comparison based sorting technique**.
- Heap sort is an in-place algorithm.
- Typically 2-3 times slower than well-implemented **[QuickSort](http://www.geeksforgeeks.org/quick-sort/)**.  The reason for slowness is a lack of locality of reference.

### **Advantages of heapsort:**

- **Efficiency –**  The time required to perform Heap sort increases logarithmically while other algorithms may grow exponentially slower as the number of items to sort increases. This sorting algorithm is very efficient.
- **Memory Usage –** Memory usage is minimal because apart from what is necessary to hold the initial list of items to be sorted, it needs no additional memory space to work
- **Simplicity –**  It is simpler to understand than other equally efficient sorting algorithms because it does not use advanced computer science concepts such as recursion

### **💡 Why is quick sort better than heap sort?**

> The heap sort algorithm has limited uses because Quicksort and Mergesort are better in practice. Nevertheless, the Heap data structure itself is enormously used.
> 
> The secret of Quicksort is: It almost doesn't do unnecessary element swaps. Swap is time consuming. With Heapsort, even if all of your data is already ordered, you are going to swap 100% of elements to order the array.
> 
> More on why Quick Sort is better than Heap Sort, refer to these links:
> 
> [Quicksort vs Heapsort on Baeldung](https://www.baeldung.com/cs/quicksort-vs-heapsort)
> 
> [Quicksort vs Heapsort on Stack Overflow](https://stackoverflow.com/questions/2467751/quicksort-vs-heapsort)

### **💡 Why is heap sort not stable?**
> Stable means if the two elements have the same key, they remain in the same order or positions. But that is not the case for Heap sort.
> 
> The final sequence of the results from heapsort comes from removing items from the created heap. Thus, any information about the ordering of the items in the original sequence was lost during the heap creation stage.
> 
> For more on this, refer to the below link:
> 
> [Why isn't Heapsort Stable? on Baeldung](https://www.baeldung.com/cs/why-isnt-heapsort-stable)

## **Design and Implementation**

> If we are going to implement heap sort, we will either implement a max heap or a min heap first.
> 
> To revise Min Heap and Max Heap implementation, refer the following → [**minHeapify()/maxHeapify()**](https://www.notion.so/4-minHeapify-maxHeapify-O-Logn-05f9c7294a21491f9af55b92be83a775)

Lets’s say we have an array of N elements and we want to sort it using Heap Sort algorithm. 

A simple heap sort implementation will look like this:

```java
public class HeapSort{
    private int[] heap;
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }
     
    public boolean isFull(){
        return size == heap.length-1;
    }
    
    public void swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    
    public int extractMax(){...}
    public max_heapify(int[] arr, int index, int size){...}
    public build_maxheap(int[] arr){..}
    public void sort(int[] arr);
}
```

### 1. **Build a binary heap: O(nLogn)**

---

First, we will have to build a max heap or a min heap of the array of N elements. Let’s consider max heap for the sake of this example. In the end, we will get an array that will follow max heap properties, i.e., all the parent nodes will be greater than their children nodes. 

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

```java
void build_maxheap(int[] arr){
	this.size = arr.length-1;
  
	for(int i = size/2 ; i >= 1 ; i-- )
	  max_heapify(heap, i, size) ;
	
  this.heap = arr;
}
```

### 2. **Extract the maximum element: extractMax() → O(Logn)**

---

Now, if the array follows the max heap properties, the maximum element will be stored at the root and extractMax() will do 3 things:

1. Return the maximum element at the root position
2. Replace the maximum element with the last element and decrease the heap size
3. Heapify the array to have a new maximum element at the root.
    
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
    
4. Place the maximum element at the last position. Here the last position is defined by size.
    
    ```java
    arr[size] = extractMax();
    ```
    

### 3. Sort the array → O(nLogn)

---

1. Now, we have to do the **second step for N-1 times to arrange all the elements in ascending order.** Now, extractMax() takes O(Logn) time. So, for ‘n’ elements, it will take O(nLogn) time. 
    
    ```java
    public void sort(int[] arr){
        //build max heap of arr
        build_maxheap(arr);	

        //extract the maximum element and store it at the last position
        for(int i=size; i>=2; i--)
            arr[size] = extractMax();	
    }
    ```
    

>💡 **Time Complexity to heap sort the array: O(nLogn).**
To build max heap of the array, it takes O(nLogn) time and to sort the max heap, it again takes O(nLogn) time.

---

## Example

We will take the following example to understand how heap sort works:

![array to max heap](https://user-images.githubusercontent.com/22317530/187023004-96e19245-a342-4ae6-8f2a-4cc0166d2c42.png)

**Processing:**

1. 8 is swapped with 5.
2. 8 is disconnected from heap as 8 is in correct position now and.
3. Max-heap is created and 7 is swapped with 3.
4. 7 is disconnected from heap.
5. Max heap is created and 5 is swapped with 1.
6. 5 is disconnected from heap.
7. Max heap is created and 4 is swapped with 3.
8. 4 is disconnected from heap.
9. Max heap is created and 3 is swapped with 1.
10. 3 is disconnected.

![heap sorting](https://user-images.githubusercontent.com/22317530/187023027-464512d3-1905-4826-b038-d17b8b61890e.png)

After all the steps, we will get a sorted array.

![sorted array](https://user-images.githubusercontent.com/22317530/187023036-988a24f6-7198-4749-9517-3b91c285b07b.png)
