###1. 两数之和

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

通过次数854,102 | 提交次数1,791,557

---

只有一组答案，那么查到就结束了

方法：

1. [暴力双层循环 O(n^2)](../../src/main/java/io/kidlovec/leetcode/twoSum/Solution1.java)
2. [map O(n)](../../src/main/java/io/kidlovec/leetcode/twoSum/Solution2.java)


### map

放 key=数组元素， value=

 一次循环 遍历数组
 如果 set 中存在 key为 target - num[i] 的项目，
 则判断 set.get(target - num[i]) != i (因为"你不能重复利用这个数组中同样的元素"， 所以这里要避免 数组中存在两个一样的值)
 true 则 返回 key , set.get(target - num[i])
