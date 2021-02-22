//TC: O(logN)
//SC: O(1)

#include <iostream>
#include <vector>
#include <stdio.h>

using namespace std;

int main() {
  
  std::vector<int> nums = {1, 3, 4, 5, 6};
  

  if(nums[nums.size()-1] == nums.size()){
    int missing = nums.size() + 1;
    std::cout<<missing;
    return 0;
  }

  if(nums[0] != 1){
    std::cout<<"1";
    return 0;
  }

  int l = 0;
  int r = nums.size()-1;

// Use binary search to find missing element. Search until left and right element are only one space apart. Then return left element.  

  while(r -l > 1){
    int mid = l + (r-l)/2;
    if(nums[mid] - mid == nums[l]-l)
      l = mid;
    else if(nums[mid] - mid == nums[r]-r)
      r = mid;
  }

  std::cout<<nums[r]-1;


  return 0;

}
