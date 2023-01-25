class Solution {
   public int maxCoins(int[] piles) {
    int sum=0;
    Arrays.sort(piles);
    int low=0;
    int high=piles.length-1;
    while(low<high){
        high--;
        sum+=piles[high];
        high--;
        low++;
    }
    return sum;
}
}
