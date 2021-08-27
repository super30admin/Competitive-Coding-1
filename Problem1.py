def missing_element(array):
    l = 0
    r = len(array)-1
    

    while (r-l) >= 2:
        pivot = (l+r)//2
        if (array[pivot]-pivot) == (array[l]-l):
            l = pivot
        else:
            r = pivot
    return array[l] + 1



# array_test = [1,2,3,4,5,7] 
# array_test = [4,5,6,8,9,10] 

print(missing_element(array_test))
        
