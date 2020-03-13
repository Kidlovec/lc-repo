package io.kidlovec.leetcode.tree.lowestCommonAncestorOfABinarySearchTree;

import io.kidlovec.leetcode.tree.TreeNode;

/**
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class Solution1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (q.val < root.val && root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
