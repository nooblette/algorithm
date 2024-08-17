class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        // 엘리먼트를 삽입
        queue.add(x);
        
        // 큐에 엘리먼트를 삽입했으므로 방금 삽입한 엘리먼트는 나중에 나오게된다.
        // 하지만 스택은 나중에 삽입한 엘리먼트가 먼저 나와야하므로 큐를 뒤집는다.
        for(int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    
    }
    
    public int pop() {
        // push() 연산을 수행할때마다 역순으로 재정렬하므로 큐 연산으로 간단히 추출할 수 있다.
        return queue.remove();
    }
    
    public int top() {
        // push() 연산을 수행할때마다 역순으로 재정렬하므로 큐 연산으로 간단히 추출할 수 있다.
        return queue.peek();
    }
    
    public boolean empty() {
        // 크기를 비교해 비어있는지 확인
        return queue.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */