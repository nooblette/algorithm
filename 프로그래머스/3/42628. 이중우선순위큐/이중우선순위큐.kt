import java.util.PriorityQueue
import java.util.Collections

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val minHeap: PriorityQueue<Int> = PriorityQueue()
        val maxHeap: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
        
        operations
            .map { it.split(" ") }
            .forEach { op -> 
                when(op[0]) {
                    "I" -> {
                        minHeap.add(Integer.valueOf(op[1]))
                        maxHeap.add(Integer.valueOf(op[1]))
                    }

                    "D" -> {
                        when(op[1]) {
                            "1" -> minHeap.remove(maxHeap.poll())
                            "-1" -> maxHeap.remove(minHeap.poll())
                        }
                    }
                }
            }
        return intArrayOf(
            maxHeap.poll() ?: 0,
            minHeap.poll() ?: 0
        )
    }
}