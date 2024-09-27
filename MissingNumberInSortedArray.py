# Time Complexity : O(logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
def findmissing(arr, N):
    low=0
    high=len(arr)-1
    mid=0
    #We are iterating the array till we reach the base case where we have only two numbers, i.e [arr[low],arr[high]] -> 1-0 = 1
    while(high - low >= 2):
        #Calculate the mid
        mid = low+(high-low)//2
        #Difference between mid element and it's index
        midIndex = arr[mid]-mid
        #Difference between low element and it's index
        lowIndex = arr[low]-low
        #Difference between high element and it's index
        highIndex = arr[high]-high
        #This condition says that we have to iterate right of binary tree as missing number exists in the right
        if(midIndex != lowIndex):
            high=mid
        #This condition says that we have to iterate left of binary tree as missing number exists in the left
        elif(midIndex != highIndex):
            low=mid
        #By this time we reach the base case where there are only two elements left in the array
    return (arr[low]+arr[high])//2
    
def main():
    arr= [1, 2, 3, 4, 5, 7, 8]
    N = len(arr)
    result= findmissing(arr, N)
    print (result)
if __name__ == "__main__":
    main()