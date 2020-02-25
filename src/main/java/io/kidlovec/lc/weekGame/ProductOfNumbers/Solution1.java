package io.kidlovec.lc.weekGame.ProductOfNumbers;

/**
 *
 * 1352. 最后 K 个数的乘积
 *
 * https://leetcode-cn.com/problems/product-of-the-last-k-numbers/
 *
 * @author kidlovec
 * @date 2020-02-23
 * @since 1.0.0
 */
public class Solution1 {

    public static void main(String[] args) {

        ProductOfNumbers s = new ProductOfNumbers();

        String[] str = new String[]{"ProductOfNumbers", "add", "add", "add", "add", "add", "getProduct", "getProduct",
                "getProduct",
                "add",
                "getProduct"};
    }

//int[int[]] = new int[[],[[3],[0],[2],[5],[4],[2],[3],[4],[8],[2];
//
//    }

    static class ProductOfNumbers {

        private Node tail=null;

        private class Node{
            public Node pred=null;
            public Node next=null;
            int value;

            public Node(int value) {
                this.value = value;
            }
        }

        public ProductOfNumbers() {

        }

        public void add(int num) {

            if (tail == null){
                tail = new Node(num);
            } else {
                Node oriTail = tail;
                tail = new Node(num);
                tail.pred = oriTail;
                oriTail.next = tail;
            }
        }

        public int getProduct(int k) {

            if (k < 0) return 0;

            int counter = 0;
            Node preNode = tail;
            int result = 1;
            while (counter < k && preNode != null){

                result *= preNode.value;

                counter++;
                preNode = preNode.pred;
            }

            return result;
        }
    }
}


