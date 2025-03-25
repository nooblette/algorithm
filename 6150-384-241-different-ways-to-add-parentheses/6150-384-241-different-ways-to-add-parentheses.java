class Solution {
    // 주어진 문자열을 연산자를 기준으로 좌, 우 분할
    public List<Integer> diffWaysToCompute(String expression) {
        // 좌, 우로 분할한 연산 결과에 대해 연산한 결과 목록을 저장
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // 연산자인 경우 좌, 우로 분할
            if(c == '+' || c == '*' || c == '-') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for(int l : left) {
                    for(int r : right) {
                        if(c == '+') {
                            result.add(l + r);
                        }else if(c == '*') {
                            result.add(l * r);
                        } else if(c == '-') {
                            result.add(l - r);
                        }
                    }
                }
            }
        }

        if(result.isEmpty()) {
            return List.of(Integer.parseInt(expression));
        }

        return result;
    }
}