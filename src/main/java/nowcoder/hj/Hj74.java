package nowcoder.hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/28 22:54
 */

public class Hj74 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<String> res = new ArrayList<>();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ' && !flag) {
                res.add(sb.toString());
                sb = new StringBuilder();
            } else if (c == '\"') flag = !flag;
            else sb.append(c);
        }
        res.add(sb.toString());
        System.out.println(res.size());
        for (String str : res) System.out.println(str);

    }
}
