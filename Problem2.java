//Time complexity : log base 2 of N;
/* The approach is that if i get an array of integers, i am assuming the first element of array is in root of heap sort then
*  from next element i keep checking if it is greater than root, if it is yes then i swap and i keep rearranging all the
* elements until i get the heap tree.
*/
Class MinHeap{
public void designMinHeap(int[] arr, int n){
	int n = 0; // assuming to design a min heap so taking the first index in array
	int temp = arr[n];
	while(n==0 && arr[n/2] > arr[n]){
	arr[n] == arr[n/2];
	n = n/2;	
}
arr[n] = temp;
}

public static void createMinHeap(){
    int[] arr = [3,15,17,10,84,19,6,22,9];
    int n = 0;
    MinHeap min = new MinHeap();

    for(int i=0; i<arr.length-1; i++){
        min.designMinHeap(arr,i);
    }
    system.out.print('Min Heap Array -> '+arr); // expected output is  [3,9,6,10,84,19,17,22,15]
}
}
