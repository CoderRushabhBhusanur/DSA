package App.Examples;
import java.util.Scanner;

public class SmartInventoryTracker {

    // Insertion Sort
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Binary Search
    static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Print Array
    static void printArray(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] prices = {14999, 8999, 12999, 19999, 9999, 17999, 7999};

        System.out.print("Original Prices: ");
        printArray(prices);

        // Sorting
        insertionSort(prices);

        System.out.print("Sorted Prices:   ");
        printArray(prices);

        // Searching
        System.out.print("\nEnter price to search: ");
        int searchPrice = sc.nextInt();

        int result = binarySearch(prices, searchPrice);

        if (result != -1)
            System.out.println("Price found at index: " + result);
        else
            System.out.println("Price not found in inventory.");

        sc.close();
    }
}
