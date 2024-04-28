//The hash of a 0-indexed string s of length k, given integers p and m, is 
//computed using the following function: 
//
// 
// hash(s, p, m) = (val(s[0]) * p⁰ + val(s[1]) * p¹ + ... + val(s[k-1]) * pᵏ⁻¹) 
//mod m. 
// 
//
// Where val(s[i]) represents the index of s[i] in the alphabet from val('a') = 
//1 to val('z') = 26. 
//
// You are given a string s and the integers power, modulo, k, and hashValue. 
//Return sub, the first substring of s of length k such that hash(sub, power, 
//modulo) == hashValue. 
//
// The test cases will be generated such that an answer always exists. 
//
// A substring is a contiguous non-empty sequence of characters within a string.
// 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", power = 7, modulo = 20, k = 2, hashValue = 0
//Output: "ee"
//Explanation: The hash of "ee" can be computed to be hash("ee", 7, 20) = (5 * 1
// + 5 * 7) mod 20 = 40 mod 20 = 0. 
//"ee" is the first substring of length 2 with hashValue 0. Hence, we return 
//"ee".
// 
//
// Example 2: 
//
// 
//Input: s = "fbxzaad", power = 31, modulo = 100, k = 3, hashValue = 32
//Output: "fbx"
//Explanation: The hash of "fbx" can be computed to be hash("fbx", 31, 100) = (6
// * 1 + 2 * 31 + 24 * 31²) mod 100 = 23132 mod 100 = 32. 
//The hash of "bxz" can be computed to be hash("bxz", 31, 100) = (2 * 1 + 24 * 3
//1 + 26 * 31²) mod 100 = 25732 mod 100 = 32. 
//"fbx" is the first substring of length 3 with hashValue 32. Hence, we return 
//"fbx".
//Note that "bxz" also has a hash of 32 but it appears later than "fbx".
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= s.length <= 2 * 10⁴ 
// 1 <= power, modulo <= 10⁹ 
// 0 <= hashValue < modulo 
// s consists of lowercase English letters only. 
// The test cases are generated such that an answer always exists. 
// 
//
// 👍 52 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2156
 * <p>
 * Name：Find Substring With Given Hash Value
 *
 * @author Yuri
 * @since 2024-04-26 15:07:19
 */

public class FindSubstringWithGivenHashValue {
    public static void main(String[] args) {
        Solution solution = new FindSubstringWithGivenHashValue().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 滑动窗口+秦九韶算法
     * <p>
     * 秦九韶用于快速求解多项式，从后往前开始滑窗，每次计算就是相当于向左新增一项a0*p^0，其余每项*p。
     * 当窗口到达长度k，也就是则需减去最右边的ak*p^k。
     */
    class Solution {
        public String subStrHash(String s, int power, int mod, int k, int hashValue) {
            int n = s.length();
            long hash = 0, p = 1;
            String ans = null;
            int r = n - 1;
            for (int l = n - 1; l >= 0; l--) {
                hash = (hash * power + (s.charAt(l) & 31)) % mod;
                if (r - l >= k) hash = (hash - p * (s.charAt(r--) & 31) % mod + mod) % mod;
                else p = p * power % mod;
                if (r - l + 1 == k && hash == hashValue) ans = s.substring(l, r + 1);
            }
            return ans;
        }
    }

    /**
     * 滑动窗口+快速幂+记忆化搜索
     * <p>
     * 暴力滑窗，用快速幂计算hash公式，并且每次计算的num*p%mod记录下来，勉强擦边过
     */
    class Solution_1 {
        private long[] ps;

        public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
            ps = new long[k];
            int l = 0;
            for (int r = k; r <= s.length(); r++, l++) {
                if (calHash(s.substring(l, r), power, modulo) == hashValue) return s.substring(l, r);
            }
            return "";
        }

        private int calHash(String sub, int power, int module) {
            long sum = 0;
            for (int i = 0; i < sub.length(); i++) {
                sum = (sum + val(sub.charAt(i)) * mfp(power, i, module) % module) % module;
            }
            return (int) sum;
        }

        private int val(Character c) {
            return c - 'a' + 1;
        }

        private long mfp(int num, int p, int mod) {
            if (ps[p] != 0) return ps[p];
            if (p == 0) return 1;
            long mfp = mfp(num, p / 2, mod);
            if ((p & 1) == 1) mfp = (mfp * mfp % mod * num) % mod;
            else mfp = (mfp * mfp) % mod;
            ps[p] = mfp;
            return mfp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}