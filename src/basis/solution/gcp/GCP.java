package basis.solution.gcp;

class GCP {
    public static void main(String[] args) {
        System.out.println(gcp(24,300));
    }
    static int gcp(int a, int b){
        if(a==0 || b == 0){
            return a==0 ? b : a;
        }
        if(a > b){
            int tmp = a;
            a = b ;
            b = tmp;
        }

        if(a%2 ==0 && b%2==0){
            return gcp(a>>>1, b >>>1)<<1;
        }else if(a%2==0){
            return gcp(a>>>1, b );
        }else if(b%2==0){
            return gcp( a, b >>>1);
        }return gcp(a, b-a);

    }
}
