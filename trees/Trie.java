package trees;

public class Trie {
	
	private final int SIZE = 26;
    private Node root;
    
    class Node{
        Node[] children = new Node[SIZE];
        boolean isEndOfWord;
        
        Node(){
            isEndOfWord = false;
            for (int i=0; i<SIZE; i++)
                children[i] = null;
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = root;
        int n = word.length();
        
        for (int i=0; i<n; i++){
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new Node();
            temp = temp.children[index];
        }
        
        temp.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public Node searchPrefix(String word) {
        Node temp = root;
        int n = word.length();
        
        for (int i=0; i<n; i++){
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null)
                return null;
            temp = temp.children[index];
        }
        
        return temp;
    }
    
    public boolean search (String word) {
    	Node temp = searchPrefix(word);
    	return (temp!=null && temp.isEndOfWord);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node temp = searchPrefix(prefix);
        return (temp!=null);
    }
    
    public boolean isEmpty(Node temp) {
    	for (int i=0; i<SIZE; i++)
    		if (temp.children[i]!=null) {
    			return false;
    		}
    	return true;
    }
    
    public boolean delete(Node temp, String word, int index) {
    	if (temp == null)
    		return false;
    	
    	if (word.length()== index) {
    		if (!temp.isEndOfWord)
    			return false;
    		//System.out.println("delete : "+index + " " + (temp==null) + " " + isEmpty(temp) + " " + temp.isEndOfWord);
    		temp.isEndOfWord = false;
    		return isEmpty(temp);
    	}
    	
    	int i = word.charAt(index) - 'a';
    	Node node = temp.children[i];
    	boolean delCurrent = delete(node, word, index+1) && !node.isEndOfWord;
    	//System.out.println("Delete Current: " +(node.isEndOfWord)+ ", " + delCurrent + ", " + word.charAt(index));
    	
    	if (delCurrent) {
    		node = null;
    		return isEmpty(temp);
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println("Search Apple: " + trie.search("apple"));   // returns true
		System.out.println("Search App: " + trie.search("app"));     // returns false
		System.out.println("Prefix App: " + trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println("Search App: " + trie.search("app"));     // returns true
		System.out.println("Delete: " + trie.delete(trie.root, "app", 0));
		System.out.println("Search after del: " + trie.search("apple"));
	}

}
