package apps;

import java.util.Arrays;

import beginner.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        MergeSortedArray.merge2ElectricBoogaloo(new int[] { 1, 2, 3, 6, 0, 0 }, 4, new int[] { 2, 7 }, 2);
        int[] test = SquaresofaSortedArray.sortedSquares(new int[] { -4, -1, 0, 3, 10, 11 });
        Arrays.toString(test);
    }

}
