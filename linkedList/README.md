# Linked List

## Introduction
>💡 On Notion → [Linked List](https://www.notion.so/Linked-List-eeff5bf5462d4c05896e98af41da2873)

- A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations.. The elements in a linked list are linked using pointers.

![Representation of Singly Linked List](https://www.notion.so/Linked-List-eeff5bf5462d4c05896e98af41da2873#c922c709c8144787be967a902262ad05)

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
	   this.data = d; 
	   this.next = null;
	} 
    } 
}
```

**2. Insertion**

```
public void push(Node head, int new_data) { 
//creating new node to store the new data
    Node new_node = new Node(new_data); 

//attach the new node to head
    new_node.next = head; 

//move head to start from new node
    head = new_node; 
}
```

**3. Deletion**

```
public void deleteNode(Node head, int key){
    /*
    Allotting 2 pointers:
    prev  --> will traverse the list
    temp  --> will delete the node 
    */

    //Traverse the list until we find the data or position
    Node prev = head, temp = head;
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
public void printList(Node head){ 
    Node tnode = head; 
    while (tnode != null) 
    { 
       System.out.print(tnode.data+" "); 
       tnode = tnode.next; 
    } 
}
```
