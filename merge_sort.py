def merge(left_arr: list, right_arr: list) -> list:
    left = 0
    right = 0
    left_end = len(left_arr)
    right_end = len(right_arr)
    result = []
    while left < left_end and right < right_end:
        if left_arr[left] <= right_arr[right]:
            result.append(left_arr[left])
            left += 1
        else:
            result.append(right_arr[right])
            right += 1
    while left < left_end:
        result.append(left_arr[left])
        left += 1
    while right < right_end:
        result.append(right_arr[right])
        right += 1
    return result


def merge_sort(arr: list) -> list:
    if len(arr) == 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)


if __name__ == '__main__':
    print(merge_sort([4, 3, 2, 1, 6, 7]))
