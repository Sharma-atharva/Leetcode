class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k==0) return new ArrayList<Integer>(Arrays.asList(target.val));
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        parent.put(root,null);
        Queue<TreeNode>  q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
              TreeNode node=q.poll();
              
              if(node.left!=null)
              {
                 parent.put(node.left,node);
                 q.add(node.left);
              }
              if(node.right!=null)
              {
                 parent.put(node.right,node);
                 q.add(node.right);
              }
        }
        HashSet<TreeNode> visited=new HashSet<>();
        visited.add(target);
        q.add(target);
        int count=0;
        while(!q.isEmpty())
        {
             int n=q.size();
             for(int i=0;i<n;i++)
             {
                 TreeNode node=q.poll();
                 if(node.left!=null && !visited.contains(node.left))
                 {
                     visited.add(node.left);
                     q.add(node.left);
                 }
                 if(node.right!=null && !visited.contains(node.right))
                 {
                     visited.add(node.right);
                     q.add(node.right);
                 }
                 if( !visited.contains(parent.get(node)))
                 {   if(parent.get(node)!=null){
                     visited.add(parent.get(node));
                     q.add(parent.get(node));}
                 }
             }

            count++;
            if(count==k) break;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            ans.add(node.val);
        }
        return ans;
        
    }
}