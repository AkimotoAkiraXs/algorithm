package nowcoder.hj;

import java.util.Scanner;

public class Hj83 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int rank = in.nextInt();
            int column = in.nextInt();
            System.out.println(rank > 9 || column > 9 ? -1 : 0);
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            System.out.println(x1 >= rank || x2 >= rank || y1 >= column || y2 >= column ? -1 : 0);
            int r = in.nextInt();
            System.out.println(rank > 8 || r >= rank ? -1 : 0);
            int c = in.nextInt();
            System.out.println(column > 8 || c >= column ? -1 : 0);
            int x3 = in.nextInt();
            int y3 = in.nextInt();
            System.out.println(x3 >= rank || y3 >= column ? -1 : 0);
        }
    }
}
