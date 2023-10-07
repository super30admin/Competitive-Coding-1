#Time Complexity:- O(log n)
#Space Complexity:- O(1)

def missingNumber(nums):
    l=0
    h=len(nums)-1
    mid=0
  
    #Loop until high-low>=2
    while(high-low>=2):
         mid=low+(high-low)//2 #prevent overflow condition
         middf=nums[mid]-mid   #Calculate middf 
         lowdf=nums[low]-low   #Calculate lowdf
         highdf=nums[high]-high  #Calculate highdf
         if(middf!=lowdf):     #Check if middf is equal to lowdf or not
           high=mid            #Move on to the left side.
         elif:
           low=mid            #Move on to the right side
    return (nums[low]-nums[high])//2

    if nums[0]!=1:
       return 1
    elif nums[h]!=h+1:
        return len(nums)+1
