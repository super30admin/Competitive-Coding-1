# your code goes here
def linMissingElem(nums):
	for i in range(len(nums)):
		if i == len(nums) - 1:
			return i + 2
		if nums[i] != i+1:
			return i + 1
 
def binMissingElem(nums):
 
	if nums[-1] == len(nums):
		return len(nums)+1
 
	l = 0
	r = len(nums) - 1
 
	while l < r:
		m = l + (r-l)//2
 
		if nums[m] > m+1:
			r = m-1
 
		else:
			l = m+1
 
	return l + 1
 
print(linMissingElem([1,3,4,5,6,7]))
print(binMissingElem([2,3]))