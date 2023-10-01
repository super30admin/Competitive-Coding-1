class findingMissingElement{
  public int search(int nums[], int size) {
    if (nums[0] != 1){
      return 1;
    }
    if (nums[size - 1] != size+1){
      return size+1;
    }
    int low = 0, high = size - 1;
    while (low <= high){
      mid = low + (high-low)/2;
      if ((mid - low) != (nums[mid] - nums[low])) {
        high = mid;
      }
      else if ((high - mid) != (nums[high] - nums[mid])){
        low = mid;
      }
      return nums[low]+1;
    }

  public static void main(String[] args){
    int nums[] = {1,2,3,5,6,7,8};
    int size = 7; 
    System.out.println("Missing number is: "+ search(nums, size));
  }
  }
