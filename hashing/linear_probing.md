#  Linear probing (open addressing or closed hashing)

## Introduction

- In open addressing, instead of in linked lists, all entry records are stored in the array itself. When a new entry has to be inserted, the hash index of the hashed value is computed and then the array is examined (starting with the hashed index). If the slot at the hashed index is unoccupied, then the entry record is inserted in slot at the hashed index else it proceeds in some probe sequence until it finds an unoccupied slot.

- The probe sequence is the sequence that is followed while traversing through entries. In different probe sequences, you can have different intervals between successive entry slots or probes.

- When searching for an entry, the array is scanned in the same sequence until either the target element is found or an unused slot is found. This indicates that there is no such key in the table. The name "open addressing" refers to the fact that the location or address of the item is not determined by its hash value.

- Linear probing is when the interval between successive probes is fixed (usually to 1). Let’s assume that the hashed index for a particular entry is index. The probing sequence for linear probing will be:

    > index = index % hashTableSize
    >
    >
    > index = (index + 1) % hashTableSize
    > 
    > index = (index + 2) % hashTableSize
    > 
    > index = (index + 3) % hashTableSize
    > 
    > and so on…


### Assumption:

1. There are no more than 20 elements in the data set.
2. Hash function will return an integer from 0 to 19.
3. Data set must have unique elements.
```
    string hashTable[21];
    int hashTableSize = 21;
````

### Insert:
```
   void insert(string s)
    {
        //Compute the index using the hash function
          int index = hashFunc(s);
        
        //Search for an unused slot and if the index will exceed the hashTableSize then roll back
          while(hashTable[index] != "")
              index = (index + 1) % hashTableSize;
  
          hashTable[index] = s;
    }
```

### Search:
```
   void search(string s)
    {
        //Compute the index using the hash function
          int index = hashFunc(s);
        
        //Search for an unused slot and if the index will exceed the hashTableSize then roll back
          while(hashTable[index] != s and hashTable[index] != "")
              index = (index + 1) % hashTableSize;
        
        //Check if the element is present in the hash table
          if(hashTable[index] == s)
              cout << s << " is found!" << endl;
          else
              cout << s << " is not found!" << endl;
    }
```
