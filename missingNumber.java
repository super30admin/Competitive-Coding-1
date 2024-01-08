//Using Binary Search
/* 
public int findMissingSorted(int[] nums){
    //Tc: O(logn) Sc: O(1)
int l = 0;
int h = nums.length-1;
int m = l + (h-l)/2;

while(l < h){
if(nums[m]-1==m){
l = m+1;
} else {
h = m - 1;
}
m = l + (h-l)/2;
}

return l;

}

*/