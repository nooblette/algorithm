class MyHashMap {
    // 노드 클래스
    static class Node {
        int key, val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    final Node[] nodes;
    
    public MyHashMap() {
        nodes = new Node[1000000];
    }
    
    public void put(int key, int value) {
        // 해시 값 index 계산
        int index = key % nodes.length;

        // 새로운 값이면서 해시 충돌이 발생하지 않는 경우 - 새로운 노드를 생성하고 종료한다.
        if(nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }

        // 해시 충돌이 발생하는 경우 - 개별 체이닝으로 해시 충돌 해결
        Node node = nodes[index];
        while(node != null) {

            // 이미 키가 존재하는 경우 - 값을 업데이트하고 종료한다.
            if(node.key == key) {
                node.val = value;
                return;
            }

            if(node.next == null) {
                break;
            }

            // 다음 노드로 진행
            node = node.next;
        }
        // 기존에 존재하던 키가 아닌 경우 - 노드를 연결한다.
        node.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = key % nodes.length;

        // 키에 해당하는 값이 없는 경우
        if(nodes[index] == null) {
            return -1;
        }

        Node node = nodes[index];
        while(node != null) {
            // 키가 이미 해시 테이블에 존재하는 경우
            if(node.key == key) {
                return node.val;
            }

            // 다음 노드 탐색
            node = node.next;
        }

        return -1;
    }	
    
    public void remove(int key) {
        // 해싱 결과를 index 변수에 저장
        int index = key % nodes.length;
        
        // 해당 인덱스에 노드가 없다면 종료
        if(nodes[index] == null) {
            return;
        }
        
        // 첫번째 노드일때 삭제처리
        Node node = nodes[index];
        if(node.key == key) {
            if(node.next == null) {
                // 다음 노드가 없으면 유일한 노드이므로 해당 인덱스를 null로 처리한다.
                nodes[index] = null;
            }
            else {
                // 다음 노드가 있다면 다음 노드를 해당 인덱스의 루트 노드로 지정한다.
                nodes[index] = node.next;
            }
        }
        
        // 첫번째 노드가 아닐때
        Node prev = node;
        while(node != null) {
            if(node.key == key) {
                // 삭제 노드 전후 노드 연결
                prev.next = node.next;
                return;
            }

            // 다음 노드로 이동하여 탐색 진행
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */