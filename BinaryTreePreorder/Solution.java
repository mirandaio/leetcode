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
        Stack<TreeNode> list = new Stack<TreeNode>();
        ArrayList<Integer> traversal = new ArrayList<Integer>();
        TreeNode node;

        if(root != null)
            list.push(root);

        while(!list.isEmpty()) {
            node = list.pop();
            traversal.add(node.val);

            if(node.right != null)
                list.push(node.right);

            if(node.left != null)
                list.push(node.left);
        }

        return traversal;
    }
}
