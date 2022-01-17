class MedianFinder {
    // Refer: https://www.youtube.com/watch?v=dshWERdcAdg&ab_channel=Pepcoding
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(minHeap.size() > 0 && num > minHeap.peek()){
            minHeap.offer(num);
        }else{
            maxHeap.offer(num);
        }
        
        // rebalancing the heap
        if(maxHeap.size() - minHeap.size() == 2){
            minHeap.offer(maxHeap.remove());
        }else if(minHeap.size() - maxHeap.size() == 2){
            maxHeap.offer(minHeap.remove());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }else if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }else{
            return minHeap.peek();
        }
    }
    
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
