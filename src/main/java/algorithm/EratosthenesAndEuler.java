package algorithm;

/**
 * Q：快速获取n类素数 <br/>
 * 埃氏筛选法 <br/>
 * 欧拉筛选（线性筛）<br/>
 * 注意：大数素数获取不要用埃氏筛、欧拉筛（内存溢出），特别是数范围可以不断减小的情况
 *
 * @author Yuri
 * @since 2022/6/28 9:28
 */
public class EratosthenesAndEuler {


    public static void main(String[] args) {

        EratosthenesAndEuler eratosthenesAndEuler = new EratosthenesAndEuler();
        eratosthenesAndEuler.eratosthenes();
        int sum = 0;
        for (int i = 0; i < MAX_N; i++) {
            if (!vis[i]) {
                System.out.print(i + " ");
                sum++;
            }
        }
        System.out.println("\nthe sum is: " + sum);
    }


    /**
     * 埃氏筛选法 O(nloglogn)
     *
     * @see <a href="https://zh.m.wikipedia.org/zh/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95">理论：wiki-埃拉托斯特尼筛法</a>
     * @see <a href="https://blog.csdn.net/o83290102o5/article/details/79491834">证明：埃拉托斯特尼筛法详解</a>
     */
    static int MAX_N = 100000;
    static boolean[] vis = new boolean[MAX_N];

    private void eratosthenes() {
        vis[0] = vis[1] = true;
        // 如果到了他的根号，还没有一个因子出现，那么后半部分也不会有因子出现了
        int sqrt = (int) Math.sqrt(MAX_N);
        for (int i = 2; i <= sqrt; i++) { //只需计算到sqrt(n)
            if (vis[i]) continue; //合数直接跳
            for (int j = i; i * j < MAX_N; j++) {
                vis[i * j] = true; //标记为合数
            }
        }
    }

    /**
     * 欧拉筛（埃氏筛的改进）
     *
     * @see <a href="https://blog.csdn.net/qq_43822715/article/details/105196474">埃式筛和欧拉筛讲解</a>
     */
    static int[] p = new int[MAX_N];

    public void euler() {
        vis[0] = vis[1] = true;
        int tot = 0;
        for (int i = 2; i <= MAX_N; ++i) {
            if (!vis[i]) {
                p[++tot] = i; //记录素数
            }
            for (int j = 1; j <= tot && i * p[j] <= MAX_N; ++j) {
                vis[i * p[j]] = true; //合数都可以以唯一形式被写成质数的乘积
                //如果i % p[j] == 0(假设i/p[j]=k)，则i = p[j]*k，∴i*p[j+1] = p[j]*k*p[j+1]，而k*p[j+1]这会被跟后续更大的i所代替
                //例如：i=12，12%2=0，k=6，如果不break继续循环，i*p[j] = 12*3 = 2*6*3 = 18*2，这会有重复，因为36会在后续循环i = 18中被计算
                if (i % p[j] == 0) {
                    break;
                }
            }
        }
    }
}
