class MyCircularDeque(k: Int) {
    
    // 이중 연결 리스트로 사용할 클래스 선언
	data class DoublyLinkedList(var `val`: Int) {
		// 왼쪽으로 연결할 이중 연결 리스트
		var left: DoublyLinkedList? = null
		
		// 오른쪽으로 연결할 이중 연결 리스트
		var right: DoublyLinkedList? = null
	}
    
    // 현재 큐의 크기
    var len = 0
    // 전체 큐의 크기
    var k = 0
    // 이중 연결 리스트의 head 노드
    var head: DoublyLinkedList? = null
    // 이중 연결 리스트의 tail 노드
    var tail: DoublyLinkedList? = null
    
    // 초기화 불록
    init {
        // 이중 연결리스트 2개 생성
        head = DoublyLinkedList(0)
        tail = DoublyLinkedList(0)
        
        // 서로 연결
        head!!.right = tail // head의 right는 null이 될 수 없다. (널이 들어오는 경우 NPE 발생)
        tail!!.left = head
        
        // 전체 큐 크기 지정
        this.k = k
        
        // 현재 큐의 크기 지정
        this.len = 0
    }
    
    fun insertFront(value: Int): Boolean {
        // 꽉 차 있으면 진행하지 않음
        if(isFull()) {
            return false
        }
        
        val node: DoublyLinkedList = DoublyLinkedList(value)
        
        // 신규 노드는 head 바로 오른쪽에 삽입
        node.left = head
        node.right = head!!.right
        head!!.right!!.left = node
        head!!.right = node
        len++
        return true
    }

    fun insertLast(value: Int): Boolean {
        // 꽉 차 있으면 진행하지 않음
        if(isFull()) {
            return false
        }
        
        val node: DoublyLinkedList = DoublyLinkedList(value)
         
        // 신규 노드는 tail 바로 왼쪽에 삽입
        node.left = tail!!.left
        node.right = tail
        tail!!.left!!.right = node
        tail!!.left = node
        len++
        return true
    }

    fun deleteFront(): Boolean {
        // 텅 비어있지 않다면 진행하지 않음
        if(isEmpty()) {
            return false
        }
        
        // head 바로 오른쪽 노드를 연결에서 끊음
        head!!.right!!.right!!.left = head
        head!!.right = head!!.right!!.right
        len--
        return true
    }

    fun deleteLast(): Boolean {
        // 텅 비어있지 않다면 진행하지 않음
        if(isEmpty()) {
            return false
        }
        
        // tail 바로 왼쪽 노드를 연결에서 끊음
        tail!!.left!!.left!!.right = tail
        tail!!.left = tail!!.left!!.left
        len--
        return true
    }

    fun getFront(): Int {
        // 맨 앞(head의 오른쪽)의 값을 가져온다.
        return if (isEmpty()) -1 else head!!.right!!.`val`
    }

    fun getRear(): Int {
        // 맨 뒤(tail의 왼쪽)의 값을 가져온다.
        return if (isEmpty()) -1 else tail!!.left!!.`val`
    }

    fun isEmpty(): Boolean {
        // 현재 큐의 크기가 0이면 비어있음
        return len == 0
    }

    fun isFull(): Boolean {
        // 현재 큐의 크기가 처음 선언한 큐의 크기와 일치하면 꽉 차 있음
        return len == k
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */