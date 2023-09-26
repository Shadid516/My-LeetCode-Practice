package beginner;

import java.util.ArrayList;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int nlength = nums.length;//
        int smallest = 10000 * 10000;// worst case scenario
        int[] output = new int[nlength];//
        int[] expcont = new int[nlength];//
        int temp = nums[0];
        expcont[0] = temp * temp;

        /*
         * [-5,-4,-3,1,1,2,3]
         * [25,16,-1,0,0,2,3]
         * compare 25 and 16 save 16
         * [25,16,1,0,0,2,3]
         * compare 16 and 1 save 1
         * [25,16,1,0,0,2,3]
         * compare 1 and 0 save 0
         * [25,16,1,0,0,2,3]
         * compare 0 and 0 save 0
         * [25,16,1,0,0,4,3]
         * compare 0 and 4 save 0
         * exit
         * 
         */
        if (nlength == 2) {
            nums[0] *= nums[0];
            nums[1] *= nums[1];
            if (nums[0] <= nums[1]) {
                return nums;
            }
            int[] out = new int[2];
            out[1] = nums[0];
            out[0] = nums[1];
            return out;

        }
        if (nlength == 1) {
            nums[0] *= nums[0];
            return nums;
        }
        smallest = nums[0];
        for (int i = 1; i < nlength - 1; i++) {
            int numsIndex = nums[i];
            if (nums[i - 1] > nums[i]) {
                smallest = nums[i];
            } else {
                break;
            }
        }

        // I am going insane, I only needed to find the closest value to 0 all along.
        // will put this out there for my archive

        // in order to find smallest value we need to start from biggest
        // since we squared a sorted list the highest value will be either in the
        // beginning or end of the array
        // if numbers on both ends of array are equal or if num at [0] is bigger,
        // nums[0] will be the value of smallest

        return output;
    }
}
