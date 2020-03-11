package hashing;

import java.util.*;

public class LinearProbing<K, V> {
	
	class HashNode <K, V>{
		K key; 
		V value;
		
		HashNode (K key, V value){
			this.key = key;
			this.value = value;
		}
	}

	private ArrayList <HashNode<K, V>> slots;
	private int capacity; 
	private int size;
	
	HashNode<K, V> deleted_node;
	Integer k = -1 , v = -1;
	
	//Initialising the hashtable
	@SuppressWarnings("unchecked")
	LinearProbing(){
		slots = new ArrayList<>();
		this.capacity = 5;
		this.size = 0;
		
		for (int i=0; i<capacity; i++)
			slots.add(null);
		
		//Initialising deleted Node
		deleted_node = new HashNode<K, V>((K) k, (V) v);
		
	}
	
	public int getCapacity() { return this.capacity; }
	
	public int getSize() { return this.size; }
	
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	
	public int getHash(K key) {
		return key.hashCode() % capacity;
	}
	
	public V getValue(K key) {
		int index = getHash(key);
		HashNode <K, V> head = slots.get(index);
		
		//Search for the value 
		for (int i=0; i<capacity; i++) {
			if (head.key.equals(key))
				return head.value;
			index = (index + 1) % capacity;
		}
		
		//if key is not found	
		return null;
		
	}// end getValue()
	
	
	public void addKey(K key, V value) {
		int index = getHash(key);
		HashNode <K, V> head = slots.get(index);
		
		while (head != null && !head.key.equals(-1)) {
			//if key already exists
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			index = (index + 1) % capacity;
			head = slots.get(index);
		}
		
		//Insert a new node
		HashNode<K,V> new_node = new HashNode<> (key, value);
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
						addKey(headNode.key, headNode.value);
					}
				}	

	}//end addKey()
	
	
	public void removeKey(K key) {
		int index = getHash(key);
		HashNode <K, V> head = slots.get(index);
		
		//search the node
		while (head != null) {		
			if (head.key.equals(key)) {
				slots.set(index, deleted_node);
				size--;
				System.out.println("Key: " + key + " found and deleted.");
				return;
			}
			index = (index + 1) % capacity;
			head = slots.get(index);
		}
		
		System.out.println("Key Not found.");
	}// end removeKey()
	
	
	public void display() {
		for (HashNode<K, V> temp: slots)
			if (temp != null)
				System.out.println("Key: " + temp.key + ", Value: " + temp.value);
			else
				System.out.println("NULL");
	}
	
	public static void main(String[] args) {
		
		LinearProbing <Integer, String> sc = new LinearProbing<>();
		
		System.out.println(sc.isEmpty());
		
		sc.addKey(1, "Tabassum");	
		sc.addKey(2, "Abdul");
		sc.addKey(3, "Ralph");
		sc.addKey(4, "Zain");
		sc.addKey(5,  "Rahil");
		sc.addKey(6, "Malik");
		sc.addKey(7, "Sahar");
		
		System.out.println(sc.getCapacity());
				
		System.out.println(sc.getValue(5));
		
		System.out.println("\nBefore delete: " + sc.getSize());
		sc.display();
		
		sc.removeKey(5);
		
		System.out.println("\nAfter delete: " + sc.getSize());
		sc.display();
	}

}
