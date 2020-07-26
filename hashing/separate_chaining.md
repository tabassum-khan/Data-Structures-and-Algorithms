# Implementation of hash tables with separate chaining (open hashing)

## Introduction

- Separate chaining is one of the most commonly used collision resolution techniques. It is usually implemented using linked lists. 
- In separate chaining, each element of the hash table is a linked list. To store an element in the hash table you must insert it into a specific linked list. 
- If there is any collision (i.e. two different elements have same hash value) then store both the elements in the same linked list.
- The cost of a lookup is that of scanning the entries of the selected linked list for the required key. 
If the distribution of the keys is sufficiently uniform, then the average cost of a lookup depends only on the average number of keys per linked list.
For this reason, chained hash tables remain effective even when the number of table entries (N) is much higher than the number of slots.

- For separate chaining, the worst-case scenario is when all the entries are inserted into the same linked list. The lookup procedure may have to scan all its entries, so the worst-case cost is proportional to the number (N) of entries in the table.

- Separate Chaining can be depicted by the following image:

![Seaparte Chaining Image](/assets/separate_chaining.png)

### Assumption:

Let us assume that the Hash function will return an integer from 0 to 19.
```
    vector <string> hashTable[20];
    int hashTableSize=20;
````

### Insert:
```
   void insert(string s)
    {
        // Compute the index using Hash Function
            int index = hashFunc(s);
            
        // Insert the element in the linked list at the particular index
            hashTable[index].push_back(s);
    }
```

### Search:
```
   void search(string s)
    {
        //Compute the index by using the hash function
          int index = hashFunc(s);
        
        //Search the linked list at that specific index
          for(int i = 0;i < hashTable[index].size();i++)
          {
              if(hashTable[index][i] == s)
              {
                  cout << s << " is found!" << endl;
                  return;
              }
          }
        
          cout << s << " is not found!" << endl;
    }
```
