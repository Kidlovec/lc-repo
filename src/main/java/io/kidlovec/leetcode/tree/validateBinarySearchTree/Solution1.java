package io.kidlovec.leetcode.tree.validateBinarySearchTree;

import io.kidlovec.leetcode.tree.TreeNode;

/**
 * No.98
 * <p>
 * 方法一
 * 中序遍历 in-order 是升序
 * <p>
 *
 *
 * 方法二
 * 递归
 * <p>
 *
 * Related topics
 *      94.Binary Tree Inorder Traversal
 *      104.Maximum Depth of Binary Tree
 *      110.Balanced Binary Tree
 *      111.Minimum Depth of Binary Tree
 *      112.Path Sum
 *      113. Path Sum II
 *      129.Sum Root to Leaf Numbers
 *      144.Binary Tree Preorder Traversal
 *      145.Binary Tree Postorder Traversal
 *      230.Kth Smallest Element in a BST
 *      687.Longest Univalue Path
 *      965.Univalued Binary
 *
 *
 *
 * @author kidlovec
 * @date 2020-02-29
 * @since 1.0.0
 */
public class Solution1 {
    private int last = -Integer.MAX_VALUE;

    public boolean isValidBST(TreeNode root){

        // 如果树为空 则是 二叉排序树
        if (root == null) {
            return true;
        }

        if (isValidBST(root.left)){
            if (last < root.val){
                last = root.val;
                return isValidBST(root.right);
            }
        }

        return false;
    }
}
