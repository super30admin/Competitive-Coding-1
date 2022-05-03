//Insert, Remove = O(logN)
//GetMin, Size = O(1)

class MinHeap{

  vector<int> vec;
  MinHeap{}

  int getMin(){
    return vec[0];
  }

  int size(){
    return vec.size();
  }

  void insert(int key){
    vec.push_back(key);
    bubbleUp(vec.size()-1);
  }

  void remove(){
     int x = vec[0];
     int y = vec[vec.size()-1];
     vec[0]=y;
     vec[vec.size()-1]=x;
     vec.pop_back();
     bubbleDown();
  }

  void bubbleUp(int index){
    int idx = index;
    if(idx==0) return;
    int parent = (idx-1/2);

    if(parent>=0 && vec[idx]<vec[parent]){
         int x = vec[idx];
         int y = vec[parent];
         vec[idx]=y;
         vec[parent]=x;
    }
    bubbleUp(parent);
  }

  void bubbleDown(int index){
      int idx = index;
      int left = 2*idx + 1;
      int right = 2*idx + 2;
      int temp = idx;

      if(left<vec.size() && vec[left]<vec[temp])
        temp = left;
      if(right<vec.size() && vec[right]<vec[temp])
        temp = right;
      if temp == idx
        return;

      int x = vec[idx];
      int y = vec[temp];
      vec[idx]=y;
      vec[temp]=x;
      bubbleDown(temp);
  }
};

