#TC = O(n)
#SC = O(1)
# Compiled and run on LC

def findMissing(arr, n):
    l, h = 0, n - 1
    mid = 0

    while (h > l):

        mid = l + (h - l) // 2


        if (arr[mid] - mid == arr[0]):

            if (arr[mid + 1] - arr[mid] > 1):
                return arr[mid] + 1
            else:


                l = mid + 1

        else:


            if (arr[mid] - arr[mid - 1] > 1):
                return arr[mid] - 1
            else:


                h = mid - 1


    return -1



arr = [-9, -8, -7, -5, -4, -3, -2, -1, 0]
n = len(arr)

print(findMissing(arr, n))