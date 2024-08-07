class Solution {
    public int maxProfit(int[] prices) {
        // 최대 이익 0, 저점은 임시로 첫번째 값으로 지정
        int maxProfit = 0, minPrice = prices[0];
        
        // 현재 값을 기준으로 우측으로 차례대로 이동하면서 계산
        for(int price : prices) {
            // 저점 갱신
            minPrice = Math.min(minPrice, price);
            
            // 최대 이익 갱신
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
    }
}