package utils;

import lombok.SneakyThrows;
import model.DAGGraphviz;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Yuri
 * @since 2023/4/17 10:18
 */


public class DAGUtils {

    @SneakyThrows
    public static void main(String[] args) {
        int[][] dag = autoDAG(20, 2, 30);
        for (int[] ary : dag) {
            System.out.println(Arrays.toString(ary));
        }
        DAGGraphviz DAGGraphviz = new DAGGraphviz(dag, "C:\\Users\\Akimo\\Desktop\\dag.dot", "C:\\Users\\Akimo\\Desktop\\dag.svg");
        DAGGraphviz.auto();
        Thread.sleep(2000);
        DAGGraphviz.openFile(DAGGraphviz.getSvgFilePath());
    }

    /**
     * 自动生成dag图
     *
     * @param n      DAG节点个数
     * @param seed   随机种子，当种子和边密度因子一样时生成相同的DAG图
     * @param factor 边密度因子，越大边越稀疏
     * @return dag邻接矩阵
     */
    public static int[][] autoDAG(int n, int seed, int factor) {
        Random random = new Random(seed);
        int[][] dag = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dag[i][j] = (double) (i + 1) / (double) (j + 1 + Math.abs(factor)) > random.nextDouble() ? 1 : 0;
            }
        }
        return dag;
    }
}
