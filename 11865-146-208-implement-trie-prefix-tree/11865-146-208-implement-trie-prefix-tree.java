class TrieNode {
	boolean word;
	TrieNode[] children;
	
	TrieNode() {
		children = new TrieNode[26];
		word = false;
	}
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        // 루트부터 시작
        TrieNode cur = root;

        // 단어의 문자를 차례대로 반복하여 자식 노드 구성
        for(char c : word.toCharArray()) {
            // 기존에 저장된 문자가 없는 경우 신규 트라이 노드 생성
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }

            // 자식 노드를 현재 노드로 교체
            cur = cur.children[c - 'a'];
        }

        // for loop가 끝나면 단어가 완성된 후이므로 현재 노드는 단어 완성 여부에 true를 설정
        cur.word = true;
    }
    
    public boolean search(String word) {
        // 루트부터 시작
        TrieNode cur = root;

        // 단어의 문자를 차례대로 반복하여 자식 노드 구성
        for(char c : word.toCharArray()) {
            // 트라이에 해당하는 단어가 없는 경우
            if(cur.children[c - 'a'] == null)
                return false;

            // 자식 노드를 현재 노드로 교체	
            cur = cur.children[c - 'a'];
        }

        // 탐색이 종료된 후 단어 완성 여부를 반환
        // 완성된 단어가 아니라면 문자는 모두 매칭이 되어도 단어 완성 여부는 false일 수 있음
        return cur.word;
    }
    
    public boolean startsWith(String prefix) {
        // 루트부터 시작
        TrieNode cur = root;

        // 단어의 문자를 차례대로 반복하여 자식 노드 구성
        for(char c : prefix.toCharArray()) {
            // 트라이에 해당하는 단어가 없는 경우
            if(cur.children[c - 'a'] == null)
                return false;

            // 자식 노드를 현재 노드로 교체	
            cur = cur.children[c - 'a'];
        }

        // 탐색이 종료되면 항상 true 리턴, 시작 여부만 판별하면 되므로 단어 완성 여부가 false여도 상관없다.
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */