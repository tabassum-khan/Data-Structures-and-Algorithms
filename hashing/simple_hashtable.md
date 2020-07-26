# HashTable Design and Implementation

## Implementing a simple hash table

- For implementing the hash table, let us assume that you have to store strings in the hash table by using the hashing technique {“abcdef”, “bcdefa”, “cdefab” , “defabc” }.

1. For that we require a Hash Table. A hash table is a data structure that is used to store keys/value pairs. Under reasonable assumptions, the average time required to search for an element in a hash table is O(1).
    > int Frequency[26];

2. Let us also apply hashing to this problem. Hashing fucntion will map data set of an arbitrary size to a data set of a fixed size.
    ```
       int hashFunc(char c)
      {
          return (c - ‘a’);
      }
    ```
    
- Here, we are taking an array frequency of size 26 as a hashtable and will hash the 26 characters with indices of the array by using the hash function. 
  Then, iterate over the string and increase the value in the frequency at the corresponding index for each character. 
  The complexity of this approach is O(N) where N is the size of the string.

```
    int Frequency[26];

    int hashFunc(char c)
    {
        return (c - ‘a’);
    }

    void countFre(string S)
    {
        for(int i = 0;i < S.length();++i)
        {
            int index = hashFunc(S[i]);
            Frequency[index]++;
        }
        for(int i = 0;i < 26;++i)
            cout << (char)(i+’a’) << ‘ ‘ << Frequency[i] << endl;
    }
```

```
Output: 
  a 2
  b 2
  c 1
  d 1
  e 0
  f 0
  …
  z 0
````


- But this simple program cannot handle collision techniques. We have already discussed various types of collision techniques in the Introductory read. Here, we will design and implement the code for all different types of collisin techniques.

1. [Separate chaining (open hashing)](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/hashing/separate_chaining.md)
2. [Linear probing (open addressing or closed hashing)](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/hashing/linear_probing.md)
3. [Quadratic Probing](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/hashing/quadratic_probing.md)
4. [Double hashing](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/hashing/double_hashing.md)
