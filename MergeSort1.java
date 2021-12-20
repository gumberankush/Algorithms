import java.util.Arrays;

public class MergeSort1 {

    public void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;

        // Create temp array
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; i++){
            L[i] = arr[l+i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[m+1+j];
        }
        int k = l;
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] arr, int l, int r){

        if(l >= r)
            return;
        int m = l + (r-l)/2;

        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);

        merge(arr, l, m, r);
    }

    public static void main(String[] args) {
        MergeSort1 mergeSort1 = new MergeSort1();
        int[] arr = {15, 14, 12, 4, 1, 3};
        mergeSort1.mergeSort(arr, 0, arr.length-1);
        System.out.print(Arrays.toString(arr));
    }
}
