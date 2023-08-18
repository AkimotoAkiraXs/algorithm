package template;

/**
 * @author Yuri
 * @since 2023/7/18 22:45
 */

public class SearchTemplate {
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

    /**
     * kmp 搜索模板
     */
    static class Kmp {
        private int kmp(String str, String match) {
            int[] next = getNext(match);
            int k = -1;
            for (int i = 0; i < str.length(); i++) {
                // 不匹配则回溯，不同于暴力，因为有next数组，所以不用回溯到match最开始
                while (k > -1 && match.charAt(k + 1) != str.charAt(i)) k = next[k];
                if (match.charAt(k + 1) == str.charAt(i)) k++;
                if (k == match.length() - 1) return i - match.length() + 1;// 返回相应的位置
            }
            return -1;
        }

        private int[] getNext(String match) {
            char[] s = match.toCharArray();
            int[] next = new int[s.length];
            next[0] = -1;
            int k = -1;
            for (int i = 1; i < s.length; i++) {
                while (k > -1 && s[k + 1] != s[i]) k = next[k];// 往前回溯，表示缩小k，此时位置i前k个字符与字符串开始k个字符也一定相同
                if (s[k + 1] == s[i]) k++;
                next[i] = k;// 这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
            }
            return next;
        }
    }
}
