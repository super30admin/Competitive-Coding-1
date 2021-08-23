//Space Complexity - O(1)
//Time Complexity - O(logn)
class MissingElement{
static int search(int arr[], int size){
    int low=0, high=size - 1, mid=0;
    while ((high-low)>1){
        mid=low+(high-low)/2;
        if ((arr[low]-low)!=(arr[mid]-mid))
            high=mid;
        else if ((arr[high]-high)!=(arr[mid]-mid))
            low=mid;
    }
    return (arr[low] + 1);
}
public static void main(String[] args){
    int arr[] = { 1, 2, 3, 4, 5, 7, 8 };
    int size = arr.length;
    System.out.println("Missing number: " + search(arr, size));
}
}