class Trie {
    // 26개(알파벳 a-z)의 자식 노드
    private Trie[] children;

    // 단어의 끝 부분인지 여부 저장
    private boolean isEndOfWord;

    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }
    
    public void insert(String word) {
        // 현재 노드부터 시작
        Trie node = this;
        
        for(char c : word.toCharArray()) {
            int index = c - 'a';

            // 자식 노드가 없다면 연결
            if(node.children[index] == null) {
                node.children[index] = new Trie();
            }

            // 자식 노드 중 인덱스에 해당하는 노드로 변경
            node = node.children[index];
        }

        // 마지막 문자는 단어가 등장했음을 마킹
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        
        // 트라이에 저장된 단어들은 모두 node가 존재한다.
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        // 마지막 노드는 단어가 등정했음이 마킹되어있어야한다.
        return node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        // 트라이에 저장된 단어들은 모두 node가 존재한다.
        Trie node = this;
        for(char c : prefix.toCharArray()) {
            int index = c - 'a';
            if(node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

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
