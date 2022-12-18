package xsolution.linkedlist;

class Palindrome3 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.addNode(2).addNode(3).addNode(4);
        Node node = new Node(1);
        node.addNode(2).addNode(3).addNode(3).addNode(2).addNode(1);
        System.out.println(isPalindrome(node));

        System.out.println(isPalindrome(node1));
    }

    static boolean isPalindrome(Node node){
        return __isPalindrome(node).isPalindrome;
    }
    static Result __isPalindrome(Node node){
        if(node == null){
            return new Result(null, true);
        }

        Result result = __isPalindrome(node.next);
        System.out.println(result);
        if(result.node == null) return new Result(node, true);
        if(! result.isPalindrome) return new Result(node, false);

        boolean nextIsPalindrome = (result.node.data == node.data);
        return new Result(node, nextIsPalindrome);
    }
}
class Result {
    Node node;
    boolean isPalindrome;

    public Result() {
    }

    @Override
    public String toString() {
        return "Result{" +
                "node=" + node +
                ", isPalindrome=" + isPalindrome +
                '}';
    }

    public Result(Node node, boolean isPalindrome) {
        this.node = node;
        this.isPalindrome = isPalindrome;
    }
}