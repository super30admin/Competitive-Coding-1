#approach 1 given the array elements starts from 0.... ex: 0,1,2,3 etc
arr = [0,1,3,4,5,6,7,8]
cum_sum = 0
natural_sum = len(arr)*(len(arr)+1)//2
    
for i in range (len(arr)):
    cum_sum += arr[i]
print (abs(natural_sum - cum_sum))

#approach 2 works for ALL - USE THIS BINARY SEARCH APPROACH AS ARRAY IS ALREADY SORTED
#Given a list of n-1 integers and these integers are in the range of 1 to n
#approach1 wont work if the integers start from 1
#Lets try binary search approach:

arr2 = [0,1,2,4,4,5,6,8]
left = 0
right =len(arr2)-1
mid_ele = 0
while right > left + 1:
    mid_ele = left + (right-left)//2
    if (arr2[left] - left) != (arr2[mid_ele]- mid_ele):
        # move left to search for the missing element, update pointers accordingly
        right = mid_ele
    elif (arr2[right] - right) != (arr2[mid_ele]- mid_ele):
        left = mid_ele
print (arr2[left]+1)