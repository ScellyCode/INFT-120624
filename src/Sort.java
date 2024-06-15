public class Sort {
    public static void bubbleSort(int[] arr) {
        int comp1;
        int comp2;
        boolean switched = true;
        while (switched) {
            switched = false;
            for (int i = 0; i < arr.length - 1; i++) {
                comp1 = arr[i];
                comp2 = arr[i + 1];
                if (comp1 > comp2) {
                    arr[i] = comp2;
                    arr[i + 1] = comp1;
                    switched = true;
                    if (Main.analysis) Main.printArrayBold(arr, i, i + 1);
                }
            }
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = partitionQuickSort(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partitionQuickSort(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (Main.analysis) Main.printArrayBold(arr, i, j);
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        if (Main.analysis) Main.printArrayBold(arr, i, end);
        return i;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            int temp = arr[smallestIndex];
            arr[smallestIndex] = arr[i];
            arr[i] = temp;
            if (Main.analysis) Main.printArrayBold(arr, i, smallestIndex);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            if (Main.analysis) Main.printArrayBold(arr, i, j + 1);
        }
    }
}
