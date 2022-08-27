# **Array**
>💡 On Notion → [Array](https://www.notion.so/Array-28832f88e843450499bcfcda674fd0ac)

## **Introduction**

- **The variables in the array are ordered (contiguous), having an index beginning from 0.**
- Java array can be also be used as a static field, a local variable or a method parameter.
- The **array size** must be an integer constant, greater than zero.
- Multidimensional arrays are arrays of arrays with each element of the array holding the reference of the other array. These are also known as Jagged Arrays.
- **Memory Allocation:**
    - In case of primitives data types, the actual values are stored in contiguous memory locations.
    - In case of creation of objects (by `new`) , the actual objects are stored in heap segment. Since all arrays are objects in Java, they are allocated in the heap memory of JVM.
        
        *(For more insights on Java Memory Allocation → [Memory Allocation in Java](https://www.notion.so/Memory-Allocation-in-Java-c45580c5299e4264bbabb45daad32e77))*
        
    - The memory isn’t allocated to an object at declaration( `int[] arr` ) but only a reference is created. For the memory allocation of the object, `new` is used, so the object is allocated memory on the heap (`int[] arr = new int[20];`).



## **Design and Implementation**

**1. Declaring Array** - only a reference is created in Java
```java
int arr[];
```

**2. Defining Array** - allocates memory to array
```java
int arr = new int[20];
```

**3. Literal Array**
```java
int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
```

**4. Declaring and Defining 2D Array**
```java
int[][] intArray = new int[10][20];
```

**5. Cloning Array in Java**
```java
int cloneArray[] = arr.clone();
```

**6. Looping over an Array**
```java
for(int i=0; i<arr.length; i++){
	System.out.println(arr[i]);
```

**7. Removing an Element from an Array**
```java
int[] arr = new int[]{1,3,3,4,5};
 ArrayList<Integer> arr_new = new ArrayList<Integer>();
 for (int i : arr){
     arr_new.add(i);
 }
 arr_new.remove(3);
```

**8. Deleting an Array**
```java
arr = null;
```

## Problems to Solve
>💡 On Notion → [Problems on Array](https://www.notion.so/957105dbc51f437da69690edb7313113?v=839ff4599fd647d1a9b6405f01df84bb)


#### EASY
[1. Two Sum](https://www.notion.so/Two-Sum-7de5bfc6a9e84770815a15a7baba705b)

[2. Contains Duplicate](https://www.notion.so/Contains-Duplicate-7ef46634b4f841c19fac5e9a8d69caa9)

[3. Best Time to Buy and Sell Stock](https://www.notion.so/Best-Time-to-Buy-and-Sell-Stock-56915dac97ec48cbb2ee22ba7040a10b)


#### MEDIUM
[4. Product of Array Except Self](https://www.notion.so/Product-of-Array-Except-Self-e283fe836436453eb09d84f20b46462d)

[5. Maximum Subarray](https://www.notion.so/Maximum-Subarray-3647ae03bc8044549bdab2b620a6a5bc)

[6. Maximum Product Subarray](https://www.notion.so/Maximum-Product-Subarray-1fae2d4d08c241048832eaee34aeae20)

[7. Find Minimum in Rotated Sorted Array](https://www.notion.so/Find-Minimum-in-Rotated-Sorted-Array-416dd008f8814372a13bac78e6e86143)

[8. Search in Rotated Sorted Array](https://www.notion.so/Search-in-Rotated-Sorted-Array-258d20b0976f474caced006eb066da6a)

[9. 3Sum](https://www.notion.so/3Sum-0dba4ccb414c4cfe994d182cbfef8fd8)

[10. Container With Most Water](https://www.notion.so/Container-With-Most-Water-2b9035c70624491599f4161452f38307)
	
