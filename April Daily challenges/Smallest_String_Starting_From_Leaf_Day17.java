//You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
//
//Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
//
//As a reminder, any shorter prefix of a string is lexicographically smaller.
//
//For example, "ab" is lexicographically smaller than "aba".
//A leaf of a node is a node that has no children.
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
public class Smallest_String_Starting_From_Leaf_Day17 {
    String smallestString="";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallestString;
    }
    public void dfs(TreeNode root, StringBuilder curString){
        if(root==null){
            return;
        }
        curString.insert(0,(char)(root.val +'a'));
        // curString = (char)(root.val +'a')+ curString;
        if(root.left==null && root.right==null){
            if(smallestString=="" || smallestString.compareTo(curString.toString())>0){
                smallestString = curString.toString();
            }
            return;
        }
        if(root.left!=null){
            dfs(root.left, curString);
            curString.deleteCharAt(0);
        }
        if(root.right!=null){
            dfs(root.right, curString);
            curString.deleteCharAt(0);
        }
        // dfs(root.left, curString);// dabc
        // dfs(root.right, curString);
    }
}
