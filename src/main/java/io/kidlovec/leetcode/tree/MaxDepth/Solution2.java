package io.kidlovec.leetcode.tree.MaxDepth;

import io.kidlovec.leetcode.tree.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author kidlovec
 * @date 2020-01-20
 */
public class Solution2 {

    /**
     * 递归: 广度优先遍历
     *
     * <ul>
     * 时间复杂度：O(N)。
     * 空间复杂度：O(N)。
     * </ul>
     *
     *
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int currentDepth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, currentDepth);
                stack.add(new Pair<>(root.left, currentDepth + 1));
                stack.add(new Pair<>(root.right, currentDepth + 1));
            }
        }
        return depth;

    }

    public static void main(String[] args) {

    }
}

