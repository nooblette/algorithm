class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        
        // 임시로 첫번째 값을 최소값으로 지정
        var minPrice = prices[0]
        
        // 현재 값을 기준으로 우측으로 차례대로 이동하면서 계산
        for(price in prices) {
            // 지금까지의 저점 계산
            minPrice = minPrice.coerceAtMost(price)
            
            // 최대 이익 갱신
            maxProfit = maxProfit.coerceAtLeast(price - minPrice)
        }
        
        return maxProfit
    }
}