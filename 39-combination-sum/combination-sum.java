class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // optional, helps avoid duplicates
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        
        for (int i = 0; i <= target; i++)
            dp[i] = new ArrayList<>();
        
        dp[0].add(new ArrayList<>());

       
        for (int num : candidates) {
            for (int t = num; t <= target; t++) {
                for (List<Integer> comb : dp[t - num]) {
                   
                    if (comb.isEmpty() || num >= comb.get(comb.size() - 1)) {
                        List<Integer> newComb = new ArrayList<>(comb);
                        newComb.add(num);
                        dp[t].add(newComb);
                    }
                }
            }
        }

        return dp[target];
    }
}