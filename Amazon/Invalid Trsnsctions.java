import java.util.*;
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<String>();
        int n = transactions.length;
        String[] name = new String[n];
        int[] time = new int[n];
        int[] amount = new int[n];
        String[] city = new String[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tknzr = new StringTokenizer(transactions[i]);
            int j = 0;
            while (tknzr.hasMoreElements()) {
                if (j == 0) {
                    name[i] = tknzr.nextToken(",");
                }
                if (j == 1) {
                    time[i] = Integer.parseInt(tknzr.nextToken());
                }
                if (j == 2) {
                    amount[i] = Integer.parseInt(tknzr.nextToken());
                }
                if (j == 3) {
                    city[i] = tknzr.nextToken();
                }
                j++;
            }
        }
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (amount[i] > 1000) {
                if (used[i] == false) {
                    res.add(transactions[i]);
                    used[i] = true;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    if (i != j && name[i].equals(name[j]) && !city[i].equals(city[j]) && Math.abs(time[i] - time[j]) <= 60) {
                        if (used[i] == false) {
                            res.add(transactions[i]);
                            used[i] = true;
                        }
                        if (used[j] == false) {
                            res.add(transactions[j]);
                            used[j] = true;
                        }
                    }
                }   
            }
        }
        return res;
    }
}
