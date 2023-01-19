package perfectcoding.tree;

import java.util.Stack;

class SpiralPrint3 {
    static void print(Node node){
        Stack<Node> rl = new Stack<>();
        Stack<Node> lr = new Stack<>();

        rl.push(node);

        while(! rl.isEmpty() || !lr.isEmpty()){
            while(! rl.isEmpty()){
                Node temp = rl.peek();
                rl.pop();

                System.out.print(temp.data + " ");
                if(temp.right != null){
                    lr.push(temp.right);
                }
                if(temp.left != null){
                    lr.push(temp.left);
                }
            }

            while(! lr.isEmpty()){
                Node temp = lr.peek();
                lr.pop();

                System.out.print(temp.data + " ");
                if(temp.left != null){
                    rl.push(temp.left);
                }
                if(temp.right != null){
                    rl.push(temp.right);
                }
            }
        }
    }
 }
