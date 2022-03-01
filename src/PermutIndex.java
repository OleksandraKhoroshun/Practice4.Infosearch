
import java.util.ArrayList;
import java.util.HashMap;

public class PermutIndex {
    HashMap<String, ArrayList<String>> index;
    Index ind;

    public PermutIndex(Index ind){
        this.ind=ind;
        index = new HashMap<>();
        for(String s: ind.matrix.keySet()){
            index.put(s,permute(s));
        }
    }

    private ArrayList<String> permute(String input){
        input=input.toLowerCase();
        ArrayList<String> res = new ArrayList<>();
        String word = input+"$";
        res.add(word);
        while(!word.startsWith("$")){
            char ch = word.charAt(0);
            word = word.replaceFirst(String.valueOf(ch),"");
            word = word+ch;
            res.add(word);
        }
        return res;
    }

    public HashMap<String,ArrayList<Integer>> search(String input) throws Exception {
        input = input.toLowerCase();
        input = input.replaceAll("\\s+", "");

        if(!input.matches("\\*?[\\w]+\\*?[\\w]+\\*?"))
            throw new Exception("Incorrect format.");

        HashMap<String,ArrayList<Integer>> res=new HashMap<>();

        if(input.contains("*")) {

            input = permuteSearch(input);
            input = input.replaceAll("\\*","");

            for (String str : index.keySet()) {
                for(String str1 : index.get(str)) {
                    if (str1.startsWith(input)) {
                        res.put(str, ind.matrix.get(str));
                        break;
                    }
                }
            }
        }else
        {
            res.put(input,ind.matrix.get(input));
        }

        return res;
    }

    private String permuteSearch(String input){
        input=input.toLowerCase();
        String res = "";
        String word = input+"$";

        while(!word.endsWith("*")){
            char ch = word.charAt(0);
            String s = String.valueOf(ch);
            if(ch=='*') s ="\\*";
            word = word.replaceFirst(s,"");
            word = word+ch;
        }
        res=word;
        return res;
    }

    //TODO Add output
}
