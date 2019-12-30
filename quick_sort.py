def partition(arr: list, start: int, end: int) -> int:
    i = p_index = start
    pivot = arr[end]
    while i < end:
        if arr[i] < pivot:
            arr[p_index], arr[i] = arr[i], arr[p_index]
            p_index += 1
        i += 1
    arr[p_index], arr[end] = arr[end], arr[p_index]
    return p_index


def quick_sort(arr: list, start: int, end: int) -> None:
    if start < end:
        index = partition(arr, start, end)
        quick_sort(arr, start, index - 1)
        quick_sort(arr, index + 1, end)


if __name__ == '__main__':
    arr = [7, 5, 2, 3, 6, 4]
    quick_sort(arr, 0, len(arr) - 1)
    print(arr)
