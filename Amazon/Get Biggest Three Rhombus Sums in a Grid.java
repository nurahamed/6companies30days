class Solution {
    public int[] getBiggestThree(int[][] grid) {
        
        int maxSize = grid.length/2;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>( (x,y) -> x-y );
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < grid.length; i++ ) {
            for(int j = 0; j < grid[i].length; j++ ) { 
                
                if(!set.contains(grid[i][j])) {
                    pq.add(grid[i][j]);
                    set.add(grid[i][j]);
                }
                if(pq.size() > 3)
                    pq.poll();
               
                for(int k = 1; k <= maxSize && i >= k && j >= k && k + i <  grid.length && k+j < grid[i].length; k++) {
                    int dia = calcRombus(grid, i, j, k);
                    if(!set.contains(dia)) {
                        pq.add(dia);   
                        set.add(dia);
                    }
                    if(pq.size() > 3) 
                        pq.poll();
                }  
            }
        }
        
        int[] res = new int[pq.size()];
        for(int i = pq.size()-1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        
        return res;
    }
    
    public int calcRombus(int[][] grid, int i, int j, int k) {
        
        int curr = 0;

        for(int l = 0; l < k+1; l++)
            curr += grid[i+l][j+k-l] + grid[i-l][j+k-l] + grid[i+l][j-k+l] + grid[i-l][j-k+l];
        curr -= grid[i+k][j] + grid[i-k][j] + grid[i][j+k] + grid[i][j-k];

        return curr;   
    }
}
