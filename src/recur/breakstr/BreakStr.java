package recur.breakstr;

class BreakStr {

}
class Trie{

    Node head;
    Node[] next;
    public Trie(){
        this.head = new Node();
    }

    public void insertTrie(String str){
        Node node = head;
        for (int i = 0; i < str.length(); i++) {
            if(node.next[str.charAt(i)-'a'] == null) {
                node.next[str.charAt(i)-'a'] = new Node();
            }
            node=node.next[str.charAt(i)-'a'];
        }
        node.leaf = true;
    }

    public boolean breakStr(String str){
        boolean[] table = new boolean[str.length()+1];
        table[0] = true;
        for (int i = 0; i < str.length(); i++) {
            if(table[i]){
                Node node = head;
                for (int j = i; j < str.length(); j++) {
                    if(node==null) break;
                    node = node.next[str.charAt(i) - 'a'];
                    if(node!=null && node.leaf) {
                        table[j+1] = true;
                    }
                }
            }
        }
        return table[str.length()];
    }
}
class Node{
    private static int CHAR_SIZE;
    boolean leaf;
    Node[] next;

    public Node() {
        this.next = new Node[CHAR_SIZE];
    }

    public Node(boolean leaf, Node[] next) {
        this.leaf = leaf;
        this.next = next;
    }
}
