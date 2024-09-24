// this is a generalized solution for any n consecutive integers and just the first n integers
class Solution{
	public static int search(int []nums){
		int i=0,j=nums.length-1;
		while(i<j){
			int mid = i + (j-i)/2;
			if(nums[mid]-nums[i]==(mid-i)){
				i=mid+1;
			}
			else{
				j=mid-1;
			}
		}
		if(i==0 || (nums[i]-nums[i-1]==1)){
			return nums[i]+1;
		}
		else if(i==nums.length-1 || (nums[i+1]-nums[i]==1)){
		return nums[i]-1;
		}
		return -1;
	}

	public static void main(String []args){
	    int test_case=search(new int[]{1,3,4,5,6,7,8,9}); 
		if(test_case==2){
			System.out.println("pass");
		}
		else {
		    System.out.println("fail");}
		test_case = search(new int[]{1,2,3,4,5,6,7,9});
		if(test_case==8){
			System.out.println("pass");
		}
		else {System.out.println("fail");}
		test_case = search(new int[]{1,3});
		if(test_case==2){
			System.out.println("pass");
		}
		else {System.out.println("fail");}
	}
}
