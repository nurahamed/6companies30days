class Solution {
    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;
        int num = 1;
        int idx = 2;
        int pos = 3;
        int ans = 1;
        while (pos < n) {
            int count = arr[idx];
            for (int i = 0; i < count && pos < n; i++) {
                arr[pos] = num;
                if (arr[pos] == 1) {
                    ans++;
                }
                pos++;
            }
            idx++;
            num = 3 - num;
        }
        return ans;
    }
}
