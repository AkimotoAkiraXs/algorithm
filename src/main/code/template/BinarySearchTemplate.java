package template;

/**
 * 二分搜索相关模板
 *
 * @author Yuri
 * @since 2023/7/18 22:45
 */

public class BinarySearchTemplate {
    public static void main(String[] args) {

    }

    /**
     * 二分查找：在nums中搜索大于key的第一个位置，当其为最小时返回0，大于等于最大值时返回数组长度
     * <p>
     * 返回值-1就表示<=key的第一个位置
     */
    int biSearchLeft(int[] nums, int key) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= key) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
