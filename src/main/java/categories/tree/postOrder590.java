package categories.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 祁连山 on 2019/4/20.
 */
public class postOrder590 {

    public List<Integer> postorder(preOrder589.Node root) {
        List<Integer> list=new ArrayList<>();
        if(null==root){
            return list;
        }
        if(null!=root.children){
            for(preOrder589.Node node:root.children){
                list.addAll(postorder(node));
            }
        }
        list.add(root.val);
        return list;
    }
}
