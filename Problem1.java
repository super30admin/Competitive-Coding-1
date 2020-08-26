
    /*  Explanation
    # Leetcode problem link : Not available on leetcode
    Time Complexity for operators : log(n) 
    Extra Space Complexity for operators : o(1) .. No extra space
    Did this code successfully run on Leetcode : Not available on leetcode
    Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
        # Basic approach : Compare element with the index (i+1) if it is not equal then return (i+1)

        # Optimized approach: The main idea of this problem is to have unique hash values for each string which can be calculated by taking a product of prime numbers assigned to each character in a dictionary
            # 1. First check whether the difference between high and low is greater than 2 or not if it is not greater thatn
                 two that emans it reached till the end where high and low are side by side of each other.
            # 2. calculate the mid everytime and check difference of mid and its index. 
            # 3. If thet difference is not equal to the difference between low and its index then we need to
                 move towards left side of an array.
            # 4. Else move on right side.
            # 5. At the end, return avarage of array's lo and high position element. That's the required o/p
    */
    
    public class Problem1{

        public static void main(String args[]) {
            int arr[] = new int[] {1,2,3,4,5,6,8};
            int val = findMissing(arr);
            System.out.println(val);
        }
        
        public static int findMissing(int arr[]) {
            int lo = 0;
            int hi = arr.length-1;
                
            if(arr.length == 0)
                return -1;
            
                //brute force approach
            //      for(int i=0;i<arr.length;i++) {
            //          if(i+1!=arr[i])
            //              return i+1;
            //      }

            int mid = 0;
            while(hi-lo>=2) {
                mid =  lo + (hi-lo)/2;
                    
                if((arr[mid]-mid) != (arr[lo]-lo))
                    hi = mid;
                else
                    lo = mid;   
            }
            return (arr[lo]+arr[hi])/2;
        }
    }
    
