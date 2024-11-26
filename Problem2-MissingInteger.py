# Time Complexity: O(logn)
# Space Complexity: O(1)
# Code tested and works

Array = [1,2,3,4,5,6,7,8,10]
# Border case if the first element is missing
if Array[0] == 2:
    print("Output: " + str(1))
else:
    l = 0
    r = len(Array) - 1
    while l <= r:
        m = int((l + r)/2)
        # Check if all elements including mid do not have missing element
        if Array[m] == m+1:
            # missing element is to the right part of the mid
            l = m + 1
        # Check if all the elements to the left of do not have missing element
        elif Array[m-1] == m:
            # mid index has the missing element
            print("Missing Element: " + str(m+1))
            exit(0)
        else:
            # missing element is to the left of mid
            r = m - 1
