class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length,n2=nums2.length,m=0;
        int a[][]=new int[n][n2];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n2;j++)
            {
                if(i==0||j==0)
                {
                    if(nums1[i]==nums2[j]){
                        a[i][j]=1;
                    m=Math.max(m,a[i][j]);}
                    else
                        a[i][j]=0;
                }
                else
                {
                    if(nums1[i]==nums2[j]){
                        a[i][j]=a[i-1][j-1]+1;
                       
                    m=Math.max(m,a[i][j]);}
                    else
                        a[i][j]=0;
                }
            }
        }
        return m;
    }
}
