public class MergeSort {

//    Merge Sort: The basic idea behind merge sort is to divide the list into smaller sub-lists, sort each
//                sub-list separately, and then merge the sorted sub-lists together to produce a fully sorted list.
//
//                  Here are the steps involved in the merge sort algorithm:
//                    1. Divide the input list into two halves, if it has more than one element. If the list has only one
//                       element or is empty, it is already sorted.
//                    2. Recursively apply merge sort to each of the two sub-lists, until they are sorted.
//                    3. Merge the two sorted sub-lists into a single sorted list, by repeatedly comparing the smallest
//                       elements of each sub-list and appending the smaller one to the output list.
//                    4. Return the fully sorted list.

//    TIME COMPLEXITY: O(n log(n))

    public static void conquerArray(int arr[], int si, int mid, int ei) {

        int mergedArray[] = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while(idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] < arr[idx2]){
                mergedArray[x++] = arr[idx1++];
            } else {
                mergedArray[x++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            mergedArray[x] = arr[idx1];
            x++; idx1++;
        }
        while (idx2 <= ei){
            mergedArray[x] = arr[idx2];
            x++; idx2++;
        }

        for (int i = 0, j = si; i < mergedArray.length; i++, j++) {
            arr[j] = mergedArray[i];
        }
    }

    public static void divideArray(int arr[], int si, int ei) {

        if(si >= ei) {
            return;
        }

        int mid = si +  (ei - si) / 2;
        divideArray(arr, si, mid);
        divideArray(arr, mid + 1, ei);
        conquerArray(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 1, 10, 7, 6};
        int n = arr.length;
        divideArray(arr, 0, n-1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}