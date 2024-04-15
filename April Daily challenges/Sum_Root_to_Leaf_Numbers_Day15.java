//You are given the root of a binary tree containing digits from 0 to 9 only.
//
//Each root-to-leaf path in the tree represents a number.
//
//For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
//
//A leaf node is a node with no children.

public class Sum_Root_to_Leaf_Numbers_Day15 {
    int sum =0;
    public int sumNumbers(TreeNode root) {
        getPathSum(root, 0);
        return sum;
    }
    public void getPathSum(TreeNode root, int curNum){
        if(root==null){
            return;
        }
        // current Node
        // form the num
        curNum = curNum*10 + root.val;
        if(root.left==null && root.right==null){
            sum+=curNum;
            return;
        }
        // left call
        getPathSum(root.left, curNum);
        // right
        getPathSum(root.right, curNum);

    }
}
