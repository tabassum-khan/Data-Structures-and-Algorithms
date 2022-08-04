# Array

## Introduction

- The variables in the array are ordered and each have an index beginning from 0. 

- Java array can be also be used as a static field, a local variable or a method parameter. 

- The size of an array must be specified by an int value.

- Multidimensional arrays are arrays of arrays with each element of the array holding the reference of other array. These are also known as Jagged Arrays.

- Memory Allocation:
	- In case of primitives data types, the actual values are stored in contiguous memory locations. 
	- In case of creation of objects (by new) , the actual objects are stored in heap segment. Since all arrays are objects in Java,  they are dynamically allocated. 


## Design and Implementation

**1. Declaring Array** - only a reference is created in Java
```
int arr[];
```

**2. Defining Array** - allocates memory to array
```
int arr = new int[20];
```

**3. Literal Array**
```
int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
```

**4. Declaring and Defining 2D Array**
```
int[][] intArray = new int[10][20];
```

**5. Cloning Array in Java**
```
int cloneArray[] = arr.clone();
```

**6. Looping over an Array**
```
for(int i=0; i<arr.length; i++){
	System.out.println(arr[i]);
```

## [Problems to Solve](https://www.notion.so/Array-6bc9e449e7f64d18a3265dd75ef5789a)
	
