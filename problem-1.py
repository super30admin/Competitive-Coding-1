# time complexity: O(Logn)
# space complexity: O(1)

def findMissing(list1):
    low=0
    high=len(list1)-1
    while(low<=high):
        mid=(low+high)//2
        if (list1[mid]-list1[mid-1])>1:
            print(list1[mid]-1)
            break
        else:
            if (list1[mid]-mid)==1:
                low=mid+1
            elif (list1[mid]-mid)>1:
                high=mid-1
# findMissing([1,2,3,4,5,7])
