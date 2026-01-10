Problem 1:  https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
Time Complexity : O(n)
Space Complexity: O(1)

for i in range(len(arr)):
            idx = abs(arr[i])-1
            if 0 <= idx < len(arr) and arr[idx] > 0:
                arr[idx] *=-1
        
        for i in range(len(arr)):
            if arr[i]>0:
                return i+1
        
        return len(arr)+1


Problem 2 : https://www.geeksforgeeks.org/min-heap-in-java/

## Need to figure out the question. To be continued
