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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1,
            postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int istart, int iend,
        int[] postorder, int pstart, int pend) {

        if(istart > iend)
            return null;

        int rootVal = postorder[pend];
        TreeNode root = new TreeNode(rootVal);
        int i;

        for(i = istart; i <= iend; i++) {
            if(inorder[i] == rootVal)
                break;
        }

        int leftLen = i - istart;

        root.left = buildTree(inorder, istart, i - 1,
            postorder, pstart, pstart + leftLen - 1);
        root.right = buildTree(inorder, i + 1, iend,
            postorder, pstart + leftLen, pend - 1);

        return root;
    }
}
