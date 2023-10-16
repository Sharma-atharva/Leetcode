class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> row,prev = null;
        for(int i=0; i<=rowIndex; i++){
            row = new ArrayList();
            for(int j=0; j<=i; j++){
                // Pascal's Triangle rules
                if(j==0 || j==i) row.add(1);
                else row.add(prev.get(j)+prev.get(j-1));
            }
            prev = row;
            list.add(row);
        }
        return list.get(rowIndex);
    }
}