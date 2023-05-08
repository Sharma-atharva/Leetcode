class Solution {
    public int diagonalSum(int[][] mat) {
        int output = 0;
        int j = mat.length;

        for ( int i = 0; i < mat.length; i++) {
            output += mat[i][i];
            output += mat[i][j-1-i];
        }

        output -= (j % 2 !=0)? mat[j/2][j/2] : 0;


        return output;
    }
}