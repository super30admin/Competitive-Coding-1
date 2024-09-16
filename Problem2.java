import java.util.ArrayList;

class MinHeap{
    ArrayList<Integer> arr;
    public MinHeap(){
        arr = new ArrayList<>();
    }
    
    public int getMin(){
        return arr.get(0);
    }
    
    public int size(){
        return arr.size();
    }

    public void insert(int num){
        arr.add(num);
        bubbleUp(arr,size()-1); //performing bubble up on last element
    }

    public int remove(){
        int temp = arr.get(0);
        arr.add(0,arr.get(size()-1));
        arr.add(size()-1,temp);
        temp = arr.remove(size()-1);
        bubbleDown(arr,0);
        return temp;
    }

    private void bubbleUp(ArrayList<Integer>arr, int index){
        if(index == 0) return;
        int parent = index/2;
        if(parent>=0 && arr.get(parent)>arr.get(index)){
            int temp = arr.get(parent);
            arr.add(parent,arr.get(index));
            arr.add(index,temp);
            bubbleUp(arr, parent);
        }  
    }

    private void bubbleDown(ArrayList<Integer> arr, int index){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int temp = index;

        if(left<arr.size() && arr.get(index)>arr.get(temp)){
            temp = left;
        } else if(right<arr.size() && arr.get(index)>arr.get(temp)){
            temp = right;
        }

        if(temp == index){
            return;
        }
        int tempVal = arr.get(temp);
        arr.add(temp,arr.get(index));
        arr.add(index,tempVal);
        bubbleDown(arr, temp);

    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        int[] nums = {15,28,16,32,31,20};
        for(int num:nums){
            heap.insert(num);
            System.out.println(heap);
        }

        for(int num:nums){
            System.out.println(heap.remove());
            System.out.println(heap);
        }
    }
}
