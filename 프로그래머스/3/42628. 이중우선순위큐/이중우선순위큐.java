import java.util.PriorityQueue;
import java.util.Collections;


class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations) {
            String[] op = operation.split(" ");

            if("I".equals(op[0])) {
                minHeap.add(Integer.valueOf(op[1]));
                maxHeap.add(Integer.valueOf(op[1]));
            } else if("D".equals(op[0])) {
                if("1".equals(op[1])) {
                    minHeap.remove(maxHeap.poll());
                } else if("-1".equals(op[1])) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
                            
        Integer minValue = minHeap.poll();
        Integer maxValue = maxHeap.poll();

        return new int []{
            (maxValue == null) ? 0 : maxValue,
            (minValue == null) ? 0 : minValue
        };
    }
}