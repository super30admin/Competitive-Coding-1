## Competitive-Coding-1
## Please submit the interview problems posted in slack channel here. The problems and statements are    intentionally not shown here so that students are not able to see them in advance 

# The array should have at least 2 elements as average of those elements will be the missing integer.
# We will store the difference of the middle, first and last element with its index as it will help
# to determine whether the missing integer is on the left side / right side of the array following 
# Binary Search
# If the mid difference is not equal to the first element difference the we search in the left side of
# the array else the right part of the array.
# Finally we will return the average as it will be the missing integer. Since array is sorted and from
# 1 to n, the integers will have a constant difference evaluating with the element and its index. 
