class Solution {
	int ans;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int[][] arr = new int[students.length][students.length];
        for(int i = 0; i < students.length; i++) {
        	for(int j = 0; j < mentors.length; j++) {
        		arr[i][j] = find(students[i], mentors[j]);
        	}
        }
        ans = 0;
        boolean[] check = new boolean[mentors.length];
        pair(0, students.length, check, arr, 0);
        return ans;
    }
    
    public void pair(int ssf, int tc, boolean[] check, int[][] arr, int sum) {
    	if(ssf == tc) {
    		if(sum > ans)
    			ans = sum;
    		return;
    	}
    	for(int i = 0; i < check.length; i++) {
    		if(check[i] == false) {
    			check[i] = true;
    			pair(ssf + 1, tc, check, arr, sum + arr[ssf][i]);
    			check[i] = false;
    		}
    	}
    }
    
    public int find(int[] stu, int[] men) {
    	int ans = 0;
    	for(int i = 0; i < stu.length; i++)
    		if(stu[i] == men[i])
    			ans++;
    	return ans;
    }
}
