class MyQueue() {
    // 자바는 이와 같이 변수(inputStack)의 타입(Deque<Int>)을 명확히 지정해줘야한다.
    val inputStack: Deque<Int> = LinkedList()

    // 코틀린은 변수의 타입을 명확히 지정하지 않고, 초깃값을 보고 자동으로 추론할 수 있다.
    val outputStack = LinkedList<Int>() // 초깃값(ArrayDeque<Int>())을 보고 변수의 타입을 추론

    fun push(x: Int) {
        inputStack.push(x)
    }

    fun pop(): Int {
        // outputStack이 inputStack의 역순으로 원소를 갖도록 peek()을 호출한다.
        peek()
        
        // 출력용 스택의 가장 마지막 원소를 추출하여 반환한다.
        return outputStack.pop()
    }

    fun peek(): Int {
        if(!outputStack.isEmpty()) {
            // 가장 나중에 삽입된 결과 조회
            return outputStack.peek()
        }
        
        // 삽입 스택이 비워질때까지 진행
        while(!inputStack.isEmpty()){
            // 삽입용 스택의 원소를 꺼내 출력용 스택에 넣는다. (outputStack은 inputStack의 역순으로 원소를 갖게 된다.)
            outputStack.push(inputStack.pop())
        }
        
        // 가장 나중에 삽입된 결과 조회
        return outputStack.peek()
    }

    fun empty(): Boolean {
        // 삽입용 스택과 출력용 스택이 모두 비어있어야 true를 반환한다.
        return inputStack.isEmpty() && outputStack.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */