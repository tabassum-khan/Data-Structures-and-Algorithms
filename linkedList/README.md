# Linked List

## Introduction

- A linked list is a linear data structure, in which the elements are dynamically allocated. The elements in a linked list are linked using pointers.
- **Advantages over arrays:**
    - Dynamic size
    - Ease of insertion/deletion
- **Drawbacks:**
    - Random access is not allowed.
    - Extra memory for pointers.  
    - Not cache friendly.



## Design and Implementation of Singly Linked List

**1. Creation**
```
class LinkedList { 
    Node head; 
    class Node { 
        int data; 
        Node next;  
        Node(int d) {
	          data = d; 
        } 
    } 
}
```

**2. Insertion** 
```
public void push(int new_data) { 
        Node new_node = new Node(new_data); 
        new_node.next = head; 
        head = new_node; 
} 
```

**3. Deletion**
```
public void deleteNode(){
    /*
    Allotting 2 pointers:
    prev  --> will traverse the list
    temp  --> will delete the node 
    */

    //Traverse the list until we find the data or position
    prev  = head;
    while(temp!=null && temp.data != key){
         prev  = temp;
         temp = temp.next;
    }

    //Unlink the node to be del
    If (temp.data!=null){
         prev.next = temp.next;
    }
    else{
          "Not found";
    }
}
```

**4. Traversal**
```
public void printList(){ 
        Node tnode = head; 
        while (tnode != null) 
        { 
            System.out.print(tnode.data+" "); 
            tnode = tnode.next; 
        } 
} 
```
	
