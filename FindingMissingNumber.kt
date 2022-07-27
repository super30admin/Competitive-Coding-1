
class Solution {

    fun findMissingNumberSortedArray(arr: IntArray){

        var low = 0
        var high = arr.size -1

        while (low <= high){

            val mid = low + (high - low)/2

            if(arr[mid] - mid + 1 != 0){
                high = mid
            }else{
                low = mid
            }

        }

        return mid + 1

    }

}