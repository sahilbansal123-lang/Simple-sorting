public class QuickSort {

//    QuickSort: Quick sort is another popular sorting algorithm that also uses the divide-and-conquer approach to sort
//               list of elements. The basic idea behind quick sort is to choose a pivot element from the list, partition
//               the list into two sub-lists such that elements smaller than the pivot are on the left, and elements
//               greater than the pivot are on the right, and then recursively apply quick sort to each sub-list.

//               Here are the steps involved in the quick sort algorithm:

//                    1. Choose a pivot element from the input list. The pivot can be any element, but commonly the first
//                       or last element of the list is chosen.
//                    2. Partition the list into two sub-lists: elements smaller than the pivot are on the left, and
//                       elements greater than the pivot are on the right.
//                    3. Recursively apply quick sort to each sub-list, until they are sorted.
//                    4. Concatenate the sorted left sub-list, the pivot, and the sorted right sub-list to produce a
//                       fully sorted list.

//                Time complexity:  Worst Case: O(n^2)
//                                  Average Case: O(nlogn)

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++){
            if (arr[j] < pivot){
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
//      arr[high] = pivot position
        arr[high] = temp;
        return i;
    }

    public static void quickSort(int arr[], int low, int high) {
        if(low < high) {

//          pidx = pivot index that is coming from partition
            int pidx = partition(arr, low, high);
            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);

        }
    }

    public static void main(String[] args) {

        int arr[] = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        quickSort(arr, 0, n-1);
        int pivoti = partition(arr, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}