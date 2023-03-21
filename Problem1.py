def find_missing_element(arr):
    low= 0
    high= len(arr)-1

    while low<=high:
        mid= low + (high-low)//2
        # Diff.
        low_diff= arr[low]-low
        mid_diff= arr[mid]-mid
        high_diff= arr[high]- high

        if low_diff==high_diff:
            return -1

        if mid_diff==high_diff:
            # Right side is sorted.
            if arr[mid-1]<arr[mid]-1:
                return arr[mid]-1
            high= mid-1
        elif mid_diff==low_diff:
            # Left is sorted.
            #[1,3]
            if arr[mid+1]>arr[mid]+1:
                return arr[mid] +1
            low= mid+1
    return -1


arr= [41, 42, 43,44,45,47,48,49]
print(f'{find_missing_element(arr= arr)}')