class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length == 0)
            return 0;
        
        if(prices.length == 1)
            return 0;
        
        
        int currentProfit = prices[0];
        int[] diff = new int[prices.length-1];
        
        for(int i = 1; i < prices.length; i++){
            diff[i-1] = prices[i] - prices[i-1];
        }
        
        int profitSoFar = diff[0];
        int maxProfit = diff[0];
        
        for(int i = 1; i < diff.length; i++){
            profitSoFar = Math.max(diff[i], diff[i]+profitSoFar);
            maxProfit = Math.max(profitSoFar, maxProfit);
        }
        
        return maxProfit < 0 ? 0: maxProfit;
    }
}
