import java.util.Arrays;
import java.util.Random;
public class Main {
    static Random random = new Random();

    public static int[] genArray(int length) {
        int[] output = new int[length];
        for (int i = 0; i < length; i++) {
            output[i] = random.nextInt(101);
        }
        System.out.println(Arrays.toString(output));
        return output;
    }
    public static void displayAlgorithm(String algorithm, int[] array) {
        long startTime = System.nanoTime();
        switch (algorithm) {
            case "bubble":
                System.out.println("BubbleSort:");
                Sort.bubbleSort(array);
                break;
            case "quick":
                System.out.println("QuickSort:");
                Sort.quickSort(array, 0, array.length - 1);
                break;
        }
        System.out.print(Arrays.toString(array));
        long endTime = System.nanoTime();
        System.out.println(" " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        int[] array = Main.genArray(15);
        displayAlgorithm("quick", array);
        System.out.println(Search.binarySearch(array, 30));
    }
}