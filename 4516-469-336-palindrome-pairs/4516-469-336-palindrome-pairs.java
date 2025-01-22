class Solution {
    static class TrieNode {
        // words 배열의 인덱스 저장
        int wordId;

        // 트라이의 자식 노드들
        TrieNode[] children;

        // 트라이 삽입 중 남은 단어가 팰린드롬인 단어의 words 배열 상 인덱스
        List<Integer> palindromeWordIds;

        public TrieNode() {
            // dummy data
            wordId = -1;

            // 자식 노드는 알파벳 개수만큼 가능
            children = new TrieNode[26];

            // 팰린드롬 ID 목록 초기화
            palindromeWordIds = new ArrayList<>();
        }
    }

    static class Trie {
        TrieNode root;

        // 클래스 생성시 루트로 빈 트라이 노드 생성
        public Trie() {
            root = new TrieNode();
        }

        // 팰린드롬 여부 판별
        public boolean isPalindrome(String str, int start, int end) {
            // 시작 지점이 종료 지점보다 앞에 있으면 계속 반복
            while(start < end) {
                if(str.charAt(start) != str.charAt(end)) {
                    return false;
                }

                start++;
                end--;
            }

            return true;
        }

        // 단어 삽입
        public void insert(int index, String word) {
            TrieNode cur = root;

            // 단어를 뒤집어서 트라이에 저장
            for(int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                // 정방향으로 해당 위치까지 팰린드롬인 경우 단어의 인덱스 저장 (그림에서 p)
                if(isPalindrome(word, 0, i)) {
                    cur.palindromeWordIds.add(index);
                }

                // 해당 문자의 자식노드가 존재하지 않다면 신규 트라이 노드 생성
                if(cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }

                cur = cur.children[c - 'a'];
            }

            // 단어가 완성된 후 단어의 words 배열상 인덱스 전달 (그림에서 w)
            cur.wordId = index;
        }

        // 팰린드롬 여부 판별
        public List<List<Integer>> search(int index, String word) {
            // 루트부터 시작
            TrieNode cur = root;

            // 결과 변수
            List<List<Integer>> result = new ArrayList<>();

            // 단어의 문자를 정방향으로 탐색하여 판별
            for(int j = 0; j < word.length(); j++) {
                // 방법 3) 탐색 중인 문자열 중간에 팰린드롬이 있고 이후 문자열도 팰린드롬인 경우
                if(cur.wordId >= 0 && isPalindrome(word, j, word.length() - 1)) {
                    result.add(Arrays.asList(new Integer[]{index, cur.wordId}));
                }

                // 자식 노드가 없으면 탐색 종료
                if(cur.children[word.charAt(j) - 'a'] == null) {
                    return result;
                }

                // 자식 노드를 현재 노드로 교체
                cur = cur.children[word.charAt(j) - 'a'];
            }

            // 방법 1) 주어진 word를 끝까지 탐색했을 때 탐색 중인 문자열을 뒤집은 문자열이 주어진 경우
            if(cur.wordId >= 0 && cur.wordId != index)
                result.add(Arrays.asList(new Integer[]{index, cur.wordId}));

            // 방법 2) 주어진 word를 끝까지 탐색했을 때 탐색 중인 문자열을 뒤집은 결과를 포함하는 문자열이 주어진 경우
            for(int palindromeWordId : cur.palindromeWordIds) {
                result.add(Arrays.asList(new Integer[]{index, palindromeWordId}));
            }

            return result;
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        // 트라이 클래스
        Trie t = new Trie();
        
        // 결과 리스트 변수
        List<List<Integer>> results = new ArrayList<>();
        
        // 단어 목록을 트라이에 추가
        for(int i = 0; i < words.length; i++) {
            t.insert(i, words[i]);
        }
        
        // 단어 목록에서 하나씩 팰린드롬 여부를 판별하고 결과에 누적
        for(int i = 0; i < words.length; i++) {
            results.addAll(t.search(i, words[i]));
        }
        
        return results;
    }
}