package algorithm;

import problems.leetcode.editor.cn.MakingALargeIsland;

/**
 * 并查集
 * <p>
 * 并查集是利用一种树型的数据结构，用于处理一些不交集的合并及查询问题，关键是由两个方法find()、union()
 *
 * @author Yuri
 * @see MakingALargeIsland Lc872.最大人工岛
 * @since 2024/5/24 18:28
 */


public class DisjointSet {

    int[] p, sz; // p是记录某个位置属于哪一个团，sz记录团的所代表的值，此处sz记录的是团有多少个点数

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra != rb) {
            sz[rb] += sz[ra];
            p[ra] = p[rb];
        }
    }

}
