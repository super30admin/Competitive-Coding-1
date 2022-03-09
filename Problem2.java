//Time complexity = a. getMin() -> O(1)  b. extractMin() -> O(log n) c. push() -< O(log n)
//Space complexity = O(n)
//Approach: 
/**
 * for push, we put element at last empty location and then we bring it to its correct position by comapring with its parent
 * if element at parent is greater than current index, we swap them and continue till parent has smaller element
 * for pop, we copy element from last index to root that is index 0, then we heapity
 * in heapify, we compare child values with parent value. if parent has higher value, we swap it with smaller child value
 * and then continue till child values becomes greater than current index or we reach to leaf index.
*/

public class PriorityQueue {
	 int[] arr = new int[15];
	 int size = 15;
	 int length = 0;;
	
	private PriorityQueue(int size) {
		this.size = size;
		this.length = 0;
		this.arr = new int[size];
	}
	
	private  void push(int num) {
		if(length == 0) {
			arr[length] = num;
			length++;
			return;
		}else {
			if(length < size) {
				arr[length] = num;
				length++;
				int curr_pos = length - 1;
				while(parent(curr_pos) != -1 && arr[parent(curr_pos)] > arr[curr_pos]) {
					swap(parent(curr_pos), curr_pos);
					curr_pos = parent(curr_pos);
				}
			}else {
				System.out.println("PQ is full");
				return;
			}
		}
	}
	
	private  int getMin() {
		if(length == 0)return -1;
		return arr[0];
	}
	
	private  int pop() {
		if(length == 0)return -1;
		int ret = arr[0];
		arr[0] = arr[length-1];
		length--;
		heapify(0);
		return ret;
	}
	
	private  void heapify(int index) {
		
		//base
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		if(left >= length && right >= length)return;
		//logic
		
		//case 1. left is not null and right is null
		if(left < length && right >= length && arr[index] > arr[left]) {
			swap(index, left);
			heapify(left);
		}
		
		//case 2. right is not null and left is null
		else if(left >= length && right < length && arr[index] > arr[right]) {
			swap(index, right);
			heapify(right);
		}
		//case 3 both are not null
		else if(left <= length && right <= length) {
			if(arr[index] > arr[left] || arr[index] > arr[right]) {
				if(arr[left] <= arr[right]) {
					swap(index, left);
					heapify(left);
				}else {
					swap(index, right);
					heapify(right);
				}
			}
		}
		
	}

	private  void swap(int parent, int child) {
		int temp = arr[parent];
		arr[parent] = arr[child];
		arr[child] = temp;
		
	}

	private int parent(int index) {
		if(index == 0)return -1;
		if(index % 2 == 0) {
			return index / 2 - 1;
		}
		return index / 2;
	}
	
	public  void print()
    {
        for (int i = 0; i < length / 2; i++) {
 
            // Printing the parent and both childrens
            System.out.print(
                " PARENT : " + arr[i]
                + " LEFT CHILD : " + arr[2 * i + 1]
                + " RIGHT CHILD :" + arr[2 * i + 2]);
 
            // By here new line is required
            System.out.println();
        }
    }
	
	private boolean isEmpty() {
		if(length == 0)return true;
		else return false;
	}
	
	

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(15);
		pq.push(5);
		pq.push(3);
		pq.push(17);
		pq.push(10);
		pq.push(84);
		pq.push(19);
		pq.push(6);
		pq.push(22);
		pq.push(9);
		
		while(!pq.isEmpty()) {
			System.out.println("Popped: " + pq.pop());
			System.out.println("Curr min: " + pq.getMin());
		}
		

	}

}

