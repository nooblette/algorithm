// 트라이의 노드
class TrieNode {
	// 단어 완성 여부
	var word: Boolean = false
	
	// 트라이의 자식 노드들, 문제 제약 조건에 따라 소문자 알파벳으로 구성
	// 자식 노드는 알파벵ㅅ의 개수인 최대 26개 가능
	val children: Array<TrieNode?> = arrayOfNulls(26)
}

class Trie() {
		// 루트로 빈 트라이 노드 생성
		val root: TrieNode = TrieNode()
		
    fun insert(word: String) {
	    // 루트부터 시작
	    var cur: TrieNode = root
	    
	    // 단어의 문자를 차례대로 반복하여 자식 노드 구성
	    for(c in word) {
		    // 해당 문자의 자식 노드가 존재하지 않으면 신규 트라이 노드 생성
		    if(cur.children[c - 'a'] == null) {
			    cur.children[c - 'a'] = TrieNode()
			  }
			  
			  // 자식 노드를 현재 노드로 교체
			  cur = cur.children[c - 'a']!!
			 }
			 
			 // 단어가 완성됐으므로 현재 노드의 단어 완성 여부를 true로 세팅
			 cur.word = true
    }

    fun search(word: String): Boolean {
        // 루트부터 시작
        var cur: TrieNode = root
        
        // 단어의 문자를 차례대로 반복하여 자식 노드 구성
        for(c in word) {
	        // 자식 노드가 존재하지 않으면 false
	        if(cur.children[c - 'a'] == null) {
		        return false
		      }
		       
		       // 자식 노드를 현재 노드로 교체
				  cur = cur.children[c - 'a']!!
				}
				
				// 탐색이 종료된 후 단어 완성 여부를 반환
        // 완성된 단어가 아니라면 문자는 모두 매칭이 되어도 단어 완성 여부는 false일 수 있음
				return cur.word
    }

    fun startsWith(prefix: String): Boolean {
         // 루트부터 시작
        var cur: TrieNode = root
        
        // 단어의 문자를 차례대로 반복하여 자식 노드 구성
        for(c in prefix) {
	        // 자식 노드가 존재하지 않으면 false
	        if(cur.children[c - 'a'] == null) {
		        return false
		    }
		       
		    // 자식 노드를 현재 노드로 교체
            cur = cur.children[c - 'a']!!
        }
        
        // 탐색이 종료되면 항상 true 리턴
        // 시작 여부만 판별하면 되므로 단어 완성 여부가 false여도 상관없다.
        return true       
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */