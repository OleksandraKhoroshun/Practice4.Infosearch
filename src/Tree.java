import ua.princeton.lib.BTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Tree {
    public BTree<String,ArrayList<Integer>> tree;
    private Index index;

    public Tree(Index i){
        index= i;
        tree = new BTree();

        ArrayList<String> res_list = new ArrayList(index.matrix.keySet());
        Collections.sort(res_list);

        for(String s: res_list){
            tree.put(s,index.matrix.get(s));
        }

    }

    public HashMap<String,ArrayList<Integer>> search(String input) throws Exception {
        input = input.toLowerCase();
        String input_test = input.replaceAll("\\s+","");

        if (!input_test.matches("[\\w]+\\*?"))
            throw new Exception("Incorrect format.");

        String temp = input.replaceAll("\\*","");
        HashMap<String,ArrayList<Integer>> res = new HashMap<>();

        if(!input.contains("*")) res.put(temp,tree.get(temp));
        else{
            for(String s: tree.getChildren(temp)){
                res.put(s,tree.get(s));
            }
        }

        return res;

    }

    //to string
    public String toString() {
        return tree.toString();
    }

}
