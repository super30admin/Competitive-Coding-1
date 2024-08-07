# Time Complexity : O(N^2) 
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : I could not understand how to calculate middle values.


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:

        ans=[]

        for i in range(1,numRows+1):
            temp=[]
            s=1
            temp.append(1)
            for j in range(1,i):
                s=s*(i-j)//j
                temp.append(s)
            ans.append(temp)
        return ans

# Approach:

# I solved this problem
# by iterating over each row and calculating the values of each element in the row. I started by initializing
# an empty list `ans` to store the result. Then, I iterated over each row from
# 1 to `numRows`. For each row, we initialize an empty list `temp` to store
# the values of the current row. I also initialize a variable `s` to 1, which
# will be used to calculate the values of each element in the row.
# In each iteration, I append 1 to the `temp` list, which is the first element
# of each row in Pascal's Triangle. Then, I iterated over each element in the row from
# 1 to `i-1`. For each element, I calculate its value by multiplying the previous value
