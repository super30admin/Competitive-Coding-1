
/*arr = [1,2,4,5,6]
arr = [2,3,4,5,6];
arr = [1,2,3,4,5];*/

//missing no in sorted array
//TC = O(logn)
//SC = O(1)
vector<int> missingno{

 int  l = 0;
    int r = arr.size()-1;
    int mid;
while(l<=r){
	mid = l+(r-l)/2;
  //base case, average out the 2 numbers near a missing number in this kind of array to get the number, example 7 is missing?, average 6 and 8
	if(mid-1>=0&& arr[mid]-arr[mid-1]==2)
		 return (arr[mid]+arr[mid-1])/2 ;
	//if missing no is on left i.e. between 1 to mid, arr[mid]-mid would be >1
	else if(arr[mid]-mid > 1){
		r = mid-1;
	}
	else{
		l = mid+1;
	} 	
}
  //end conditions for edge cases where 1st or last no is missing
    if(mid == 0) return 1;
	return arr.size()+1;
}
