package io.kidlovec.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kidlovec
 * @date 2020-02-29
 * @since 1.0.0
 */
public class TreeNode {
    public Integer val;
    public TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }

    private final static int NODE_INTERVAL_LEN = 2;

    static TreeNode generate(Integer[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        int depth = 0;

        TreeNode root = new TreeNode(arr[0]);

        buildBinaryTree(root, arr, 1);
//        for (int i = 1; i < arr.length; i++) {
//
//            addNode(root, arr[i]);
//
//        }
        return root;
    }

    // 用数组建立普通二叉树
    public static TreeNode buildBinaryTree(TreeNode root, Integer[] arr, int index) {
        if (index > arr.length / 2)
            return root;
        if (index == 1)
            root.val = arr[0];
        if (root == null) return root;

        root.left = trans(arr[index * 2 - 1]);
        root.right = trans(arr[index * 2]);
        buildBinaryTree(root.left, arr, index + 1);
        buildBinaryTree(root.right, arr, index + 2);
        return root;
    }

    public static TreeNode trans(Integer value) {
        return value == null ? null : new TreeNode(value);
    }


    // 层序遍历打印二叉树
    public static void levelOrderPrintBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.print(" null ");
                continue;
            } else
                System.out.print(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
            System.out.println();
        }
    }


    private static void addNode(TreeNode node, Integer val) {

        if (node == null) return;

        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else {
                addNode(node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else {
                addNode(node.right, val);
            }
        }

    }

    static void print(TreeNode head) {

        System.out.println(" ");
        System.out.print(head.val);

        if (head.left != null) {
            print(head.left);
        }

        if (head.right != null) {
            print(head.right);
        }
    }


    /*
    树的结构示例：
    ^^^^^^^^^1
    ^^^^^^^/^^^^\
    ^^^^^^2^^^^^^3
    ^^^^^/^\^^^^/^\
    ^^^^4^^^5^^6^^^7
    */

    /**
     * <pre>
     *
     *
     *  树的结构示例：
     *   {7}     1
     *   {6}   /    \
     *   {5}  2      3
     *   {4} / \    / \
     *   {3}4   5  6   7
     *
     * 保持底层的 元素之间间隔为 3
     *
     * </pre>
     *
     * @param root
     * @return
     */
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    public static void printTree(TreeNode root) {

        final int maxLevel = getTreeDepth(root);

        int arrLevel = 2 * maxLevel - 1;


        String[][] treeView = new String[arrLevel][];

        int lvlCount = 0;
        for (int i = treeView.length - 1; i >= 0; i--) {
            int currLevelCnt = getCurrentLevelCnt(1 + i);
            String[] arr = new String[currLevelCnt];
            final int levelCnt = lvlCount + NODE_INTERVAL_LEN;
            for (int j = 0; j < currLevelCnt; j++) {
                arr[j] = ".";
                if (j < levelCnt)
                    arr[j] = "^";

            }
            arr[arr.length - 1] = "1";

            treeView[i] = arr;
            lvlCount++;

            for (String a : arr) {
                System.out.print(a);
            }
            System.out.println();
        }

        print(treeView);
    }

    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {" ", " ", " ", " ", " ", " ", "1"},
                {" ", " ", " ", " ", " ", "/", " ", " ", "\\"},
                {" ", " ", " ", " ", "2", " ", " ", " ", " ", "3"},
                {" ", " ", " ", "/", " ","\\", " ", " ", " ", "/", " ", "\\"},
                {" ", " ", "4", " ", " ", "5", " ", " "," ", "6", " ", " ", "7"}
        };

        print(arr);
//        sout
    }

    private static void print(String[][] treeView) {

        for (String[] a : treeView) {
            for (String b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }

    private static int getCurrentLevelCnt(int currLevel) {

        return currLevel * (NODE_INTERVAL_LEN + 1);
    }

    /**
     * 树的前序遍历
     * pre order
     *
     * <pre>
     *
     * 根 -> 左子树 -> 右子树
     *
     * </pre>
     * 递归方式
     *
     * @param root
     */
    public static void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "  ");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    /**
     * 树的前序遍历
     * pre order
     * 根 -> 左子树 -> 右子树
     * <p>
     * 非递归方式 : 用栈来存放
     *
     * <pre>
     *  树的结构示例：
     *           1
     *         /    \
     *        2      3
     *       / \    / \
     *      4   5  6   7
     *
     *
     *
     *
     *            ---------------------------
     *  push --->                           |
     *              head -->  7 6 3 5 4 2 1 |
     *  pop  <---                           |
     *            ---------------------------
     *
     *
     *            ---------------------------
     *  push 1 ->                           |
     *              head --> null           |
     *                                      |
     *            ---------------------------
     *
     *            ---------------------------
     *  push 2 ->                           |
     *              head --> 1              |
     *                                      |
     *            ---------------------------
     *
     *
     *            ---------------------------
     *  push 4 ->                           |
     *              head --> 2 1            |
     *                                      |
     *            --------------------------
     *
     *
     *            ---------------------------
     *  push 5 ->                           |
     *              head --> 4 2 1          |
     *                                      |
     *            ---------------------------
     *
     *
     *
     *
     *
     * </pre>
     *
     * @param root
     */
    public static void preOrderTraverse2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.val + "  ");
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }


    public static void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.println(root.val + " ");
            inOrderTraverse(root.right);
        }
    }

    public static void inOrderTraverse2(TreeNode root) {


    }

    public static void postOrderTraverse1(TreeNode root) {

        if (root != null){
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.println(root.val + " ");
        }
    }


//    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
//        // 保证输入的树不为空
//        if (currNode == null) return;
//        // 先将当前节点保存到二维数组中
//        res[rowIndex][columnIndex] = String.valueOf(currNode.val);
//
//        // 计算当前位于树的第几层
//        int currLevel = ((rowIndex + 1) / 2);
//        // 若到了最后一层，则返回
//        if (currLevel == treeDepth) return;
//        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
//        int gap = treeDepth - currLevel - 1;
//
//        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
//        if (currNode.left != null) {
//            res[rowIndex + 1][columnIndex - gap] = "/";
//            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
//        }
//
//        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
//        if (currNode.right != null) {
//            res[rowIndex + 1][columnIndex + gap] = "\\";
//            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
//        }
//    }
//
//
//    public static void show(TreeNode root) {
//        if (root == null) System.out.println("EMPTY!");
//        // 得到树的深度
//        int treeDepth = getTreeDepth(root);
//
//        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
//        // 作为整个二维数组的宽度
//        int arrayHeight = treeDepth * 2 - 1;
//        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
//        // 用一个字符串数组来存储每个位置应显示的元素
//        String[][] res = new String[arrayHeight][arrayWidth];
//        // 对数组进行初始化，默认为一个空格
//        for (int i = 0; i < arrayHeight; i++) {
//            for (int j = 0; j < arrayWidth; j++) {
//                res[i][j] = " ";
//            }
//        }
//
//        // 从根节点开始，递归处理整个树
//        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
//        writeArray(root, 0, arrayWidth / 2, res, treeDepth);
//
//        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
//        for (String[] line : res) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < line.length; i++) {
//                sb.append(line[i]);
//                if (line[i].length() > 1 && i <= line.length - 1) {
//                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }


}
