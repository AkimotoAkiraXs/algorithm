//A kingdom consists of a king, his children, his grandchildren, and so on. 
//Every once in a while, someone in the family dies or a child is born. 
//
// The kingdom has a well-defined order of inheritance that consists of the 
//king as the first member. Let's define the recursive function Successor(x, curOrder)
//, which given a person x and the inheritance order so far, returns who should 
//be the next person after x in the order of inheritance. 
//
// 
//Successor(x, curOrder):
//    if x has no children or all of x's children are in curOrder:
//        if x is the king return null
//        else return Successor(x's parent, curOrder)
//    else return x's oldest child who's not in curOrder
// 
//
// For example, assume we have a kingdom that consists of the king, his 
//children Alice and Bob (Alice is older than Bob), and finally Alice's son Jack. 
//
// 
// In the beginning, curOrder will be ["king"]. 
// Calling Successor(king, curOrder) will return Alice, so we append to 
//curOrder to get ["king", "Alice"]. 
// Calling Successor(Alice, curOrder) will return Jack, so we append to 
//curOrder to get ["king", "Alice", "Jack"]. 
// Calling Successor(Jack, curOrder) will return Bob, so we append to curOrder 
//to get ["king", "Alice", "Jack", "Bob"]. 
// Calling Successor(Bob, curOrder) will return null. Thus the order of 
//inheritance will be ["king", "Alice", "Jack", "Bob"]. 
// 
//
// Using the above function, we can always obtain a unique order of inheritance.
// 
//
// Implement the ThroneInheritance class: 
//
// 
// ThroneInheritance(string kingName) Initializes an object of the 
//ThroneInheritance class. The name of the king is given as part of the constructor. 
// void birth(string parentName, string childName) Indicates that parentName 
//gave birth to childName. 
// void death(string name) Indicates the death of name. The death of the person 
//doesn't affect the Successor function nor the current inheritance order. You 
//can treat it as just marking the person as dead. 
// string[] getInheritanceOrder() Returns a list representing the current order 
//of inheritance excluding dead people. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth", 
//"getInheritanceOrder", "death", "getInheritanceOrder"]
//[["king"], ["king", "andy"], ["king", "bob"], ["king", "catherine"], ["andy", 
//"matthew"], ["bob", "alex"], ["bob", "asha"], [null], ["bob"], [null]]
//Output
//[null, null, null, null, null, null, null, ["king", "andy", "matthew", "bob", 
//"alex", "asha", "catherine"], null, ["king", "andy", "matthew", "alex", "asha", 
//"catherine"]]
//
//Explanation
//ThroneInheritance t= new ThroneInheritance("king"); // order: king
//t.birth("king", "andy"); // order: king > andy
//t.birth("king", "bob"); // order: king > andy > bob
//t.birth("king", "catherine"); // order: king > andy > bob > catherine
//t.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
//t.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > 
//catherine
//t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > 
//catherine
//t.getInheritanceOrder(); // return ["king", "andy", "matthew", "bob", "alex", 
//"asha", "catherine"]
//t.death("bob"); // order: king > andy > matthew > bob > alex > asha > 
//catherine
//t.getInheritanceOrder(); // return ["king", "andy", "matthew", "alex", "asha",
// "catherine"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= kingName.length, parentName.length, childName.length, name.length <= 15 
//
// kingName, parentName, childName, and name consist of lowercase English 
//letters only. 
// All arguments childName and kingName are distinct. 
// All name arguments of death will be passed to either the constructor or as 
//childName to birth first. 
// For each call to birth(parentName, childName), it is guaranteed that 
//parentName is alive. 
// At most 10⁵ calls will be made to birth and death. 
// At most 10 calls will be made to getInheritanceOrder. 
// 
//
// 👍 83 👎 0

package problems.leetcode.editor.cn;

import java.util.*;

/**
 * Id：&emsp;&emsp;1600
 * <p>
 * Name：Throne Inheritance
 *
 * @author Yuri
 * @since 2024-04-07 09:56:36
 */

public class ThroneInheritance {
    public static void main(String[] args) {
        ThroneInheritance_ king = new problems.leetcode.editor.cn.ThroneInheritance().new ThroneInheritance_("king");
        king.birth("king", "andy");
        king.birth("king", "bob");
        king.birth("king", "catherine");
        king.birth("andy", "matthew");
        king.birth("bob", "alex");
        king.birth("bob", "asha");
        System.out.println(king.getInheritanceOrder());
        king.death("bob");
        System.out.println(king.getInheritanceOrder());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 不要去管官方伪代码，那个伪代码害人不浅，当成一道dfs来做就行，提交代码需要去掉类名下划线
    class ThroneInheritance_ {
        Set<String> dead = new HashSet<>();
        final Person root;
        Map<String, Person> map = new HashMap<>();

        public ThroneInheritance_(String kingName) {
            this.root = new Person(kingName);
            map.put(kingName, root);
        }

        public void birth(String parentName, String childName) {
            Person parent = map.get(parentName);
            Person baby = new Person(parent, childName);
            parent.children.add(baby);
            map.put(childName, baby);
        }

        public void death(String name) {
            dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> successor = new ArrayList<>();
            success(root, successor);
            successor.removeAll(dead);
            return successor;
        }

        private void success(Person person, List<String> currentOrder) {
            currentOrder.add(person.name);
            for (Person child : person.children)
                success(child, currentOrder);
        }

        class Person {
            Person parent;
            String name;
            List<Person> children = new ArrayList<>();

            Person(String name) {
                this.name = name;
            }

            Person(Person parent, String name) {
                this.parent = parent;
                this.name = name;
            }
        }
    }

    /**
     * Your ThroneInheritance object will be instantiated and called as such:
     * ThroneInheritance obj = new ThroneInheritance(kingName);
     * obj.birth(parentName,childName);
     * obj.death(name);
     * List<String> param_3 = obj.getInheritanceOrder();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}