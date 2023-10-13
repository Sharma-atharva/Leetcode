class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        char ans = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            set.add(s.charAt(i-1));
            if(set.contains(s.charAt(i))){
                ans = s.charAt(i);
                break;
            }  
        }
        return ans;
    }
}