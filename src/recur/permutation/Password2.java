package recur.permutation;

class Password2 {
    public static void main(String[] args) {
        String[] strs = {"a","t","c","i","s","w"};
//        password(4, "",strs, 0);
//        password2(strs, "", 0, 4);
        password3(strs, "", 0, 4);
    }
    static void password(int n, String str, String[] strs, int idx){
        if(str.length() == n){
            System.out.println(str);
            return;
        }
        for (int i = idx; i < strs.length; i++) {
            String s = strs[i];
            str+=s;
            password(n, str, strs, idx+1);
        }
    }
    static void password2(String[] strs, String str, int offset, int n){
        if(str.length() == n){
            System.out.println(str);
            return;
        }
        for (int i = offset; i < strs.length; i++) {
            String s = strs[i];
            String next = str+s;
            password2(strs, next, offset+1, n);
        }
    }

    static void password3(String[] strs, String str, int offset, int n){
        if(str.length() == n){
            System.out.println(str);
            return;
        }
        for (int i = offset; i < strs.length; i++) {
            String s = strs[i];
            if(!str.contains(s)){
                String next = str+s;
                password3(strs, next, offset+1, n);
            }

        }
    }
}
