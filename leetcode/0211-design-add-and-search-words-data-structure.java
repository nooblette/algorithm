class WordDictionary {
    private WordDictionary[] children;
    private boolean isEndOfWord;

    public WordDictionary() {
        children = new WordDictionary[26];
        isEndOfWord = false;
    }
    
    public void addWord(String word) {
        WordDictionary node = this;

        for(char c : word.toCharArray()) {
            if(node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new WordDictionary();
            }

            node = node.children[c - 'a'];
        }

        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return search(this, 0, word.toCharArray());
    }

    private boolean search(WordDictionary node, int index, char[] words) {
        // 문자의 끝에 도달한 경우
        if(index == words.length) {
            return node.isEndOfWord;
        }

        // '.' 이 등장한 경우
        if(words[index] == '.') {
            boolean result = false;

            for(int i = 0; i < 26; i++) {
                // '.'을 저장된 알파벳으로 치환
                if(node.children[i] == null) {
                    continue;
                }

                boolean tmp = search(node.children[i], index + 1, words);
                result = tmp ? tmp : result;
            }

            return result;
        }
        
        // 알파벳이 저장된 경우
        if(node.children[words[index] - 'a'] == null) {
            return false;
        }

        return search(node.children[words[index] - 'a'], index + 1, words);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
