package hashing;

import java.util.ArrayList;
import java.util.Scanner;

public class SeparateChaining <K, V>{
	
	//Declaring slots (array list)
	private ArrayList<HashNode<K, V>> slots;
	private int capacity;
	private int size;
	
	SeparateChaining (int c){
		slots = new ArrayList<>();
		this.capacity = c;
		this.size = 0;
		
		//create empty slots
		for (int i=0; i<capacity; i++)
			slots.add(null);		
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public int getHash(K key) {
		int hashcode = key.hashCode();
		int index = hashcode % capacity;
		//System.out.println(index + " " + hashcode);
		return index;
	}//end getHash()
	
	
	//Get a value for a key
	public V getValue(K key) {
		int index = getHash(key);
		HashNode<K, V> head = slots.get(index); 
		
		while (head != null) {
			 if (head.key.equals(key))
				 return head.value;
			 head = head.next;
		}
		
		return null;
	}
	
	
	public void addKey (K key, V value) {
		int index = getHash(key);
		HashNode<K, V> head = slots.get(index);
		
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		//Insert new node in chain
		head = slots.get(index); 
		HashNode<K,V> new_node = new HashNode<>(key, value);
		new_node.next = head;
		slots.set(index, new_node);
		size++;	
		
		// If load factor increases, then increment the size of hashtable by twice
		if ((size/capacity) >= 0.7) {
			ArrayList <HashNode<K, V>> temp = slots;
			slots = new ArrayList<>();
			capacity = 2*capacity;
			size=0;
			
			//reset all the slots
			for (int i=0; i<capacity; i++)
				slots.add(null);
			
			//Add the keys and values from temp to slots according to the new capacity of the hashtable
			for (HashNode<K, V> headNode: temp) {
				while (headNode!=null) {
					addKey(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}	
	}//end addKey()
	
	
	public void removeKey(K key) {
		int index = getHash(key);
		HashNode <K, V> head = slots.get(index);
		HashNode <K, V> prev = null;
		
		while (head != null) {
			if (head.key.equals(key))
				break;
			prev = head;
			head = head.next;
		}
		
		//Key not found
		if (head == null) {
			System.out.println("Key not found");
			return;
		}
		
		size--;
		
		//Remove key
		if (prev != null) 
			prev.next = head.next;
		else
			slots.set(index, head.next);
		
		System.out.println("Key: " + key + " found and deleted");
		
	}//end removeKey()

	
	public void print() {		
		for (HashNode<K, V> head : slots) {
			while (head != null) {
				System.out.println("Key: " + head.key + ", Value: " + head.value);
				head = head.next;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the capacity of the hashtable: " );
		int capacity = s.nextInt();
		
		SeparateChaining <Integer, String> sc = new SeparateChaining<>(capacity);
		
		System.out.println(sc.isEmpty());
		
		sc.addKey(1, "Tabassum");	
		sc.addKey(2, "Abdul");
		sc.addKey(3, "Ralph");
		sc.addKey(4, "Zain");
		sc.addKey(5,  "Rahil");
		sc.addKey(6, "Malik");
		sc.addKey(7, "Sahar");
		
		System.out.println(sc.capacity);
				
		System.out.println(sc.getValue(5));
		
		System.out.println("\nBefore delete: " + sc.getSize());
		sc.print();
		
		sc.removeKey(5);
		
		System.out.println("\nAfter delete: " + sc.getSize());
		sc.print();
		
	}

}
