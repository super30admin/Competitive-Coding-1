# Space Complexity - O(1)
# Time Complexity - O(log n)

class BinarySearch:

    def __init__(self,array):
        self.array = array

    def binary_search(self):
        low = 0
        high = len(self.array)-1
        while(low<=high):
            # FInding mid
            mid = (low+high) // 2
            if (self.array[mid] - mid) > 1:
                ## trim righ most array
                high = mid - 1
                # trim the left half of the array
            else:
                low = mid + 1
        return low+1
    
a = BinarySearch([1,2,3,4,5,7,8])
print(a.binary_search())