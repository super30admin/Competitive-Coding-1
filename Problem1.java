
package Arrays;

public class MissingElement {
    public static void main(String[] args) {
        int []test ={1,2,3,5,6,7};
        /**
         * get the value of the element missing in the array
         */
        int rightPos = test.length-1;
        int leftPos = 0;
        int result=-1;
        while(leftPos <= rightPos){
            if((leftPos+1) != test[leftPos])
            {
                result = leftPos+1;
                break;
            }

                leftPos++;
            }
        System.out.println(result);

    }

    }

