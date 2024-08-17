class MyQueue {
    // 삽입용 스택 선언
    Deque<Integer> inputStack = new ArrayDeque();
    
    // 출력용 스택 선언
    Deque<Integer> outputStack = new ArrayDeque();
    

    public MyQueue() {
        
    }
    
    public void push(int x) {
        inputStack.push(x);
    }
    
    public int pop() {
        // outputStack이 inputStack의 역순으로 원소를 갖도록 peek()을 호출한다.
        peek();
        
        // 출력용 스택의 가장 마지막 원소를 추출하여 반환한다.
        return outputStack.pop();
        
    }
    
    public int peek() {
        if(!outputStack.isEmpty()) {
            // 가장 나중에 삽입된 결과 조회
            return outputStack.peek();
        }
        
        // 삽입 스택이 비워질때까지 진행
        while(!inputStack.isEmpty()){
            // 삽입용 스택의 원소를 꺼내 출력용 스택에 넣는다. (outputStack은 inputStack의 역순으로 원소를 갖게 된다.)
            outputStack.push(inputStack.pop());
        }
        
        // 가장 나중에 삽입된 결과 조회
        return outputStack.peek();
    }
    
    public boolean empty() {
        // 삽입용 스택과 출력용 스택이 모두 비어있어야 true를 반환한다.
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */