package beginner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int nlength = nums.length;
        int smallest;
        int[] output = new int[nlength];
        for (int i : nums) {
            i = i * i;// squaring all numbers
        }

        // in order to find smallest value we need to start from biggest
        // since we squared a sorted list the highest value will be either in the
        // beginning or end of the array
        // if numbers on both ends of array are equal or if num at [0] is bigger,
        // nums[0] will be the value of smallest

        smallest = nums[0] < nums[nlength - 1] ? nums[nlength - 1] : nums[0];
        for (int i : nums) {// iterating to find smallest variable
            if (i < smallest) {
                smallest = i;
            }
        }
        // condition checks if nums length is odd or even
        if (nlength % 2.0 == 0) {
            int i1 = nlength / 2;
            int i2 = ++i1;
        }

        return output;
    }
}
