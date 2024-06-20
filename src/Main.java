import java.util.Arrays;
import java.util.Random;

public class Main {
    static Random random = new Random();
    static boolean analysis = true;
    static boolean averageCalculation = false;

    public static int[] genArray(int length) {
        int[] output = new int[length];
        for (int i = 0; i < length; i++) {
            output[i] = random.nextInt(101);
        }
        if (!averageCalculation) System.out.println(Arrays.toString(output));
        return output;
    }

    public static void displayAlgorithm(String algorithm, int[] array) {
        switch (algorithm) {
            case "bubble":
                System.out.println("BubbleSort:");
                Sort.bubbleSort(array);
                break;
            case "quick":
                System.out.println("QuickSort:");
                Sort.quickSort(array, 0, array.length - 1);
                break;
            case "selection":
                System.out.println("SelectionSort:");
                Sort.selectionSort(array);
                break;
            case "insertion":
                System.out.println("InsertionSort:");
                Sort.insertionSort(array);
                break;
        }
        System.out.println("Solved array:");
        System.out.println(Arrays.toString(array));
    }

    public static void printArrayBold(int[] arr, int... boldIndices) {
        final String ANSI_BOLD = "\033[1m";
        final String ANSI_RESET = "\033[0m";
        final String ANSI_UNDERLINE = "\033[4m";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            boolean isBoldAndUnderlined = false;
            for (int boldAndUnderlinedIndex : boldIndices) {
                if (i == boldAndUnderlinedIndex) {
                    isBoldAndUnderlined = true;
                    break;
                }
            }
            if (isBoldAndUnderlined) {
                sb.append(ANSI_BOLD).append(ANSI_UNDERLINE).append(arr[i]).append(ANSI_RESET);
            } else {
                sb.append(arr[i]);
            }
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printAverage(String algorithm) {
        final int cycles = 10000;
        final int arrayLengthShort = 15;
        final int arrayLengthMedium = 250;
        final int arrayLengthLarge = 3500;
        analysis = false;
        averageCalculation = true;
        int[] cyclesShort = new int[cycles];
        int[] cyclesMedium = new int[cycles];
        int[] cyclesLarge = new int[cycles];
        long sumShort = 0;
        long sumMedium = 0;
        long sumLarge = 0;
        switch (algorithm) {
            case "bubble":
                System.out.println("BubbleSort:");
                System.out.println("measure times...");
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.bubbleSort(Main.genArray(arrayLengthShort));
                    long endTime = System.nanoTime();
                    cyclesShort[i] = (int) (endTime - startTime);
                }
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.bubbleSort(Main.genArray(arrayLengthMedium));
                    long endTime = System.nanoTime();
                    cyclesMedium[i] = (int) (endTime - startTime);
                }
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.bubbleSort(Main.genArray(arrayLengthLarge));
                    long endTime = System.nanoTime();
                    cyclesLarge[i] = (int) (endTime - startTime);
                }
                break;
            case "quick":
                System.out.println("QuickSort:");
                System.out.println("measure times...");
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.quickSort(Main.genArray(arrayLengthShort), 0, 10 - 1);
                    long endTime = System.nanoTime();
                    cyclesShort[i] = (int) (endTime - startTime);
                }
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.quickSort(Main.genArray(arrayLengthMedium), 0, 50 - 1);
                    long endTime = System.nanoTime();
                    cyclesMedium[i] = (int) (endTime - startTime);
                }
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.quickSort(Main.genArray(arrayLengthLarge), 0, 150 - 1);
                    long endTime = System.nanoTime();
                    cyclesLarge[i] = (int) (endTime - startTime);
                }
                break;
            case "selection":
                System.out.println("SelectionSort:");
                System.out.println("measure times...");
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.selectionSort(Main.genArray(arrayLengthShort));
                    long endTime = System.nanoTime();
                    cyclesShort[i] = (int) (endTime - startTime);
                }
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.selectionSort(Main.genArray(arrayLengthMedium));
                    long endTime = System.nanoTime();
                    cyclesMedium[i] = (int) (endTime - startTime);
                }
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.selectionSort(Main.genArray(arrayLengthLarge));
                    long endTime = System.nanoTime();
                    cyclesLarge[i] = (int) (endTime - startTime);
                }
                break;
            case "insertion":
                System.out.println("InsertionSort:");
                System.out.println("measure times...");
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.insertionSort(Main.genArray(arrayLengthShort));
                    long endTime = System.nanoTime();
                    cyclesShort[i] = (int) (endTime - startTime);
                }
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.insertionSort(Main.genArray(arrayLengthMedium));
                    long endTime = System.nanoTime();
                    cyclesMedium[i] = (int) (endTime - startTime);
                }
                for (int i = 0; i < cycles; i++) {
                    long startTime = System.nanoTime();
                    Sort.insertionSort(Main.genArray(arrayLengthLarge));
                    long endTime = System.nanoTime();
                    cyclesLarge[i] = (int) (endTime - startTime);
                }
                break;
        }
        System.out.println("calculating average...");
        for (int number : cyclesShort) {
            sumShort += number;
        }
        sumShort /= cycles;
        for (int number : cyclesMedium) {
            sumMedium += number;
        }
        sumMedium /= cycles;
        for (int number : cyclesLarge) {
            sumLarge += number;
        }
        sumLarge /= cycles;
        System.out.println("averages short/medium/large: " + sumShort + "ns / " + sumMedium + "ns / " + sumLarge + "ns");

    }

    public static void useSearch(String algorithm) {

    }

    public static int getAverageRaw(String algorithm, char length) {
        final int cycles = 10000;
        final int arrayLengthShort = 15;
        final int arrayLengthMedium = 250;
        final int arrayLengthLarge = 3500;
        analysis = false;
        averageCalculation = true;
        int[] cyclesShort = new int[cycles];
        int[] cyclesMedium = new int[cycles];
        int[] cyclesLarge = new int[cycles];
        long sumShort = 0;
        long sumMedium = 0;
        long sumLarge = 0;
        switch (algorithm) {
            case "bubble":
                switch(length) {
                    case 's':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.bubbleSort(Main.genArray(arrayLengthShort));
                            long endTime = System.nanoTime();
                            cyclesShort[i] = (int) (endTime - startTime);
                        }
                        break;
                    case 'm':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.bubbleSort(Main.genArray(arrayLengthMedium));
                            long endTime = System.nanoTime();
                            cyclesMedium[i] = (int) (endTime - startTime);
                        }
                        break;
                    case 'l':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.bubbleSort(Main.genArray(arrayLengthLarge));
                            long endTime = System.nanoTime();
                            cyclesLarge[i] = (int) (endTime - startTime);
                        }
                        break;
                }
                break;
            case "quick":
                switch(length) {
                    case 's':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.quickSort(Main.genArray(arrayLengthShort), 0, 10 - 1);
                            long endTime = System.nanoTime();
                            cyclesShort[i] = (int) (endTime - startTime);
                        }
                        break;
                    case 'm':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.quickSort(Main.genArray(arrayLengthMedium), 0, 50 - 1);
                            long endTime = System.nanoTime();
                            cyclesMedium[i] = (int) (endTime - startTime);
                        }
                        break;
                    case 'l':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.quickSort(Main.genArray(arrayLengthLarge), 0, 150 - 1);
                            long endTime = System.nanoTime();
                            cyclesLarge[i] = (int) (endTime - startTime);
                        }
                        break;
                }
                break;
            case "selection":
                switch(length) {
                    case 's':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.selectionSort(Main.genArray(arrayLengthShort));
                            long endTime = System.nanoTime();
                            cyclesShort[i] = (int) (endTime - startTime);
                        }
                        break;
                    case 'm':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.selectionSort(Main.genArray(arrayLengthMedium));
                            long endTime = System.nanoTime();
                            cyclesMedium[i] = (int) (endTime - startTime);
                        }
                        break;
                    case 'l':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.selectionSort(Main.genArray(arrayLengthLarge));
                            long endTime = System.nanoTime();
                            cyclesLarge[i] = (int) (endTime - startTime);
                        }
                        break;
                }
                break;
            case "insertion":
                switch(length) {
                    case 's':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.insertionSort(Main.genArray(arrayLengthShort));
                            long endTime = System.nanoTime();
                            cyclesShort[i] = (int) (endTime - startTime);
                        }
                        break;
                    case 'm':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.insertionSort(Main.genArray(arrayLengthMedium));
                            long endTime = System.nanoTime();
                            cyclesMedium[i] = (int) (endTime - startTime);
                        }
                        break;
                    case 'l':
                        for (int i = 0; i < cycles; i++) {
                            long startTime = System.nanoTime();
                            Sort.insertionSort(Main.genArray(arrayLengthLarge));
                            long endTime = System.nanoTime();
                            cyclesLarge[i] = (int) (endTime - startTime);
                        }
                        break;
                }
                break;
        }
        switch(length) {
            case 's':
                for (int number : cyclesShort) {
                    sumShort += number;
                }
                sumShort /= cycles;
                return (int) sumShort;
            case 'm':
                for (int number : cyclesMedium) {
                    sumMedium += number;
                }
                sumMedium /= cycles;
                return (int) sumMedium;
            case 'l':
                for (int number : cyclesLarge) {
                    sumLarge += number;
                }
                sumLarge /= cycles;
                return (int) sumLarge;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        int[] array = Main.genArray(15);
    }
}