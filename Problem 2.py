import queue

# Creating empty priority queue
pQueue = queue.PriorityQueue()

# Adding items to the priority queue
# using put() method
pQueue.put(10)
pQueue.put(30)
pQueue.put(20)
pQueue.put(400)

# Printing the most priority element
print("Head value using peek function:", pQueue.queue[0])

# Printing all elements
print("The queue elements:")
while not pQueue.empty():
    print(pQueue.get())

# Removing the top priority element (or head) and
# printing the modified pQueue using get()
pQueue.get()
print("After removing an element with get function:")

while not pQueue.empty():
    print(pQueue.get())

# Removing 30 using remove()
pQueue.queue.remove(30)

print("after removing 30 with remove function:")
while not pQueue.empty():
    print(pQueue.get())

# Check if an element is present using contains()
b = 20 in pQueue.queue
print("Priority queue contains 20 or not?:", b)

# Getting objects from the queue and print them
arr = list(pQueue.queue)
print("Values in array:")
for i in arr:
    print("Value:", i)
