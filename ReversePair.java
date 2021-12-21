class ReversePair {
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length-1, nums);
    }
    
    public int mergeSort(int l, int r, int[] nums){
        if(l >= r)
            return 0;
        
        
        int mid = l + (r-l)/2;
        int count = mergeSort(l, mid, nums);
        count += mergeSort(mid+1, r, nums);

        count += merge(l, mid, r, nums);

        return count;
    }
    
    public int merge(int l, int m, int r, int[] nums){
        
        int cnt = 0;
        int j = m + 1; 
        for(int i = l; i <= m; i++) {
            while(j <= r && nums[i] > (2 * (long)nums[j])) {
                j++;
            }
            // how many times j moved
            cnt += (j - (m+1));
        }
        
        int n1 = m-l+1;
        int n2 = r-m;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for(int i = 0; i < n1; i++){
            L[i] = nums[l+i];
        }
        for(int n = 0; n < n2; n++){
            R[n] = nums[m+1+n];
        }
        int i = 0, n = 0, k = l;
        while(i < n1 && n < n2){
            if(L[i] <= R[n]){
                nums[k++] = L[i++];
            }else if(R[n] < L[i]){
                nums[k++] = R[n++];
            }
        }
        
        while(i < n1){
            nums[k++] = L[i++];
        }
        
        while(n < n2){
            nums[k++] = R[n++];
        }
        
        return cnt;
    }
}
