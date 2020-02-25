package io.kidlovec.lc.weekGame.ProductOfNumbers;

import java.util.ArrayList;
import java.util.List;

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
public class Solution2 {

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

        private List<Integer> productList;

        public ProductOfNumbers() {
            productList = new ArrayList<>();
            productList.add(1);
        }

        public void add(int num) {

            if (num == 0){
                productList.clear();
                productList.add(1);
            } else {
                productList.add(num * productList.get(productList.size() - 1));
            }
        }

        public int getProduct(int k) {

            if (productList.size() <= k) return 0;

            return productList.get(productList.size() - 1) / productList.get(productList.size() - 1 - k);
        }
    }
}

