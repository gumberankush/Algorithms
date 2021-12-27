class MinimumPlatforms
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platformCount = 1, max = Integer.MIN_VALUE;
        
        int i = 1, j = 0;
        
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                platformCount++;
                i++;
            }else{
                platformCount--;
                j++;
            }
            
            max = Math.max(max, platformCount);
        }
        return max;
    }
}
