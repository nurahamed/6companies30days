class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        long mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[1] = 1;

        for (int i = 1; i < n; ++i) {
            for (int j = i + delay; j < i + forget && j <= n; ++j) {
                dp[j] = (dp[j] + dp[i]) % mod;
            }
        }

        long res = 0;
        for (int i = n; i > n - forget; --i) {
            res = (res + dp[i]) % mod;
        }

        return (int) res;
        
    }
}
