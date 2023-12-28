// Problem Statement
// Provide an array of n-1 integers in the range of 1 to n with no duplicates in list,
// One of the integers is missing in the list.Write a code to find the missing integer.

// Examples:
// Input : arr[] = [1, 2, 3, 5, 6, 7, 8]
// Output : 4

// Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]
// Output : 3

const missingNumber = (arr) => {
    let low = 0;
    let high = arr.length - 1;
    let mid = 0;

    while (high - low >= 2) {
        mid = Math.floor((low + high) / 2);
        let lowCompare = arr[low] - low;
        let midCompare = arr[mid] - mid;
        let highCompare = arr[high] - high;
        if (midCompare !== lowCompare) {
            high = mid;
        }
        else if (highCompare !== midCompare) {
            low = mid;
        }
    }
    return ((arr[low] + arr[high]) / 2);
}
  
console.log(missingNumber([1, 2, 3, 4, 5, 6, 8]));
console.log(missingNumber([1, 3, 4, 5, 6]));
console.log(missingNumber([1, 2, 4, 5, 6, 7]));

//T(n) = log(n). Because we are splitting the array size into half each time for binary search.