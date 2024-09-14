/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
	// Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        // 예외 처리
        if(root == null) {
            // serialize() 메서드의 반환형이 String (null 불가)
            return ""
        }
        
        // BFS 탐색을 위한 큐 선언
        val q: Queue<TreeNode> = LinkedList()
        
        // 직렬화 결과를 저장할 문자열 변수
        val sb = StringBuilder()
        
        // root 노드를 큐에 추가
        q.add(root)
        
        // 0번째 인덱스는 사용하지 않으며("#") 다음 인덱스는 root부터 시작
        sb.append("#," + root.`val`)
        
        // BFS 탐색하며 트리를 문자열로 직렬화
        while(!q.isEmpty()) {
            // 큐에서 노드 추출
            val node = q.remove()
            
            // 왼쪽 자식 노드가 null이 아니면 q에 추가하고 sb에 값을 추가(append)
            if(node.left != null) {
                q.add(node.left)
                sb.append("," + node.left.`val`)
            } else {
                // null이라면 sb에 사용하지 않는 문자("#")로 null 임을 표시
                sb.append(",#")
            }
            
            // 오른쪽 자식 노드가 null이 아니면 q에 추가하고 sb에 값을 추가(append)
            if(node.right != null) {
                q.add(node.right)
                sb.append("," + node.right.`val`)
            } else {
                // null이라면 sb에 사용하지 않는 문자("#")로 null 임을 표시
                sb.append(",#")
            }
        }
        
        // 문자열로 변환하여 반환
        return sb.toString()
            
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        // 예외 처리
        if(data == "") {
            // deserialize() 메서드의 반환형이 TreeNode? (null 가능)
            return null
        }
        
        // data 문자열을 ,를 기준으로 분리
        val nodes = data.split(",")
        
        // 인덱스 1번이 root 노드
        val root = TreeNode(nodes[1].toInt())
        
        // BFS 탐색을 위한 큐 선언
        val q: Queue<TreeNode> = LinkedList()
        
        // 첫번째 원소로 root 노드 추가
        q.add(root)
        
        // 2번 인덱스부터 탐색 시작
        var index = 2
        
        // BFS 탐색 시작
        while(!q.isEmpty()) {
            val node = q.remove()
            
            // 값이 있다면 왼쪽 자식으로 추가
            if(nodes[index] != "#") {
                node.left = TreeNode(nodes[index].toInt())
                
                // BFS 탐색을 위해 큐에 추가
                q.add(node.left)
            }
            
            // 항상 좌/우 세트로 구성되어있으므로 오른쪽 자식 노드에 대해서도 한번 더 진행
            index += 1
            if(nodes[index] != "#") {
                node.right = TreeNode(nodes[index].toInt())
                
                // BFS 탐색을 위해 큐에 추가
                q.add(node.right)
            }
            
            // 다음 인덱스에 대해 탐색 진행
            index += 1
        }
        
        
        // 결과 노드 반환
        return root
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */