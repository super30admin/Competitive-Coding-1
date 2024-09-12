#time complexity: O(logn)
#space complexity: O(1)

#array=[1,2,3,4,5,7]
#array=[1,3,4,5,6,7]
array=[24,25,26,28,29,30]
#array=[1,2,3,4,5,6,7,9]
low=0
high=len(array)-1
diff=array[0]-0

while(low<=high):
    mid=(low+high)//2
    if(low==mid and mid==high):
        if(array[mid]!=array[mid-1]+1):
            print("missing number is", array[mid]-1)
        else:
            print("missing number is", array[mid]+1)
    if(array[mid]-mid==diff):
        low=mid+1
    else:
        high=mid-1

