# Recursion

## Introduction

- Recursion is a process in which a function calls itself directly or indirectly. Recursion break down a complex problem into smaller subproblems to make it easier and simpler.
- A recursive function has a:
  - **Base case:** The function keeps calling itself until the base condition is true and the execution stops. The function returns to the previous stack. A recursive function can have multiple base cases.
  - **Recursive case:** The function calls itself and also has some code.
      
- Example:
 ```
int fact(int n){
    if (n < = 1) // base case
        return 1;
    else    
        return n*fact(n-1); // recursive case 
}
```

## How recursive problems can be identified?

Recursive problems follow these 6 general patterns: 

1. **Iteration** - if the problem can be solved using iterative loops, then it can also be solved using recursion. 
2. **Breaking into Subproblems** - when problems can be broken down into smaller subproblems, eg: Tower of Hanoi.
3. **Selection (Combination)** - when problems require a series of selections or combinations of selections to be made, eg: NQueens, Knapsack.
4. **Ordering (Permutations)** - eg: Word Squares.
5. **Divide and Conquer** - eg: Binary Search Tree, O(logN) Sorting
6. **Depth First Search (DFS) or Breadth First Search (BFS)** - eg : Trees, Graphs.

## How memory is allocated to different function calls in recursion?

- When any function is called from main(), the memory is allocated to it on the stack. 
- When a recursive function calls itself, the memory for the called function is allocated on top of memory allocated to the calling function.
- Different copy of local variables is created for each function call. Thus, calling function and called fucntion will have different set of local variables.
- When the base case condition is met, the function returns its value to the caller and memory is de-allocated and the process continues.

- Let us take the example how recursion works by taking a simple function.
```
class GFG{ 
    static void printFun(int test) 
    { 
        if (test < 1) 
          return; 
        else
        { 
          System.out.printf("%d ",test); 
          printFun(test-1); // statement 2 
          System.out.printf("%d ",test); 
          return; 
        } 
    } 

    public static void main(String[] args) 
    { 
        int test = 3; 
        printFun(test); 
    } 
} 
```

> **Output:** 3 2 1 1 2 3

> **Explantion:**
>
> 1. When printFun(3) is called from main(), memory is allocated to printFun(3) and a local variable test is initialized to 3 and statement 1 to 4 are pushed on the stack as    shown in below diagram.
> 2. It first prints ‘3’. In statement 2, printFun(2) is called and memory is allocated to printFun(2) and a local variable test is initialized to 2 and statement 1 to 4 are pushed in the stack. 
> 3. Similarly, printFun(2) calls printFun(1) and printFun(1) calls printFun(0). printFun(0) goes to if statement and it return to printFun(1). 
> 4. Remaining statements of printFun(1) are executed and it returns to printFun(2) and so on. 
> 5. In the output, value from 3 to 1 are printed and then 1 to 3 are printed. 

**The memory stack has been shown in the diagram below:**

![Recursion Memory Stack](/assets/recursion_diag.jpg)
