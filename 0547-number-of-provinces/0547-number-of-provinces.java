class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            //make adj matrix to adj list
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 & i!=j){
                    list.get(i).add(j);                    
                    list.get(j).add(i);

                }
            }
        }
        
        int vis[] = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                count++;
                dfs(i,list,vis);
            }
        }
        return count;
        
    }
    public void dfs(int i,ArrayList<ArrayList<Integer>>list,int vis[]){
        vis[i]=1;
        for(int it:list.get(i)){
            if(vis[it]==0){
                dfs(it,list,vis);
            }
        }
    }
}