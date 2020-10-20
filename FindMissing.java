public class FindMissing {

	public int findMissing(int[] arr) {
		if (arr.length == 0 || arr == null) {
			return -1;
		}
		int low = 0;
		int high = arr.length - 1;
		while (high - low >= 2) {
			int mid = low + (high - low) / 2;
			if ((arr[low] - low) != arr[mid] - mid) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return (arr[high] + arr[low]) / 2;

	}

	public static void main(String[] args) {
		FindMissing missNo = new FindMissing();
		System.out.println(missNo.findMissing(new int[] { 0, 1, 3, 4 }));

	}
}
