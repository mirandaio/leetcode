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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> traversal = new LinkedList<List<Integer>>();
        Queue<TreeNode> level = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> temp;

        if(root != null)
            level.add(root);

        while(!level.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            traversal.add(0, list);

            while(!level.isEmpty()) {
                TreeNode node = level.remove();
                list.add(node.val);
                if(node.left != null)
                    nextLevel.add(node.left);

                if(node.right != null)
                    nextLevel.add(node.right);
            }

            temp = level;
            level = nextLevel;
            nextLevel = temp;
        }

        return traversal;
    }
}
