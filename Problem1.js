//Time: O(logn), Space: O(1)

function findMissing(arr) 
{ 
	let left = 0, right = arr.length - 1; 
	while (left <= right) { 
		let mid = left + Math.floor((right - left) / 2); 
		if (arr[mid] != mid + 1 && arr[mid - 1] == mid) 
		{
            return mid + 1;          
        }
		if (arr[mid] == mid + 1){
			left = mid + 1; 
        }else{
			right = mid - 1; 
        }
	} 
	return -1; 
} 