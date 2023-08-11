// You are given a 0-indexed array nums comprising of n non-negative integers.
//
// In one operation, you must: 
//
// 
// Choose an integer i such that 1 <= i < n and nums[i] > 0. 
// Decrease nums[i] by 1. 
// Increase nums[i - 1] by 1. 
// 
//
// Return the minimum possible value of the maximum integer of nums after 
// performing any number of operations.
//
// 
// Example 1: 
//
// 
// Input: nums = [3,7,1,6]
// Output: 5
// Explanation:
// One set of optimal operations is as follows:
// 1. Choose i = 1, and nums becomes [4,6,1,6].
// 2. Choose i = 3, and nums becomes [4,6,2,5].
// 3. Choose i = 1, and nums becomes [5,5,2,5].
// The maximum integer of nums is 5. It can be shown that the maximum number
// cannot be less than 5.
// Therefore, we return 5.
// 
//
// Example 2: 
//
// 
// Input: nums = [10,1]
// Output: 10
// Explanation:
// It is optimal to leave nums as is, and since 10 is the maximum value, we
// return 10.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 2 <= n <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// 👍 50 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2439
 * <p>
 * Name：Minimize Maximum of Array
 *
 * @author Yuri
 * @since 2023-07-21 16:11:21
 */


public class MinimizeMaximumOfArray {
    public static void main(String[] args) {
        Solution solution = new MinimizeMaximumOfArray().new Solution();
        // System.out.println(Integer.MAX_VALUE);
        int i = solution.minimizeArrayValue(new int[]{169699253, 631654875, 242010974, 75546839, 197853196, 984045994, 692675612, 560165936, 970337806, 746705572, 850408627, 300549075, 6901286, 909500065, 818103314, 79792287, 284895596, 778358378, 70144012, 94869775, 826116611, 282447287, 721122159, 280959437, 260814037, 884562542, 32923701, 223219291, 292863354, 829595238, 59192134, 415411184, 105998039, 306512126, 797376359, 908074936, 915654951, 52740457, 229748266, 200471638, 308384125, 970357179, 321246952, 912309540, 628335005, 308539474, 452481686, 695166872, 316813825, 879483069, 797082880, 888425110, 572758651, 205903420, 699584310, 282203007, 824701253, 772905222, 724564649, 106720512, 131175164, 483570573, 200836642, 186156465, 243559387, 428594417, 803767266, 137882842, 486705334, 472856129, 166137320, 299734077, 287076692, 874961440, 140296219, 378641037, 847294518, 677756580, 116151366, 52211836, 221935534, 911439017, 116556836, 467468185, 101088873, 228953104, 812728994, 399389748, 483333141, 520078751, 751031349, 733898838, 875135070, 814942571, 521776370, 731622765, 338363848, 923949359, 637921102, 794910277, 641345758, 314120452, 996952828, 333610996, 639629767, 167703245, 270388039, 398923688, 754948018, 211977527, 958402910, 133878383, 236577158, 728819129, 572742464, 588897059, 686746234, 463358232, 780687680, 638297024, 250112252, 495502217, 819216582, 400362548, 733629108, 859581977, 354752575, 609882615, 846876122, 321851741, 378299372, 191132219, 857400130, 857416395, 881319049, 858424463, 377651157, 171508704, 4594516, 796019029, 269820549, 924329512, 82277640, 592068705, 987626800, 261549278, 832594115, 89452086, 624658712, 683473134, 398881408, 57257596, 925898460, 627373238, 181302730, 502626656, 763858194, 629723336, 958915893, 455691955, 4170122, 897262347, 285741932, 787608357, 612617231, 136519306, 166334841, 731269397, 123809507, 734353990, 154376227, 896833695, 803086233, 48108382, 137962967, 681829204, 586695713, 877028446});

        System.out.println(i);

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] nums;
        public int minimizeArrayValue(int[] nums) {
            this.nums = nums;
            int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
            for (int num : nums) {
                l = Math.min(l, num);
                r = Math.max(r, num);
            }
            while (l < r) {
                int mid = (l + r) / 2;
                if (check(mid)) r = mid;
                else l = mid + 1;
            }
            return r;
        }

        boolean check(int min) {
            long have = 0;
            for (int num : nums) {
                if (min - num >= 0) have += min - num;
                else if (num - min > have) return false;
                else have += min - num;
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
