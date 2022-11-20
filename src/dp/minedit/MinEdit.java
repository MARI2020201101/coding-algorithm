package dp.minedit;

class MinEdit {
    public static void main(String[] args) {
//        Node[][] dp = minEdit("intention", "execution");
        Node[][] dp = minEdit("rad", "apple");
        print(dp);
        System.out.println(dp[dp.length-1][dp[0].length-1].val);

    }
    static Node[][] minEdit(String a, String b){
        Node[][] dp = new Node[a.length()+1][b.length()+1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = new Node(1, Edit.ADD);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = new Node(1, Edit.DELETE);
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = new Node(dp[i-1][j-1].val, Edit.DONE);
                }else{
                    dp[i][j]=getMinNode(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
                }
            }
        }
        return dp;
    }

    private static void print(Node[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Node node = dp[i][j];
                System.out.print(node.edit.name().substring(0,3) + " ");
            }
            System.out.println();
        }
    }
    private static Node getMinNode(Node left, Node up, Node dia) {
        int val = Math.min(Math.min(left.val, up.val),dia.val);
        Edit edit = (val == up.val) ? Edit.ADD : val == dia.val ? Edit.EDIT : Edit.DELETE;
        return new Node(val+1, edit);
    }
}
class Node{
    int val;
    Edit edit;

    public Node(int val, Edit edit) {
        this.val = val;
        this.edit = edit;
    }

    @Override
    public String toString() {
        return edit.op;
    }
}
enum Edit{
    DONE("."),ADD("+"),DELETE("-"),EDIT("*");
    final String op;

    Edit(String op) {
        this.op = op;
    }
}