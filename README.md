# Competitive-Coding-1

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 


class Solution:
    def findMissingElement(self,list,l):
        low =0
        high = l-1
        while(low<=high):
            mid = int((low+high)//2)
            lowdiff = list[low]-low
            middiff = list[mid]-mid
            if lowdiff == middiff-1:
                break
            if lowdiff < middiff:
                high = mid -1
            else:
                low = mid+1
        
        return int((list[low]+list[high]))//2


if __name__ == '__main__':
    obj = Solution()
    list= [2,3,4,5,6,9,10]
    l =  len(list)
    missingElement = obj.findMissingElement(list,l)
    print(missingElement)

