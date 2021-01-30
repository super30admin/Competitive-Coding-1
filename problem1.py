// Finding Missing Number in a Sorted Array  
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
nums= [12,13,14,16,17,18,19,20,21]
low=0
high =len(nums)-1
flag=0
while low<=high:
    mid=low+(high-low)//2
    if (nums[mid]-mid!=nums[0]) and (mid==0 or nums[mid-1]-(mid-1)==nums[0]):
    	flag=1
    	print(mid+nums[0])
    	break
    elif nums[mid]-mid==nums[0]:
    	low=mid+1
    else:
    	high=mid-1

if flag==0:
	print(len(nums)+nums[0]) 
