//You are given an array books where books[i] = [thicknessi, heighti] indicates 
//the thickness and height of the iᵗʰ book. You are also given an integer 
//shelfWidth. 
//
// We want to place these books in order onto bookcase shelves that have a 
//total width shelfWidth. 
//
// We choose some of the books to place on this shelf such that the sum of 
//their thickness is less than or equal to shelfWidth, then build another level of the 
//shelf of the bookcase so that the total height of the bookcase has increased by 
//the maximum height of the books we just put down. We repeat this process until 
//there are no more books to place. 
//
// Note that at each step of the above process, the order of the books we place 
//is the same order as the given sequence of books. 
//
// 
// For example, if we have an ordered list of 5 books, we might place the first 
//and second book onto the first shelf, the third book on the second shelf, and 
//the fourth and fifth book on the last shelf. 
// 
//
// Return the minimum possible height that the total bookshelf can be after 
//placing shelves in this manner. 
//
// 
// Example 1: 
// 
// 
//Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4
//Output: 6
//Explanation:
//The sum of the heights of the 3 shelves is 1 + 3 + 2 = 6.
//Notice that book number 2 does not have to be on the first shelf.
// 
//
// Example 2: 
//
// 
//Input: books = [[1,3],[2,4],[3,2]], shelfWidth = 6
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= books.length <= 1000 
// 1 <= thicknessi <= shelfWidth <= 1000 
// 1 <= heighti <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 225 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Id：&emsp;&emsp;1105
 * <p>
 * Name：Filling Bookcase Shelves
 *
 * @author Yuri
 * @since 2023-04-23 18:01:31
 */


public class FillingBookcaseShelves {
    public static void main(String[] args) {
        Solution solution = new FillingBookcaseShelves().new Solution();
        int i = solution.minHeightShelves(new int[][]{{7, 3}, {8, 7}, {2, 7}, {2, 5}}, 10);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minHeightShelves(int[][] books, int shelfWidth) {
            int n = books.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, 1000 * 1000); // dp表示前n本书的最小高度，题目1000本书，书最高1000，所以极端情况把dp中的值填入1000*1000
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                int max = 0, width = 0;
                for (int j = i; j >= 0; j--) {
                    width += books[j][0];
                    if (width > shelfWidth) break;
                    max = Math.max(max, books[j][1]);
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + max);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

} 
