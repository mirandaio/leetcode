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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        TreeNode node;

        if(root != null)
            stack.push(root);

        while(!stack.isEmpty()) {
            node = stack.pop();

            if(node.left == null && node.right == null) {
                traversal.add(node.val);
            } else {
                if(node.right != null)
                    stack.push(node.right);

                stack.push(node);

                if(node.left != null)
                    stack.push(node.left);

                node.left = null;
                node.right = null;
            }
        }

        return traversal;
    }
}
