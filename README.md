# 山巔的風景會事怎樣的呢？

经典题目：



|      核心       |                             题目                             |                           知识点                           |                             备注                             | 难度 |
| :-------------: | :----------------------------------------------------------: | :--------------------------------------------------------: | :----------------------------------------------------------: | :--: |
|      模拟       |                                                              |                                                            |                                                              |      |
|     哈希表      |                                                              |                                                            |                                                              |      |
|     位运算      | [Lc136. 只出现一次的数字](https://leetcode.cn/problems/single-number)<br />[Lc137. 只出现一次的数字 II](https://leetcode.cn/problems/single-number-ii)<br />[Lc260. 只出现一次的数字 III](https://leetcode.cn/problems/single-number-iii) |                           位运算                           |                         位运算入门题                         |  M   |
|     前缀和      | [Lc1444. 切披萨的方案数](https://leetcode.cn/problems/number-of-ways-of-cutting-a-pizza/) |                       二维前缀和+Dp                        |          需要会二维前缀和，然后用记忆化搜索\Dp遍历           | 2127 |
|      链表       | [Lc92. 反转链表 II](https://leetcode.cn/problems/reverse-linked-list-ii) |                          反转链表                          |                        链表反转入门题                        |  M   |
|                 | [Lc237. 删除链表中的节点](https://leetcode.cn/problems/delete-node-in-a-linked-list/) |                          删除链表                          |                    基础但重要，脑筋急转弯                    |  M   |
|                 | [Lc142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/) |                      链表+双指针+数学                      |            链表找环基础题，可以用数学推导证明公式            |  M   |
|                 | [Lc25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/) |                          反转链表                          |                        链表反转进阶题                        |  H   |
| 双指针/滑动窗口 | [Lc795. 区间子数组个数](https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/) |                       双指针+子数组                        |               子数组中双指针运用超级经典的题！               | 1817 |
|                 | [Lc1658. 将 x 减到 0 的最小操作数](https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/) |                      双指针+逆向思维                       |              逆向可以简化问题，正向直接做也不难              | 1817 |
|                 | [Lc1574. 删除最短的子数组使剩余数组有序](https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/) |                           双指针                           |                      比较典型的双指针题                      | 1932 |
|                 | [Lc2106. 摘水果](https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/) |                           双指针                           |                    思路不难，代码编写较难                    | 2062 |
|       DFS       |                                                              |                                                            |                                                              |      |
|       BFS       |                                                              |                                                            |                                                              |      |
|     二分法      | [Lc2528.最大化城市的最小供电站数目](https://leetcode.cn/problems/maximize-the-minimum-powered-city/) |                 前缀和+二分答案+贪心+差分                  |  非常经典、较难的题，多种算法结合起来很经典，比较考验熟练度  | 2236 |
|     单调栈      | [Lc20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/) |                         单调栈模板                         |                    比较经典的单调栈模板题                    |  E   |
|                 | [2818. 操作使得分最大](https://leetcode.cn/problems/apply-operations-to-maximize-score/) | 数论+贡献法（子数组）+单调栈+坐标排序（小技巧）+矩阵快速幂 |                      大杂烩，很锻炼基础                      | 2397 |
|    单调队列     |                                                              |                                                            |                                                              |      |
|    优先队列     | [Lc2532. 过桥的时间](https://leetcode.cn/problems/time-to-cross-a-bridge/) |                       优先队列+模拟                        |      一道较为复杂的模拟题，只要想到用**优先队列**就不难      | 2589 |
|    有序集合     | [Lc2817. 限制条件下元素之间的最小绝对差](https://leetcode.cn/problems/minimum-absolute-difference-between-elements-with-constraint/) |                 有序集合（平衡树TreeSet）                  |       需要知道有序集合有方法ceiling()和floor()可以调用       |      |
|       DP        | [Lc2826. 将三个组排序](https://leetcode.cn/problems/sorting-three-groups/) |                          状态机Dp                          |           LIS做法比较简单，但是状态机做法比较奇妙            | 1721 |
|                 | [Lc1444. 切披萨的方案数](https://leetcode.cn/problems/number-of-ways-of-cutting-a-pizza/) |    记忆化搜索+二维前缀和、Dp+二维前缀和、Dp+二维后缀和     | 记忆化搜索很简单，只需要会二维前缀和。但是推Dp思路较难。后缀和Dp优化时间方案超级精妙。 | 2127 |
|                 | [Lc.879. 盈利计划](https://leetcode.cn/problems/profitable-schemes/) |                          多维背包                          | 01背包进阶题-多维背包，其中dp数组中每个维度定义不同影响数组初始化和最后答案的求解 | 2204 |
|                 | [Lc2801. 统计范围内的步进数字数目](https://leetcode.cn/problems/count-stepping-numbers-in-range/) |                    数位DP+前缀和+模运算                    |     比较有难度，**上下界位数不一致**，可以和Lc1397做对比     | 2367 |
|                 | [Lc1397. 找到所有好字符串](https://leetcode.cn/problems/find-all-good-strings/) |                         数位DP+KMP                         | 难度达到竞赛水平，**上下界位数一致**，很考验算法理解的一道题 | 2667 |
|      数学       | [Lc2652. 倍数求和](https://leetcode.cn/problems/sum-multiples) |                          容斥原理                          | \|A ∪ B ∪ C\| = \|A\|+\|B\|+\|C\| - \|A ∩ B\| - \|B ∩ C\| - \|C ∩ A\| + \|A ∩ B ∩ C\| | 1182 |
|                 | [Lc279. 完全平方数](https://leetcode.cn/problems/perfect-squares) |                        四平方和定理                        | 每个正整数最多可表示为4个整数的平方和，当且仅当n=4^k^(8m+7)时可表示为4个整数的平方和 |  M   |
|      贪心       |                                                              |                                                            |                                                              |      |
|     博弈论      | [Lc11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/) |                       博弈论+双指针                        |                      简单而不失优雅的题                      |  M   |
|     思维题      | [Lc1726. 同积元组](https://leetcode.cn/problems/tuple-with-same-product/) |                       hash+排列组合                        |                         需要转化思维                         | 1530 |
|                 | [Lc822. 翻转卡片游戏](https://leetcode.cn/problems/card-flipping-game/) |                    题意理解+脑筋急转弯                     |           很简单的题，关键在于理解题意后动点小脑筋           | 1594 |
|                 | [Lc2731. 移动机器人](https://leetcode.cn/problems/movement-of-robots/) |                     前缀和+脑筋急转弯                      |             关键在于能否想明白机器人碰撞后的状态             | 1923 |



Lose：

- [Lc2787.将一个数字表示成幂的和的方案数](https://leetcode.cn/problems/ways-to-express-an-integer-as-sum-of-powers/)
- [Lc42. 接雨水](https://leetcode.cn/problems/trapping-rain-water/)
- [Lc2826. 将三个组排序](https://leetcode.cn/problems/sorting-three-groups/)