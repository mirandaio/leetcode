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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> postorder = new ArrayList<Integer>();
        TreeNode node;

        if(root != null)
            stack.push(root);

        while(!stack.isEmpty()) {
            node = stack.pop();

            if(node.left == null && node.right == null) {
                postorder.add(node.val);
            } else {
                stack.push(node);
                if(node.right != null)
                    stack.push(node.right);
                if(node.left != null)
                    stack.push(node.left);

                node.left = null;
                node.right = null;
            }
        }

        return postorder;
    }
}
