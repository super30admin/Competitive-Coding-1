package leetcode;
class MinHeap {
    int[] arr;
    int size;

    public MinHeap() {
        arr = new int[1000];
    }
    public void heapifyDown(int root ){
        arr[0] = root;
        int index = 0;
        while ((arr[index] > arr[2*index+1]) || (arr[index] > arr[2*index+2])){
            if(arr[2*index+1] > arr[2*index+2]){
                if((2*index+2)>size){return;}
                swap(2*index+2,index);
                index=2*index+2;
            }else{
                swap(2*index+1,index);
                index=2*index+1;
            }
        }
    }
    public void remove(){
        if(size==0){return;}
        int temp = arr[size-1];
        size--;
        heapifyDown(temp);

   }
    public int getMin() {
        if(size==0) {
            System.out.println("there is no element in array");
            return -1;
        }
        return arr[0];
    }

    public void swap(int cpos, int ppos) {
        int temp = arr[cpos];
        arr[cpos] = arr[ppos];
        arr[ppos] = temp;
    }

    public void print(){
        for(int i=0; i <size;i++){
            System.out.println(arr[i]);
        }
    }

    public void insert(int val) {
        int index = size;
        arr[index] = val;
        while (arr[index] < arr[(index - 1) / 2]) {
            int parentPos = (index - 1) / 2;
            swap(index, parentPos);
            index = (index - 1) / 2;
        }
        size++;
    }


    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(50);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(1);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.remove();
        minHeap.remove();
        minHeap.remove();
        minHeap.remove();minHeap.remove();minHeap.remove();minHeap.remove();
        minHeap.insert(1);
        minHeap.insert(3);
        minHeap.insert(2);
        System.out.println("minimum :"  + minHeap.getMin());
        minHeap.print();
    }
}