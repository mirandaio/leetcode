# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def inorderTraversal(self, root):
        traversal = []
        stack = []

        while root != None or len(stack) != 0:
            if root == None:
                root = stack.pop()
                traversal.append(root.val)
                root = root.right
            else:
                stack.append(root)
                root = root.left

        return traversal
