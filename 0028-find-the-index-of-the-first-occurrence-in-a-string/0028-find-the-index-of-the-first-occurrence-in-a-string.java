class Solution {
    public int strStr(String haystack, String needle) {
        int res=-1;
        if(haystack.contains(needle)){
            int inx=haystack.indexOf(needle);
            res=inx;
        }
        return res;
    }
}