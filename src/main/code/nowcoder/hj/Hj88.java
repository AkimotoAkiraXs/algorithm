package nowcoder.hj;

import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 10:52
 */
public class Hj88 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strings = s.split("-");
        String[] poker1 = strings[0].split(" ");
        String[] poker2 = strings[1].split(" ");
        String[] out;
        if (s.contains("joker") && (poker1.length == 2 || poker2.length == 2)) System.out.println("joker JOKER");
        else if (poker1.length + poker2.length != 8 && (poker1.length == 4 || poker2.length == 4)) {
            if (poker1.length == 4) System.out.println(String.join(" ", poker1));
            else System.out.println(String.join(" ", poker2));
        } else if (poker1.length == poker2.length) {
            int p1 = translate(poker1[0]);
            int p2 = translate(poker2[0]);
            if (p1 > p2) System.out.println(String.join(" ", poker1));
            else if (p2 > 1) System.out.println(String.join(" ", poker2));
        } else System.out.println("ERROR");
    }

    private static int translate(String poker) {
        switch (poker) {
            case "A":
                return 14;
            case "2":
                return 15;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "joker":
                return 16;
            case "JOKER":
                return 17;
            default:
                return Integer.parseInt(poker);
        }
    }
}
