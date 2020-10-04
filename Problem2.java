
    /*  Explanation
    # Leetcode problem link : Not available on leetcode
    Time Complexity for operators : o(log(n)) 
    Extra Space Complexity for operators : o(1) .. No extra space
    Did this code successfully run on Leetcode : Not available on leetcode
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: The main idea of this problem is to have unique hash values for each string which can be calculated by taking a product of prime numbers assigned to each character in a dictionary
            # 1. Calculate middle index and do heapify from that element to the start element.
	      2. Do this recursively so that is can solve subtree gets affected due to swapping.
	      3. In heapify check which side of the element is greater and then swap that with the root node.
	      4. Once we are done with the heapify, just print the array.
    */

public class maxHeap {


	    // To heapify a subtree rooted with node i which is 
	    // an index in arr[].Nn is size of heap 
	    static void heapify(int arr[], int n, int i) 
	    { 
	        int largest = i; // Initialize largest as root 
	        int l = 2 * i + 1; // left = 2*i + 1 
	        int r = 2 * i + 2; // right = 2*i + 2 
	  
	        // If left child is larger than root 
	        if (l < n && arr[l] > arr[largest]) 
	            largest = l; 
	  
	        // If right child is larger than largest so far 
	        if (r < n && arr[r] > arr[largest]) 
	            largest = r; 
	  
	        // If largest is not root 
	        if (largest != i) { 
	            int swap = arr[i]; 
	            arr[i] = arr[largest]; 
	            arr[largest] = swap; 
	  
	            // Recursively heapify the affected sub-tree 
	            heapify(arr, n, largest); 
	        } 
	    } 
	  
	    // Function to build a Max-Heap from the Array 
	    static void buildHeap(int arr[], int n) 
	    { 
	        // Index of last non-leaf node 
	        int startIdx = (n / 2) - 1; 
	  
	        // Perform reverse level order traversal 
	        // from last non-leaf node and heapify 
	        // each node 
	        for (int i = startIdx; i >= 0; i--) { 
	            heapify(arr, n, i); 
	        } 
	    } 
	  
	    // A utility function to print the array 
	    // representation of Heap 
	    static void printHeap(int arr[], int n) 
	    { 
	        System.out.println("Array representation of Heap is:"); 
	  
	        for (int i = 0; i < n; ++i) 
	            System.out.print(arr[i] + " "); 
	  
	        System.out.println(); 
	    } 
	  
	    public static void main(String args[]) 
	    { 

	    	// example take from below  youtube link
	    	// https://www.youtube.com/watch?v=WsNQuCa_-PU
	        int arr[] = { 5,12,64,1,37,90,91,97}; 
	  
	        int n = arr.length; 
	  
	        buildHeap(arr, n); 
	  
	        printHeap(arr, n); 
	    } 
	
}
