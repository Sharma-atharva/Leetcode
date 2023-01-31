class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int sLen = scores.length;
        int[][] scoreAge = new int[sLen][2];
        for(int i=0; i<sLen; i++){
            scoreAge[i][0] = scores[i];
            scoreAge[i][1] = ages[i];
        }
        PlayerAgeComparator comparator = new PlayerAgeComparator();
        Arrays.sort(scoreAge, comparator);
        int max = 0;
        // reuse the existing scores array as dp array...
        Arrays.fill(scores, 0);
        for(int i=0; i<sLen; i++){
            scores[i] = scoreAge[i][0];
            // check for all previous players if their score is less or equal to current...
            for(int j=0; j<i; j++){
                if(scoreAge[i][0]>=scoreAge[j][0]){
                    scores[i] = Math.max(scores[i], scores[j]+scoreAge[i][0]);
                }
            }
            max = Math.max(max, scores[i]);
        }
        return max;
    }
}

public class PlayerAgeComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] a, int[] b) {
       // 0 -> score, 1->age
       return a[1]==b[1]?Integer.compare(a[0], b[0]):Integer.compare(a[1], b[1]);
    }

}