def missing(arr,size):
    low=0
    high=size-1
    while low<=high:
        mid_point=(low+high)//2
        if arr[mid_point]-arr[0]==mid_point:
            low=mid_point+1
        elif arr[mid_point-1]-arr[0]==mid_point-1:
            return arr[mid_point]-1
        else:
            high=mid_point-1

    return -1

arr= [11, 12, 13, 14, 15, 16, 17,19]
size=len(arr)
print("Missing Element :",missing(arr,size))