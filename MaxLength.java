class MaxLength
{
    int maxLen(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for(int i = 0; i < n ; i++){
            sum += arr[i];
            
            if(sum == 0){
                maxLen = i+1;
            }else{
                if(map.containsKey(sum)){
                    maxLen = Math.max(maxLen, i-map.get(sum));
                }else{
                    map.put(sum, i);
                }
            }
        }
        return maxLen;
    }
}
