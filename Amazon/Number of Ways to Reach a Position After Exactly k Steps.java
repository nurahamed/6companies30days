class Solution {
    long mod = 1000000007L;
    public int numberOfWays(int startPos, int endPos, int k) {
        if(endPos - startPos > k || (k - endPos + startPos) % 2 != 0) return 0;
        int backward = (k - endPos + startPos) / 2;
        int forward = endPos - startPos + backward;
        return (int) (dfs(forward, backward) % mod);
    }
    
    
    long[][] dp = new long[1001][1001];
    long dfs(int forward, int backward) {
        if(forward == 0 || backward == 0) return 1L;
        if(dp[forward][backward] != 0L) return dp[forward][backward];
        long res = (dfs(forward - 1, backward) % mod + dfs(forward, backward - 1) % mod) % mod;
        dp[forward][backward] = res;
        return res;
    }
}
