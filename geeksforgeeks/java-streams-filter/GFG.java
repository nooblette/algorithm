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
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            // taking total count of elements
            int n = temp.length;

            // creating an array of size n and type int
            int[] arr = new int[n];

            // inserting elements to the array
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);

            // calling the method filtersUsingStreams
            // and printing the result
            System.out.println(filterUsingStreams(arr));
        }
    }

    
// } Driver Code Ends

// User function Template for Java

public static int filterUsingStreams(int[] arr) {
    // Your code here
    return Arrays.stream(arr)
        .filter(a -> a % 2 != 0)
        .max()
        .getAsInt();
    // Use filter() to get only odd elements then apply max().getAsInt()
}


//{ Driver Code Starts.
}
// } Driver Code Ends
