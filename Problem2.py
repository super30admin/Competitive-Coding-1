
"""

    Student : Shahreen Shahjahan Psyche

    Time Complexity :
                insert : O(log N)
                getMin : O(1)
                extractMin : O(log N)

    Space Complexity : O(N)

    My code ran successfully for test cases that I have generated.

"""

from typing import List

class min_heap():
    def __init__(self):
        self.heap_list = []

    # This method inserts a value to the heap and then balances back to the min-heap property
    # Time complexity : O(log N)

    def insert(self, value):

        if len(self.heap_list) == 0:
            self.heap_list.append(value)
            return

        self.heap_list.append(value)

        start = 0
        end = len(self.heap_list)-1

        while(start<end):
            print(end)
            parent_index = end//2
            if self.heap_list[parent_index]>=self.heap_list[end]:
                 # swaps the new value with its parent if the value is less than its parent's value
                self.heap_list[parent_index] , self.heap_list[end] = self.heap_list[end], self.heap_list[parent_index]
                end = parent_index
            else:
                return
    
    # This method returns the minimum value from the heap
    # Time Complexity : O(1)

    def getMin(self):
        if len(self.heap_list) == 0:
            return
        return self.heap_list[0]
    

    # This method extracts the minimum value from the heap and rebalancees the heap
    # Time Complexity : O(log N)

    def extractMin(self):

        if len(self.heap_list) == 0:
            return
        
        start = 0
        end = len(self.heap_list) - 1

        # Swaps the first value with the last one. Because then I will pop the minimum value from the last of the array.
        self.heap_list[start] , self.heap_list[end] = self.heap_list[end], self.heap_list[start]
        min_val = self.heap_list.pop()

        while(start<end):
            # As 2*0 will result in 0, thats why it is checking that
            if start == 0:
                 left_child = 1
                 right_child = 2
            else:
                left_child = start*2
                right_child = left_child + 1
            # checking the edge case
            if left_child > len(self.heap_list)-1:
                return min_val
            # checking the edge case
            elif right_child > len(self.heap_list) - 1:
                # As if we are in this pary of the code, that means the left child exists. So, we can compare the parent value with its left child
                if self.heap_list[left_child]<self.heap_list[start]:
                    self.heap_list[left_child], self.heap_list[start] = self.heap_list[start], self.heap_list[left_child]
                    return min_val
            else:   
                # checking which child is less so that I can compare it with its parent's value
                if self.heap_list[left_child]<=self.heap_list[right_child]:
                    # comparing with its parents value
                    if self.heap_list[left_child]<self.heap_list[start]:
                        self.heap_list[left_child], self.heap_list[start] = self.heap_list[start], self.heap_list[left_child]
                        start = left_child
                    else:
                        return min_val
                else:
                    if self.heap_list[right_child]<self.heap_list[start]:
                        self.heap_list[right_child], self.heap_list[start] = self.heap_list[start], self.heap_list[right_child]
                        start = right_child
                    else:
                        return min_val
            
        return min_val

    # This method just prints the min-heap
    def print_heap(self):
        print("The current array that consist of the heap is : ")
        print(self.heap_list)
    


# Testing my solution
my_minheap = min_heap()
my_minheap.insert(3)
my_minheap.insert(5)
my_minheap.insert(9)
my_minheap.insert(1)
my_minheap.insert(6)
my_minheap.print_heap()
my_minheap.insert(8)
my_minheap.print_heap()
print("The current minimum value in heap is " + str(my_minheap.getMin()))
print("Deleted " + str(my_minheap.extractMin()))
my_minheap.print_heap()
print("Deleted " + str(my_minheap.extractMin()))
my_minheap.print_heap()
print("End of program")
        







