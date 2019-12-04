package stacks;

import java.util.Scanner;

/* Java program to implement basic stack 
operations */
public class StackArray 
{ 
	static final int MAX = 1000; 
	int top; 
	int a[] = new int[MAX]; // Maximum size of Stack 
	
	//Initialize constructor
	StackArray() 
	{ 
		top = -1; 
	} 
	
	boolean isEmpty() 
	{ 
		return (top < 0); 
	} 
	
	boolean push(int x) 
	{ 
		if (top >= (MAX-1)) 
		{ 
			System.out.println("Stack Overflow"); 
			return false; 
		} 
		else
		{ 
			a[++top] = x; 
			System.out.println(x + " pushed into stack"); 
			return true; 
		} 
	} 

	int pop() 
	{ 
		if (top < 0) 
		{ 
			System.out.println("Stack Underflow"); 
			return 0; 
		} 
		else
		{ 
			int x = a[top--]; 
			return x; 
		} 
	} 
	
	int peek() {
		if (isEmpty()) 
			return 0;
		else
			return a[top];
	}
	
	int search(int x) {
		if (isEmpty())
			return -1;
		for (int i=0; i<=top;i++) {
			if (x==a[i])
				return i;
		}
		return -1;
	}
	
	public static void main(String args[]) 
	{ 
		StackArray s = new StackArray(); 
		
		System.out.println("Enter the number of elements to be pushed: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Enter the number of elements: ");
		for (int i=0; i<n; i++) {
			int x = sc.nextInt();
			s.push(x);
		}
		
		System.out.println(s.isEmpty()? "Empty Stack" : "Not Empty");
				//System.out.println(s.isEmpty());
		System.out.println(s.pop() + " Popped from stack"); 
		System.out.println("Top element: " + s.peek());
		System.out.println(s.search(50)==-1?"Not found" : "found");
		System.out.println(s.search(20)==-1?"Not found" : "found at " + s.search(20));
	} 
} 
