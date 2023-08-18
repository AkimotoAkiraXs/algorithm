// Given a rectangular pizza represented as a rows x cols matrix containing the
// following characters: 'A' (an apple) and '.' (empty cell) and given the integer
// k. You have to cut the pizza into k pieces using k-1 cuts.
//
// For each cut you choose the direction: vertical or horizontal, then you 
// choose a cut position at the cell boundary and cut the pizza into two pieces. If you
// cut the pizza vertically, give the left part of the pizza to a person. If you
// cut the pizza horizontally, give the upper part of the pizza to a person. Give
// the last piece of pizza to the last person.
//
// Return the number of ways of cutting the pizza such that each piece contains 
// at least one apple. Since the answer can be a huge number, return this modulo 10
//^9 + 7. 
//
// 
// Example 1: 
//
// 
//
// 
// Input: pizza = ["A..","AAA","..."], k = 3
// Output: 3
// Explanation: The figure above shows the three ways to cut the pizza. Note
// that pieces must contain at least one apple.
// 
//
// Example 2: 
//
// 
// Input: pizza = ["A..","AA.","..."], k = 3
// Output: 1
// 
//
// Example 3: 
//
// 
// Input: pizza = ["A..","A..","..."], k = 1
// Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= rows, cols <= 50 
// rows == pizza.length 
// cols == pizza[i].length 
// 1 <= k <= 10 
// pizza consists of characters 'A' and '.' only. 
// 
//
// 👍 150 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1444
 * <p>
 * Name：Number of Ways of Cutting a Pizza
 *
 * @author Yuri
 * @since 2023-08-17 16:22:15
 */


public class NumberOfWaysOfCuttingAPizza {
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysOfCuttingAPizza().new Solution();

        solution.ways(new String[]{"A..", "AAA", "..."}, 0);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int ways(String[] pizza, int k) {
            int[][] matrix = matrix(pizza);
            return (int) dfs(k, 0, 0);
        }

        private long dfs(int k, int i, int j) {

            return 0L;
        }

        private int[][] matrix(String[] pizza) {
            int x = pizza.length;
            int y = pizza[0].length();
            int[][] matrix = new int[x + 1][y + 1];
            for (int i = 1; i <= x; i++)
                for (int j = 1; j <= y; j++)
                    matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j] - matrix[i - 1][j - 1]
                            + (pizza[i - 1].charAt(j - 1) == 'A' ? 1 : 0);
            return matrix;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
