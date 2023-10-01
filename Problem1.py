# Problem Name: Interview Problem: Find Missing Number in a sorted array

# Source Link: https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

# Time Complexity :  O(log n) 
# Space Complexity :  O(1)

# Approach : To find the missing element optimally, binary search can be used. To cut down the search space,
# compare the number of elements present vs how many elements should actually be
# if they are equal that means the one half of the array doesn't have any missing values

def find_missing_element(arr):
    low = 0; high = len(arr) - 1
    no_of_elements = 0
    while low <= high:
        mid = low + (high - low) // 2
        no_of_elements = (mid + 1)
        if arr[mid] ==  no_of_elements:
            # the low to mid there are no elements missing. 
            low = mid + 1
        else:
            high = mid - 1
        
    return arr[high] + 1


def main():

    print(find_missing_element([1, 2, 3, 4, 6, 7, 8]))
    print(find_missing_element([1, 2, 3, 4, 5, 6, 8, 9]))

    print(find_missing_element([1, 3, 4, 5, 6, 7]))
    print(find_missing_element([1, 2, 3, 4, 5]))

    # Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
    # Output : 5

    # Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
    # Output : 7


if __name__ == "__main__":
    main()