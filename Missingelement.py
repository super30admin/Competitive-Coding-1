def findmissingnum(nums,size):
    #Time Complexity: O(LogN)
    #Space Complexity: O(1)
    #It runs successfully on leetcode missing number at muliple index (I tried with first missing element)
    len(nums)
    l=0
    h=len(nums)-1

    if nums[0]!=1: return 1
    #if last element is missing 
    if nums[size-1]!=size+1: return size+1
    #nums are sorted so the index are, so we can match it along with index
    #     11 12 13 14 15 16 if [element is missing it shud be like] 11 12 13 14 16
    #     0  1  2  3  4  5                                           0  1  2  3  4
    #diff 11 11 11 11 11 11                                         11 11 11 11 12
    # we can map value- index will always be same, if not element is missing then we will search rest of part not other where difference is right
    # as half range we can delete we can apply binary search method
    while(l+1<h): #for initial edge cases where number missing is at 2nd index
        m=(l+h)//2
        if nums[l]-l!=nums[m]-m:
            h = m
        elif nums[h]-h!=nums[m]-m:
            l = m
    return nums[l]+1 # low will have last sorted index with proper position, so we can be sure next element is misssing 
        

print(findmissingnum([1,2,3,5,6,7,8],7))
