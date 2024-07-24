class MyCircularQueue(k: Int) {
    // k 크기의 원형 큐로 사용할 배열 선언
    var q: IntArray = IntArray(k)
    var front = 0
    var rear = -1
    var len = 0
    
    fun enQueue(value: Int): Boolean {
        // 꽉 차 있지 않다면 원소 삽입
        return if(!isFull()) {
            // rear 포인터 한 칸 이동, 최대 크기를 초과하면 나머지 위치로 이동
            this.rear = (this.rear + 1) % this.q.size
            
            // rear 위치에 값 삽입
            this.q[rear] = value
            
            // 현재 큐 크기 계산
            this.len++
            true
        } else {
            false
        }
    }

    fun deQueue(): Boolean {
        // 텅 비어있지 않다면 삭제 진행
        return if(!isEmpty()) {
            // front 포인터 한 칸 이동, 최대 크기를 초과하면 나머지 위치로 이동
            this.front = (this.front + 1) % this.q.size
            
            // 현재 큐 크기 계산
            this.len--;
            true
        } else {
            false
        }
    }

    fun Front(): Int {
        // 맨 앞의 값을 가져온다.
        return if(this.isEmpty()) {
            -1
        } else {
            q[front]
        }   
    }

    fun Rear(): Int {
        // 맨 뒤의 값을 가져온다.
        return if(this.isEmpty()) {
            -1
        } else {
            q[rear]
        } 
    }

    fun isEmpty(): Boolean {
        return this.len == 0
    }

    fun isFull(): Boolean {
        return this.len == this.q.size
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */