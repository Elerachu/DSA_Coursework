import java.io.FileWriter;    // Write text to a file
import java.io.IOException;   // My File operations can fail and Java makes me know that possibility
import java.util.Random;

public class InsertionSort_Timing {
    public static void main(String[] args) throws IOException {
        // "throws IOException" tells Java: if something goes wrong writing the file and let the program stop rather than silently continue

        int[] sizes = {500, 1000, 2000, 4000, 8000}; // These are the five array sizes the brief asks me to test
        int number_of_runs = 5; // I'm running each size 5 times, so a single unlucky run doesn't skew my results

        FileWriter file_writer = new FileWriter("insertion_sort.csv"); // I'm creating a CSV file to save my results into
        file_writer.write("sort,n,average_ns,average_ms\n");

        System.out.println("Successfully wrote to the file."); // A confirmation message printed to the console

        System.out.println("    RANDOM DATA    ");

        // Going through each size one at a time
        for (int array_size : sizes) {
            long total_duration = 0; // Resetting my running total to 0 for this size, before I start timing
            System.out.println("--- Size " + array_size + " ---");

            // I'm repeating the timing 5 times for this size so I can average the results
            for (int time_run = 0; time_run < number_of_runs; time_run++) {
                int[] testArray = generateRandomArray(array_size); // I'm generating a new random array of this size

                long startTime = System.nanoTime(); // Time right before sorting starts in ns
                InsertionSort.insertion_sort(testArray);
                long endTime = System.nanoTime(); // Time right after sorting finishes in ns

                long ns_duration = endTime - startTime; // The gap between those two times is how long this run took
                total_duration = total_duration + ns_duration; // I'm adding this run's time onto my running total

                System.out.println("Run " + (time_run + 1) + ": " + ns_duration + " ns"); // For individual run's time
            }

            double averageDuration = total_duration / (double) number_of_runs; // Average time
            double averageMillis = averageDuration / 1_000_000.0; // I'm converting nanoseconds into milliseconds for easy reading

            // Size's results as one row in my CSV (sort name, size and both time formats)
            file_writer.write("insertion_unsorted," + array_size + "," + averageDuration + "," + averageMillis + "\n");

            System.out.println("Average: " + averageDuration + " ns (" + averageMillis + " ms)");
            System.out.println();
        }

        System.out.println("  ALREADY SORTED DATA   "); // Tests for an already-sorted list

        for (int array_size : sizes) {
            long total_duration = 0;
            System.out.println("--- Size " + array_size + " ---");

            for (int time_run = 0; time_run < number_of_runs; time_run++) {
                int[] testArray = generateSortedArray(array_size); // An already-sorted array

                long startTime = System.nanoTime();
                InsertionSort.insertion_sort(testArray);
                long endTime = System.nanoTime();

                long ns_duration = endTime - startTime;
                total_duration = total_duration + ns_duration;

                System.out.println("Run " + (time_run + 1) + ": " + ns_duration + " ns");
            }

            double averageDuration = total_duration / (double) number_of_runs;
            double averageMillis = averageDuration / 1_000_000.0;

            // Row "insertion_sorted" to tell the two datasets apart
            file_writer.write("insertion_sorted," + array_size + "," + averageDuration + "," + averageMillis + "\n");

            System.out.println("Average: " + averageDuration + " ns (" + averageMillis + " ms)");
            System.out.println();
        }

        file_writer.close(); // Close the file now that I'm done writing; making sure everything gets saved
    }

    private static int[] generateRandomArray(int size) {
        Random random_numbers = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random_numbers.nextInt(1000); // 0 and 999
        }

        return array; // The finished array
    }

    // This generates an array that's already in order
    private static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i; // Each slot just holds its own position number, it is sorted by construction
        }
        return array;
    }
}