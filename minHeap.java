public class MinHeap{
    List<Integer> tree;

    public MinHeap(){
        tree = new ArrayList<>();
    }

    // O(1);
    public int getMin(){
        return tree.get(0);
    }

    // O(logn)
    public int extractMin(){
        swap(0, tree.size()-1);
        int result = tree.get(tree.size()-1);
        tree.remove(tree.size()-1);
        heapify(0);
        return result;
    }

    // O(logn)
    public void insert(int value){
        tree.add(value);
        int index = tree.size()-1;
        
        while(index != 0){
            int parentIndex = findParent(index);
            if(tree.get(index) < tree.get(parentIndex)){
               swap(index, parentIndex);
            }
            else{
                break;
            }
            index = parentIndex;
        }
    }

    private void heapify(int index){
        if(getLeftChild(index) < (tree.size()-1) && getRightChild(index) < (tree.size()-1)){
            if(tree.get(index) > tree.get(getLeftChild(index))){
                swap(index, getLeftChild(index));
                heapify(getLeftChild(index));
            }
            if(tree.get(index) > tree.get(getRightChild(index))){
                swap(index, getRightChild(index));
                heapify(getRightChild(index));
            }
        }
    }

    private int getLeftChild(int index){
        return 2*index+1;
    }

    private int getRightChild(int index){
        return 2*index+2;
    }

    private void swap(int index1, int index2){
        int temp = tree.get(index1);
        tree.set(index1, tree.get(index2));
        tree.set(index2, temp);
    }

    private int findParent(int index){
        return (index-1)/2;
    }
}
