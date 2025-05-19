
// Time comnplexity for insert and remove is O(logn)
// Space complexity is O(n)

#include <vector>
#include <iostream>

using namespace std;

// Assumptions
// ints
// min heap

class priority_queue
{
private:
  vector<int> data_;
  size_t size_;
  size_t factor_;
  size_t capacity_;

  void trickle_up(int idx) 
  {
    if (idx == 0) 
    {
        return;
    }

    int parent = (idx - 1) / 2;
    if (data_[idx] < data_[parent]) 
    {
        swap(data_[idx], data_[parent]);
        trickle_up(parent);
    }
  }

  void trickle_down(int idx) 
  {
    int left = 2 * idx + 1;
    int right = 2 * idx + 2;
    if (left >= size_) 
    {
        return;
    }

    int smaller = left;
    if (right < size_ && data_[right] < data_[left])
        smaller = right;
    if (data_[idx] > data_[smaller]) 
    {
        swap(data_[idx], data_[smaller]);
        trickle_down(smaller);
    }
  }


public:
  priority_queue()
  {
    size_ = 0;
    factor_ = 1;
    capacity_ = factor_;
    data_.resize(capacity_);
  }

  void insert(int val)
  {
    if (size_ == capacity_)
    {
        factor_ *= 2;
        capacity_ += factor_;
        data_.resize(capacity_);
    }

    size_++;
    data_[size_ - 1] = val;
    trickle_up(size_ - 1);
  }

  int remove()
  {
    if (size_ == 0)
        throw runtime_error("Error");
    int ret = data_[0];
    data_[0] = data_[size_ - 1];
    size_--;
    trickle_down(0);
    return ret;
  }

  void print() const 
  {
    for (size_t i = 0; i < size_; ++i)
        cout << data_[i] << " ";
    cout << endl;
  }

};

int main() {
    cout << "The Min Heap is " << endl;

    priority_queue pq;
    pq.insert(5);
    pq.insert(3);
    pq.insert(17);
    pq.insert(10);
    pq.insert(84);
    pq.insert(19);
    pq.insert(6);
    pq.insert(22);
    pq.insert(9);

    pq.print();

    cout << "The Min val is " << pq.remove() << endl;
    return 0;
}
