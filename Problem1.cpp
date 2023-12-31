Find the Missing Number in a sorted array

Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer. 


TC O(n)
SC O(1)
int search(vector<int>&arr, int size) {
	int low = 0;
	int high = arr.size()-1;
	int mid = 0;
	while((high - low) >= 2)) {
		mid = (low + (high - low)/2);
		int lowidx = arr[low] - low;
		int mididx = arr[mid] - mid;
		int highidx = arr[high] - high;
		if (mididx != lowidx) {
			high = mid;	
		} else if (mididx != highidx) {
			low = mid;
		}
	}
	return ((arr[low] + arr[high])/2);
}

// geeks for geeks solution is not right
