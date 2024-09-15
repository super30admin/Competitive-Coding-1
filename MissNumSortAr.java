public class MissNumSortAr {
        public int findMiss(int[] nums){
            int left = 0, right = nums.length - 1, middle;

            // binary search if there are more than two elements: invariant
            while(right - left > 2){

                middle = left + (right - left)/2;

                int midValIdxDif = nums[middle] - middle;
                int leftValIdxDif = nums[left] - left;
                int rightValIdxDif = nums[right] - right;

                //shift search to left
                if(leftValIdxDif != midValIdxDif)
                    right = middle;
                    //shift search to right
                else if(rightValIdxDif != midValIdxDif)
                    left = middle;

            }
            // take average if there are two elements
            return (nums[left]+nums[right])/2;
        }
        public static void main(String[] args){

            MissNumSortAr object = new MissNumSortAr();
            int[] arr = {1, 2, 4, 5, 6, 7, 8, 9};

            int result = object.findMiss(arr);
            System.out.println("missing number is " +result);
        }

    }
