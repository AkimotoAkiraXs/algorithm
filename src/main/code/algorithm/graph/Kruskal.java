package algorithm.graph;

import problems.leetcode.editor.cn.PathWithMinimumEffort;

/**
 * 克鲁斯卡尔
 * <p>
 * 利用并查集生成最小生成树
 * <p>
 * 先对所有边进行排序，从小到大依次取出边，比较两点是否属于同一团，是则表示已联通，否则进行union，当所有点都属于同一团时则得到最小生成树
 *
 * @author Yuri
 * @see Prim 普里姆
 * @see DisjointSet 并查集
 * @see PathWithMinimumEffort Lc1631.最小体力消耗路径
 * @since 2024/5/31 16:42
 */

public class Kruskal {

}
