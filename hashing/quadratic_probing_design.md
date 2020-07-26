# Quadratic Probing

## Introduction

- Quadratic probing is similar to linear probing and the only difference is the interval between successive probes or entry slots. Here, when the slot at a hashed index for an entry record is already occupied, you must start traversing until you find an unoccupied slot. The interval between slots is computed by adding the successive value of an arbitrary polynomial in the original hashed index.

- Let us assume that the hashed index for an entry is index and at index there is an occupied slot. The probe sequence will be as follows:
    
    > index = index % hashTableSize
    >
    > index = (index + 12) % hashTableSize
    > 
    > index = (index + 22) % hashTableSize
    > 
    > index = (index + 32) % hashTableSize
    > 
    > and so on…


### Assumption:

1. There are no more than 20 elements in the data set.
2. Hash function will return an integer from 0 to 19.
3. Data set must have unique elements.

```
    string hashTable[21];
    int hashTableSize = 21;
```

### Insert:
```
    void insert(string s)
    {
        //Compute the index using the hash function
            int index = hashFunc(s);
        
        //Search for an unused slot and if the index will exceed the hashTableSize roll back
            int h = 1;
        
            while(hashTable[index] != "")
            {
                index = (index + h*h) % hashTableSize;
                     h++;
            }
            
            hashTable[index] = s;
    }
```

### Search:
```
   vvoid search(string s)
    {
        //Compute the index using the Hash Function
            int index = hashFunc(s);
        
        //Search for an unused slot and if the index will exceed the hashTableSize roll back
            int h = 1;
        
            while(hashTable[index] != s and hashTable[index] != "")
            {
                index = (index + h*h) % hashTableSize;
                     h++;
            }
        
        //Is the element present in the hash table
            if(hashTable[index] == s)
                cout << s << " is found!" << endl;
            else
                cout << s << " is not found!" << endl;
    }
```
