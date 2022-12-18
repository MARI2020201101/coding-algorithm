package xsolution.linkedlist;

class Palindrome4 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.addNode(2).addNode(3).addNode(4);
        Node node = new Node(1);
        node.addNode(2).addNode(3).addNode(3).addNode(2).addNode(1);
        System.out.println(isPalindrome(node));

        System.out.println(isPalindrome(node1));
    }

    static boolean isPalindrome(Node node){
        System.out.println(lengthOfNode(node));
        return __isPalindrome(node, lengthOfNode(node)).isPalindrome;
    }

    static Integer lengthOfNode(Node node){
        int len = 0;
        while(node!=null){
            node = node.next;
            len++;
        }
        return len;
    }
    static ResultData __isPalindrome(Node node, Integer len){
        if(len == 0){
            return new ResultData(node, true);
        }else if(len == 1){
            return new ResultData(node.next, true);
        }

        ResultData result = __isPalindrome(node.next, len-2);
        System.out.println(result);
        if(result.data == null) return new ResultData(node, true);
        if(! result.isPalindrome) return new ResultData(node, false);

        boolean nextIsPalindrome = (result.data.data == node.data);
        return new ResultData(result.data.next, nextIsPalindrome);
    }
}
class ResultData{
    Node data;
    boolean isPalindrome;

    public ResultData() {
    }

    public ResultData(Node data, boolean isPalindrome) {
        this.data = data;
        this.isPalindrome = isPalindrome;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "data=" + data +
                ", isPalindrome=" + isPalindrome +
                '}';
    }
}