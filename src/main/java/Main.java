import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuri
 * @since 2021/12/15 11:06
 */
public class Main {
    public static void main(String[] args) {
        String[] strs = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<Integer, String> map = new HashMap<>();
        int N = 26;

        int[][] cnts = new int[N][2];

        for (int i = 0; i < N; i++) cnts[i][0] = i + 'a';
        for (String str : strs) {
            boolean[] b = new boolean[N];
            for (char c : str.toCharArray()) {
                int k = c - 'a';
                if (!b[k]) {
                    b[k] = true;
                    cnts[k][1]++;
                }
            }
        }
        Arrays.sort(cnts, (a, b) -> {
            if (a[1] == 0 && b[1] != 0) return 1;
            if (a[1] != 0 && b[1] == 0) return -1;
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        System.out.println(Arrays.deepToString(cnts));
    }
}
