# Linked List
>💡 On Notion → [Linked List](https://www.notion.so/Linked-List-bc9221877bd44197a47325290b1c6dcb)
>
## Introduction

- A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations.. The elements in a linked list are linked using pointers.

![Singly Linked List](https://user-images.githubusercontent.com/22317530/186352508-8de94f9a-36e3-4d36-9cb2-92eab9e2966a.png)


- **Advantages over arrays:**
    - Dynamic size
    - Ease of insertion/deletion
- **Drawbacks:**
    - Random access is not allowed.
    - Extra memory for pointers.
    - Not cache friendly.



## Design and Implementation of Singly Linked List

**1. Creation**

```java
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

```java
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

```java
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

```java
public void printList(Node head){ 
    Node tnode = head; 
    while (tnode != null) 
    { 
       System.out.print(tnode.data+" "); 
       tnode = tnode.next; 
    } 
}
```

## Problems to Solve
>💡 On Notion → [Problems on Linked List](https://www.notion.so/3be9e3ea14374f51ac05b69ee78f4b7c)

#### EASY
[1. Reverse a Linked List](https://www.notion.so/Reverse-a-Linked-List-7ebc6aece981432c816449f8c1c8458d)

[2. Detect a cycle in a Linked List](https://www.notion.so/Detect-a-cycle-in-a-Linked-List-26eb374edceb4c3da11ae9ac54f08280)

[3. Merge Two Sorted Lists](https://www.notion.so/Merge-Two-Sorted-Lists-4a84f64816aa47c4a4b648933e83b889)


#### MEDIUM
[4. Remove Nth Node From End of List](https://www.notion.so/Remove-Nth-Node-From-End-of-List-6b2592c26c6f47378e99fefe225e7e0f)

[5. Reorder List](https://www.notion.so/Reorder-List-9aadf4247afc44d19e9eb595507ea6a2)


#### HARD

[6. Merge K Sorted Lists](https://www.notion.so/Merge-K-Sorted-Lists-d7ff29f09c7441a892732f3b59779c23)
