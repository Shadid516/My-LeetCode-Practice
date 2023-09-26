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
        if (nlength == 2) {// edge case 1
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
        if (nlength == 1) {// edge case 2
            nums[0] *= nums[0];
            return nums;
        }
        smallest = Math.abs(nums[0]);
        int i;
        for (i = 1; i < nlength - 1; i++) {
            int numsIndex = Math.abs(nums[i]);
            if (Math.abs(nums[i - 1]) > numsIndex) {
                smallest = numsIndex;
            } else {
                break;
            }
        }

        // edgecases that would break with the current algorithm
        // i before the for below shows index of smallest num in nums[]
        output[nlength - 1] = smallest * smallest;

        // Dual Pointer Setup
        // i before the for below shows index of smallest num in nums[]
        int leftstep = i - 1;
        int rightstep = i + 1;
        int leftNum;
        int rightNum;
        int copyflag = 0;// used to optimise function when either pointer gets out of range, -1 means
                         // left pointer exited 1 right
        if (i == nlength - 1) {// edgecase uses copyflag code (this was implemented last)
            leftNum = ((int) Math.pow(nums[leftstep], 2));
            for (i = i; i > -1; i--) {
                output[i] = leftNum;
                leftstep--;
            }
        }
        if (i == 0) {// edgecase uses copyflag code (this was implemented last)
            rightNum = ((int) Math.pow(nums[rightstep], 2));
            for (i = i; i > -1; i--) {
                output[i] = rightNum;
                rightstep++;
            }
        }

        for (i = nlength - 2; i > -1; i--) {// i is the index responsible for filling

            // precompute number value in rightsteo and leftstep
            leftNum = ((int) Math.pow(nums[leftstep], 2));
            rightNum = ((int) Math.pow(nums[rightstep], 2));

            // Sort.
            if (leftNum < rightNum && rightstep < nlength - 1) {
                output[i] = rightNum;
                rightstep++;
            } else {
                if (leftNum < rightNum && leftstep > -1) {
                    output[i] = leftNum;
                    leftstep--;
                }
            }
            if (leftNum <= rightNum) {
                output[i] = rightNum;
                if (rightstep < nlength - 1) {
                    rightstep++;
                } else {
                    copyflag = 1;// signals exit
                    break;
                }
            } else {
                output[i] = leftNum;
                if (leftstep > -1) {
                    leftstep--;
                } else {
                    copyflag = -1;// signals exit
                }
            }
        }
        if (copyflag > 0) {
            leftNum = ((int) Math.pow(nums[leftstep], 2));
            for (i = i; i > -1; i--) {
                output[i] = leftNum;
                leftstep--;
            }
        } else {
            rightNum = ((int) Math.pow(nums[rightstep], 2));
            for (i = i; i > -1; i--) {
                output[i] = rightNum;
                rightstep++;
            }
        }

        // in order to find smallest value we need to start from biggest
        // since we squared a sorted list the highest value will be either in the
        // beginning or end of the array
        // if numbers on both ends of array are equal or if num at [0] is bigger,
        // nums[0] will be the value of smallest
        // this way we can finish using least comparisons, if java had pop and that
        // suite by default in array, implementation of this
        // specific algorythm would have been a loooot easier

        return output;
    }
}
