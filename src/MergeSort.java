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

        merge_sort(unsorted_array); // My Merge sort

        System.out.println("\nSorted:");
        System.out.println(Arrays.toString(unsorted_array)); // Sorted array
    }

    // My splitting method.
    // I give it an array and it recursively breaks it down and sorts it in place.
    public static void merge_sort(int [] sorted_array) {

        // My base case: if there's only 1 or 0 element, it's already sorted; stop here
        if (sorted_array.length < 2) {
            return;
        }

        int midpoint = sorted_array.length/2; // The middle position to split the array at

        int[] left = new int[midpoint]; // The left half array
        int[] right = new int[sorted_array.length - midpoint]; // The right half array

        // I'm copying everything from the start to the midpoint into left
        for (int i = 0; i < midpoint; i++) {
            left[i] = sorted_array[i];
        }

        // I'm copying everything from the midpoint to the end into right
        for (int i = midpoint; i < sorted_array.length; i++) {
            right[i - midpoint] = sorted_array[i];
        }

        // These are old debug prints I commented out
        // System.out.println("\nLeft half of the array:");
        // System.out.println(Arrays.toString(left));

        // System.out.println("\nRight half of the array:");
        // System.out.println(Arrays.toString(right));

        merge_sort(left); // I'm recursively sorting the left half on its own
        merge_sort(right); // I'm recursively sorting the right half on its own

        merge(sorted_array, left, right); // Now that both halves are sorted
        // Combine them back into sorted_array
    }

    // My merging method.
    // I take two already-sorted arrays and combine them into one result written directly into sorted_array (the original array I'm ultimately trying to sort).
    public static void merge(int[] sorted_array, int[] left_array, int[] right_array) {
        int i = 0, j = 0, k = 0; // i tracks my position in left_array, j in right_array, k in sorted_array

        // I'm comparing the fronts of both halves and taking whichever is smaller until one half runs out of element
        while (i < left_array.length && j < right_array.length) {
            if (left_array[i] <= right_array[j]) {
                sorted_array[k] = left_array[i]; // left's front is smaller or equal, I take it
                i++; // I move one step forward in left_array
            } else {
                sorted_array[k] = right_array[j]; // right's front is smaller, I take it instead
                j++; // I move one step forward in right_array
            }
            k++; // Either way, I move one step forward in my result
        }

        // If left_array still has leftovers once right_array has run out, I copy the rest straight over (no more comparing)
        while (i < left_array.length) {
            sorted_array[k] = left_array[i];
            i++;
            k++;
        }
        // Same idea but for right_array's leftovers if left_array ran out first
        while (j < right_array.length) {
            sorted_array[k] = right_array[j];
            j++;
            k++;
        }
    }
}