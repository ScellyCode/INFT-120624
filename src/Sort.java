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
                if(comp1 > comp2) {
                    arr[i] = comp2;
                    arr[i + 1] = comp1;
                    switched = true;
                }
            }
        }
    }
    public static void quickSort(int[] arr, int start, int end) {
        if(end <= start) {
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j <= end -1; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }
}
