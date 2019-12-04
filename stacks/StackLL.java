package stacks;

import java.util.Scanner;

//Java Code for Linked List Implementation 

public class StackLL { 

	StackNode root; 

	static class StackNode { 
		int data; 
		StackNode next; 

		StackNode(int data) { 
			this.data = data; 
		} 
	} 
	
	public boolean isEmpty() { 
		if (root == null) { 
			return true; 
		} else return false; 
	} 
	
	public void push(int data) { 
		StackNode newNode = new StackNode(data); 

		if (root == null) { 
			root = newNode; 
		} else { 
			StackNode temp = root; 
			root = newNode; 
			newNode.next = temp; 
		} 
		//System.out.println(data + " pushed to stack"); 
	} 

	public int pop() { 
		int popped = Integer.MIN_VALUE; 
		if (root == null) { 
			System.out.println("Stack is Empty"); 
		} else { 
			popped = root.data; 
			root = root.next; 
		} 
		return popped; 
	} 

	public int peek() { 
		if (root == null) { 
			System.out.println("Stack is empty"); 
			return Integer.MIN_VALUE; 
		} else { 
			return root.data; 
		} 
		
	} 
	
	public void traverse () {
		StackNode temp = root;
		if (isEmpty())
			System.out.println("Empty Stack");
		System.out.print("Data: " + " ");
		
		while (temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public boolean search(int x) {
		if (root==null) {
			System.out.println("Stack is empty"); 
			return false;
		}
		StackNode temp = root;
		while (temp!= null) {
			if (temp.data == x) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public static void main(String[] args) { 
		
		StackLL sll = new StackLL(); 
		System.out.println("Choose: 1. Push(); 2. Pop(); 3. Peek(); 4. isEmpty; 5. search();");
		Scanner sc = new Scanner(System.in);
		
		
		while (sc.hasNextLine()) {
			
			int choice = sc.nextInt();
			switch(choice) {
				case 1: System.out.println("Enter number of elements to be pushed: ");
						int n = sc.nextInt();
						for (int i=0; i<n;i++) {
							int x = sc.nextInt();
							sll.push(x);
						}
						sll.traverse();
						break;
						
				case 2: System.out.println(sll.pop() + " popped from stack");
						break;
						
				case 3: System.out.println("Top element is " + sll.peek()); 
						break;
						
				case 4: System.out.println(sll.isEmpty() ? "Empty Stack" : "Not Empty");
						break;
						
				case 5: System.out.println("Enter an element to search: ");
						int y = sc.nextInt();
						System.out.println(sll.search(y)?"Found" : "Not Found");
						break;
						
				default: System.out.println("Choose one option");
					
			}
		}
	} 
} 

