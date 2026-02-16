class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        // 중앙값 기준으로 경계 유지를 위함
        // 중앙값 기준으로 작은 범위는 maxHeap에 저장(홀수인 경우 중앙값은 이 경계에 포함), 큰 값은 minHeap에 저장
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        // 크기 균형 유지
        // 홀수인 경우 maxHeap.size == minHeap.size + 1, 짝수인 경우 maxHeap.size = minHeap.size를 보장
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        // 홀수인 경우
        if(maxHeap.size() == minHeap.size() + 1) {
            return maxHeap.peek();
        } else {
            // 짝수인 경우
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
