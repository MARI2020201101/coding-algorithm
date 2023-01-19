package perfectcoding.tree;

class SpiralPrint2 {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(4
                , new Node(8), new Node(9)) , new Node(5 , new Node(10), new Node(11)))
                , new Node(3, new Node(6
                , new Node(12), new Node(13)) , new Node(7 , new Node(14), new Node(15))));
        print(root);
    }
    static void print(Node root){
        int level = 1;
        boolean flip = false;
        while(__print(root, level++, flip = !flip)){

        }
    }

    private static boolean __print(Node root, int level, boolean flip) {
        if(root == null) return false;

        if(level == 1){
            System.out.print(root.data + " ");
            return true;
        }

        if(flip){
            boolean left = __print(root.left, level-1, flip);
            boolean right = __print(root.right, level-1, flip);
            return left || right;
        }else{
            boolean right = __print(root.right, level-1, flip);
            boolean left = __print(root.left, level-1, flip);
            return right || left;
        }
    }
}
