// Find Missing Number in a sorted array

function main(arr) {
    var size = arr.length;
 //Extreme cases
    if(arr[0]!=1)
        return 1;
    if(arr[size-1]!=(size+1))
        return size+1;
        
  var low = 0;
  var high = arr.length;
  while (low <= high) {
    var mid = Math.floor(low +(high-low)/2);
      console.log("mid", mid)
       console.log("arr[mid] o", arr[mid])
    if ((arr[mid]-mid === 1) && (arr[mid+1]-(mid+1) === 2)) {
        console.log("arr[mid]", arr[mid])
        return arr[mid]+1;
    }
    if (arr[mid]-mid === 1) {
        console.log("low", low)
      low = mid+1;
    } else {
        console.log("high", high)
      high = mid-1;
    }
  }
  return -1;
}
let a = [1,2,4,5,6,7]
let res = main(a);
console.log(res)