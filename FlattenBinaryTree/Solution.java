/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root != null) {
            if(root.right != null)
                stack.push(root.right);

            if(root.left != null) {
                root.right = root.left;
                root.left = null;
            } else if(!stack.isEmpty()) {
                root.right = stack.pop();
            }

            root = root.right;
        }
    }
}
