#Time Complexity is O(logn) as we are using binary search
#Space Complexity is O(1) 
#Ran successfully on leetcode compiler
#Faced no problems while coding

class Search(object):
    def search(self,ar, size):
        #Checking whether size of the array is 0 or not
        if(size==0):
            return "Array size i 0"
        else:
            self.low=0
            self.high=size-1
            while(self.high-self.low>=2):
                #Checking the mid value
                self.mid=self.low+(self.high-self.low)//2
                #Checking the difference between mid index and mid index value
                self.midIndexDiff=ar[self.mid]-self.mid
                #Checking the difference between the low index and low index value
                self.lowIndexDiff=ar[self.low]-self.low
                #if the value is missing towards left side
                if(self.midIndexDiff!=self.lowIndexDiff):
                    self.high=self.mid
                #if the value is missing towards right side
                else:
                    self.low=self.mid
            #returning missing value
            return (ar[self.low]+ar[self.high])//2


# Driver Code
a = [1, 2, 3, 5, 6, 7, 8]
n = len(a)
obj=Search()
print("Missing number:", obj.search(a, n))

