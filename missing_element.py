from typing import List


class test:
    def find_missing(self, arr: List):
        low = 0
        high = len(arr) - 1
        while low < high:
            mid = low + ((high - low) // 2)
            if arr[mid] == mid + 1:
                low = mid + 1
            else:
                high = mid
        return arr[low] - 1


if __name__ == "__main__":
    _arr = [1, 2, 3, 5, 6, 7, 8]
    print(test().find_missing(_arr))
