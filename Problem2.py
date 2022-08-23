'''
MIN HEAP
TIME COMPLEXITY:
    insert: O(logn)
    remove: O(logn)
SPACE COMPLEXITY: O(N)
LEETCODE: question doesn't exist
ANY PROBLEMS FACED: nope nothing major
'''

def get_parent_node(idx):
    if idx / 2 == 0:
        # last_index is right node
        parent_node = (idx -2) // 2
    else:
        # last_index is left node
        parent_node = (idx - 1) // 2
    return parent_node


def get_child_nodes(idx):
    left_child = idx * 2 + 1
    right_child = left_child + 1

    return left_child, right_child


def insert(e):
    min_heap.append(e)
    idx = len(min_heap) - 1
    parent_node = get_parent_node(idx)
    while idx > 0 and min_heap[parent_node] > min_heap[idx]:
        min_heap[parent_node], min_heap[idx] = min_heap[idx], min_heap[parent_node]
        idx = parent_node
        parent_node = get_parent_node(idx)

def get_min():
    if len(min_heap) == 0:
        return None
    return min_heap[0]


def extract_min(min_heap):
    if len(min_heap) == 0:
        return min_heap
    # put last element into first one and balance the tree
    min_heap[0] = min_heap[len(min_heap)-1]
    # usually last element is kept, but I am deleting for simplicity
    min_heap = min_heap[:-1]
    ln = len(min_heap)
    idx = 0

    while idx < ln-1:
        lc, rc = get_child_nodes(idx)
        idx_small_child = None
        if lc <= ln -1 and rc <= ln -1:
            if min_heap[lc] < min_heap[rc]:
                idx_small_child = lc
            else:
                idx_small_child = rc
        elif rc <= ln -1:
            idx_small_child = rc
        elif lc <= ln -1:
            idx_small_child = lc

        if idx_small_child != None and min_heap[idx] > min_heap[idx_small_child]:
            min_heap[idx], min_heap[idx_small_child] = min_heap[idx_small_child], min_heap[idx]
            idx = idx_small_child
        else:
            break

    return min_heap


min_heap = []

# i - insert,  m - get_min, r - extract_min, p - print min heap array
operation = ['i','i','i','p','i','i','i','i','p', 'm', 'r', 'p','r', 'r', 'p', 'i', 'i','i', 'p','r','r','r','r','r','r','r','r','r','r','p']
element = [23, 98, 9, '', 35, 67, 1,78, '', '', '','', '', '', '', 62, 59, 3, '', '', '', '', '', '', '', '', '', '', '','']


for o, e in zip(operation, element):
    if o == 'i':
        insert(e)
    elif o == 'm':
        print(get_min())
    elif o == 'r':
        # extract_min()
        print('removing ', get_min())
        min_heap = extract_min(min_heap)
    elif o == 'p':
        print(min_heap)

