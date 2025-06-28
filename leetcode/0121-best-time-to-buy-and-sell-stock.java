class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;

        // min 초기화
        int min = prices[0];

        for(int i = 1; i < prices.length; i++) {
            // 가격이 더 저렴한 날짜를 만나면 갱신
            if(prices[i] < min) {
                // 주식 구매
                min = prices[i];

                // 주식 판매는 다른날에 가능하므로 넘어간다.
                continue;
            }

            // 예상 수익 게산
            int profit = prices[i] - min;
            result = Math.max(result, profit);
        }

        return result;
    }
}
