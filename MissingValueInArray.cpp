// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : No link provided
// Any problem you faced while coding this : No




/*Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 5, 6, 7, 8]



Output : 4





Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]



Output : 3


*/


#include<iostream>

#include<vector>
using namespace std;
class solution{
public: solution(){

}
public:
	int search_missing(std::vector <int> &nums){
		int low = 0;
		int high = nums.size()-1;

		while (low <= high){
			cout << low<< endl;
			cout << high<< endl;
			int mid = low + (high-low)/2;

			if ((nums[mid +1] - nums[mid] != 1)){
				return nums[mid] +1;
			}
			else if (nums[mid]-nums[mid -1] != 1){
				return nums[mid] -1;
			}
			else if ((mid -low )==(nums[mid]-nums[low])){
				low = mid +1;
			} else high = mid -1;

		}



		return -1;


	}


};

int main(){

solution s ;
vector <int> array1 {1,2,3,4,5,7};

int result = s.search_missing(array1);
cout << result<< endl;

return 0;
}