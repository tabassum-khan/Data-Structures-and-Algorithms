# Hash Table

## Introduction

### Hashing: 

- Hashing is an important Data Structure which is designed to use a special function called the Hash function which is used to map a given value with a particular key for faster access of elements.
- The efficiency of mapping depends  of the efficiency of the hash function used.

- Hashing is implemented in two steps: **( element => h(x) => key )**
    - An element is converted into an integer by using a hash function. This element can be used as an index to store the original element, which falls into the hash table.
    - The element is stored in the hash table where it can be quickly retrieved using hashed key.
      > hash = hashfunc(key)
      >
      > index = hash % array_size 

**| Key Space | ---> | Hash Function | ---> | Hash Table |**
> In hashing, large keys are converted into small keys by using hash functions. The values are then stored in a data structure called hash table. Each element is assigned a key (converted key). 

### Hash table : 

- A hash table is a data structure that is used to store keys/value pairs. 
- It uses a hash function to compute an index into an array in which an element will be inserted or searched.

##### [Design and Implementation of a simple hash table](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/hashing/simple_hashtable.md)

### Collision Resolution Techniques:

**1. Separate chaining (open hashing):**

In separate chaining, each element of the hash table is a linked list. To store an element in the hash table you must insert it into a specific linked list. If there is any collision (i.e. two different elements have same hash value) then store 	both the elements in the same linked list.

##### [Design and Implementation of Separate Chaining](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/hashing/separate_chaining.md)

**2. Linear probing (open addressing or closed hashing):**

If the slot at the hashed index is unoccupied, then the entry record is inserted in slot at the hashed index else it proceeds in some probe sequence until it finds an unoccupied slot.
The probe sequence is the sequence that is followed while traversing through entries. In different probe sequences, you can have different intervals between successive entry slots or probes.

> index = index % hashTableSize
>
> index = (index + 1) % hashTableSize
>
> index = (index + 2) % hashTableSize
>
> index = (index + 3) % hashTableSize


##### [Design and Implementation of Linear Probing](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/hashing/linear_probing.md)

**3. Quadratic Probing:**

Quadratic probing is similar to linear probing and the only difference is the interval between successive probes or entry slots. Here, when the slot at a hashed index for an entry record is already occupied, you must start traversing until you find an unoccupied slot.

> index = index % hashTableSize
>
> index = (index + 1^2) % hashTableSize
>
> index = (index + 2^2) % hashTableSize
> 
> index = (index + 3^2) % hashTableSize


##### [Design and Implementation of Quadratic Probing](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/hashing/quadratic_probing.md)


**4. Double Hashing:**

Double hashing is similar to linear probing and the only difference is the interval between successive probes. Here, the interval between probes is computed by using two hash functions.

> index = (index + 1 * indexH) % hashTableSize;
>
> index = (index + 2 * indexH) % hashTableSize;
>
> Here, indexH is the hash value that is computed by another hash function.


##### [Design and Implementation of Double Hashing](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/hashing/double_hashing.md)
