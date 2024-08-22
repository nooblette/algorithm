class MyHashMap() {
    // 노드 클래스
    class Node(var key: Int, var `val`: Int) {
        var next: Node? = null
    }
    
    val nodes: Array<Node?> = arrayOfNulls(1000000)
    
    fun put(key: Int, value: Int) {
        // 해싱 결과 값 index 계산
        val index = key % nodes.size
        
        // 해싱 인덱스에 노드가 없다면 신규 생성
        if(nodes[index] == null) {
            nodes[index] = Node(key, value)
            return
        }
        
        // 해싱 인덱스에 노드가 있다면 연결리스트로 연결
        var node = nodes[index]
        while(node != null) {
            // 기존 키를 업데이트하는 경우
            if(node.key == key) {
                node!!.`val` = value
                return
            }
            
            // 다음 노드가 없는 경우
            if(node.next == null) {
                break
            }
            
            // 다음 노드 탐색
            node = node.next
        }
        
        // 마지막 노드 다음으로 연결
        node!!.next = Node(key, value)
    }

    fun get(key: Int): Int {
        // 해싱 결과 값 index 계산
        val index = key % nodes.size
        
        // 해당 인덱스에 노드가 없는 경우
        if(nodes[index] == null) {
            return -1
        }
        
        // 인덱스에 노드가 있다면 일치하는 키 탐색
        var node = nodes[index]
        while(node != null) {
            if(node.key == key) {
                return node.`val`
            }
            
            // 다음 노드 탐색
            node = node.next
        }
        
        // 일치하는 키를 찾지 못한 경우
        return -1
    }

    fun remove(key: Int) {
        // 해싱 결과 값 index 계산
        val index = key % nodes.size
        
        // index에 해당하는 노드가 없는 경우
        if(nodes[index] == null) {
            return
        }
        
        
        // 첫번재 노드가 삭제 대상 노드인 경우
        var node = nodes[index]
        if(node!!.key == key) {
            // 이후 노드가 없는 경우
            if(node.next == null) {
                // 해당 인덱스 Null 처리
                nodes[index] = null
            }
            
            // 이후 노드가 있는 경우
            else {
                // 다음 노드를 해당 인덱스의 루트 노드로 지정
                nodes[index] = node.next
            }
        }
        
        // 삭제 대상 노드가 연결리스트 중간에 있는 경우
        var prev = node
        while(node != null) {
            // 일치하는 키가 있다면
            if(node.key == key) {
                prev!!.next = node.next
                return
            }
            
            // 다음 노드 탐색
            prev = node
            node = node.next
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */