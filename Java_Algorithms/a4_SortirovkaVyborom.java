import java.util.Arrays;

public class a4_SortirovkaVyborom {

    public static void main(String[] args) {
        int[] array = new int[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(arrayToString(array));
        quickSort(array, 0, array.length - 1);
    }


    static void quickSort(int[] array, int from, int to) {
        if (from < to) {
            int divideIndex = partition(array, from, to);
            printSortStep(array, from, to, divideIndex);
            quickSort(array, from, divideIndex - 1);
            quickSort(array, divideIndex, to);
        }

    }

    static int partition(int[] array, int from, int to) {

        int rightIndex = to;
        int leftIndex = from;

        int pivot = array[from];
        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot) {
                leftIndex++;
            }
            while (array[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(array, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static void printSortStep(int[] array, int from, int to, int partitionIndex) {
        System.out.println(arrayToString(array));
        System.out.println("\npartition at index: " + partitionIndex);
        System.out.println(", left: " + arrayToString(Arrays.copyOfRange(array, from, partitionIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(array, partitionIndex, to + 1)));
    }
}


