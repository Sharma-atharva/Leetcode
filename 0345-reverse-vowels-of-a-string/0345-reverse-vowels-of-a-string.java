class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack= new Stack<>();
        
        String vowels="aeiouAEIOU";
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(vowels.contains(String.valueOf(c))) stack.push(c);
        }

        String res="";

        for(int i=0;i<s.length();i++){
            char d= s.charAt(i);
            if(vowels.contains(String.valueOf(d))){
               
                res+=stack.pop();
            }else res+=d;
        }
return res;
    }
}