package ds.binarytree.sumbinarybit;

class SumBits {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(0);
        Node node2 = new Node(0);
        Node node3 = new Node(0);
        Node node4 = new Node(1);
        Node node5 = new Node(1);
        Node node6 = new Node(1);
        Node node7 = new Node(0);

        root.left = node1;
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;
        node6.left = node7;

        System.out.println(sumBits(root, 0));
        System.out.println(sumBits(sampleData(), 0));
    }
    static int sumBits(Node root, int partialSum){
        if(root == null){
            return partialSum;
        }
        System.out.println("partial Sum =" +partialSum);
        int leftSum = sumBits(root.left, (partialSum << 1) | root.data);
        int rightSum = sumBits(root.right, (partialSum << 1) | root.data);

        return leftSum+rightSum;
    }
    static Node sampleData(){
        Node root = new Node(1);
        Node left1 = new Node(0);
        Node left2 = new Node(0);
        Node left3 = new Node(0);
        root.left= left1;
        left1.left = left2;
        left2.left = left3;

        return root;
    }
}
