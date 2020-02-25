package io.kidlovec.leetcode;

import lombok.Data;

import java.util.List;

/**
 * @author kidlovec
 * @date 2020-02-05
 * @since 1.0.0
 */
public class TestTree {

    public static void main(String[] args) {



    }


}

@Data
class TreeNode {
    String id;
    String parentId;
    String name;
}



interface TreeSearch {
    List<String> getParentList(TreeNode treeNode, TreeNode root);

    TreeNode getRootNode(TreeNode treeNode, TreeNode root);
}