'''
Time Complexity: O(n) as we traverse through n elements in an array
Space Complexity: O(1) Constant Space
Worked successfully during the interview.
'''


def search(a):
    # initialize the low and high pointers
    low = 0
    high = len(a)-1
    # Sanity check: whether the array is null or empty
    if a==None or a==0:
        return -1
    # loop though the array elements
    while low<=high:
        # Calculate the mid
        mid = low + (high - low)//2
        
        # check point: check whether the difference between the element - index is 1 then disregard the left side as it will be sorted and most probably have all the elements.
        if a[mid] - mid == 1:
            low = mid + 1
        else:
            high = mid - 1
    # return the index at low + 1as the indices start from 0th index. and the low index will be pointing at the element whose difference is not == 1
    print("Missing Value: ",low+1)
    

''' Quick Dry run  '''
a = [1,2,3,4,6,7]
a = [1,3,4,5,6,7]
search(a)
