# Stack

## Introduction

- Stack is a linear data structure which follows a particular order in which the operations are performed. The order may be **LIFO(Last In First Out) or FILO(First In Last Out)**. 
- **Basic Operations:**
    - push()
    - pop()     
    - peek() or top()   
    - isEmpty()


## Design and Implementation

**1. Creation** - creating stack class and initialising the constructor.
```
class Stack { 
    static final int MAX = 1000; 
    int top; 
    int a[] = new int[MAX]; 
    Stack(){
      top = -1;
    } 
    boolean isEmpty(){ 
      return (top < 0);   
    }
}
```

**2. Insertion** - method to push the elements onto the stack
```
boolean push(int x){ 
    if (top >= (MAX - 1)) { 
      System.out.println("Stack Overflow"); 
      return false; 
    } 
    else{ 
      a[++top] = x; 
      System.out.println(x + " pushed into stack"); 
      return true; 
    }
}
```

**3. Deletion** - method to pop elements from the stack
```
int pop()     { 
    if (top < 0) { 
      System.out.println("Stack Underflow"); 
      return 0; 
    } 
    else{ 
      int x = a[top--]; 
      return x; 
    } 
}   
```

**4. Access top element** - method to access the top element on the stack
```
int peek(){ 
    if (top < 0) { 
      Stack Underflow"; 
      return 0; 
    } 
    else{ 
      int x = a[top]; 
      return x; 
    }
} 
```
	
