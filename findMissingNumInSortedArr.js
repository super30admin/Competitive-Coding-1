function findMissingNumInSortedArr(arr) {
    var left = 0;
    var right = arr.length - 1;
    while(left <= right) {
        var mid = Math.floor((left + right)/2);
        if(arr[mid] - arr[mid-1] === 2) return arr[mid] - 1;
        if(arr[mid] === mid + arr[0]) left = mid+1;
        else right = mid - 1;
    }
    return -1;
} 