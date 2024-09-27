class MinHeap
{
  List<Integer> minHeap;

  public MinHeap() {
	  this.minHeap = new ArrayList<>();
  }

  private void minHeapify(int index)
  {
    int parent = (index - 1) / 2;

    while(parent >= 0 )
    {
      if(this.minHeap.get(index) < this.minHeap.get(parent))
      {
        swap(parent, index);
        index = parent;
        parent = (index - 1) >= 0
                 ? index - 1
                 : -2/ 2;
      }
      else {
    	  break;
      }

    }

  }

  public void insert(int key)
  {
    int count = this.minHeap.size();
    this.minHeap.add(count, key);
    this.minHeapify(count);
  }

  public int getMin()
  {
    if(!this.isEmpty())
      return this.minHeap.get(0);

    return -1;
  }

  public boolean isEmpty()
  {
    return this.minHeap.size() < 0;
  }

  public int extractMin()
  {
    if(this.isEmpty())
      return -1;

    int temp = this.getMin();
    int len = this.minHeap.size();
    int last = this.minHeap.get(len -1);
    this.minHeap.remove(len-1);
    this.minHeap.set(0, last);

    this.validateHeap(0);

    return temp;
  }

  private void validateHeap(int index)
  {
    int[] children  = new int[2];

    int count = this.minHeap.size();

    if(count == 1) return;

    children[0] = index * 2 + 1 < count
                  ? this.minHeap.get(index * 2 + 1)
                  : Integer.MAX_VALUE;

    children[1] = index * 2 + 2 < count
                  ? this.minHeap.get(index * 2 + 2)
                  : Integer.MAX_VALUE;

    if(children[0] < children[1]){
      swap(index, index * 2 + 1);
      this.validateHeap(index * 2 + 1);
    }
    if(children[1] < children[0]){
      swap(index, index * 2 + 2);
      this.validateHeap(index * 2 + 2);
    }

  }

  private void swap(int i, int j)
  {
    int temp = this.minHeap.get(i);
    this.minHeap.set(i, this.minHeap.get(j));
    this.minHeap.set(j , temp);

  }


  public void printHeap() {
	  if(this.minHeap.size() > 0){
		 int count = 0;
		 while(count < this.minHeap.size()) {
			 System.out.print(this.minHeap.get(count) + " - ");
			 count++;
		 }
		 System.out.println();
	  }
  }
}
