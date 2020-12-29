""""Missing element
TC : O(logN)
SC : O(1) No extra spaces we are using same array
"""
def findmissingelement(nums):
    #edge case
    if not nums or len(nums)==0:
        return -1
    #logic
    #initialize low and high pointer
    l = 0
    h = len(nums)-1
    #make sure the diff between low and high is greater than 1
    while (h-l)>1:
        m = l +(h-l)//2 #calc mid pointer
        if (nums[l] - l) != (nums[m] - m): #check first half of array
            h = m #move left
        elif (nums[h] - h) != (nums[m] - m): #check second half of array
            l = m #move right
    return nums[m]+1 #return current element + 1
	
nums = [1,2,3,4,5,6,7,8,9,11]
print("Missing element is ",findmissingelement(nums))