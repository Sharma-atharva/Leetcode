/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
                if(root==null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean level = false;
        
        while(q.size()>0){
            List<Integer> currentLevel = new ArrayList<>();
            int size = q.size();
            
        for(int i=0;i<size;i++){
            TreeNode curr = q.remove();
            currentLevel.add(curr.val);
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
        }
        if(level){
            Collections.reverse(currentLevel);
        }
        level = !level;
        result.add(currentLevel);
        }
    return result;
    }
}