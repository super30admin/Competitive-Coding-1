# Two slightly different approaches - first one a little more intuitive and quicker
# Time complexity: O(log(n))
# Space complexity: O(1)
# Approach: Perform binary search and check the difference between current element and it's index to find which direction to go/correct value


def binarySearch(A):
    low = 0
    high = len(A)
    sDiff = A[0]

    while low < high:
        mid = (low + high)//2
        curDiff = abs(A[mid] - mid)

        if curDiff > sDiff:
            high = mid
        else:
            low = mid + 1
    
    return A[low] - 1


def main():
    inp = [3, 5]
    #1, 2, 4, 6, 3, 7, 8
    print(binarySearch(inp))

main()


# TC 1
# A = [1,2,3,5] 
# l = 0, h = 4, sDiff = 1, mid = (0 + 4)//2 = 2, curDiff = 3 - 2 = 1
# l = 3, h = 4, mid = (3+4)//2 = 3, curDiff = 5 - 3 = 2, 
# l = 3, h = 3
# return A[low] - 1 = A[3] - 1 = 5 - 1 = 4
    
def binarySearch2(A): #find leftmost
    low = 0
    high = len(A) - 1
    sDiff = A[0]

    while low <= high:
        mid = (low + high)//2
        curDiff = abs(A[mid] - mid)

        if curDiff == sDiff:
            low = mid + 1
        else: #it might be first occ of 'not' sDiff or might not, let's check
            if mid == 0 or abs(A[mid - 1] - (mid - 1)) == sDiff:
                return A[mid] - 1
            else:
                high = mid - 1


#TC 1
# [1 , 2, 3, 4, 6]
# sDiff = 1
# l = 0, h = 4, mid = (0 + 4)//2 = 2, curDif = (3 - 2) = 1, l = mid + 1 = 3
# l = 3, h = 4, mid = (3 + 4)//2 = 3, curDif = (4 - 3) = 1, l = mid + 1 = 4
#  = 4, h = 4, mid = 4, curDif = (6 - 4) = 2, return mid

#TC 2
# [3, 5]
# sDiff = 3
# l = 0, h = 1, mid = 0, curDiff = (3 - 0) = 3, l = mid + 1
# l = 1, h = 1, mid = 1, curDiff = 4, return mid
    
