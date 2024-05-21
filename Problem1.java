//Time Complexity - O(log n)
// Space Complexity - O(1)
// Able to code in interview - Yes
//We initially check the middle element and if the previous element or next element to mid is not consecutive, then we return the missing element. 
// If not, check the diff between the value at mid and the index mid , if the difference is not 1, then we know that the sorted array has some missing
//element in the first half. Else in the second half. 
class Sample{
    public static int getMissingElement(int[] arr){
        int low = 0;
        int high = (arr.length) - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2 ; 
            System.out.println(mid);
    
            if(arr[0] != 1){
                return 1;
            }
            if(mid != 0 && arr[mid] - arr[mid - 1] != 1){
                
                return arr[mid] - 1;   
            }
            else if(mid != arr.length -1 && arr[mid + 1] - arr[mid] != 1){
                return arr[mid] + 1;  
            }
            else if(arr[mid] - mid != 1){
                high = mid - 1;
    
            }
            else{
                low = mid + 1;
            }
        }
        return arr.length + 1;
    }
    
    public static void main(String args[]){
        int[] arr = {2,3,4,5};
        int missingElement = getMissingElement(arr);
        System.out.println("The missing element:" +missingElement);
    }
    }
