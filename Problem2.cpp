int findMin(vector<int> a){
    return a[0];
}

void printHeap(vector<int> ans){
    for (auto i : ans){
        cout<<i<<"\t";
    }    
    cout<<"\n";
}

vector<int> heapify(vector<int> a, int i){
    int left = 2*i +1;
    int right = 2*i +2;
    int smallest = i;
    
    if((left<a.size())&&(a[left]<a[smallest])){
        smallest = left;
    }
    if((right<a.size())&&(a[right]<a[smallest])){
        smallest = right;
    }
    
    if(smallest != i){
        swap(a[i], a[smallest]);
        heapify(a, smallest);
    }
    printHeap(a);
    return a;
}

vector<int> insert(vector<int> a, int ele){
    a.push_back(ele);
    int i = a.size()-1;
    while(i != 0 && a[(i-1)/2] > a[i]){
        swap(a[i], a[(i-1)/2]);
        i = (i-1)/2;
    }
    return a;
}

vector<int> extractMin(vector<int> ans){
    if(ans.size()==0){
        cout<<"Heap is Empty";
        return ans;
    } 
    else{
    ans[0]=ans[ans.size()-1];
    ans.erase(ans.begin()+ans.size()-1);
    ans = heapify(ans, 0);
    }
    return ans;
}

int main() {
   vector<int> heap = {4, 5, 6, 7, 8, 9};
    cout<<findMin(heap)<<"\n";
    heap = insert(heap, 3);
    printHeap(heap);
    heap = extractMin(heap);
    printHeap(heap);
    
    
    return 0;
}
