import java.io.FileWriter;
import java.io.IOException;   // File operations can fail and Java makes me acknowledge that possibility
import java.util.Random;

public class MergeSort_Timing {
    public static void main(String[] args) throws IOException {
        // "throws IOException" tells Java: if something goes wrong writing the file and let the program stop rather than silently continue

        // Same as my Insertion Sort timing logic
        int[] sizes = {500, 1000, 2000, 4000, 8000}; //
        int number_of_runs = 5;

        FileWriter file_writer = new FileWriter("merge_sort.csv"); // I'm creating a separate CSV file just for merge sort's results
        file_writer.write("sort,n,average_ns,average_ms\n"); // My header row, comma-separated; this allows Excel reads it as proper columns

        System.out.println("Successfully wrote to the file."); // A confirmation message

        System.out.println("    RANDOM DATA    "); // Merge sort only needs this one dataset and no already-sorted comparison

        // Going through each size one at a time
        for (int array_size : sizes) {
            long total_duration = 0; // Resetting my running total to 0 for this size before timing starts
            System.out.println("--- Size " + array_size + " ---");

            // I'm repeating the timing 5 times for this size and I average the results
            for (int time_run = 0; time_run < number_of_runs; time_run++) {
                int[] testArray = generateRandomArray(array_size); // A new random array of this size

                long startTime = System.nanoTime(); //
                MergeSort.merge_sort(testArray); // Calling my merge sort algorithm
                long endTime = System.nanoTime(); //

                long ns_duration = endTime - startTime; // How long this one run took
                total_duration = total_duration + ns_duration; // Adding it onto my running total

                System.out.println("Run " + (time_run + 1) + ": " + ns_duration + " ns"); // The individual run's time
            }

            double averageDuration = total_duration / (double) number_of_runs; // Average time over the 5 runs
            double averageMillis = averageDuration / 1_000_000.0; // Same value converted to milliseconds for easier reading

            // Writing this size's result as one CSV row — labeled "merge_random" so I can tell it apart from insertion sort's data later
            file_writer.write("merge_random," + array_size + "," + averageDuration + "," + averageMillis + "\n");

            System.out.println("Average: " + averageDuration + " ns (" + averageMillis + " ms)");
            System.out.println();
        }

        file_writer.close(); // Closing the file now that I'm done writing allowing everything actually gets saved
    }

    // This generates an array filled with random numbers given how big I want it to be
    private static int[] generateRandomArray(int size) {
        Random random_numbers = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random_numbers.nextInt(1000); // A random number between 0 and 999
        }

        return array; // Handing back the finished array
    }
}