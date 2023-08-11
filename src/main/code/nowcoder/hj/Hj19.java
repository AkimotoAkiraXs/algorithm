package nowcoder.hj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author Yuri
 * @since 2023/2/20 15:41
 */

public class Hj19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        Vector<String> vector = new Vector<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] lines = line.split("\\\\");
            String last = lines[lines.length - 1];
            String[] stings = last.split(" ");
            if (stings[0].length() > 16) {
                last = stings[0].substring(stings[0].length() - 16) + " " + stings[1];
            }
            if (map.containsKey(last)) {
                map.put(last, map.get(last) + 1);
            } else {
                map.put(last, 1);
                if (vector.size() == 8) vector.remove(0);
                vector.add(last);
            }
        }
        for (String s : vector) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
