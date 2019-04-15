package categories.graph;

import java.util.List;

/**
 * Created by 祁连山 on 2019/4/15.
 */
public class Node {
    public int val;
    public List<Node> next;

    public Node() {
    }

    public Node(int _val, List<Node> _next) {
        val = _val;
        next = _next;
    }
}
