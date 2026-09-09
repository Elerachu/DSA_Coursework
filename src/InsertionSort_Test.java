public class InsertionSort_Test {
    public static void main(String [] args) {
        // Test 1: Hand-traceable list
        int[] test_A = {4, 9, 0, 3, 1, 5, 6};

        // Test 2: Already-sorted list
        int [] test_B = {11,12,23,24,35,46};

        // Test 3: List with duplicates
        int [] test_C = {21,12,23,24,35, 21,7};

        InsertionSort.insertion_sort(test_A);
        System.out.println(java.util.Arrays.toString(test_A));

        InsertionSort.insertion_sort(test_B);
        System.out.println(java.util.Arrays.toString(test_B));

        InsertionSort.insertion_sort(test_C);
        System.out.println(java.util.Arrays.toString(test_C));
    }
}
