
请你实现一个「数字乘积类」`ProductOfNumbers`，要求支持下述两种方法：


1. `add(int num)`
    - 将数字 num 添加到当前数字列表的最后面。

2. `getProduct(int k)`

    - 返回当前数字列表中，最后 k 个数字的乘积。
    - 你可以假设当前列表中始终 至少 包含 k 个数字。

题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。

 

示例：

```
输入：
["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

输出：
[null,null,null,null,null,null,20,40,0,null,32]

解释：
ProductOfNumbers productOfNumbers = new ProductOfNumbers();
productOfNumbers.add(3);        // [3]
productOfNumbers.add(0);        // [3,0]
productOfNumbers.add(2);        // [3,0,2]
productOfNumbers.add(5);        // [3,0,2,5]
productOfNumbers.add(4);        // [3,0,2,5,4]
productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
productOfNumbers.add(8);        // [3,0,2,5,4,8]
productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
```


提示：

- add 和 getProduct 两种操作加起来总共不会超过 40000 次。
- 0 <= num <= 100
- 1 <= k <= 40000

通过次数2,183 | 提交次数5,381

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/product-of-the-last-k-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

---


1. 自测类思路
根据传入的参数，用反射 调用 `ProductOfNumbers` 所对应的成员方法。

### 解题思路：可以无限添加的队列，且获取最后K 个数

1. 可以使用 `双向链表`。

    - add(): 每次在链表尾部添加
    - getProduct(): 获取时也是从链表尾添加

    时间复杂度：

    - add O(1)
    - get O(K)


2. `前缀积`


    - add(): 每次
    - getProduct(): 获取时也是从链表尾添加

    时间复杂度：

    - add O(1)
    - get O(K)

> 前缀积，假设存在一个数组A[]，它的第i个数=A[0]*A[1]..A[i]
 因为每次添加0之后， getProduct 会都变成 0,所以添加 0 之后，数组清空。
如果 数组目前有n个数,添加了一个新的数 N，那么 A[n+1] = N * A[n]
这时，如果调用 `getProduct(k)` 则返回 `A[k] / A[A.length -1 - k]`

如 添加 3，2，4，5
```
A[0] = 3
A[1] = 3 * 2
A[2] = 3 * 2 * 4
A[3] = 3 * 2 * 4 * 5
getProduct(2) = 4 * 5 =  A[3] / A[1] = A[3] / A[4 - 1 - 2]

```