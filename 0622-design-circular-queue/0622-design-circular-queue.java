class MyCircularQueue {

    int[] q;
    int front = 0, rear = -1, len = 0;

    public MyCircularQueue(int k) {
        this.q = new int[k];
    }

    public boolean enQueue(int value) {
        if(!this.isFull()) {
            this.rear = (this.rear + 1) % this.q.length;
            this.q[rear] = value;
            this.len++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean deQueue() {
        if(!this.isEmpty()) {
            this.front = (this.front + 1) % this.q.length;
            this.len--;
            return true;
        } else {
            return false;
        }
    }
    public int Front() {
        return isEmpty() ? -1 : q[this.front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : q[this.rear];
        
    }
    
    public boolean isEmpty() {
        return len == 0;
        
    }
    
    public boolean isFull() {
        return len == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */