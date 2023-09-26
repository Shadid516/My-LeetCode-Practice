package beginner;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int nlength = nums.length;// 3
        int smallest = 10000 * 10000;// worst case scenario
        int[] output = new int[nlength];// 0,0,0
        int[] expcont = new int[nlength];// 0,0,0

        for (int i = 0; i < nlength; i++) {// i0 nlegth3
            expcont[i] = Math.abs(nums[i]); // 0=abs1 === abscont 1
            if (smallest < expcont[i]) {
                smallest = nums[i];
            } else {
                break;
            }
        }
        // I am going insane, I only needed to find the closest value to 0 all along.
        // will put this out there for my archive
        do {
            int i = 0;
            smallest = nums[i];
        } while (smallest < 0);

        while (true) {
            int i = 0;
            if (nums[i] < nums[i + 1]) {
                smallest = nums[i];
            }
            break;
        }

        // in order to find smallest value we need to start from biggest
        // since we squared a sorted list the highest value will be either in the
        // beginning or end of the array
        // if numbers on both ends of array are equal or if num at [0] is bigger,
        // nums[0] will be the value of smallest

        smallest = nums[0] < nums[nlength - 1] ? nums[nlength - 1] : nums[0];

        smallest = nums[1];
        for (int i : nums) {// iterating to find smallest variable
            if (i <= smallest) {
                smallest = i;
            } else {
                break;
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
