package tips;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Yuri
 * @since 2023/3/10 0:53
 */

public class Java8Tips {
    public static void main(String[] args) {

    }


    /**
     * Map下的Java8流式操作
     *
     * @see nowcoder.hj.Hj45 Hj45 对Map排序
     */
    private static void sortMap(Map<Integer, Integer> map) {
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 对Map进行key的倒序排列
        entries = entries.stream().sorted(((o1, o2) -> o2.getValue() - o1.getValue()))
                .collect(Collectors.toCollection(LinkedHashSet::new)); // 不能直接toSet，不然排序不会生效


    }
}
