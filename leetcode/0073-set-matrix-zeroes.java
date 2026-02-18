class Solution {
    public void setZeroes(int[][] matrix) {
        // 최초 0인 인덱스 저장
        List<List<Integer>> indexes = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    indexes.add(List.of(i, j));
                }
            }
        }

        for(List<Integer> index : indexes) {
            int i = index.get(0);
            int j = index.get(1);

            // 상
            while(i >= 0) {
                matrix[i][j] = 0;
                i--;
            }
            i = index.get(0);

            // 하
            while(i < matrix.length) {
                matrix[i][j] = 0;
                i++;
            }
            i = index.get(0);

            // 좌
            while(j >= 0) {
                matrix[i][j] = 0;
                j--;
            }
            j = index.get(1);

            // 우
            while(j < matrix[0].length) {
                matrix[i][j] = 0;
                j++;
            }
        }
    }
}
