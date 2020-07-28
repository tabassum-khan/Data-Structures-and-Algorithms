# Trie

## Introduction

- Tries are an extremely special and useful data-structure that are based on the prefix of a string. They are used to represent the “Retrieval” of data and thus the name Trie.

- #### Prefix : What is prefix?

  > The prefix of a string is nothing but any  letters  that can be considered beginning strictly from the starting of a string. For example , the word “abacaba” has the following prefixes:

  > a
  >
  > ab
  >
  > aba
  >
  > abac
  > 
  > abaca
  > 
  > abacab

- A Trie is a special data structure used to store strings that can be visualized like a graph. It consists of nodes and edges.
- Each node consists of at max 26 children and edges connect each parent node to its children. 
- These 26 pointers are nothing but pointers for each of the 26 letters of the English alphabet A separate edge is maintained for every edge.

- Strings are stored in a top to bottom manner on the basis of their prefix in a trie. 
- All prefixes of length 1 are stored at until level 1, all prefixes of length 2 are sorted at until level 2 and so on.

- A trie is depicted in the following picture:

![Trie Image](/assets/trie.jpg)

## Design and Implementation

### Insertion

- The insertion of any string into a Trie starts from the root node. All prefixes of length one are direct children of the root node. 
- In addition, all prefixes of length 2 become children of the nodes existing at level one.

```
void insert(String s)
{
    for(every char in string s)
    {
        if(child node belonging to current char is null)
        {
            child node=new Node();
        }
        current_node=child_node;
    }
}
```

### Check if a word exists in a trie or not

```
boolean check(String s)
{
    for(every char in String s)
    {
        if(child node is null)    
        {
            return false;
        }
    }
    return true;
}
```

Full implementation of trie can be seen [here](https://github.com/tabassum-khan/Data-Structures-and-Algorithms/blob/master/trees/Trie.java)
