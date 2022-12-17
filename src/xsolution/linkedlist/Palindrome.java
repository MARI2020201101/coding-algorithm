package xsolution.linkedlist;

class Palindrome {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.addNode(2).addNode(3).addNode(4);
        System.out.println(reverse(node1));

        Node node = new Node(1);
        node.addNode(2).addNode(3).addNode(2).addNode(1);
        System.out.println(isPalindrome(node));

        System.out.println(isPalindrome(node1));
    }
    static boolean isPalindrome(Node node){
        Node reverse = reverse(node);
        while(reverse!=null && node!=null){
            if(reverse.data != node.data) return false;
            reverse = reverse.next;
            node = node.next;
        }
        return true;
    }
    static Node reverse(Node head){
        Node node = head;
        Node prev = null;
        while(node!=null){
            Node curr = new Node(node.data);
            curr.next = prev;
            prev = curr;
            node = node.next;
        }
        return prev;
    }
}
