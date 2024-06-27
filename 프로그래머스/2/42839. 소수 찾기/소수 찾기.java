import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        // numbers를 숫자 리스트로 변환
        char[] numberArray = numbers.toCharArray();
        List<Integer> numberList = new ArrayList<>();
        for(char number : numberArray){
            numberList.add(Character.getNumericValue(number));
        }
        Collections.sort(numberList);
        
        // 숫자 리스트로 만들 수 있는 숫자 목록(부분집합) 반환
        List<List<Integer>> subsetNumberList = new ArrayList<>();
        dfsForSubset(subsetNumberList, numberList, 0, new ArrayDeque<>());
        
        // 각 부분집합 리스트 별로 만들 수 있는 숫자 목록(순열) 반환
        // e.g. subsetNumber = [1, 7] -> permutationList = [17, 71]
        boolean[] isCheck = new boolean[9999999];
        Arrays.fill(isCheck, false);
        for(List<Integer> subsetNumber : subsetNumberList){
            Set<Integer> permutationSet = new HashSet<>();
            boolean[] visited = new boolean[subsetNumber.size()];
            Arrays.fill(visited, false);
            
            // 숫자 목록(순열 반환)
            permutation(permutationSet, new ArrayDeque<>(), subsetNumber, visited, 0);
            
            // 소수 판별
            for(Integer permutaion : permutationSet) {
                if(isPrime(permutaion, isCheck)) {
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
    
    // 숫자 리스트 목록 탐색(dfs)
    private void dfsForSubset(List<List<Integer>> subsetNumberList,
                     List<Integer> numberList,
                     int index,
                     Deque<Integer> path
                    ){
        // subsetNumberList : 숫자 부분집합 리스트 저장
        subsetNumberList.add(new ArrayList<>(path));
        
        // 각 원소들을 순차 탐색(e.g. [1, 2, 4] : 1 -> 2 -> 4)
        for(int i = index; i < numberList.size(); i++){
            path.add(numberList.get(i));
            dfsForSubset(subsetNumberList, numberList, i + 1, path);
            path.removeLast();
        }
    }
    
    private void permutation(Set<Integer> permutationSet,
                             Deque<Integer> prevElements, 
                             List<Integer> elements,
                             boolean[] visited,
                             int depth
                            ) {
        if(depth == elements.size()){
            StringBuilder sb = new StringBuilder();
            for(Integer prevElement : prevElements) {
                sb.append(prevElement);
            }
            
            if(!sb.toString().isBlank()) {
                permutationSet.add(Integer.parseInt(sb.toString()));
            }
            
            return;
        }
        
        for(int i = 0; i < elements.size(); i++) {
            if(visited[i]) {
                continue;
            }
            
            prevElements.add(elements.get(i));
            visited[i] = true;
            permutation(permutationSet, prevElements, elements, visited, depth + 1);
            prevElements.removeLast();
            visited[i] = false;
        }
    }
    
    // 소수 판별
    private boolean isPrime(Integer number, boolean[] isCheck) {
        // 이미 소수인지 검증한 숫자는 다시 검증하지 않는다.
        if(isCheck[number]) {
            return false;
        }
        
        isCheck[number] = true;
        if(number <= 1) {
            return false;
        }
        if(number == 2 || number == 3) {
            return true;
        }
        
        if(number % 2 == 0) {
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) {
                return false;
            }
        }
        
        return true;
        
    }
    
    private void p(String str){
        System.out.print(str);
    }
}