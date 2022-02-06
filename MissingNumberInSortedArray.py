# Time Complexity = O(logn)
# Space complexity = o(1)

def missing_number(arr,size):

    low = 0
    high = size -1

    while(high - low >=2):

        mid = low +(high - low)//2

        midIdiff = arr[mid] - mid
        lowIdiff = arr[mid] - low
        highIdiff =arr[high] - high

        if midIdiff != lowIdiff:
            high = mid
        elif midIdiff != highIdiff:
            low = mid
    return (arr[low]+arr[high])//2

arr = [4,7,9,10]
