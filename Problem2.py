def insert(nums,num):
    nums.append(num)
    ind = len(nums) - 1
    while nums[ind // 2] > nums[ind]:
        temp = nums[ind]
        nums[ind] = nums[ind // 2]
        nums[ind // 2] = temp

        ind = ind // 2

def getmin(nums):
    if len(nums) != 0:
        return nums[0]
    else:
        print("Empty heap!")

def isLeaf(nums,pos):
    l = len(nums) - 1
    if pos < (l // 2):
        return False
    else:
        return True

def min_heapify(nums,pos):
    if not isLeaf(nums, pos):
        left = 2 * pos + 1
        right = 2 * pos + 2
        if right < len(nums) and nums[pos] > min(nums[left],nums[right]):
            if nums[left] < nums[right]:
                temp = nums[pos]
                nums[pos] = nums[left]
                nums[left] = temp
                min_heapify(nums, left)
            else:
                temp = nums[pos]
                nums[pos] = nums[right]
                nums[right] = temp
                min_heapify(nums, right)

        else:
            if nums[pos] > nums[left]:
                temp = nums[pos]
                nums[pos] = nums[left]
                nums[left] = temp
                min_heapify(nums, left)



def extract_min(nums):
    nums[0] = nums[len(nums)-1]
    nums.pop()
    min_heapify(nums, 0)

def main():
# demonstrate the implementation
    nums = [13,16,31,41,51,100,41]
    insert(nums, 2)
    print(getmin(nums))
    extract_min(nums)
    print(nums)

if __name__ == "__main__":
    main()
