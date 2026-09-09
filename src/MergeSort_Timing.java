import java.util.Random;

public class MergeSort_Timing {
    public static void main(String[] args) {
        int[] sizes = {500, 1000, 2000, 4000, 8000};
        int number_of_runs = 5;

        for (int array_size : sizes) {
            long total_duration = 0;
            System.out.println("-- Size " + array_size + " --");

            for (int time_run = 0; time_run < number_of_runs; time_run++) {
                int[] testArray = generateRandomArray(array_size);

                long startTime = System.nanoTime();
                MergeSort.merge_sort(testArray);
                long endTime = System.nanoTime();

                long ns_duration = endTime - startTime;
                total_duration = total_duration + ns_duration;

                System.out.println("Run " + (time_run + 1) + ": " + ns_duration + " ns");
            }

            double averageDuration = total_duration / (double) number_of_runs;
            double averageMillis = averageDuration / 1_000_000.0;

            System.out.println("\nAverage: " + averageDuration + " ns (" + averageMillis + " ms)");
            System.out.println();
        }
    }

    private static int[] generateRandomArray(int size) {
        Random random_numbers = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random_numbers.nextInt(1000);
        }

        return array;
    }
}