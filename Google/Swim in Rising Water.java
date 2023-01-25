class Solution {
    private final int[][] dirs = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1},
    };
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] time = new int[n][n];
        for(int[] row : time) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0});
        time[0][0] = grid[0][0];
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i += 1) {
                int[] cell = queue.poll();
                
                for(int[] dir : dirs) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];
                    
                    if(row >= 0 && col >= 0 && row < n && col < n) {
                        int current = time[row][col];
                        int expected = time[cell[0]][cell[1]];
                        
                        if(expected < current) {
                            time[row][col] = Math.max(expected, grid[row][col]);
                            queue.offer(new int[]{row, col});
                        }
                        
                    }
                }
            }
        }
        
        return time[n-1][n-1];
    }
}
