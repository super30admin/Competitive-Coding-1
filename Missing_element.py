#// Time Complexity :O(logn)
#// Space Complexity :O(1)
#// Did this code successfully run on Leetcode :yes
#// Any problem you faced while coding this :no

class missing_element:
    def __init__(self):
        self.array=[1,2,3,4,5,6,8]
    def find(self):
        if(self.array==[]):
            print("-1")
        else:
            left=0
            right=len(self.array)-1
            while(left<=right):
                mid=left+(right-left)//2
                if(self.array[mid]==mid+1):
                    left=mid+1
                else:
                    right=mid-1
            print("missing element in index "+str(left)+" is "+str(left+1))
obj=missing_element()
obj.find()
