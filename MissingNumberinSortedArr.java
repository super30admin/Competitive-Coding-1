
class Solution {
    int MissingNumber(int array[], int n) {
        // Your Code Here
        
        int low = 0;
        int high = n-2;
        int mid = 0;
        
        while(high-low >= 2){
            mid = low + (high - low)/2;
            if(array[mid]-mid != array[low]-low){
                high = mid;
            }else if(array[mid]-mid !=array[high]-high){
                low = mid;
            }
        }
        return (array[low]+array[high])/2;
    }
}
