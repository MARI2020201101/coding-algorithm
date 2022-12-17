package xsolution.linkedlist;

class Partition {
    public static void main(String[] args) {
        Node node = new Node(3);
        node.addNode(5).addNode(8).addNode(5).addNode(10).addNode(2).addNode(1);
        Node newHead = partition(node, 5);
        System.out.println(newHead);
    }
    static Node partition(Node node, Integer x){
        Node headSmaller = null;
        Node tailSmaller = null;
        Node headLarger = null;
        Node tailLarger = null;

        while(node != null){
            if(node.data < x){
                if(headSmaller == null){
                    Node n = new Node(node.data);
                    headSmaller = n;
                    tailSmaller = n;
                }else{
                    Node n = new Node(node.data);
                    tailSmaller.next = n;
                    tailSmaller = n;
                }
            }else{
                if(headLarger == null){
                    Node n = new Node(node.data);
                    headLarger = n;
                    tailLarger = n;
                }else{
                    Node n = new Node(node.data);
                    tailLarger.next = n;
                    tailLarger = n;
                }
            }
            node = node.next;
        }
        if(headSmaller == null){
            return headLarger;
        }
        tailSmaller.next = headLarger;
        return headSmaller;
    }
}
