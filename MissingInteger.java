// Time Complexity : O(log n) where n is the length of input array, binary search
// Space Complexity : O(1), no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Checking if the middle element is at its position, to decide which half of the side to go
//if index+1 is equal to element at the index, then it is in the right position, so we have to move right side
//else move left side and repeat till we reach a point where all pointers are at same place, return the index low+1 as the missing element;

class MissingInteger{
    public static void main(String[] args){
System.out.println(MissingInt(new int[] {1,2,3,4,5,6,8}));
    }

static int MissingInt(int[] A){

    int low=0;
    int high=A.length-1;
    while (low<=high){
        int mid=low+(high-low)/2;

        if(mid+1==A[mid]){
            low=mid+1;
        }
        else if(mid+1<A[mid]){
            high=mid-1;
        }
    }

        return low+1;


    }
}
