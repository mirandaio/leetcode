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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        TreeNode node;

        if(root != null)
            stack.push(root);

        while(!stack.isEmpty()) {
            node = stack.pop();
            traversal.add(node.val);

            if(node.right != null)
                stack.push(node.right);

            if(node.left != null)
                stack.push(node.left);
        }

        return traversal;
    }
}
