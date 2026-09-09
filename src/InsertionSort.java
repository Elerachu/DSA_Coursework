import java.util.Random;

public class InsertionSort {
    public static void main(String [] args) {
        Random random_numbers = new Random();
        int[] unsorted_array = new int[10];

        for (int i = 0; i < unsorted_array.length; i++) {
            unsorted_array[i] = random_numbers.nextInt(500);
        }

        System.out.println("Unsorted list:");
        System.out.println(java.util.Arrays.toString(unsorted_array));

        insertion_sort(unsorted_array);

        System.out.println("Sorted list:");
        System.out.println(java.util.Arrays.toString(unsorted_array));

        }

    public static void insertion_sort(int [] sorted_array) {
        for (int i = 1; i < sorted_array.length; i++) {
            int key = sorted_array[i];
            int j = i - 1;

            while(j >= 0 && sorted_array[j] > key) {
                sorted_array[j + 1] = sorted_array[j];
                j--;
                sorted_array[j + 1] = key;
            }
        }
    }
}


