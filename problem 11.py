class optimal_sol():
    # the logic here is that if the numbers  are sorted and not missing any element inbetween then
    #  the difference between numbers and  their indices shoudl be same
    # ex: a=[1,2,3,4,5,6,7], low =0, high =6    mid element is a[3]=4 and a[low]=1 and a[high] = 7
    #a[3]-3=1 and a[4]-4=1 and a[0]-1=1
    def missing_number(self,a):
        low= 0
        high = len(a)-1

        while high - low >=2 : #search until 2 numbers are
            mid = (low + high) // 2
            middiff = a[mid] - mid
            lowdiff = a[low]-low
            #highdiff = a[high]-high
            if (middiff != lowdiff): #left part has missing number
                high=mid
            else:
                low=mid #right part has missing number
        return (a[low] + a[high])/2
class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.nums=nums
        self.n=max(self.nums)
        #print(self.n,len(nums))
        sum_n=(self.n*((self.n)+1))/2
        sum_arr = sum(self.nums)
        dif = sum_n - sum_arr
        return dif
        #print(sum_n,sum_arr)



a=[2,3,4,6,7,8,9]
f= optimal_sol()
print(f.missing_number(a))



