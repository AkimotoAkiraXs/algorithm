package problems.nowcoder.hj;

import java.util.*;
import java.util.stream.Collectors;

/**
 * hard
 * dp：分组背包
 *
 * @author Yuri
 * @since 2023/2/18 18:39
 */

public class Hj16 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, m;
        while (in.hasNextInt()) {
            N = in.nextInt() / 10;
            m = in.nextInt();
            Item[] items = new Item[m + 1];
            for (int i = 1; i <= m; i++) {
                int price = in.nextInt() / 10;
                int weight = in.nextInt();
                int dad = in.nextInt();
                Item item = new Item(i, price, weight, 0);
                if (dad != 0) {
                    // 如果是附属品
                    if (items[dad] == null) {
                        // 不存在主物品则先去创建
                        List<Item> children = new ArrayList<>();
                        children.add(item);
                        Item dadItem = new Item(dad, children);
                        items[dad] = dadItem;
                    } else {
                        // 存在就直接添加附属品
                        items[dad].items.add(item);
                    }
                } else if (items[i] == null) {
                    items[i] = item;
                } else {
                    items[i].price = price;
                    items[i].value = weight;
                }
            }
//            System.out.println(JSON.toJSON(items));
            List<Item> list = Arrays.stream(items).filter(Objects::nonNull).collect(Collectors.toList());

            int[] dp = new int[N + 1];
            dp[0] = 0;
            for (Item item : list) {
                int price = item.price;
                int weight = item.getWeight();
                List<Item> children = item.items;
                for (int j = N; j >= price; j--) {
                    // 只要这个主物品
                    dp[j] = Math.max(dp[j], dp[j - price] + weight);
                    if (children != null && children.size() > 0) {
                        Item child1 = children.get(0);
                        int price1 = child1.price;
                        int weight1 = child1.getWeight();
                        if (price1 + price <= j) {
                            // 要主物品+附属品1
                            dp[j] = Math.max(dp[j], dp[j - price1 - price] + weight + weight1);
                        }
                        if (children.size() > 1) {
                            Item child2 = children.get(1);
                            int price2 = child2.price;
                            int weight2 = child2.getWeight();
                            if (price2 + price <= j) {
                                // 要主物品+附属品2
                                dp[j] = Math.max(dp[j], dp[j - price2 - price] + +weight + weight2);
                            }
                            if (price + price1 + price2 <= j) {
                                // 要主物品+附属品1+附属品2
                                dp[j] = Math.max(dp[j], dp[j - price - price1 - price2] + weight + weight1 + weight2);
                            }
                        }
                    }
                }
            }
            System.out.println(dp[N]);
        }
    }

    private static class Item {
        int n;
        int price;
        int value;
        int dad;
        List<Item> items = new ArrayList<>();

        public Item(int n, int price, int value, int dad) {
            this.n = n;
            this.price = price;
            this.value = value;
            this.dad = dad;
        }

        public Item(int n, List<Item> items) {
            this.n = n;
            this.items = items;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "n=" + n +
                    ", price=" + price +
                    ", value=" + value +
                    ", dad=" + dad +
                    ", items=" + items +
                    '}';
        }

        public int getWeight() {
            return this.value * this.price * 10;
        }
    }
}


