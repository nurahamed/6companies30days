class Solution {
    public int maximumGood(int[][] s) {
        int max = 0;
        _xxx:
        for (int i = (1 << s.length) - 1; i >= 0; i--) { // i is the mask of good ppl
            for (int j = 0; j < s.length; j++)  
                if (((1 << j) & i) > 0)  // j is good ppl
                    for (int k = 0; k < s.length; k++) // good ppl's statement
                        if (s[j][k] == 0 && (i & (1 << k)) > 0 || s[j][k] == 1 && (i & (1 << k)) == 0) continue _xxx; // gool ppl tell truth
            max = Math.max(max, Integer.bitCount(i)); // if use grey code, then greed instead of brute force
        }
        return max;
    }
}
