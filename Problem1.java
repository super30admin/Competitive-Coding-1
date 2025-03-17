
//Program to find missing no from a sorted array
//Time complexity: O(logn)
//Space complexity: O(1)

class MissingNo{
    static int search(int arr[], int size){
        if(arr[0]!=1)
            return 1;
        if(arr[size-1]!=(size+1))
            return size+1;
        int left = 0, right = size-1;
        int mid;

        //Binary search loop to find missing no
        while((right-left)>1){
            mid = left+(right-left)/2;
            //if difference between element and index doesnt match at mid, the missing element is on the left side
            if((arr[left]-left)!=(arr[mid]-mid)){
                right = mid;
            }
            //if the difference match on the left side, dearch on the right side
            else if((arr[right]-right)!=(arr[mid]-mid)){
                left = mid;
            }
        }
        return (arr[left]+1);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,5,6,7};
        int size = arr.length;
        System.out.println("Missing number:" +search(arr,size));
    }
}