def missing_element(arr):
    low , high = 0, len(nums) -1
    while low<high:
        mid = (low+high)//2

        if arr[mid] != mid + arr[0]:
            if mid == 0 or arr[mid - 1] == (mid - 1) + arr[0]:
                return mid + arr[0]
            high = mid - 1
        else:
            low = mid + 1

    # If no missing element is found in the loop
    return None


nums = [1,2,3,5,6,7,8]
print(missing_element(nums))