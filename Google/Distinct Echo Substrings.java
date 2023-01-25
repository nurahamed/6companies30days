class Solution {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j+=2) {

                String s = text.substring(i, j + 1);
                if (isConcat(s)){
                    set.add(s);
                }     
            }
        }
        return set.size();
    }
    public boolean isConcat(String s) {
        int l = 0;
        int r = s.length() - 1;
        int mid = ((l+r)/2)+1;
        if(r%2==0) return false; 
        while (mid<=r){
            if(s.charAt(l)!=s.charAt(mid)){
                return false;
            }
            mid++;
            l++;
        }
        return true;
    }
}
