package recursion;

public class maxElement {
	public static int fun(int a[],int n) 
	{ 
	  int x = 0; 
	  if(n == 1) {
		System.out.println("Returning a[0]: " + a[0]);
	    return a[0]; 
	  }
	  else {
		  System.out.println("Before recursion: " + n + " " + x);
		  x = fun(a, n-1);
		  System.out.println( n);
	  }
	  System.out.println("After recursion: " + x+ " " + n);
	  if(x > a[n-1]) { 
		System.out.println("Returning x: " + x);
	    return x; 
	  }
	  else {
		System.out.println("Returning a[n-1]: " + a[n-1]);
	    return a[n-1]; 
	  }
	} 
	
	public static int fun1(int i) 
	{ 
	  if ( i%2!=0 ) return (i++); 
	  else return fun1(fun1( i - 1 )); 
	} 
	  
	public static void main(String[] args) 
	{ 
	  int arr[] = {12, 10, 30, 50, 100}; 
	  System.out.println(fun(arr, 5));
	  System.out.println();
	  System.out.println();
	  System.out.println(fun1(200));
	  
	  
	} 
}
