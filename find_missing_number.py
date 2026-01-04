#-------------Solution 1-------------
def find_missing_number_formula(arr, n):
    """
    arr: sorted list of n-1 integers from 1 to n
    n: the upper bound of the range
    Return the missing integer

    Approach : Taking the difference of Sum of Total array, and Sum of given array.
    Time Complexity : O(n) 
    Space Complexity : O(1)

    """
    # Formula to get the sum of all integers from 1 to n
    total_sum = n * (n + 1) // 2 
    arr_sum = sum (arr)
    missing_no = total_sum - arr_sum
    return missing_no

#-------------Solution 2-------------
def find_missing_number_binary(arr, n):
    """
    arr: sorted list of n-1 integers from 1 to n
    n: the upper bound of the range
    Return the missing integer

    Approach : In sorted array, the difference of index and the element would be exactly 1,
              If any no is missing the diff of next element would be 2.

    TIme Complexity : O(log n)
    Space Complexity : O(1)
    """
    l , r = 0 , n-2
    while l <= r:
        mid = (l + r) // 2
        print(l, r, mid)
        diff = arr[mid] - mid
        if diff == 1:
            l = mid + 1
        else:
            r = mid - 1
    print("mid:",mid)
    return arr[r] + 1

        
def main():
    # Read input
    # Example input:
    # 1 2 3 4 6 7 8
    arr = list(map(int, input("Enter the array elements separated by space: ").split()))
    # Since one number is missing, n = len(arr) + 1
    n = len(arr) + 1
    # Call the function
    missing = find_missing_number_binary(arr, n)
    # Print result
    print("Missing number:", missing)
if __name__ == "__main__":
    main()
