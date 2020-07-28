# Heap Sort

## Introduction

- Heap sort is a comparison based sorting technique based on Binary Heap data structure. 
- It is similar to selection sort where we first find the maximum element and place the maximum element at the end. We repeat the same process for remaining element.
- We can use heaps in sorting the elements in a specific order in efficient time.
- We build the max heap of elements stored in Arr, and the maximum element of Arr will always be at the root of the heap.


## Design and Implementation

1) Initially, build a max heap/min heap of elements in Arr.
2) Now the root element i.e. arr[1] contains maximum/minimum element of the arr depending of the heap built. Store it in a variable.
3) Replace the first element with the last element of the array. Reduce the size of the heap. Max Heapify/Min Heapify excluding the last element.

```
void heap_sort(int Arr[ ])
{
    int heap_size = N;
    build_maxheap(Arr);
    for(int i = N; i>=2 ; i-- )
    {
        swap|(Arr[ 1 ], Arr[ i ]);
        heap_size = heap_size-1;
        max_heapify(Arr, 1, heap_size);
    }
}
```

- Full Implementation of heap sort with max heapify can be found [here](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/trees/HeapSort.java).
