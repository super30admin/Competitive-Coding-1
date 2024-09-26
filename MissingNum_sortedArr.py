def searchMissingElement(arr : []) -> int:
    start =0
    end = len(arr)-1
    startele = arr[0]
    while end - start >1:
        mid = start+(end-start)//2
        if arr[mid]==startele+mid:
            start = mid
        else:
            end = mid
    if arr[end] !=startele+end:
        return (startele+end)

print(searchMissingElement([5,7]))
           
            
        
        