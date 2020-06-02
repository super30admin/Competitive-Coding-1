//Time complexity: O(log n)    //skipping half of the array every time
//Space Complexity: O(1)      //because not using any  extra space 


//Algorithm:
//1) Calculate mid, the check difference between midIndex and midIndexValue, lowIndex and lowIndexValue, highIndex and highIndexValue
//2) if midIndex and midIndexValue difference not equalto lowIndex and lowIndexValue diff then missing  no. is on left side, will move high to mid
//3) if midIndex and midIndexValue difference not equalto highIndex and highIndexValue diff then missing  no. is on right side, will  move low to high
//4) continue till high-low>=2
//5) diff is 2 then adding values at high and low and dividing by 2 to get the missing number.



class Main {
    public static int searchMissing(int []nums){
        int low=0;
        int high=nums.length-1;
        while(high-low>=2){                     //chhecking until the diff is greater than and equal to 2;
            int mid=low + (high-low)/2;
            int midDiffIndex=nums[mid]-mid;     //Calculating difference between index of mid and its value
            int lowDiffIndex=nums[low]-low;     //Calculating difference between index of low and its value
            int highDiffIndex=nums[high]-high;  //Calculating difference between index of high and its value
            if(midDiffIndex!=lowDiffIndex){     //if the difference of middiffindex and lowdiffindex is not equal then value is in left side moving high to mid
                high=mid;
            }else if(midDiffIndex!=highDiffIndex){         //if the difference of middiffindex and highdiffindex is not equal then value is in right side moving low to mid
                low=mid;
            }
        }
        return (nums[low]+nums[high])/2;                    // high-low diff is  two then missing lies in between, adding values and dividing by 2 to get the missing no.
    }
    
	public static void main (String[] args) {
	    int nums[]={1,2,4,5,6,7,8,9};
	    System.out.println("Missing number is: " + searchMissing(nums));
	}
}