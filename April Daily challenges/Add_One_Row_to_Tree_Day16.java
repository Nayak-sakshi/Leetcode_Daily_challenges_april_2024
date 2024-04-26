
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
public class Add_One_Row_to_Tree_Day16 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode newRoot = null;
        if(depth==1){
            newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        newRoot = dfs(root,1,depth,val);
        return newRoot;
    }
    public TreeNode dfs(TreeNode root, int curDepth, int depth, int val){
        // base case
        if(root== null){
            return root;
        }
        // find inserton point
        if(curDepth ==depth-1){
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = root.left;
            root.left = newLeft;
            TreeNode newRight = new TreeNode(val);
            newRight.right = root.right;
            root.right = newRight;
            return root;
        }
        dfs(root.left,curDepth+1,depth,val);
        dfs(root.right,curDepth+1,depth,val);
        return root;
    }
}
