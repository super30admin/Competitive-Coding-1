// Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, One of the integers is missing in the list. Write a code to find the missing integer.

// Examples:
// Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
// Output : 4

//Time Complexity- O(logn)
//Space Complexity- O(1)

int search(int ar[], int size)
{
	// Extreme cases
	if (ar[0] != 1)
		return 1;
	if (ar[size - 1] != (size + 1))
		return size + 1;

	int a = 0, b = size - 1;
	int mid;
	while ((b - a) > 1) {
		mid = (a + b) / 2;
		if ((ar[a] - a) != (ar[mid] - mid))                 //Elements to the left of missing element will have this property: ar[i]-i=1
			b = mid;
		else if ((ar[b] - b) != (ar[mid] - mid))            //Elements to the right of missing element will have this property: ar[i]-i=2
			a = mid;
	}
	return (ar[a] + 1);
}
