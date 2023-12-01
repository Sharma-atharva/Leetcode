class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
         StringBuilder sb1 = new StringBuilder();
         StringBuilder sb2 = new StringBuilder();
         for(String i : word1){
             sb1.append(i);
         }
         for(String i : word2){
             sb2.append(i);
         }
            String s1 = sb1.toString();
            String s2 = sb2.toString();

            return s1.equals(s2); 
    }  
}