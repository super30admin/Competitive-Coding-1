'''
array
size n-1
range 1 to n
array sorted


ex
1 2 3 5 6 7
1 2 4 5 6

left right mid iter
0       4   2    1
2       4   3
'''

def search(ar): 
    low = 0
    high = len(ar) -1
    mid = 0
    while low+1< high:
        mid = low + (high-low)//2
        print('low: ',low)
        print('ar[low]',ar[low])
        print('high: ',high)
        print('ar[high]',ar[high])
        print('mid',mid)
        print('ar[mid]',ar[mid])
        if (ar[low] - low) != (ar[mid] - mid): 
            high = mid 
        elif (ar[high] - high) != (ar[mid] - mid): 
            low = mid 
    return ar[mid]+1


print(search([1,3,4,5,6]))
        