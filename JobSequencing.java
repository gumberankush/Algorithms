class JobSequencing
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int[] res = new int[2];
        
        int maxDeadline = 0;
        for(int i = 0; i < n; i++){
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }
        
        int[] deadline = new int[maxDeadline+1];
        
        for(int i = 1; i <= maxDeadline; i++){
            deadline[i] = -1;
        }
        
        // Comparator<Job> comp = (Job a, Job b) -> Integer.compare(a.profit, b.profit);
        
        // Arrays.sort(arr, comp.reversed());
        Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit)); 
        int countJobs = 0;
        int totalProfit = 0;
        for(int i = 0; i < n; i++){
            for(int j = arr[i].deadline; j > 0; j--){
                if(deadline[j] == -1){
                    deadline[j] = arr[i].id;
                    countJobs++;
                    totalProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        res[0] = countJobs;
        res[1] = totalProfit;
        return res;
    }
}
