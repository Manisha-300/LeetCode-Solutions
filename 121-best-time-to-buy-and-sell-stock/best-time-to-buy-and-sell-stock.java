class Solution {
    public int maxProfit(int[] prices) {
         int n=prices.length;
         int minp=Integer.MAX_VALUE;
      //   int profit=0;
         int maxm=0;
         for(int i=0;i<n;i++){
            minp=Math.min(minp,prices[i]);
           int  profit=prices[i]-minp;
               maxm=Math.max(maxm,profit);
               
         }

         return maxm; 
    }
}