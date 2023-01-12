package perfectcoding.bitoperation;

class GetValue {
    static int getValue(int x){
        return x & 1;
    }
}
class SetValue{
    static int setValue(int n, int k){
        int mask = 1 << k;
        return n | mask;
    }
}
class ClearFrom{
    static int clearFrom(int n, int k){
        int mask = (1 << k) - 1;
        return n & mask;
    }
    static int clearTo(int n, int k){
        int mask = -1 << (k + 1);
        return n&mask;
    }
}
