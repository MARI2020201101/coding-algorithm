package recur.permutation;

class Password {
    public static void main(String[] args) {
        String[] strs = {"a","t","c","i","s","w"};
        password(4, strs, "", 0);
    }
    static void password(int n, String[] strs,String str,  int i){
        if(str.length() == n){
            System.out.println(str);
            return;
        }
        String s = strs[i];
        String next = str + s;
//        password(n, strs, str, i+1);
        password(n, strs, next, i+1);
    }
}
