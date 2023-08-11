package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/3/14 10:59
 */

public class Hj66 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] strings = s.split(" ");
            String str1 = strings[0];
            String res = "";
            if (strings.length == 1 && "reset".contains(str1)) res = "reset what";
            else if (strings.length == 2) {
                int cnt = 0;
                String str2 = strings[1];
                if ("reset".indexOf(str1) == 0 && "board".indexOf(str2) == 0) {
                    cnt++;
                    res = "board fault";
                }
                if ("board".indexOf(str1) == 0 && "add".indexOf(str2) == 0) {
                    cnt++;
                    res = "where to add";
                }
                if ("board".indexOf(str1) == 0 && "delete".indexOf(str2) == 0) {
                    cnt++;
                    res = "no board at all";
                }
                if ("reboot".indexOf(str1) == 0 && "backplane".indexOf(str2) == 0) {
                    cnt++;
                    res = "impossible";
                }
                if ("backplane".indexOf(str1) == 0 && "abort".indexOf(str2) == 0) {
                    cnt++;
                    res = "install first";
                }
                if (cnt > 1) res = "";
            }
            System.out.println(res.isEmpty() ? "unknown command" : res);
        }
    }
}
