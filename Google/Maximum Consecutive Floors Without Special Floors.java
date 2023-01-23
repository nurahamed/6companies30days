class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int index = 0;
        int curr = bottom, ans = 0;
        while (curr <= top && index < special.length) {
            ans = Math.max(ans, special[index] - curr);
            curr = special[index] + 1;
            index += 1;
        }
        ans = Math.max(ans, top - curr + 1);
        return ans;
    }
}
