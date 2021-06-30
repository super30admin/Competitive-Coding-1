//Time Complexity: O(logN) 
//Space Complexity: O(1)

class Main {
  public static void main(String[] args) {    
    int[] arr = {1, 2, 3, 5, 6};
    int missingElement =  Main.searchElement(arr);
    System.out.println("missingElement : " + missingElement);
  }

  public static int searchElement(int[] arr){
    if(arr==null || arr.length==0) return 1;

    int low = 0, high = arr.length-1;
    while(low<=high){
        int mid = low+(high-low)/2;
        if(arr[mid] - mid > 1){
            high = mid-1;
        } else {
            low=mid+1;
        }
    }
    return low+1;
    }
}