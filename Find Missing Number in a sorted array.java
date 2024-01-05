public int findMissingSorted(int[] nums){
int low = 0;
int high = nums.length-1;
int mid = low + (high-low)/2;

while(low < high){
if(nums[mid]-1==mid){
low = mid+1;
} else {
high = mid - 1;
}
mid = low + (high-low)/2;
}

return low;

}
