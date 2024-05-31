package algorithm.string;

import java.util.Arrays;

/**
 * Q：假设字符串s长度为n，字符串p长度为m（n >=  m），确定str中是否有某个子串是等于match的？
 * KMP：能以O(n+m)时间复杂度解决上述问题(D.E.Knuth、J.H.Morris、V.R.Pratt)
 *
 * @author Yuri
 * @see <a href="http://t.zoukankan.com/zhangj95-p-4486979.html">KMP，深入讲解next数组的求解</a>
 * @see <a href="https://blog.csdn.net/starstar1992/article/details/54913261?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-54913261-blog-118930611.pc_relevant_paycolumn_v3&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-54913261-blog-118930611.pc_relevant_paycolumn_v3&utm_relevant_index=1">KMP算法最浅显理解——一看就明白</a>
 * @see <a href="https://blog.csdn.net/qq_42225775/article/details/118930611">KMP算法详解</a>
 * @since 2022/6/7 15:10
 */
public class Kmp {

    public static void main(String[] args) {

        Kmp kmp = new Kmp();
        int[] next = kmp.getNext("ababaca");
        System.out.println(Arrays.toString(next));

        int kmp1 = kmp.kmp("ababaca", "ca");
        System.out.println("kmp1:" + kmp1);
    }

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

    /**
     * getNext()函数求解思路详情可见上文第一篇链接<br/>
     * 以下都以0作为起始<br/>
     * str[]:原始字符串<br/>
     * next[]:一个固定字符串各个位置的最长前缀和最长后缀相同的长度，即该方法返回结果<br/>
     * k:表示从该位置往前的k个位置与从头起k个位置一定是相同的(从0开数)<br/>
     * 接下来将以(a b a b a c a)[-1, -1, 0, 1, 2, -1, 0]作为示例讲解getNext()的具体实现:<br/>
     * 因为是从0开数，所以初始next[0]=k=-1，循环字符串从第1个字符开始到最后一个字符。
     * 从i = 2(a)开始，可以得到s[k+1] == s[i]，此时k = -1+1。当i = 3(b)时，从k = 0可得到前面已经有一个位置相同
     * 比较k=0+1和i=3的位置，如果相同则k=k+1。所以只需要不断比较s[i]和s[k+1]，如果相同则next[i]会继承next[i-1]并且+1<br/>
     * 如果s[i] != k+1，如i=5(c)，则表示next[i]并不能继承next[i-1]。
     * 此时k=2，表示在字符串ababa中有s[0~2]=s[2~4]，即有相同字符串aba。<br/>
     * k = next[k](next[k]一定小于k)表示在i=5时，∵k=2时，abab!=abac，∴缩小k值为next[k]后
     * 依旧能保证该位置往前的k个位置与从头起k个位置一定是相同的
     * (∵aba中，k=0，有一个字符相同∴s[0]=s[2]，有∵ababa中s[0~2]=s[2~4]，则有s[2]=s[4]∴s[0]=s[4]也一定成立）
     */
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
