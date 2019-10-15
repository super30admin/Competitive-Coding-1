# Time complexity : o(logn)
#space complexity : o(1)
#yes my code ran on IDE
# Approach : Using binary search implementaion. Basic concept behind this is finding the arr[mid]-mid!=arr[low]-low. 
#Then we adjust the low and high values accordingly. In the end we left out with two elements. 
#Then we find the missing element by calculating the (arr[low] +arr[high])//2



def missing(arr):
    low=0
    high=len(arr)-1
    while (high-low)>=2:
        mid=low+(high-low)//2
        if (arr[mid]-arr[low])!=(mid-low):
            high=mid
        else:
            low=mid
    return (arr[low]+arr[high])//2



