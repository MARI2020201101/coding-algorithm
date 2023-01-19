package ds.string.median;

class Median {
    static float median(int[] q, int[] p){
        int lenQ = q.length;
        int lenP = p.length;

        if(lenQ>lenP){
            return median(p, q);
        }
        int qPointerMin = 0;
        int qPointerMax = q.length;
        int midLength = (q.length + p.length + 1)/2;
        int qPointer;
        int pPointer;

        while(qPointerMin <= qPointerMax){
            qPointer = (qPointerMin+qPointerMax)/2;
            pPointer = midLength - qPointer;

            if(qPointer< q.length && p[pPointer-1] >  q[qPointer]){
                qPointerMin = qPointer+1;
            }else if(qPointer>0 && q[qPointer-1]>p[pPointer]){
                qPointerMax = qPointer-1;
            }else{
                return Integer.max(q[qPointer-1], p[pPointer-1]);
            }
        }
        return -1;
    }
}
