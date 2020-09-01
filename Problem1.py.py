

#Method 1
#for sorted array I would prefer 2 pointer method mentioned below
# Time : O(nlogn) (As i am sorting)
# Space : O(1)


def twoSum(self, lst: List[int], target: int) -> List[int]:
    lst = enumerate(lst)
    lst = sorted(lst, key=lambda x: x[1])
    left, right = 0, len(lst) - 1

    while left < right:
        if lst[left][1] + lst[right][1] > target:
            right -= 1

        if lst[left][1] + lst[right][1] < target:
            left += 1

        if lst[left][1] + lst[right][1] == target:
            return [lst[left][0], lst[right][0]]





#Method 2
#Using HashMap to store index and num
# Time : O(n)  for the for loop
# Space : O(n) for the hashmap

def twoSum(self, nums: List[int], target: int) -> List[int]:
    ans = {}

    for index, num in enumerate(nums):
        if target - num in ans:
            return [ans[target - num], index]
        else:
            ans[num] = index