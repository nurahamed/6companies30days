class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int blank = 12 - s.length();
        getIpList("", s, blank, 0);
        return res;
    }
    
    public void getIpList(String pre, String str, int blank, int depth){
        if(blank < 0) return;
        if(depth == 3) {
            if(str.length() > 3 || str.length() < 1 || (str.length() > 1 && str.substring(0,str.length()).startsWith("0"))) return;
            if(isPartValid(str.substring(0,str.length()))) res.add(pre + str);
            return;
        }
        if(str.length() >= 1 && isPartValid(str.substring(0,1))) {
            getIpList(pre + str.substring(0,1) + ".", str.substring(1, str.length()), blank - 2, depth + 1);
        }
        if(str.length() >= 2 && isPartValid(str.substring(0,2)) && !str.substring(0,2).startsWith("0")) {
            getIpList(pre + str.substring(0,2) + ".", str.substring(2, str.length()), blank - 1, depth + 1);
        }
        if(str.length() >= 3 && isPartValid(str.substring(0,3)) && !str.substring(0,2).startsWith("0")) {
            getIpList(pre + str.substring(0,3) + ".", str.substring(3, str.length()), blank, depth + 1);
        }
    }
    
    public boolean isPartValid(String part){
        return 0 <= Integer.valueOf(part) &&
               Integer.valueOf(part) < 256;
    }
}
