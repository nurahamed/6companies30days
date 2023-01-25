class Solution {
    Random random ;
    int [] wSum;
    public Solution(int[] w) {
        for(int i=1;i<w.length;i++){
            w[i]+=w[i-1];
        }
        this.random= new Random();
        this.wSum=w;
    }
    
    public int pickIndex() {
        // Time Complexity : Intializing O(n) and the for every subsequent pick O(logn)
        /* random.nextInt(wSum.length-1) will return a random no from [0,n) */
        int size = wSum.length;
        int val = random.nextInt(wSum[size-1])+1;
        int left=0;
        int right=size-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(wSum[mid]==val)
                return mid;
            else if(wSum[mid]<val)
                left=mid+1;
            else
                right=mid;
            
        }
        return left;
    }
}
