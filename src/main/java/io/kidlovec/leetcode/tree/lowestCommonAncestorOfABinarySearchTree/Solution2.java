package io.kidlovec.leetcode.tree.lowestCommonAncestorOfABinarySearchTree;

import io.kidlovec.leetcode.tree.TreeNode;

/**
 * 非递归的方式
 *
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
