// Provide an array of n-1 integers in the range of 1 to n with no duplicates in list, 
//One of the integers is missing in the list. Write a code to find the missing integer.
// Examples:
// Input : arr[] = [1, 2, 3, 5, 6, 7, 8]

// Output : 4

// Input : arr[] = [1, 2, 4, 5, 6, 7, 8, 9]

// Output : 3

// Checking for the missing element with the logic of finding index difference is 2 assuming 1 to N-1 consecutive numbers list.
public int binarySearch(int[] arr){

    //missing element
    
    int l = 0; int h = arr.length - 1;
  
    while(l < h){ //l = 3, h =3
        int mid = l + (h - l)/2;//4
        
        if(arr[mid] - m == 1){ // 6 - 4  !=1
            l = mid + 1; // 3
        }
        else{
            h = mid - 1;  // 3
        }
    }
    
    return h + 1;//3 + 1 = 4
}

// [1,2,3,5,6,7]