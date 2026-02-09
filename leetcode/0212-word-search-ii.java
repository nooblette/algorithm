class Solution {
    private int[][] heads = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();

        for(String word : words) {
            Trie node = root;
            for(char c : word.toCharArray()) {
                int index = c - 'a';
                if(node.children[index] == null) {
                    node.children[index] = new Trie();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {    
        Trie root = buildTrie(words);

        List<String> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root, result);
            }
        }

        return result;
    }

    private void dfs(int i, int j, char[][] board, Trie node, List<String> result) {
        // 탐색 범위를 벗어나거나 이미 방문한 노드인 경우
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X') {
            return;
        }

        // 해당 위치의 문자가 탐색하는 문자(Trie) 목록에 없는 경우 탐색 종료 (Prunning)
        if(node == null || node.children[board[i][j] - 'a'] == null) {
            return;
        }

        // 대상 문자를 찾은 경우 (Trie 가장 하단까지 도달한 경우)
        node = node.children[board[i][j] - 'a'];
        if(node.word != null) {
            result.add(node.word);

            // 중복 탐색 방지
            node.word = null;
        }

        // 백트래킹
        char tmp = board[i][j];
        board[i][j] = 'X';
        for(int[] head : heads) {
            dfs(i + head[0], j + head[1], board, node, result);
        }
        board[i][j] = tmp;
    }

    static class Trie {
        Trie[] children = new Trie[26];
        String word;
    }

}
