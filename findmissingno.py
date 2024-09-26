'''
ttime complexity: O(n)
space complexity: O(1)
'''
def findMissing(arr):
    if(len(arr)==0):
        return 0

    l = 0
    r = len(arr)-1

    while((r-l)>1):
        mid = l + (r-l)//2

        
        if(arr[mid]>mid+1):
            r = mid 
        else:
            l = mid 
    return arr[l]+1
arr = [1,3,4,5,6,7,8,9]
#arr = [1,2,3,5,6,7,8]
#arr = [1,2,3,4,5,6,8,9]
print(findMissing(arr))

'''
1,3,4,5,6,7,8,9
l = 0, r = 7
mid = 3

4!=5

l = 0, r = 2
mid = 1
arr[mid] != mid+1


'''