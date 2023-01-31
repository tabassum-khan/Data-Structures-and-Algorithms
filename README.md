# Data Structures and Algorithms in Java

This is a complete guide to Interview Preparation. This repository entails some of the most frequently asked Data Structures and Algorithms. It contains the theory as well as popular problems from LeetCode and Cracking the Coding Interview Book. 

This may also help, if you're a computer science student who needs to prepare for exams -- or if you're a self-taught programmer who wants to brush up on the theory behind your craft -- this repository will definitely help!

😍 Suggestions and contributions are welcome! 😍

<br/>

### **💡 How to use this repository?**
>
> The respository can be cloned or be downloaded as a zip file.
>
> Or
> 
> You can choose to go through the topics on GitHub itself or if you are feeling a bit fancy, you can easily access the whole [Data Structure and Algorithms Database](https://www.notion.so/Data-Structure-and-Algorithms-2de89667a1854d9698ea81be51496b40) on [Notion](https://www.notion.so/desktop).


<br/>

### **💡 Important Resources**

>The resources listed below have helped me immensely through this journey.
>
> - [GeeksforGeeks Gate Syllabus for Data Structures and Algorithms](https://www.geeksforgeeks.org/gate-cs-notes-gq/) --> Section 3: Algorithms, Section 4: Programming and Data Structures
>
> - HackerEarth Tutorials and Problems:
> 
>     - [Basic Programming](https://www.hackerearth.com/practice/basic-programming/). 
>     - [Data Structure](https://www.hackerearth.com/practice/data-structures/).
>     - [Algorithm](https://www.hackerearth.com/practice/algorithms/).
> - Youtube Links:
>
>     - [Algorithm Tutorials by Abdul Bari](https://youtu.be/0IAPZzGSbME). 
>     - [My Code School Data Structure Tutorial](https://youtu.be/92S4zgXN17o).
>     
<br/>


# Data Structures

### Linear Data Structures

- [Array](/array/)
- [Linked List](/linkedList/)
- [String](/String/)
- [Stack](/stacks/). Last In First Out (LIFO)
- [Queues](/queues/). First In First Out (FIFO)
    - [Circular Queue](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/queues/CircularQueue.java).
    - [Priority Queue](queues/priority_queues.md)


### Hierarchial Data Structures

- [Tree](/trees). Introduction to Trees
    - [Binary Tree](trees/binary_tree.md). A tree where each node has at most two children
    - [Binary Search Tree(BST)](trees/binary_search_tree.md). A binary tree that orders its nodes in a way that allows for fast queries
    - [Heap](trees/heap.md). A binary tree stored in an array, so it doesn't use pointers. Makes a great priority queue
    - [Trie](trees/trie.md). A special type of tree used to store associative data structures


- [Graph](/graphs). Introduction to Graphs.
    - [BFS and DFS](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/graphs/BFS_DFS.java).
    - [Graph using Adajcency List](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/graphs/AdjacencyList.java).
    - [Graph using HashSets](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/graphs/Graph_SetsandHash.java).

### Hashing

- [Hashing and HashTable Introduction](/hashing/).

<br/>

# Algorithms

Different problems require the use of different kinds of techniques. A good programmer uses all these techniques based on the type of problem. Some commonly-used techniques are:

1. Divide and conquer
2. Randomized algorithms
3. Greedy algorithms
4. Dynamic programming
5. Recursion


### Sorting
1. Basic Sorts
    - [Insertion Sort]()
    - [Bubble Sort]()
    - [Selection Sort]()
2. Fast Sorts
    - [Merge Sort]()
    - [Quick Sort]()
    - [Hoare Quick Sort]()
    - [Heap Sort](sorting/heap_sort.md)
  
3. Special Purpose Sorts
    - [Counting Sort]()
    - [Radix Sort]()



### Searching

- [Linear Search](). Find an element in an array.
- [Binary Search](). Quickly find elements in a sorted array.
- [k-th Largest Element](). Find the k-th largest element in an array, such as the median.
- String Search
    - [Brute-Force String Search](). A naive method.
    - [Boyer-Moore](). A fast method to search for substrings. It skips ahead based on a look-up table, to avoid looking at every character in the text.


### Backtracking

- [Knights Tour]().
- [N Queens]().
- [Rat in a Maze]().
- [Subset Sum]().


### Greedy Algorithm

- [Introduction](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/tree/master/greedyAlgo).
- [Activity Selection Problem](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/activity_selection.md).
- [Job Sequencing](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/job_sequencing.md).
- [Job Sequencing - Loss Minimisation](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/job_sequencing_loss_minimisation.md).
- [Optimal Merge Pattern](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/optimal_merge_pattern.md).
- [Huffman Coding](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/huffman_coding.md).
- [Fractional Knapsack](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/fractional_knapsack.md).
- [Egyptian Fraction](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/egyptian_fraction.md).
- [Bracket Balancing](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/greedyAlgo/bracket_balancing.md).

<br/>

# Useful Information

### Big O Notation

Big O notation is used to classify algorithms according to how their running time or space requirements grow as the input size grows. On the chart below you may find most common orders of growth of algorithms specified in Big O notation.

![Big-O Graph](/assets/big-o-graph.png)

Source: [Big O Cheat Sheet](https://www.bigocheatsheet.com/).

<br/>

Below is the list of some of the most used Big O notations and their performance comparisons against different sizes of the input data.

| Big O Notation | Computations for 10 elements | Computations for 100 elements | Computations for 1000 elements  |
| -------------- | ---------------------------- | ----------------------------- | ------------------------------- |
| **O(1)**       | 1                            | 1                             | 1                               |
| **O(log N)**   | 3                            | 6                             | 9                               |
| **O(N)**       | 10                           | 100                           | 1000                            |
| **O(N log N)** | 30                           | 600                           | 9000                            |
| **O(N^2)**     | 100                          | 10000                         | 1000000                         |
| **O(2^N)**     | 1024                         | 1.26e+29                      | 1.07e+301                       |
| **O(N!)**      | 3628800                      | 9.3e+157                      | 4.02e+2567                      |

<br/>

### Data Structure Operations Complexity

| Data Structure          | Access    | Search    | Insertion | Deletion  | Comments  |
| ----------------------- | :-------: | :-------: | :-------: | :-------: | :-------- |
| **Array**               | 1         | n         | n         | n         |           |
| **Stack**               | n         | n         | 1         | 1         |           |
| **Queue**               | n         | n         | 1         | 1         |           |
| **Linked List**         | n         | n         | 1         | n         |           |
| **Hash Table**          | -         | n         | n         | n         | In case of perfect hash function costs would be O(1) |
| **Binary Search Tree**  | n         | n         | n         | n         | In case of balanced tree costs would be O(log(n)) |
| **B-Tree**              | log(n)    | log(n)    | log(n)    | log(n)    |           |
| **Red-Black Tree**      | log(n)    | log(n)    | log(n)    | log(n)    |           |
| **AVL Tree**            | log(n)    | log(n)    | log(n)    | log(n)    |           |
| **Bloom Filter**        | -         | 1         | 1         | -         | False positives are possible while searching |

<br/>

### Array Sorting Algorithms Complexity

| Name                  | Best            | Average             | Worst               | Memory    | Stable    | Comments  |
| --------------------- | :-------------: | :-----------------: | :-----------------: | :-------: | :-------: | :-------- |
| **Bubble sort**       | n               | n<sup>2</sup>       | n<sup>2</sup>       | 1         | Yes       |           |
| **Insertion sort**    | n               | n<sup>2</sup>       | n<sup>2</sup>       | 1         | Yes       |           |
| **Selection sort**    | n<sup>2</sup>   | n<sup>2</sup>       | n<sup>2</sup>       | 1         | No        |           |
| **Heap sort**         | n&nbsp;log(n)   | n&nbsp;log(n)       | n&nbsp;log(n)       | 1         | No        |           |
| **Merge sort**        | n&nbsp;log(n)   | n&nbsp;log(n)       | n&nbsp;log(n)       | n         | Yes       |           |
| **Quick sort**        | n&nbsp;log(n)   | n&nbsp;log(n)       | n<sup>2</sup>       | log(n)    | No        | Quicksort is usually done in-place with O(log(n)) stack space |
| **Shell sort**        | n&nbsp;log(n)   | depends on gap sequence   | n&nbsp;(log(n))<sup>2</sup>  | 1         | No         |           |
| **Counting sort**     | n + r           | n + r               | n + r               | n + r     | Yes       | r - biggest number in array |
| **Radix sort**        | n * k           | n * k               | n * k               | n + k     | Yes       | k - length of longest key |
