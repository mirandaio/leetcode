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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
            inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pstart, int pend,
        int[] inorder, int istart, int iend) {

        if(pstart > pend)
            return null;

        int rootVal = preorder[pstart];
        TreeNode root = new TreeNode(rootVal);
        int i;

        for(i = istart; i <= iend; i++) {
            if(inorder[i] == rootVal)
                break;
        }

        int leftLen = i - istart;

        root.left = buildTree(preorder, pstart + 1, pstart + leftLen,
            inorder, istart, i - 1);
        root.right = buildTree(preorder, pstart + leftLen + 1, pend,
            inorder, i + 1, iend);

        return root;
    }
}
