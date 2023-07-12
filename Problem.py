class Solution:
    def find_min(arr):
        low=0
        high=len(arr)-1
        while(low<=high):
            mid=int(low+(high-low)/2)
            if(arr[mid]-mid==arr[low]-low):
                low=mid+1
            else:
                high=mid-1
        print(arr[high]-1)
        return arr[high]-1
#arr=[11,12,13,14,15,16,17,19]
arr=[33,35,36,37,38]
Solution.find_min(arr)