class Solution {
       public int countDistinct(int[] a, int k, int p) {
        int n =a.length;
        HashSet<String> hs = new HashSet<>();
        
        for(int i=0;i<n;i++)
        {   
            String s ="";
            int count=0;
            for(int j=i;j<n;j++)
            {
               if(a[j]%p==0) count++;
             
                if(count>k) break;     
               
               s=s+a[j]+";"; 
               hs.add(s); 
            }
        }
        return hs.size();
    }
}
