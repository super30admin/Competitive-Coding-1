"""
time complexity: O(n)
space complexity: O(1)
issues faced: implementing the code
"""
def missingElement(ar,size):
    l=0
    h= size-1
    mid =0
    while(h>l+1):
        mid = (l+h)//2
        print("mid=",mid)
        if ar[l]-l != ar[mid]-mid:
            h=mid
            print("h=",h)
        if ar[h]-h != ar[mid]-mid:
            l = mid
            print("l=",l)
    return ar[l] +1
if __name__ == '__main__':
    # print("I am in main")
    x = missingElement([1,2,3,4,5,6,8], 7)
    print("missing element:", x)
