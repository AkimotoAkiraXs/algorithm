// You have n tasks and m workers. Each task has a strength requirement stored
// in a 0-indexed integer array tasks, with the iᵗʰ task requiring tasks[i] strength
// to complete. The strength of each worker is stored in a 0-indexed integer array
// workers, with the jᵗʰ worker having workers[j] strength. Each worker can only
// be assigned to a single task and must have a strength greater than or equal to
// the task's strength requirement (i.e., workers[j] >= tasks[i]).
//
// Additionally, you have pills magical pills that will increase a worker's 
// strength by strength. You can decide which workers receive the magical pills,
// however, you may only give each worker at most one magical pill.
//
// Given the 0-indexed integer arrays tasks and workers and the integers pills 
// and strength, return the maximum number of tasks that can be completed.
//
// 
// Example 1: 
//
// 
// Input: tasks = [3,2,1], workers = [0,3,3], pills = 1, strength = 1
// Output: 3
// Explanation:
// We can assign the magical pill and tasks as follows:
//- Give the magical pill to worker 0.
//- Assign worker 0 to task 2 (0 + 1 >= 1)
//- Assign worker 1 to task 1 (3 >= 2)
//- Assign worker 2 to task 0 (3 >= 3)
// 
//
// Example 2: 
//
// 
// Input: tasks = [5,4], workers = [0,0,0], pills = 1, strength = 5
// Output: 1
// Explanation:
// We can assign the magical pill and tasks as follows:
//- Give the magical pill to worker 0.
//- Assign worker 0 to task 0 (0 + 5 >= 5)
// 
//
// Example 3: 
//
// 
// Input: tasks = [10,15,30], workers = [0,10,10,10,10], pills = 3, strength = 10
//
// Output: 2
// Explanation:
// We can assign the magical pills and tasks as follows:
//- Give the magical pill to worker 0 and worker 1.
//- Assign worker 0 to task 0 (0 + 10 >= 10)
//- Assign worker 1 to task 1 (10 + 10 >= 15)
// The last pill is not given because it will not make any worker strong enough
// for the last task.
// 
//
// 
// Constraints: 
//
// 
// n == tasks.length 
// m == workers.length 
// 1 <= n, m <= 5 * 10⁴ 
// 0 <= pills <= m 
// 0 <= tasks[i], workers[j], strength <= 10⁹ 
// 
//
// 👍 105 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * Id：&emsp;&emsp;2071
 * <p>
 * Name：Maximum Number of Tasks You Can Assign
 *
 * @author Yuri
 * @since 2024-09-04 11:01:25
 */

public class MaximumNumberOfTasksYouCanAssign {

    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfTasksYouCanAssign().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 排序+二分+贪心：二分答案k，则选择k个最强的工人去完成k个最简单的任务，判断是否能完成。
         * 从k个中最难任务开始，用最强的工人去完成，能独立完成则直接完成，需要用药丸则在工人中找一个最弱的但用药丸能完成该任务的工人进行完成，
         * 此处用一个单调队列来维护，单调队列里依次存入吃药丸可以完成工作的工人，由于工作由强到弱，所以上一个入队的工人吃药也一定能完成下一个工作。
         */
        public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
            Arrays.sort(tasks);
            Arrays.sort(workers);
            int n = workers.length;
            int l = 0, r = tasks.length;
            while (l <= r) {
                int mid = l + r >> 1;
                Deque<Integer> deque = new ArrayDeque<>();
                int i = mid - 1, j = n - 1, p = pills;
                for (; i >= 0 && n >= mid; i--) {
                    if (!deque.isEmpty() && tasks[i] <= deque.peekFirst()) deque.pollFirst(); // 判断队列首位（当前最强）是否能完成
                    else if (j >= n - mid && tasks[i] <= workers[j]) j--; // 队列中可能没有工人，则判断下一个工人
                    else {
                        // 没人可以直接完成，判断吃药哪些工人能完成
                        while (j >= n - mid && tasks[i] <= workers[j] + strength) deque.add(workers[j--]);
                        // 队列如果不为空，则末尾就是吃药能完成工作的工人中最弱的那个，用他吃药来完成
                        if (!deque.isEmpty() && p > 0) {
                            deque.pollLast();
                            p--;
                        } else break; // 如果队列为空或者没有药了，则说明该工作无论如何都无法完成
                    }
                }
                if (i < 0) l = mid + 1;
                else r = mid - 1;
            }
            return r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}