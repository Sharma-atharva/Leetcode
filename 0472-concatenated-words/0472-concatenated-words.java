class Solution {
    Set<String> set = new HashSet<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> answer = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(String word : words){
            if(word.length() != 0) set.add(word);
            min = Math.min(min, word.length());
        }
        
        for(String word : words){
            if(concat(word, 0, word.length(), min)) answer.add(word);
        }
        return answer;
    }
    
    private boolean concat(String word, int start, int end, int min){
        for(int i = start+min; i <= end-min; i++){
            if(set.contains(word.substring(start, i)) && (set.contains(word.substring(i,end)) || concat(word, i, end, min))){
                return true;
            }
        }
        return false;
    }
}