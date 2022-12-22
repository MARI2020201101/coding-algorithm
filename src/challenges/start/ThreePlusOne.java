package challenges.start;

import java.util.ArrayList;
import java.util.List;

class ThreePlusOne {
    public static void main(String[] args) {
        solve(22);
    }
    static void solve(int n){
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while(n!=1){
            if((n&1)==1){
                n = n*3+1;
            }else{
                n>>=1;
            }
            list.add(n);
        }
        list.forEach(l-> System.out.print(l+" "));
    }
}
