package tips;

import java.util.*;

/**
 * 创建有序容器
 *
 * @author Yuri
 * @since 2023/2/17 21:12
 */

public class SortedContainer {
    public static void main(String[] args) {
        // TreeMap自带顺序
        Map<Integer, Integer> map = new TreeMap<>();
        // TreeMap倒排
        TreeMap<Integer, Integer> reverseMap = new TreeMap<>(Collections.reverseOrder());

        // TreeSet自身有序
        Set<Integer> set = new TreeSet<>();
        // TreeSet倒排
        Set<Integer> reverseSet = new TreeSet<>(Collections.reverseOrder());

    }
}
