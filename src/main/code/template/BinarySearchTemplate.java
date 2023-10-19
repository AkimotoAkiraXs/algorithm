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
        System.out.println(bst.binarySearch(new int[]{1, 2, 3, 4, 4, 4, 5, 5, 5, 6, 8, 9, 9, 9, 9}, 7));

    }

    /**
     * 二分查找：只需要记一个模板就可以了，该模板为左闭右开
     * <p>
     * 对于求小于key的位置，大于key的最后一个位置等问题都可以通过等价转换得到。
     *
     * @return 大于/大于等于key的第一个位置，当key小于最小值时返回0，大于/大于等于最大值时返回数组长度n
     */
    private int binarySearch(int[] nums, int key) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= key) l = mid + 1; // 去掉等号则会找大于等于，加上等号则会只找大于
            else r = mid;
        }
        return l;
    }


}
