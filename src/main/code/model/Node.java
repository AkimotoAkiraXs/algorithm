package model;

import java.util.List;

/**
 * @author Yuri
 * @since 2024/2/19 18:34
 */

// Definition for a Node.
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
