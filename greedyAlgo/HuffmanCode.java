package greedyAlgo;

import java.util.*;

class HuffmanNode{
	char ch;
	int freq;
	HuffmanNode left, right;
	
	HuffmanNode(){
		left = right = null;
	}
	
	HuffmanNode(char ch, int freq){
		this.ch = ch;
		this.freq = freq;
		left = right = null;
	}	
}

public class HuffmanCode {

	private static HashMap <Character, String> encode_map = new HashMap<Character, String>();
	private static HuffmanNode root = null;
	
	public static void encode (HuffmanNode temp, String s) {
		if (temp == null)
			return;
		
		if (temp.left == null && temp.right == null)
			encode_map.put(temp.ch, s);
		
		encode(temp.left, s + "0");
		encode(temp.right, s + "1");
	}
	
//	public static String decode(HuffmanNode temp, StringBuilder sb) {
//		if (temp == null || sb.equals(""))
//			return "";
//		String s = "";
//		for (int i=0; i<sb.length(); i++) {
//			if (sb.charAt(i) == '0')
//				temp = temp.left;
//			else if (sb.charAt(i) == '1')
//				temp = temp.right;
//			
//			if (temp.left == null && temp.right == null) {
//				s += "" + temp.ch;
//				temp = root;
//			}
//		}
//		return s;
//	}

	
	public static String decode(HuffmanNode temp, StringBuilder sb, int i, String s) {
		if (temp.left == null && temp.right== null) {
			s += "" + temp.ch;
			temp = root;
		}
		
		if (i == sb.length())
			return s;

		if (sb.charAt(i) == '0')
			return decode(temp.left, sb, i+1, s);
		return decode(temp.right, sb, i+1, s);

	}
	
	
	public static HuffmanNode buildTree(HuffmanPriorityQueue pq) {		
		while (pq.size() > 1) {
			HuffmanNode x = pq.extractMin();
			HuffmanNode y = pq.extractMin();

			HuffmanNode new_root = new HuffmanNode ('-', x.freq + y.freq);
			new_root.left = x;
			new_root.right = y;
			root = new_root;
			
			pq.add(new_root);
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		
		String s = "Huffman coding is a compression algorithm. All the charcters are present at the leaf nodes.";
		
		HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
		for (char c : s.toCharArray())
			freq.put(c, freq.getOrDefault(c, 0)+1);
		
		HuffmanPriorityQueue pq = new HuffmanPriorityQueue(freq.size()+1);
		
		
		//Add new nodes in the priority queue --> nlogn;
		for (var entry : freq.entrySet()) 
			pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
		
		//print the priority queue;
		System.out.println(pq);
		
		System.out.println(pq.size());
		
		//build the huffman tree --> extractMin() - logn, hence total nlogn;
		root = buildTree(pq);
		
		//encode using huffman tree and store the coded value in a map
		encode(root, "");
		System.out.println("Huffman Codes are: ");
		System.out.println(encode_map);
		
		//Encoded String
		StringBuilder sb = new StringBuilder();		
		for (char ch: s.toCharArray())
			sb.append(encode_map.get(ch));
		
		System.out.println("\n" + sb);
		
		System.out.println("\nDecoded String is : ");
		System.out.println(decode(root, sb, 0, ""));
		
	}

}
