package xsolution.linkedlist;

import java.util.Stack;

class Palindrome2 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.addNode(2).addNode(3).addNode(4);
        Node node = new Node(1);
        node.addNode(2).addNode(3).addNode(2).addNode(1);
        System.out.println(isPalindrome(node));

        System.out.println(isPalindrome(node1));
    }
    static boolean isPalindrome(Node node){
        Stack<Integer> stack = new Stack<>();

        Node slow = node;
        Node fast = node;
        while(fast!=null && fast.next!=null){
            stack.add(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){
            slow = slow.next;
        }
        while(slow!=null){
            if(stack.pop() != slow.data) return false;
            slow = slow.next;
         }
        return true;
    }
}
