package xsolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SearchPartialWord {
    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        HashMap<String, List<Integer>> search = search(big, smalls);
        search.forEach((k,v) -> System.out.println(k + " : " + v));
    }
    static HashMap<String,List<Integer>> search(String big, String[] smalls){
        HashMap<String, List<Integer>> lookup = new HashMap<>();
        Trie trie = createTrieFromString(big);
        for (int i = 0; i < smalls.length; i++) {
            List<Integer> list = trie.containsString(smalls[i]);
            if(list!=null){
                lookup.put(smalls[i], list);
            }
        }
        return lookup;
    }

    private static Trie createTrieFromString(String str) {
        Trie trie = new Trie();
        trie.insertString(str);
        return trie;
    }
}
class Trie{
    TrieNode root = new TrieNode(' ');

    public void insertString(String str){
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i);
            root.insertString(s, i);
        }
    }
    public List<Integer> containsString(String str){
        return root.search(str);
    }
}
class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    Character value;
    boolean isLast;
    List<Integer> indexesInString = new ArrayList<>();

    public TrieNode(Character value) {
        this.value = value;
    }

    public List<Integer> search(String str){
        if((str==null || str.length() == 0)) return indexesInString;
        char first = str.charAt(0);
        if(children.containsKey(first)){
            TrieNode child = children.get(first);
            child.search(str.substring(1));
        }
        return null;
    }
    public void insertString(String str, Integer index){
        indexesInString.add(index);
        if(str!=null && str.length()!=0){
            char first = str.charAt(0);

            if(children.containsKey(first)){
                TrieNode child = children.get(first);
                child.insertString(str.substring(1), index+1);
            }else{
                TrieNode child = new TrieNode(first);
                children.put(first,child);
                child.insertString(str.substring(1), index+1);
            }
        }else{
            isLast = true;
            this.value = '*';
        }
    }
}
