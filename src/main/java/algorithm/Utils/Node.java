package algorithm.Utils;

import java.util.List;

/**
 * Created by 祁连山 on 2019/4/13.
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
