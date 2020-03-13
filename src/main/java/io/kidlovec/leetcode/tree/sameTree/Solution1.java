package io.kidlovec.leetcode.tree.sameTree;

import io.kidlovec.leetcode.tree.TreeNode;

/**
 * @author kidlovec
 * @date 2020-03-02
 * @since 1.0.0
 */
public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && p == q)
            return true;
        // one of p and q is null
        if (q == null || p == null) return false;

        return isSameTree(p.left, q.left) && p.val == q.val && isSameTree(p.right, q.right);
    }
}
