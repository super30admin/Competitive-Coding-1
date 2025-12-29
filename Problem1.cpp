// MISSING ELEMENT IN A SORTED ARRAY

int missingNumber(vector<int>& nums) {
    int low = 0, high = nums.size() - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (nums[mid] == mid + 1)// check if the index and the element are right or not for mid
        // if mid is at the right position it means,left half of mid sorted and theres nothing missing
            low = mid + 1;//hence we increment low by mid + 1
        else
            high = mid - 1;// if mid index and mid element dont pass the if condition
    }

    return low + 1;// after repetitive looping we will eventually come out of the loop when low>high 
    // in that case we can find the missing by returning low + 1
    // return "low" if you want the position where the element is supposed to be in
}

