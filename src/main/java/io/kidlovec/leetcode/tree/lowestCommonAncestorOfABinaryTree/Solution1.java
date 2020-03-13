package io.kidlovec.leetcode.tree.lowestCommonAncestorOfABinaryTree;

import io.kidlovec.leetcode.tree.TreeNode;

/**
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class Solution1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q){
            return root;
        }

        final TreeNode left = lowestCommonAncestor(root.left, p, q);
        final TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null ? right: right == null ? left : root;
    }
}
