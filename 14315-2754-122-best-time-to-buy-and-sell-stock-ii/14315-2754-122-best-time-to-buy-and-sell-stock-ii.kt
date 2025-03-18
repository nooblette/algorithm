class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        
        for (i in 0 until prices.size - 1) {
            // 주식의 가격이 오른다면 항상 이익을 취한다.
            if(prices[i] < prices[i+1]) {
                result += (prices[i+1] - prices[i])
            }
        }

        return result
    }
}