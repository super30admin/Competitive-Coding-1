// TC : O(logn)
// SC : O(1)
// Ran on LeetCode : NA
// Problems : None.

int search(int ar[], int size)
{
	if (ar[0] != 1)
		return 1;
	if (ar[size - 1] != (size + 1))
		return size + 1;

	int a = 0, b = size - 1;
	int mid = 0;
	while ((b - a) > 1) {
		mid = (a + b) / 2;
		if ((ar[a] - a) != (ar[mid] - mid))
				b = mid;
		else if ((ar[b] - b) != (ar[mid] - mid))
				a = mid;
	}
	return (ar[a] + 1);
}