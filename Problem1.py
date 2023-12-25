def search(nums):
    l = 0
    h = len(nums) - 1

    while l <= h:
        mid = (l + h) // 2
        val = nums[mid]

        if val - 1 == mid:
            l = mid + 1
        else:
            if nums[mid-1] - 1 == mid - 1:
                return nums[mid] - 1
            else:
                h = mid - 1

def main():
    num = search([1,3,4,5,6,7,8])
    print(num)

if __name__ == "__main__":
    main()