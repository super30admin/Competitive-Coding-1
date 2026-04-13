function result(arr) {
  const n = arr.length;
  let lo = 0,
    hi = n - 1;

  while (lo < hi) {
    const mid = (lo + hi) >>> 1;
    if (arr[mid] === mid + 1) {
      lo = mid + 1;
    } else {
      hi = mid;
    }
  }
  return lo + 1;
}

const arr = [1, 2, 3, 4, 6, 7, 8];
console.log(result(arr));
