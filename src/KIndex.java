import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class KIndex {
    HashMap<String, ArrayList<String>> index;
    Index ind;
    public KIndex(Index ind){
        this.ind = ind;
        index = new HashMap<>();
        for(String s: ind.matrix.keySet()){
            index.put(s,permute(s));
        }
    }

    private ArrayList<String> permute(String input){
        input=input.toLowerCase();
        ArrayList<String> res = new ArrayList<>();
        String word = "$"+input+"$";
        String temp="";
        int counter =0;

        while(!temp.endsWith("$")){
            temp=word.substring(counter,counter+3);
            res.add(temp);
            counter++;
        }
        return res;
    }

    public HashMap<String,ArrayList<Integer>> search(String input) throws Exception {
        input = input.toLowerCase();
        input = input.replaceAll("\\s+", "");

        if(!input.matches("\\*?[\\w]+\\*?[\\w]+\\*?"))
            throw new Exception("Incorrect format.");

        HashMap<String,ArrayList<Integer>> res=new HashMap<>();

        if(!input.contains("*")) {
            HashMap<String,ArrayList<Integer>> ret = new HashMap<>();
            ret.put(input,ind.matrix.get(input));
            return ret;
        }
       input = "$" + input +"$";
       input = input.replaceAll("\\*","&");

        ArrayList<String> temp = permuteSearch(input);

            for (String str : index.keySet()) {
                int n1=0;
                for(String str2 : temp){
                    int n=0;
                for(String str1 : index.get(str)) {

                    if (str1.equals(str2)) {
                      n++;
                    }

                }
                if(n>0) n1++;
            }
               if(n1>=temp.size())res.put(str, ind.matrix.get(str));
        }

        return res;
    }

    private ArrayList<String> permuteSearch(String input){
        input=input.toLowerCase();
        ArrayList<String> res = new ArrayList<>();
        String word = input;
        String temp="";
        int counter =0;

        while(!temp.endsWith("$")){
            temp=word.substring(counter,counter+3);
            if(!temp.contains("&")) {
                res.add(temp);
            }
            counter++;
        }
        return res;
    }

    //TODO Add output
}
