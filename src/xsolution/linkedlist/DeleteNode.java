package xsolution.linkedlist;

class DeleteNode {
    static void deleteNode(Node head, Integer data){
        while(true){
            if(head.data == data){
                head.data = head.next.data;
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
    }
}
