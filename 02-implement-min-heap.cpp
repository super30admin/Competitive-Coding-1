/*
TC - O(logN) for push/pop, O(N) for heapify
SC - O(N) to hold the elements
*/


/*
Issues Faced with CPP Syntax - Need to Improve

- class syntax is rusty
- declared access specifiers but not entirely sure I have written it in Java style or not. Pretty sure it is C++ style though.
- can I put function prototypes and the implementations in the class itself? or do prototypes go inside and I use scope resolution operators to resolve and implement outside?
- is a minHeap only for integers? how do I templatize this? Should I do this, given an interview situation? Probably better to ask the interviewer.
- I forgot that I need a constructor and destructor for this

*/

/*

Issues faced with Min Heap Implementation
- what are the internal data structures a heap holds?
- an array or a vector? does it matter? yes, probably does in terms of ease of dynamic resizing.

*/


class minHeap {
    private:
    vector<int> heapData;

    public:
    int heapPop() {
        if (heapData.size() == 0) {
            return -1;
        } 
        int poppedValue = heapData[0];

        heapData[0] = heapData.back();
        heapData.pop_back();

        int n = heapData.size();
        int currParent = 0;

        while (2*currParent + 1 < n) {
            int leftChild = 2 * currParent + 1;
            int rightChild = 2 * currParent + 2;
            int smallest = currParent;

            if (heapData[leftChild] < heapData[smallest]) {
                smallest = leftChild;
            }
            if (rightChild < n && heapData[rightChild] < heapData[smallest]) {
                smallest = rightChild;
            }
    
            if (smallest != currParent) {
                swap(heapData[smallest], heapData[currParent]);
                currParent = smallest; // Move down further to fix this now
            } else {
                break; // we have placed it
            }
            
        }

        return poppedValue;


    }
    
    void heapPush(int x) {
        heapData.push_back(x);
        int i = heapData.size() - 1;
        while (i != 0) {
            int parentNode = (i-1)/2;

            if (heapData[i] < heapData[parentNode]) {
                swap(heapData[i], heapData[parentNode]);
                i = parentNode;
            } else {
                //placed correctly, can break
                break;
            }

        }
    }


    // minHeap(int* arr, int size); >> you do NOT keep prototypes and declarations in the same scope. Could take the
    //latter out using SRO though
    ~minHeap() {

    }

    // void heapify(vector<int> &arr) { >> no need to pass it, we already have it in the class
    //this is floyd's algorithm - uses bottom-up approach in O(N)
    //Faster than inserting elements one by one, which is O(NlogN)
    void heapify() {
        int n = heapData.size();
        //start at the last non-leaf node
        if (heapData.size() == 0) {
            return;
        }

        int smallestChild = (n/2) - 1;

        //iterate backwards to the root

        for (int i = smallestChild ; i >= 0; i--) {
            //sift down node i, while it has at least one child to compare to
            /*
                - look at the current parent node and its two children
                - find the smallest value amoung the three
                - swap the parent with that smallest value, if the child is smaller
                - repeat this process at the new child position until the parent is smaller than both its children, or becomes a leaf
            */
           
            int currParent = i;
            while (2 * currParent + 1 < n) { //While a left child exists
                int leftChild = 2*currParent + 1;
                int rightChild = 2*currParent + 2;
                int smallest = currParent;

                if (heapData[leftChild] < heapData[smallest]) {
                    smallest = leftChild;
                }

                if (rightChild < n && heapData[rightChild] < heapData[smallest]) {
                    smallest = rightChild;
                }

                if (smallest != currParent) { //something was smaller
                    swap(heapData[smallest], heapData[currParent]); //swap them!
                    currParent = smallest; //moves us down the tree
                } else {
                    break;//no more sifting since we are in the right spot
                }

            }

        }

        //sift/percolate down each node
        //find the smallest child
        //compare with parent
        //repeat down the tree

    }

    minHeap(int* arr, int size){
        //how do I iterate over this?
        //sizeof will not work because this pointer has been flattened, so I will get the sizeof the integer pointer instead
        //isn't size a reserved keyword?
        for (int i = 0; i< size; i++) {
            heapData.push_back(arr[i]);
        }
        heapify();
    }

    
};
