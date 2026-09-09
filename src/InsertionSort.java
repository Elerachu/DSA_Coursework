import java.util.Random;

public class InsertionSort {
    public static void main(String [] args) {
        Random random_numbers = new Random(); // Random number generator

        int[] unsorted_array = new int[10]; // Empty array with 10 slots starting at 0

        // Going through every position in the array, one by one and filling each with a random number
        for (int i = 0; i < unsorted_array.length; i++) {
            unsorted_array[i] = random_numbers.nextInt(500); // Random number (0-499) into this slot
        }

        System.out.println("Unsorted list:");
        System.out.println(java.util.Arrays.toString(unsorted_array)); // I'm printing the array before sorting, so I have a "before" picture

        insertion_sort(unsorted_array); // Arrays are shared by reference, this actually changes unsorted_array itself

        System.out.println("Sorted list:");
        System.out.println(java.util.Arrays.toString(unsorted_array));

    }

    // My Insertion Sort Algorithm
    public static void insertion_sort(int [] sorted_array) {

        // Array starting from position 1, not 0 (a single number on its own is already "sorted"), so there's nothing to do with position 0 yet
        for (int i = 1; i < sorted_array.length; i++) {

            int key = sorted_array[i]; // I'm picking the number I'm currently trying to insert into the correct spot and saving it before I touch anything else

            int j = i - 1; // I'm setting j to point at the number immediately to key's left and that's the first one I'll compare against

            // I'm going to keep comparing and shifting as long as two things are both true:
            // 1) I haven't exited at the start of the array (j >= 0)
            // 2) the number at position j is still bigger than my key
            while(j >= 0 && sorted_array[j] > key) {

                sorted_array[j + 1] = sorted_array[j]; // I'm pushing that bigger number one step to the right

                j--; // Move one step further left so I can check the next number over

                sorted_array[j + 1] = key; // I'm placing my key into the gap I just made (loop) so it stays up to date even before the loop is fully done
            }
        }
    }
}