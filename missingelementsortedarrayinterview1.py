"""
Complexities, Approaches mentioned below
Link:https://leetcode.com/problems/missing-number/ starts from 0
https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/ starts from 1
ran on leetcode- yes
"""

def search(arr):
    """
    3 ways-
    1.mathematically if number starts from 0,1 below, O(n)
    2. brute force if the number if the number starts from 1 at index 0, basically the number will be index +1
    3. O(logn) if we do binary search and the array is sorted else sort it to get it O(logn) complexity
    """

    ###if the array is starting from 1
    length = len(arr)
    sum = 0
    for i in range(length):
        sum += arr[i]
    return (((length+1) * (length + 2)) // 2) - sum


    ###O(logn) solution
    # low=0
    # high=len(arr)-1
    # # return arr[(low+high)//2]
    # while high-low >=2: ## need to go to consecutive indexes where high -low would be =1 where the number is missing and then take
    ##the average of thhe numbers at those indexes to get the missing number
    #     mid = (low + high) // 2
    #     midindexdifference=arr[mid]-mid
    #     lowindexdifference=arr[low]-low
    #     highindexdifference=arr[high]-high
    #
    #     if midindexdifference!=lowindexdifference:
    #         high=mid
    #
    #     elif midindexdifference!=highindexdifference:
    #         low=mid
    #
    # return (arr[low]+arr[high])//2

arr=[1, 2, 3, 5, 6, 7, 8]
print("missing number is", search(arr))

# ##brute force below
# def search (arr):

    # for i in range(0, len(arr)-1):
    #     if arr[i]==i+1:
    #         continue
    #     else:
    #         print("hello")
    #         # return arr[]
    #
    # #         # print("value", i+1, "is at correct index")
    # #         pass
    # #     else:
    # #         # missingnumber=arr[i]+1
    # #         # return arr[i]+1
    # #         print("in else loop")
    # #         return (arr[i]+1)
    # # return False



# missingnumber=0
