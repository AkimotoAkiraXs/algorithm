package template;

/**
 * 二分搜索相关模板
 *
 * @author Yuri
 * @since 2023/7/18 22:45
 */

public class BinarySearchTemplate {

    public static void main(String[] args) {
        BinarySearchTemplate bst = new BinarySearchTemplate();
        System.out.println(bst.binarySearch_left_close_right_close(new int[]{9, 9, 7, 7, 6, 5, 5, 2}, 7));

    }

    /**
     * 左闭右开
     * <p>
     * 适用于求最小值
     *
     * @return 大于/大于等于key的第一个位置，当key小于最小值时返回0，大于/大于等于最大值时返回数组长度n
     */
    private int binarySearch_left_open_right_close(int[] nums, int key) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] <= key) l = mid + 1; // 去掉等号则会找大于等于，加上等号则会只找大于
            else r = mid;
        }
        return l;
    }

    /**
     * 左闭右闭
     * <p>
     * 适用于求最大值
     *
     * @return 返回大于key的最后一个数
     */
    private int binarySearch_left_close_right_close(int[] nums, int key) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] > key) l = mid + 1; // 加上等于就会返回大于等于key的最后一个数
            else r = mid - 1;
        }
        return r;
    }


}
