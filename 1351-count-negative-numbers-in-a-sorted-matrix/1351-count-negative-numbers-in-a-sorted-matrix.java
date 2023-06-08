class Solution {
    public int countNegatives(int[][] grid) {
        int row= grid.length-1;
        int col = grid[0].length;
        
        int i=row;
        int j=0;
        int negative = 0;
        
        while(i>=0 && j<col){
            if(grid[i][j]<0){
                negative +=(col-j);
                i--;
            }
            else{
                j++;
            }
        }
        return negative;
    }
}