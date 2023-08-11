package nowcoder.hj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 14:36
 */
public class Hj92 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();
            List<String> res = new LinkedList<>();
            for (Character c : s.toCharArray()) {
                if (Character.isDigit(c)) sb.append(c);
                else if (sb.length()>0) {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            res.add(sb.toString());
            res.sort((o1, o2) -> o2.length() - o1.length());
            int max = 0;
            for (String str : res) {
                if (max > str.length()) break;
                max = str.length();
                System.out.printf("%s", str);
            }
            System.out.println("," + max);
        }
    }
}
