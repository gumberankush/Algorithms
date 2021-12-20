// Java implementation of the approach
import java.util.Arrays;

public class InversionCount {

    // Function to count the number of inversions
    // during the merge process
    private static int mergeAndCount(int[] arr, int l,
                                     int m, int r)
    {
        int n1 = m-l+1;
        int n2 = r-m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Create temporary arrays
        for(int i = 0; i< n1; i++){
            L[i] = arr[l+i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[m+1+j];
        }

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else {
                arr[k++] = R[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
        return swaps;
    }

    // Merge sort function
    private static int mergeSortAndCount(int[] arr, int l,
                                         int r)
    {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r) {
            int m = l + (r-l)/2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 1, 20, 6, 4, 5 };

        System.out.println(
                mergeSortAndCount(arr, 0, arr.length - 1));
    }
}
