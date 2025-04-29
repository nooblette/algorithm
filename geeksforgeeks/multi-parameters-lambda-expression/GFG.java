//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking the first number
            int a = sc.nextInt();

            // taking the second number
            int b = sc.nextInt();

            // calling helperFunction which adds
            // the two number and return the object
            Add ans = helperFunction();

            // calling interface function to print
            // the answer
            System.out.println(ans.addParameters(a, b));

            System.out.println("~");
        }
    }

    
// } Driver Code Ends

// User function Template for Java

/*
The interface looks like

interface Add {
    public int addParameters(int a, int b);
}
*/
public static Add helperFunction() {
    // Your code here
    return (a, b) -> a + b;
    // Implement the addParameters method that returns a+b.
}


//{ Driver Code Starts.
}

interface Add {
    public int addParameters(int a, int b);
}
// } Driver Code Ends
