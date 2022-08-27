>💡 This syllabus will only focus on Strings in Java.

# String
>💡 On Notion → [String](https://www.notion.so/String-2ec93655b6f5494ca58cfb628eec9690)

## **Introduction**

**Strings in Java are Objects that are backed internally by a char array. Since arrays are immutable(cannot grow), Strings are **immutable** as well. Whenever a change to a String is made, an entirely new String is created.**

**Memory allotment of String:**

- **String Literal :** Whenever a String Object is created as a literal, the object will be created in String constant pool. This allows JVM to optimize the initialization of String literal. 
`String str = "Geeks";`
- **String Object :** The string can also be declared using `**new**` operator i.e. dynamically allocated. They are assigned to a new memory location in heap. This string will not be added to the String constant pool.
`String str = new String("Geeks");`
If you want to store this string in the constant pool then you will need to “intern” it.
`String internedString = str.intern();`
- **CharArray to String:**
    
    ```
    **char** c[] = {'G','f','g'};
    String s1 = **new** String (c);
    ```
> 💡 Here the JVM checks the String Constant Pool for a string. If the string does not exist, then a new string instance is created and placed in the pool. If the string exists, then it will not create a new object. Rather, it will return the reference to the same instance. The cache which stores these string instances is known as the String Constant pool or String Pool. By the use of the ‘new’ keyword, the JVM will create a new string object in the normal heap area even if the same string object is present in the string pool.

Hence, It is preferred to use String literals as it allows JVM to optimize the memory allocation.


## String Buffer Class in Java

**StringBuffer** is a peer class of **String** that provides much of the functionality of strings. The string represents fixed-length, immutable character sequences while StringBuffer represents growable and writable character sequences.

**StringBuffer** may have characters and substrings inserted in the middle or appended to the end. It ****will automatically grow to make room for such additions and often has more characters pre-allocated than are actually needed, to allow room for growth. 

**Constructors of StringBuffer class:**

**1. StringBuffer()**: It reserves room for 16 characters without reallocation

`StringBuffer s = **new** StringBuffer();`

**2.** **StringBuffer( int size)**: It accepts an integer argument that explicitly sets the size of the buffer.

`StringBuffer s = **new** StringBuffer(20);`

**3.** **StringBuffer(String str):** It accepts a string ****argument that sets the initial contents of the StringBuffer object and reserves room for 16 more characters without reallocation.

`StringBuffer s = **new** StringBuffer("GeeksforGeeks");`

**Conversion of String to StringBuffer and vice-versa :**

1. **String to StringBuffer using append() method:**
    
    ```jsx
    String str = "This is Java Weblog. "; //creates a string literal
    StringBuffer sb = new StringBuffer(); //creates a new string buffer object
    sb.append(str); //adds text to the end of the buffer; thereby converting the string into a buffer object
    ```
    
    OR
    
    ```jsx
    String str = "This is Java Weblog. "; //creates a string literal
    StringBuffer sb = new StringBuffer(str); //creates a new string buffer object
    ```
    
2. **StringBuffer to String using toString() method:**
    
    ```jsx
    StringBuffer sb = new StringBuffer("Google is top search-engine."); //creates a new string buffer object
    String str = sb.toString(); //converts string buffer object to a string literal
    ```
    

**Methods of StringBuffer class**

| Methods | Action Performed |
| ------- | ---------------- | 
| append() | Used to add text at the end of the existing text. |
| length() | The length of a StringBuffer can be found by the length( ) method |
| capacity() | the total allocated capacity can be found by the capacity( ) method |
| charAt() | returns the character at the index specified |
| delete() | Deletes a sequence of characters from the invoking object |
| deleteCharAt() | Deletes the character at the index specified by loc |
| ensureCapacity() | Ensures capacity is at least equals to the given minimum. |
| insert() | Inserts text at the specified index position |
| length() | Returns length of the string |
| reverse() | Reverse the characters within a StringBuffer object |
| replace() | Replace one set of characters with another set inside a StringBuffer object |

> 💡 *Note: Besides that, all the methods that are used in the String class can also be used.*

## String Builder Class in Java

**StringBuilder** in Java represents a mutable sequence of characters. Since the String Class in Java creates an immutable sequence of characters, the StringBuilder class provides an alternative to String Class, as it creates a mutable sequence of characters.

The function of StringBuilder is very much similar to the StringBuffer class, as both of them provide an alternative to String Class by making a mutable sequence of characters. However, the StringBuilder class differs from the StringBuffer class on the basis of synchronization. 
The StringBuilder class provides no guarantee of synchronization whereas the StringBuffer class does. Therefore this class is designed for use as a drop-in replacement for StringBuffer in places where the StringBuffer was being used by a single thread (as is generally the case). 
Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations. Instances of StringBuilder are not safe for use by multiple threads. If such synchronization is required then it is recommended that StringBuffer be used. String Builder is not thread-safe and high in performance compared to String buffer.


**Constructors of StringBuilder class:**

1. **StringBuilder():** Constructs a string builder with no characters in it and an initial capacity of 16 characters.
    
    `StringBuilder str = **new** StringBuilder();`
    
2. **StringBuilder(int capacity):** Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument. 
`StringBuilder str = **new** StringBuilder(10);`
3. **StringBuilder(CharSequence seq):** Constructs a string builder that contains the same characters as the specified CharSequence.
    
    `StringBuilder str = **new** StringBuilder("AAAABBBCCCC");`
    
4. **StringBuilder(String str):** Constructs a string builder initialized to the contents of the specified string.
    
    `StringBuilder str = **new** StringBuilder(str1.toString());`
    

****Conversion of String to StringBuilder and vice-versa :****

1. **String to StringBuilder using append() method:**
    
    ```jsx
    String str = "This is Java Weblog. "; //creates a string literal
    StringBuilder sb = new StringBuilder(); //creates a new string builder object
    sb.append(str); //adds text to the end of the builder; thereby converting the string into a builder object
    ```
    
    OR
    
    ```jsx
    String str = "This is Java Weblog. "; //creates a string literal
    StringBuilder sb = new StringBuilder(str); //creates a new string builder object
    ```
    
2. **StringBuilder to String using toString() method:**
    
    ```jsx
    StringBuilder sb = new StringBuilder("Google is top search-engine."); //creates a new string builder object
    String str = sb.toString(); //converts string builder object to a string literal
    ```
    

**Methods of StringBuilder class:**

| Method | Description |
| ------- | ---------------- | 
| public StringBuilder append(String s) | It is used to append the specified string with this string. The append() method is overloaded like append(char), append(boolean), append(int), append(float), append(double) etc. |
| public StringBuilder insert(int offset, String s) | It is used to insert the specified string with this string at the specified position. The insert() method is overloaded like insert(int, char), insert(int, boolean), insert(int, int), insert(int, float), insert(int, double) etc. |
| public StringBuilder replace(int startIndex, int endIndex, String str) | It is used to replace the string from specified startIndex and endIndex. |
| public StringBuilder delete(int startIndex, int endIndex) | It is used to delete the string from specified startIndex and endIndex. |
| public StringBuilder reverse() | It is used to reverse the string. |
| public int capacity() | It is used to return the current capacity. |
| public void ensureCapacity(int minimumCapacity) | It is used to ensure the capacity at least equal to the given minimum. |
| public char charAt(int index) | It is used to return the character at the specified position. |
| public int length() | It is used to return the length of the string i.e. total number of characters. |
| public String substring(int beginIndex) | It is used to return the substring from the specified beginIndex. |
| public String substring(int beginIndex, int endIndex) | It is used to return the substring from the specified beginIndex and endIndex. |


## Problems to Solve

>💡 On Notion →  [Problems On String](https://www.notion.so/b0923d87829b469cbebcfbf4da45fc6d)

#### EASY
1. [Valid Anagram](https://www.notion.so/Valid-Anagram-2b798aa98e8c4b178a9f5a8865912f05)

2. [Valid Parentheses](https://www.notion.so/Valid-Parentheses-4ff10616866245dda1c6e28a45538095)

3. [Valid Palindrome](https://www.notion.so/Valid-Palindrome-3db6be2ad0774988bef70917a911a486)

4. [Encode and Decode Strings](https://www.notion.so/Encode-and-Decode-Strings-6629db5f35084a28bb36a0f9c53d6252)


#### MEDIUM 

5. [Group Anagrams](https://www.notion.so/Group-Anagrams-4462cdc61c8d41e7be04fd57cc289ef8)
6. [Longest Substring Without Repeating Characters](https://www.notion.so/Longest-Substring-Without-Repeating-Characters-05e818d3d0184962a7e307855c464c73)
7. [Longest Repeating Character Replacement](https://www.notion.so/Longest-Repeating-Character-Replacement-1614c49a38d34733b8e06f4e05a4452a)
8. [Longest Palindromic Substring](https://www.notion.so/Longest-Palindromic-Substring-2335b89ec5a044a0af4f0e0e08ad7b21)
9. [Palindromic Substrings](https://www.notion.so/Palindromic-Substrings-71644c756f98410481322d43a5897b6c)

#### HARD
11. [Minimum Window Substring](https://www.notion.so/Minimum-Window-Substring-0a6a9e53a35c4136a9a9d0b0ff3fad33)
