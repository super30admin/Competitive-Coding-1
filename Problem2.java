import java.util.ArrayList;
import java.util.List;

class Problem2{ // Min Heap

    public List<Integer> minHeap;


    Problem2(){
        minHeap = new ArrayList<>();
    }
    public void insert(int val){

        //1)Append
        //2)Bubble up
        minHeap.add(val); //1)
        int currentIndex = minHeap.size() - 1;


        //2)

        int parentIndex = (currentIndex - 1) / 2;

        while(parentIndex > -1){

            if(minHeap.get(parentIndex) > minHeap.get(currentIndex)){
                int temp = minHeap.get(parentIndex);
                minHeap.set(parentIndex,minHeap.get(currentIndex));
                minHeap.set(currentIndex,temp);
                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1)/ 2;
            }else{
                break;
            }
        }


    }

    public int remove(){

        //1)Swap first and last element
        //2)Bubbling down

        if(minHeap.size() == 0){
            return -1;
        }

        int firstElement = minHeap.get(0);
        int lastIndex = minHeap.size() - 1;

        //Swap
        int temp = minHeap.get(0);
        minHeap.set(0,minHeap.get(lastIndex));
        minHeap.set(lastIndex, temp);

        int currentIndex = 0;

        while((currentIndex * 2) + 2 < minHeap.size()){

            if((currentIndex * 2) + 1 < minHeap.size() && minHeap.get(currentIndex) > minHeap.get((currentIndex * 2) + 1)){
                int temp1 = minHeap.get(currentIndex);
                minHeap.set(currentIndex,minHeap.get((currentIndex * 2) + 1));
                minHeap.set((currentIndex * 2) + 1, temp1);
                currentIndex = (currentIndex * 2) + 1;

            }

            if((currentIndex * 2) + 2 < minHeap.size() && minHeap.get(currentIndex) > minHeap.get((currentIndex * 2) + 2)){
                int temp2 = minHeap.get(currentIndex);
                minHeap.set(currentIndex,minHeap.get((currentIndex * 2) + 2));
                minHeap.set((currentIndex * 2) + 2, temp2);
                currentIndex = (currentIndex * 2) + 2;
            }

        }

        minHeap.remove(minHeap.size() - 1); // Removing the last element
        return firstElement;
    }

    public int getMin(){
        return minHeap.get(0);
    }

    public int size(){
        return minHeap.size();
    }


}
