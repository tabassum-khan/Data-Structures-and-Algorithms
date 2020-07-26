# Implementation of hash table with double hashing

## Introduction

- Double hashing is similar to linear probing and the only difference is the interval between successive probes. Here, the interval between probes is computed by using two hash functions.

- Let us say that the hashed index for an entry record is an index that is computed by one hashing function and the slot at that index is already occupied. You must start traversing in a specific probing sequence to look for an unoccupied slot. The probing sequence will be:

> index = (index + 1 * indexH) % hashTableSize;
> 
> index = (index + 2 * indexH) % hashTableSize;
>
> and so on…
>
> Here, indexH is the hash value that is computed by another hash function.


### Assumption:

1. There are no more than 20 elements in the data set.
2. Hash functions will return an integer from 0 to 19.
3. Data set must have unique elements.

```
    string hashTable[21];
    int hashTableSize = 21;
```

### Insert:
```
    void insert(string s)
    {
        //Compute the index using the hash function1
          int index = hashFunc1(s);
          int indexH = hashFunc2(s);
        
        //Search for an unused slot and if the index exceeds the hashTableSize roll back
          while(hashTable[index] != "")
              index = (index + indexH) % hashTableSize;
        
          hashTable[index] = s;
    }
```

### Search:
```
   void search(string s)
    {
        //Compute the index using the hash function
          int index = hashFunc1(s);
          int indexH = hashFunc2(s);
        
        //Search for an unused slot and if the index exceeds the hashTableSize roll back
          while(hashTable[index] != s and hashTable[index] != "")
              index = (index + indexH) % hashTableSize;
        
        //Is the element present in the hash table
          if(hashTable[index] == s)
              cout << s << " is found!" << endl;
          else
             cout << s << " is not found!" << endl;
    }
```
