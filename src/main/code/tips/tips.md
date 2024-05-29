### 位运算
1. x&(x-1) Brian Kernighan 算法：每次会减去x二进制下最后一位1

### 有序序列
2.PriorityQueue无法通过迭代器（包括stream流）获取有序序列，只能poll取出有序序列，但TreeSet可以。