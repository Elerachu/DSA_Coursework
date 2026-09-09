import java.util.Random;
import java.util.Arrays;

public class MergeSort {
    public static void main (String [] args) {

        Random random_numbers = new Random();
        int[] unsorted_array = new int[10];

        for (int i = 0; i < unsorted_array.length; i++) {
            unsorted_array[i] = random_numbers.nextInt(500);
        }

        System.out.println("Unsorted:");
        System.out.println(Arrays.toString(unsorted_array));

        merge_sort(unsorted_array);

        System.out.println("\nSorted:");
        System.out.println(Arrays.toString(unsorted_array));
    }

    public static void merge_sort(int [] sorted_array) {
        if (sorted_array.length < 2) {
            return;
        }

        int midpoint = sorted_array.length/2;
        int[] left = new int[midpoint];
        int[] right = new int[sorted_array.length - midpoint];

        for (int i = 0; i < midpoint; i++) {
            left[i] = sorted_array[i];
        }

        for (int i = midpoint; i < sorted_array.length; i++) {
            right[i - midpoint] = sorted_array[i];
        }

        // System.out.println("\nLeft half of the array:");
        // System.out.println(Arrays.toString(left));

        // System.out.println("\nRight half of the array:");
        // System.out.println(Arrays.toString(right));

        merge_sort(left);
        merge_sort(right);

        merge(sorted_array, left, right);
    }

    public static void merge(int[] sorted_array, int[] left_array, int[] right_array) {
        int i = 0, j = 0, k = 0;

        while (i < left_array.length && j < right_array.length) {
            if (left_array[i] <= right_array[j]) {
                sorted_array[k] = left_array[i];
                i++;
            } else {
                sorted_array[k] = right_array[j];
                j++;
            }
            k++;
        }

        while (i < left_array.length) {
            sorted_array[k] = left_array[i];
            i++;
            k++;
        }
        while (j < right_array.length) {
            sorted_array[k] = right_array[j];
            j++;
            k++;
        }
    }
}
