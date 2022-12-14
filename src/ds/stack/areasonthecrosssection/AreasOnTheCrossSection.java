package ds.stack.areasonthecrosssection;

import java.util.Stack;

class AreasOnTheCrossSection {
    public static void main(String[] args) {
        String sections = "\\\\///\\_/\\/\\\\\\\\/_/\\\\///__\\\\\\_\\\\/_\\/_/\\";
        System.out.println(solve(sections));
    }
    static int solve(String sections){
        int total = 0;
        Stack<Integer> idxs = new Stack<>();
        Stack<Integer> areas = new Stack<>();
        for (int i = 0; i < sections.length(); i++) {
            if(sections.charAt(i)=='\\'){
                idxs.push(i);
            }else if(sections.charAt(i)=='/'){
                if(! idxs.isEmpty()){
                    Integer idx = idxs.pop();
                    areas.push(i-idx);
                }

            }
        }
        while(! areas.isEmpty()){
            Integer area = areas.pop();
            System.out.print(area + " ");
            total+=area;
        }
        System.out.println();
        return total;
    }
}
