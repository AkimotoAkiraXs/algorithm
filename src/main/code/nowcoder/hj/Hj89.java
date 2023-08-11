package nowcoder.hj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 11:22
 */
public class Hj89 {
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (s.contains("joker") || s.contains("JOKER")) {
            System.out.println("ERROR");
            return;
        }
        List<Integer> nums = new LinkedList<>();
        String[] pokers = s.split(" ");
        for (String poker : pokers) nums.add(translate(poker));
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> temp = new LinkedList<>(nums);
            Integer num = temp.remove(i);
            dfs(num, temp, deTranslate(num));
        }
        if (!flag) System.out.println("NONE");

    }

    private static void dfs(int k, List<Integer> nums, String res) {
        if (!flag && k == 24 && nums.size() == 0) {
            System.out.println(res);
            flag = true;
        }
        for (int i = 0; i < nums.size() && !flag; i++) {
            List<Integer> temp = new LinkedList<>(nums);
            Integer num = temp.remove(i);
            dfs(k + num, new LinkedList<>(temp), res + "+" + deTranslate(num));
            dfs(k - num, new LinkedList<>(temp), res + "-" + deTranslate(num));
            dfs(k * num, new LinkedList<>(temp), res + "*" + deTranslate(num));
            dfs(k / num, new LinkedList<>(temp), res + "/" + deTranslate(num));
        }
    }

    private static int translate(String poker) {
        switch (poker) {
            case "A":
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.parseInt(poker);
        }
    }

    private static String deTranslate(int k) {
        switch (k) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 1:
                return "A";
            default:
                return String.valueOf(k);
        }
    }
}
