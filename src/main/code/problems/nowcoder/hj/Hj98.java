package problems.nowcoder.hj;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Yuri
 * @since 2023/4/6 22:59
 */

public class Hj98 {

    final static String[] msg = new String[]{
            "",
            "S001:Initialization is successful",
            "S002:Pay success,balance=",
            "S003:Buy success,balance="};
    final static String[] errorMsg = new String[]{
            "",
            "",
            "E002:Denomination error",
            "E003:Change is not enough, pay fail",
            "",
            "E005:All the goods sold out",
            "E006:Goods does not exist",
            "E007:The goods sold out",
            "E008:Lack of balance",
            "E009:Work failure",
            "E010:Parameter error"};


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int[] goodsUnit = new int[]{2, 3, 4, 5, 8, 6};
        final int[] moneyUnit = new int[]{1, 2, 5, 10};

        Vending vending = new Vending();
        String[] split = in.nextLine().split(";");
        for (String string : split) {
            if (Objects.equals(string, "") || string == null) continue;
            String[] orders = string.split(" ");
            switch (orders[0]) {
                case "r": {
                    String[] goodNums = orders[1].split("-");
                    Good[] goods = new Good[goodsUnit.length];
                    for (int i = 0; i < goodNums.length; i++) {
                        goods[i] = new Good("A" + (i + 1), goodsUnit[i], Integer.parseInt(goodNums[i]));
                    }
                    Money[] monies = new Money[moneyUnit.length];
                    String[] moneyNums = orders[2].split("-");
                    for (int i = 0; i < moneyUnit.length; i++) {
                        monies[i] = new Money(moneyUnit[i], Integer.parseInt(moneyNums[i]));
                    }
                    vending = new Vending(goods, monies);
                    System.out.println(msg[1]);
                    break;
                }
                case "p": {
                    vending.putMoney(Integer.parseInt(orders[1]));
                    break;
                }
                case "b": {
                    vending.buy(orders[1]);
                    break;
                }
                case "c": {
                    vending.change();
                    break;
                }
                case "q": {
                    vending.query(Integer.parseInt(orders[1]));
                    break;
                }
                default:
                    System.out.println(errorMsg[10]);
            }
        }
    }


    private static class Vending {
        private Good[] goods;
        private Money[] monies;
        private int balance;

        public Vending() {

        }

        public Vending(Good[] goods, Money[] monies) {
            this.goods = goods;
            this.monies = monies;
            this.balance = 0;
        }

        public void query(int order) {
            if (order == 0) {
                for (Good good : goods) {
                    System.out.println(good.getName() + " " + good.getUnit() + " " + good.getNum());
                }
            } else if (order == 1) {
                for (Money money : monies) {
                    System.out.println(money.getUnit() + " yuan coin number=" + money.getNum());
                }
            } else System.out.println(errorMsg[10]);
        }

        public void change() {
            if (balance == 0) {
                System.out.println(errorMsg[9]);
                return;
            }
            StringBuilder res = new StringBuilder();
            for (int i = 3; i >= 0; i--) {
                Money money = monies[i];
                int num = balance / money.getUnit();
                int max = Math.min(num, money.getNum());
                res.insert(0, money.getUnit() + " yuan coin number=" + max + "\n");
                balance -= max * money.getUnit();
            }
            res.deleteCharAt(res.length() - 1);
            System.out.println(res);
        }

        public void buy(String goodName) {
            Good good = getGood(goodName);
            if (good == null) return;
            if (good.getNum() == 0) {
                System.out.println(errorMsg[7]);
                return;
            }
            if (good.getUnit() > balance) {
                System.out.println(errorMsg[8]);
                return;
            }
            balance -= good.getUnit();
            good.sell();
            System.out.println(msg[3] + balance);
        }

        public void putMoney(int money) {
            switch (money) {
                case 1: {
                    monies[0].num++;
                    balance += monies[0].unit;
                    break;
                }
                case 2: {
                    monies[1].num++;
                    balance += monies[1].unit;
                    break;
                }
                case 5: {
                    if (checkMoney(money)) return;
                    monies[2].num++;
                    balance += monies[2].unit;
                    break;
                }
                case 10: {
                    if (checkMoney(money)) return;
                    monies[3].num++;
                    balance += monies[3].unit;
                    break;
                }
                default:
                    System.out.println(errorMsg[2]);
                    return;
            }
            if (!checkSum()) return;
            System.out.println(msg[2] + balance);
        }

        private Good getGood(String goodName) {
            for (Good good : goods) {
                if (good.name.equals(goodName)) return good;
            }
            System.out.println(errorMsg[6]);
            return null;
        }

        private boolean checkSum() {
            for (Money money : this.monies) {
                if (money.getNum() > 0) return true;
            }
            System.out.println(errorMsg[5]);
            return false;
        }

        private boolean checkMoney(int money) {
            Money moneyOne = monies[0];
            Money moneyTwo = monies[1];
            int oneAndTwoSum = moneyOne.getNum() * moneyOne.getUnit() + moneyTwo.getNum() * moneyTwo.getUnit();
            if (money >= oneAndTwoSum) System.out.println(errorMsg[3]);
            return money >= oneAndTwoSum;
        }

        private void initBalance() {
            int balance = 0;
            for (Money money : this.monies) balance += money.getSum();
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public Good[] getGoods() {
            return goods;
        }

        public void setGoods(Good[] goods) {
            this.goods = goods;
        }

        public Money[] getMonies() {
            return monies;
        }

        public void setMonies(Money[] monies) {
            this.monies = monies;
        }
    }

    private static class Good {

        private String name;
        private int unit;
        private int num;

        public Good(String name, int unit, int num) {
            this.name = name;
            this.unit = unit;
            this.num = num;
        }

        public void sell() {
            this.num--;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
            this.unit = unit;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    private static class Money {
        private int unit;
        private int num;

        public Money(int unit, int num) {
            this.unit = unit;
            this.num = num;
        }

        public int getSum() {
            return this.num * this.unit;
        }

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
            this.unit = unit;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
