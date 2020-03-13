package io.kidlovec.leetcode.tree;

/**
 * @author kidlovec
 * @date 2020-02-29
 * @since 1.0.0
 */
public class TestMain {

    public static void main(String[] args) {
        Integer[] data = new Integer[]{5, 1, 4, null, null, 3, 6};

//        data = new Integer[]{1, 2, 3};

        final TreeNode root = TreeNode.generate(data);
        TreeNode curr = root;

        TreeNode.printTree(curr);

        System.out.println();

    }

}
