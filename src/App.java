public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        merge2ElectricBoogaloo(new int[] { 1, 2, 3, 6, 0, 0 }, 4, new int[] { 2, 7 }, 2);
    }

    public static void merge2ElectricBoogaloo(int[] nums1, int m, int[] nums2, int n) {
        int indexn1 = m - 1;
        int indexn2 = n - 1;
        int fillIndex = m + n - 1;

        while (indexn2 >= 0) {
            if (indexn1 >= 0 && nums1[indexn1] > nums2[indexn2]) {
                nums1[fillIndex--] = nums1[indexn1--];
            } else {
                nums1[fillIndex--] = nums2[indexn2--];
            }
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        } else {
            if (n != 0) {
                // Initialisation
                int indexn1 = m - 1;// Arrays start at 0
                int indexn2 = n - 1;
                int fillIndex = m + n - 1;
                int nums1Temp = 0;
                int nums2Temp = 0;

                while (indexn1 > -1 && indexn2 > -1) { // both indexes have acceptable values of >-1
                    nums1Temp = nums1[indexn1];
                    nums2Temp = nums2[indexn2];
                    if (nums1Temp == nums2Temp) { // checks equality first since it moves 2 indexes if true
                        nums1[fillIndex] = nums1Temp;
                        fillIndex--;
                        indexn1--;
                        nums1[fillIndex] = nums2Temp;
                        fillIndex--;
                        indexn2--;
                    } else {
                        if (nums1Temp < nums2Temp) { // one more check require before determining
                            nums1[fillIndex] = nums2Temp;// appropriate action
                            fillIndex--;
                            indexn2--;
                        } else {
                            nums1[fillIndex] = nums1Temp;
                            fillIndex--;
                            indexn1--;
                        }
                    }
                }
                if (indexn1 < 0) { // fills nums1 with remaining of nums2
                    while (indexn2 > -1) {
                        nums1[fillIndex] = nums2[indexn2];
                        fillIndex--;
                        indexn2--;
                    }
                }
            } // second if clause end
        } // main else clause end
    }// merge function end

}
