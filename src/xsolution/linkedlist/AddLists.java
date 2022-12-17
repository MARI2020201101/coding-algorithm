package xsolution.linkedlist;

class AddLists {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.addNode(2).addNode(3).addNode(4);
        Node node2 = new Node(5);
        node2.addNode(6).addNode(7);

        System.out.println(addLists(node1, node2));
    }
    static Node addLists(Node node1, Node node2){
        Integer len1 = lengthOfNode(node1);
        Integer len2 = lengthOfNode(node2);

        int diff = Math.abs(len1 - len2);

        Node node1Head = node1;
        Node node2Head = node2;
        if(diff!=0 && len1 > len2){
            node2Head = insertZeroHeads(node2, diff);
        }else if(diff!=0 && len2 > len1){
            node1Head = insertZeroHeads(node1, diff);
        }

        return __addLists(node1Head, node2Head).sum;
    }

    private static PartialSum __addLists(Node node1, Node node2) {
        if(node1 == null && node2 == null){
            return new PartialSum();
        }

        PartialSum partialSumFrom = __addLists(node1.next, node2.next);

        int sum = (node1.data + node2.data + partialSumFrom.carry) % 10;
        Node nextSum = new Node(sum);
        nextSum.next = partialSumFrom.sum;
        int carry = (node1.data + node2.data + partialSumFrom.carry) / 10;
        return new PartialSum(nextSum, carry);
    }

    static Integer lengthOfNode(Node node){
        int count = 0;
        while(node!=null){
            node=node.next;
            count++;
        }
        return count;
    }
    static Node insertZeroHeads(Node head, Integer zeroCount){
        while(zeroCount > 0){
            Node newHead = insertHead(head, 0);
            head = newHead;
            zeroCount--;
        }
        return head;
    }

    static Node insertHead(Node head, Integer data){
        if(head == null){
            return new Node(data);
        }

        Node newHead = new Node(data);
        newHead.next = head;
        return newHead;
    }
}
class PartialSum{
    Node sum = null;
    int carry = 0;

    public PartialSum() {
    }

    public PartialSum(Node sum, int carry) {
        this.sum = sum;
        this.carry = carry;
    }
}
