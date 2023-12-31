package beginner;

public class SquaresofaSortedArray {

    public int[] sortedSquaresOptimized(int[] nums) { // 1ms solution
        int[] copy = new int[nums.length];
        int l = 0, r = nums.length - 1;
        while (r >= l) {
            // check largest; add to index; increment resp pointer

            // largest is pos
            if (Math.abs(nums[r]) > Math.abs(nums[l])) {
                copy[r - l] = nums[r] * nums[r];
                r--;
            }
            // largest is neg;
            else if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
                copy[r - l] = nums[l] * nums[l];
                l++;
            }
        }
        return copy;
    }

    public static int[] sortedSquares(int[] nums) {

        /*
         * This will explain how the algorithm works
         * [-5,-4,-3,0,1,2,3]
         * -5 and 3 ==> 25 > 9 save 25 in output starting from end
         * -4 and 3 ==> 16 > 9 save 9 in output starting from end
         * -3 and 3 ==> 3==3 save 3 in current fill index and index below it while
         * decrementing manually to save time //check special try catch block
         * 0 and 2 ==> 0 < 2 save 2
         * 0 and 1 ==> 0 < 1 save 1
         * 0 and 0 ==> 0 == 0 save 0 and go out of program bounds, outofbounds exception
         * is our que to finish processing
         */

        // Dual Pointer Setup

        int nlength = nums.length; // calculating nums.length only once saves a bit of compute time
        int[] output = new int[nlength]; // output array
        int leftstep = 0; // selector index starting from the first entry of the array or the "left" side
                          // of the array
        int rightstep = nlength - 1; // selector index starting from the last entry of the array or the "right" side
                                     // of the array
        int leftNum; // storage container to avoid running Math.pow(nums[i]) twice on comparison and
                     // on write
        int rightNum;
        leftNum = ((int) Math.pow(nums[leftstep], 2));
        rightNum = ((int) Math.pow(nums[rightstep], 2));// precompute first 2 index nums to cut down on unnecessary
                                                        // re-computing of rightNum/leftNum

        for (int i = nlength - 1; i > -1; i--) { // i index for filling output

            // algo main engine, optimisation is done primarily here
            if (leftNum == rightNum) {
                try {
                    // decrementing i here may cause out of bounds exception when both pointers
                    // intersect
                    output[i] = leftNum;
                    output[--i] = leftNum;// leftNum == rightNum can be used interchangeably
                    leftstep++;
                    rightstep--;
                    rightNum = ((int) Math.pow(nums[rightstep], 2));
                    leftNum = ((int) Math.pow(nums[leftstep], 2));
                } catch (Exception e) {
                    System.out.println("It's yaboi Exception e here to haunt your dreams. leftrightstep " + leftstep
                            + ":" + rightstep + " |leftrightNum " + leftNum + ":" + rightNum);
                    // this means that nums[--i] does not exist, so we simply return the sorted num
                    return output;
                }
            } else if (leftNum < rightNum) {
                output[i] = rightNum;
                rightstep--;
                rightNum = ((int) Math.pow(nums[rightstep], 2));
            } else {
                output[i] = leftNum;
                leftstep++;
                leftNum = ((int) Math.pow(nums[leftstep], 2));
            }

        }
        return output;

    }

    // too tired to read through this
    // public static int[] sortedSquares(int[] nums) { //my solution

    /*
     * This will explain how the algorithm works
     * [-5,-4,-3,0,1,2,3]
     * -5 and 3 ==> 25 > 9 save 25 in output starting from end
     * -4 and 3 ==> 16 > 9 save 9 in output starting from end
     * -3 and 3 ==> 3==3 save 3 in current fill index and index below it while
     * decrementing manually to save time //check special try catch block
     * 0 and 2 ==> 0 < 2 save 2
     * 0 and 1 ==> 0 < 1 save 1
     * 0 and 0 ==> 0 == 0 save 0 and go out of program bounds, outofbounds exception
     * is our que to finish processing
     */

    // Dual Pointer Setup

    int[] output = new int[nums.length]; // output array
    int leftstep = 0; // selector index starting from the first entry of the array or the "left" side
                      // of the array
    int rightstep = nums.length - 1; // selector index starting from the last entry of the array or the "right" side
    // of the array
    for(
    int i = rightstep;i>-1;i--)
    { // i index for filling output

        // algo main engine, optimisation is done primarily here
        if (Math.abs(nums[leftstep]) >= Math.abs(nums[rightstep])) { //
            output[i] = nums[leftstep] * nums[leftstep];
            leftstep++;
        } else {
            System.out.println(nums.length + " " + rightstep);
            output[i] = nums[rightstep] * nums[rightstep];
            rightstep--;
        }

        // if (leftNum == rightNum) {
        // try {
        // // decrementing i here may cause out of bounds exception when both pointers
        // // intersect
        // output[i] = nums[leftstep] * nums[leftstep];
        // output[--i] = output[i];// leftNum == rightNum can be used interchangeably
        // leftstep++;
        // rightstep--;
        // } catch (Exception e) {
        // System.out.println("It's yaboi Exception e here to haunt your dreams.
        // leftrightstep " + leftstep
        // + ":" + rightstep + " |leftrightNum " + leftNum + ":" + rightNum);
        // // this means that nums[--i] does not exist, so we simply return the sorted
        // num
        //
        // }
        // } else if (leftNum < rightNum) {
        // output[i] = nums[rightstep] * nums[rightstep];
        // rightstep--;
        // } else {
        // output[i] = nums[leftstep] * nums[leftstep];
        // leftstep++;
        // }

    }return output;

    }

    private SquaresofaSortedArray() {
    }
}
