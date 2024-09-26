//Given program is not a leetcode problem
//Time complexity has been stated in front of each required method
class Problem2 {

	private int[] minHeap;
	private int currLen;
	private int maxLen;

	public Problem2(int maxLen)
	{
		this.maxLen = maxLen;
        minHeap = new int[this.maxLen + 1];
		this.currLen = 0;
		minHeap[0] = Integer.MIN_VALUE;
	}

	private boolean isLeaf(int i)
	{
        return (i > (currLen / 2));
	}
	
    private void minHeapify(int i)
    {	
        if(!isLeaf(i)){
            int swapIx = i;
            if((2*i + 1) <= currLen){
                if (minHeap[2*i]<minHeap[2*i + 1]){
                    swapIx = 2*i; 
                }
                else{
                    swapIx = 2*i + 1;
                }
            }
            else
                swapIx= minHeap[2*i];
            
            if(minHeap[i]>minHeap[2*i] || minHeap[i]> minHeap[2*i + 1]){
                int tmp;
		        tmp = minHeap[i];
		        minHeap[i] = minHeap[swapIx];
		        minHeap[swapIx] = tmp;
                minHeapify(swapIx);
            }
            
        }	
    }

    //Time Complexity = O(logn)
	public void insert(int n)
	{

		if (currLen >= maxLen) {return;}

		currLen++;
        minHeap[currLen] = n;
		int curr = currLen;

		while (minHeap[curr] < minHeap[curr/2]) {
            int tmp;
		    tmp = minHeap[curr];
		    minHeap[curr] = minHeap[curr/2];
		    minHeap[curr/2] = tmp;
			curr = curr/2;
		}
	}

    //Time Complexity = O(1)
	public int getMin(){
        return minHeap[1];
    }

    //Time Complexity = O(logn)
	public int extractMin(){
        int retMin = minHeap[1];
		minHeap[1] = minHeap[currLen--];
		minHeapify(1);

		return retMin;
	}

}

