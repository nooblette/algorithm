//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // Taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");

            // creating an array of size n
            int n = temp.length;
            int[] arr = new int[n];

            // inserting elements to
            // the array
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);

            // calling the maxUsingStreams method
            // printing the result
            System.out.println(maxUsingStreams(arr));
        }
    }

    
// } Driver Code Ends

// User function Template for Java

public static int maxUsingStreams(int[] arr) {
    // Your code here
    return Arrays.stream(arr).max().getAsInt();
    // Use stream().max().getAsInt()
}



//{ Driver Code Starts.
}
// } Driver Code Ends
