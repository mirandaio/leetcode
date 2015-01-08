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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        if(root.left == null && root.right == null)
            return true;

        if(root.left == null || root.right == null)
            return false;

        TreeNode tmp = root.left.right;
        root.left.right = root.right.right;
        root.right.right = tmp;

        return root.left.val == root.right.val && 
            isSymmetric(root.left) && isSymmetric(root.right);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        ArrayList<TreeNode> level = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
        ArrayList<TreeNode> tmp;
        int i;
        int j;

        if(root != null)
            level.add(root);

        while(level.size() != 0) {
            i = 0;
            j = level.size() - 1;

            while(i < j) {
                if((level.get(i) == null && level.get(j) != null) ||
                    (level.get(i) != null && level.get(j) == null) ||
                    (level.get(i) != null && level.get(j) != null &&
                    level.get(i).val != level.get(j).val))
                    return false;
                i++;
                j--;
            }

            for(TreeNode node : level) {
                if(node != null) {
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }

            level.clear();
            tmp = level;
            level = nextLevel;
            nextLevel = tmp;
        }

        return true;
    }
}
