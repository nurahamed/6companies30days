class Solution {
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> sums = new TreeSet<>();
        int[][] diagSum = new int[205][205];
        int[][] antiDiagSumLeft = new int[105][105];
        int[][] antiDiagSumRight = new int[105][105];
        
        int m = grid.length;
        int n = grid[0].length;
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                // /
                diagSum[r + c][r] += grid[r][c];
                if (r > 0) {
                    diagSum[r + c][r] += diagSum[r + c][r - 1];
                }
                
                // \
                if (r >= c) {
                    antiDiagSumLeft[r - c][r] += grid[r][c];
                    if (r > 0) {
                        antiDiagSumLeft[r - c][r] += antiDiagSumLeft[r - c][r - 1];
                    }
                }
                
                if (r <= c) {
                    antiDiagSumRight[c - r][r] += grid[r][c];
                    if (r > 0) {
                        antiDiagSumRight[c - r][r] += antiDiagSumRight[c - r][r - 1];
                    }
                }
            }
        }

        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                sums.add(grid[r][c]);
                for (int lo = r + 2; lo < m; lo += 2) {
                    int d = lo - r;
                    int mid = r + d / 2;
                    
                    if (c - d / 2 < 0 || c + d / 2 >= n) continue;
                    
                    int diag1 = diagSum[r + c][mid];
                    if (r > 0) {
                        diag1 -= diagSum[r + c][r - 1];
                    }
                    
                    int diag2 = diagSum[lo + c][lo];
                    if (mid > 0) {
                        diag2 -= diagSum[lo + c][mid - 1];
                    }
                    
                    int antiDiagLeft = lo - c > 0 ? antiDiagSumLeft[lo - c][lo] : antiDiagSumRight[c - lo][lo];
                    if (mid > 0) {
                        antiDiagLeft -= lo - c > 0 ? antiDiagSumLeft[lo - c][mid - 1] : antiDiagSumRight[c - lo][mid - 1];
                    }
                    
                    int antiDiagRight = c - r > 0 ? antiDiagSumRight[c - r][mid] : antiDiagSumLeft[r - c][mid];
                    if (r > 0) {
                        antiDiagRight -= c - r > 0 ? antiDiagSumRight[c - r][r - 1] : antiDiagSumLeft[r - c][r - 1];
                    }
                    
                    int sum = diag1 + diag2 + antiDiagLeft + antiDiagRight 
                        - grid[r][c] - grid[lo][c] - grid[mid][c - d / 2] - grid[mid][c + d / 2];
                    
                    sums.add(sum);
                }
            }
        }
        
        int[] result = new int[Math.min(3, sums.size())];
        int idx = 0;
        while (idx < result.length) {
            result[idx++] = sums.pollLast();
        }
        return result;
    }
}
