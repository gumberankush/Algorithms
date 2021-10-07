class NegativeNumber {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        int wStart = 0;
        Queue<Long> queue = new LinkedList<>();
        long[] ans = new long[N-K+1];
        
        for(int wEnd = 0; wEnd < A.length; wEnd++){
            if(A[wEnd] < 0){
                queue.offer(A[wEnd]);
            }
            
            if(wEnd-wStart+1 == K){
                if(queue.size() == 0){
                    ans[wStart] = 0;
                }else{
                    ans[wStart] = queue.peek();
                    if(queue.peek() == A[wStart]){
                        queue.poll();
                    }
                }
                wStart++;
            }
        }
        return ans;
    }
}
