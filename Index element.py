#TimeComplexity : O(LOGN)
#Space Complexity : O(1)
#Procedure:

def binarysearch(a):
    start = 0
    end = len(a)-1
    while(end - start >1 ): # when the index of the elements is ==1 we found the missing element
        mid = (start +end)//2
        # checks which start is not missing the element by doing operation shown below
        # and move start or end point opposite to it
        if (a[start] - start) == (a[mid] - mid):
            start = mid
        elif a[mid]-mid == a[end]-end:
            end = mid
    return (a[start] +a[end]) //2


a = [3,4,6,7]
k = binarysearch(a)
print(k)
