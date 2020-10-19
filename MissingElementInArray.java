package WeeklyInterviews;

// Time Complexity: O(log n)
// Since we are doing binary search by reducing search space by half.

// Space Complexity: O(1) 
// No extra space used.

// Did this code successfully run on Eclipse : Yes

// Any problem you faced while coding this : No

// Approach: 
// The diff of element and its index in the array is the driving factor in logic.
// If (diff of mid element and its index(=mid)) is same as (diff of start element and its index(=start)) 
//      => Left of mid has no missing element => missing element should be found in right part of mid => so reset start pointer to mid.
// else 
//     Left of mid has missing element =>  so reset end pointer to mid.



public class MissingElem_Oct18_Refined {

	public int search(int arr[]) {

		// edge cases
		if (arr == null || arr.length < 2) {
			return -1;
		}

		int start = 0, end = arr.length - 1;

		// Applying binary search to the given array
		while (start <= end) {

			int mid = start + (end - start) / 2;

			int diff1 = arr[start] - start;
			int diff2 = arr[mid] - mid;
			int diff3 = arr[end] - end;

			// when only two elements are left in the array (i.e. start and end pointer are next to each other)
			if (end == start + 1 ) {
				// check if diff of first element and its index(=start)) is same as (diff of second element and its index(=end))
				//   => If yes, no missing elements in array, so return -1.
				//   => If no, missing element returned by using formula: (arr[start] + arr[end]) / 2
				//           Example:  {6, 8}  Missing elem = (6+8)/2 = 7
				if(diff1 == diff3)
				return -1;
				else
					return (arr[start] + arr[end]) / 2;	
			}
			
			if (diff1 == diff2) {
				start = mid;
			} else {
				end = mid;
			}

		}

		return -1;

	}

	public static void main(String[] args) {

		MissingElem_Oct18_Refined s = new MissingElem_Oct18_Refined();
		int arr[] = { 4,6};
		int result = s.search(arr);
		if (result != -1)
			System.out.println("Number missed is " + result);
		else
			System.out.println(" No number is missed");

	}

}
