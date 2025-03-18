class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        
        for(int i = 0; i < prices.length - 1; i++) {
            // 주식의 가격이 오른다면 항상 이익을 취한다.
            if(prices[i] < prices[i+1]) {
                result += (prices[i+1] - prices[i]);
            }
        }
        
        return result;
    }
}